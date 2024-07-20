package pers.chenjiahao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/13 17:56:29
 */
public class ESDocGet {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 查询数据
        GetRequest getRequest = new GetRequest();
        getRequest.index("user")
                        .id("1001");

        GetResponse getResponse = esClient.get(getRequest, RequestOptions.DEFAULT);

        System.out.println(getResponse.getIndex());
        System.out.println(getResponse.getSource());
        System.out.println(getResponse.getSourceAsString());

        // 关闭ES客户端
        esClient.close();
    }
}