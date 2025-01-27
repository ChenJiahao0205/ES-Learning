package pers.chenjiahao.es;

import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch7.ElasticsearchSink;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/20 15:45:30
 */
public class FlinkElasticsearch {

    public static void main(String[] args) throws Exception {
        // 构建Flink环境对象
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 数据的输入
        DataStreamSource<String> source = env.socketTextStream("localhost", 9999);

        // 使用ESBuilder构建输出
        List<HttpHost> hosts = new ArrayList<>();
        hosts.add(new HttpHost("localhost", 9200, "http"));

        ElasticsearchSink.Builder<String> esBuilder = new ElasticsearchSink.Builder<>(hosts, new ElasticsearchSinkFunction<String>() {
            @Override
            public void process(String s, RuntimeContext runtimeContext, RequestIndexer requestIndexer) {
                // 处理请求
                Map<String, String> jsonMap = new HashMap<>();
                jsonMap.put("data", s);

                IndexRequest request = Requests.indexRequest();
                // 索引名称中不能包含大写，否则插入失败
//                request.index("flnkIndex");
                request.index("flink-index");
                request.id("1001");
                request.source(jsonMap);
                requestIndexer.add(request);
            }

        });
        // 默认是批处理的，但是这里为了立马看到效果，就来一条输出一条
        esBuilder.setBulkFlushMaxActions(1);

        // Sink：数据的输出
        source.addSink(esBuilder.build());

        // 执行操作
        env.execute("flink-es");
    }
}
