package com.gpdi.es.dao;


import com.gpdi.common.domain.Article;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.Optional;

/**
 * @Auther: xf
 * @Date: 2019/1/13 14:08
 * @Description: 继承 ElasticsearchRepository<实体类, 实体类主键类型>
 */
public interface ESArticleRepository extends ElasticsearchRepository<Article, Long> {


    @Override
    default <S extends Article> S index(S s) {
        return null;
    }

    @Override
    default Iterable<Article> search(QueryBuilder queryBuilder) {
        return null;
    }

    @Override
    default Page<Article> search(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    default Page<Article> search(SearchQuery searchQuery) {
        return null;
    }

    @Override
    default Page<Article> searchSimilar(Article article, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    default void refresh() {

    }

    @Override
    default Class<Article> getEntityClass() {
        return null;
    }

    @Override
    default Iterable<Article> findAll(Sort sort) {
        return null;
    }

    @Override
    default Page<Article> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Article> S save(S s) {
        return null;
    }

    @Override
    default <S extends Article> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    default Optional<Article> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Article> findAll() {
        return null;
    }

    @Override
    default Iterable<Article> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Article article) {

    }

    @Override
    default void deleteAll(Iterable<? extends Article> iterable) {

    }

    @Override
    default void deleteAll() {

    }

    // Pageable为分页使用，不需要分页是去除。
    Page<Article> findByName(String name, Pageable pageable);

    Page<Article> findByNameLike(String name, Pageable pageable);

    /**
     * 参考 官网 https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
     * 仅仅作为理解，与本项目无关
     */
    /* 以Name 开头 */
    /*    List<Book> findByNameStartingWith(String name);
     *//* 以Name 结尾 *//*
    List<Book> findByNameEndingWith(String name);
    *//* 包含 Name *//*
    List<Book> findByNameContaining(String name);
    *//* 年龄在 ageFrom 到 ageTo 之间 *//*
    List<Book> findByAmountBetween(Integer amountFrom, Integer amountTo);
    *//* 名称为name 和 价格为 price 的 *//*
    List<Book> findByNameAndPrice(String name, Integer price);
    *//* 名称为name 和 价格为 price 的 按照价格排序 *//*
    List<Book> findByNameAndPriceOrderByPriceDesc(String name, Integer price);
   */
}
