package pers.chenjiahao.es;

import cn.hutool.json.JSONUtil;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/13 17:56:29
 */
public class ESDocInsert {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 插入数据
        User user = new User();
        user.setName("wutiao");
        user.setAge(98);
        user.setSex("男");

        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user")
                        .id("1002")
                        .source(JSONUtil.toJsonStr(user), XContentType.JSON);

        IndexResponse indexResponse = esClient.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(indexResponse.getResult());

        // 关闭ES客户端
        esClient.close();
    }
}
