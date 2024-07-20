package pers.chenjiahao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/13 17:56:29
 */
public class ESIndexDelete {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 删除索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        AcknowledgedResponse deleteResponse = esClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        System.out.println(deleteResponse.isAcknowledged());

        // 关闭ES客户端
        esClient.close();
    }
}
