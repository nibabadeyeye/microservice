package com.dalaoyang.repository;

import com.dalaoyang.entity.Goods;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @description: 根据一定的规则进行接口的定义，jpa会自动的去分析接口可能的含义进行动态生成对应的实现
 */
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    List<Goods> findAllByGoodsIdBetween(Long goodsId1,Long goodsId2);

    List<Goods> findAllByGoodsIdIn(List<Long> goodsIds);

}
