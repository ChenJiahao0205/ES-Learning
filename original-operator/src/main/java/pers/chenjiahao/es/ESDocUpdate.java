package pers.chenjiahao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/13 17:56:29
 */
public class ESDocUpdate {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 修改数据
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("user")
                        .id("1001")
                        .doc(XContentType.JSON, "sex", "女");

        UpdateResponse updateResponse = esClient.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(updateResponse.getResult());

        // 关闭ES客户端
        esClient.close();
    }
}
