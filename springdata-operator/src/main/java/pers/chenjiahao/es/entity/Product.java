package pers.chenjiahao.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/18 22:39:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product", shards = 3, replicas = 1)
public class Product {

    /**
     * 商品唯一标识
     */
    @Id
    private Long id;

    /**
     * 商品名称
     */
    @Field(type = FieldType.Text)
    private String title;

    /**
     * 分类名称 不能被分词
     */
    @Field(type = FieldType.Keyword)
    private String category;

    /**
     * 商品价格
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     * 图片地址 不能被分词，不能被查询
     */
    @Field(type = FieldType.Keyword, index = false)
    private String images;
}
