package pers.chenjiahao.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import pers.chenjiahao.es.entity.Product;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/18 22:48:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataEsIndexTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void createIndex(){
        // 创建索引，系统初始化会自动创建索引
        System.out.println("创建索引");
    }

    @Test
    public void deleteIndex(){
        boolean deleteFlag = elasticsearchRestTemplate.deleteIndex(Product.class);
        System.out.println("删除索引 = " + deleteFlag);
    }
}
