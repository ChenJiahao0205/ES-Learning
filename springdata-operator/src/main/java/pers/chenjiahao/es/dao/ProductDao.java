package pers.chenjiahao.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;
import pers.chenjiahao.es.entity.Product;

/**
 * @author ChenJiahao(五条)
 * @date 2024/07/18 22:44:58
 */
@Service
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}
