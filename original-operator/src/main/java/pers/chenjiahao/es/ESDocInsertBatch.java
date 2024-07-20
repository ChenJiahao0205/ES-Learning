package pers.chenjiahao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/13 17:56:29
 */
public class ESDocInsertBatch {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        // 批量插入数据
        BulkRequest bulkRequest = new BulkRequest();

        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "wutiao", "age", 30, "sex", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "wu", "age", 30, "sex", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "tiao", "age", 40, "sex", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "tiao4", "age", 50, "sex", "男"));
        bulkRequest.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "tiao5", "age", 50, "sex", "女"));
        bulkRequest.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "tiao6", "age", 50, "sex", "男"));
        BulkResponse bulkResponse = esClient.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulkResponse.getTook());
        System.out.println(bulkResponse.getItems());

        // 关闭ES客户端
        esClient.close();
    }
}
