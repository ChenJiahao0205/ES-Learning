package pers.chenjiahao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
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
public class ESDocDelete {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 删除数据
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("user")
                        .id("1002");

        DeleteResponse deleteResponse = esClient.delete(deleteRequest, RequestOptions.DEFAULT);

        System.out.println(deleteResponse.toString());

        // 关闭ES客户端
        esClient.close();
    }
}
