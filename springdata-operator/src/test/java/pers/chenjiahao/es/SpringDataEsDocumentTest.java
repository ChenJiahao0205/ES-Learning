package pers.chenjiahao.es;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import pers.chenjiahao.es.dao.ProductDao;
import pers.chenjiahao.es.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/18 23:02:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataEsDocumentTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void createDocument(){
        Product product = new Product();
        product.setId(2L);
        product.setCategory("华为手机");
        product.setTitle("手机");
        product.setPrice(2999.0);
        product.setImages("http://www.chenjiahao.com");

        productDao.save(product);
    }

    @Test
    public void updateDocument(){
        Product product = new Product();
        product.setId(3L);
        product.setCategory("苹果手机");
        product.setTitle("手机");
        product.setPrice(19999.0);
        product.setImages("http://www.chenjiahao.com");

        productDao.save(product);
    }

    @Test
    public void findById(){
        Product product = productDao.findById(2L).get();
        System.out.println(product);
    }

    @Test
    public void findAll(){
        Iterable<Product> all = productDao.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }

    @Test
    public void deleteDocument(){
        productDao.deleteById(2L);
    }

    @Test
    public void saveAll(){
        List<Product> productList = new ArrayList<>();

        for (int i = 4; i < 15; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setCategory("[" + i + "]苹果手机");
            product.setTitle("手机");
            product.setPrice(19999.0);
            product.setImages("http://www.chenjiahao.com");
            productList.add(product);
        }

        productDao.saveAll(productList);
    }

    @Test
    public void page(){
        // 设置ID降序查询
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        // 当前页
        int from = 0;
        // 每页显示多少条数据
        int size = 5;
        // 设置分页
        PageRequest pageRequest = PageRequest.of(from, size, sort);
        Page<Product> all = productDao.findAll(pageRequest);
        for (Product product : all) {
            System.out.println(product);
        }
    }

    @Test
    public void search(){
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        Iterable<Product> search = productDao.search(matchQueryBuilder);
        for (Product product : search) {
            System.out.println(product);
        }
    }

    @Test
    public void searchPage(){
        int from = 0;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(from, size);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", "手机");
        Iterable<Product> search = productDao.search(matchQueryBuilder, pageRequest);
        for (Product product : search) {
            System.out.println(product);
        }
    }
}
