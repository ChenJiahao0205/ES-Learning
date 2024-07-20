package pers.chenjiahao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/13 17:56:29
 */
public class ESDocQuery {
    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

//        // 1.查询索引中全部数据
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 2.条件查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age", 30)));
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 3.分页查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // index
//        builder.from(0);
//        // size
//        builder.size(3);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 4.查询排序
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 5.过滤字段
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String[] includes = {"name"};
//        String[] excludes = {};
//        builder.fetchSource(includes, excludes);
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 6.组合字段
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age", 30));
////        boolQueryBuilder.mustNot(QueryBuilders.matchQuery("sex", "女"));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("sex", "男"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 30));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age", 40));
//
//        builder.query(boolQueryBuilder);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 7.范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30);
//        rangeQuery.lte(40);
//
//        builder.query(rangeQuery);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 8.模糊查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "wutiao")
//                .fuzziness(Fuzziness.TWO); // 允许相差几个长度的数据
//
//        builder.query(fuzzyQueryBuilder);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 9.高亮查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "wutiao");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//
//        builder.highlighter(highlightBuilder);
//        builder.query(termsQueryBuilder);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(searchResponse.toString());
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

//        // 10.聚合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("ageAge")
//                .field("age");
//        builder.aggregation(aggregationBuilder);
//
//        searchRequest.source(builder);
//
//        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        // 这里能看到最大的
//        System.out.println(searchResponse.toString());
//        System.out.println(searchResponse.getTook());
//        SearchHits hits = searchResponse.getHits();
//        System.out.println(hits.getTotalHits());
//
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 11.分组查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup")
                .field("age");
        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);

        SearchResponse searchResponse = esClient.search(searchRequest, RequestOptions.DEFAULT);

        // 这里能看到分组情况
        System.out.println(searchResponse.toString());
        System.out.println(searchResponse.getTook());
        SearchHits hits = searchResponse.getHits();
        System.out.println(hits.getTotalHits());

        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }

        // 关闭ES客户端
        esClient.close();
    }
}
