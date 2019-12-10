package com.dalaoyang.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * 这里使用的都是单键分片策略
 * 示例分表策略是：
 * GoodsType为奇数使用goods_1表
 * GoodsType为偶数使用goods_0表
 *
 * @author yangyang
 * @date 2019/1/30
 */
@Component
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {
    /**
     * @description: 传递的数值有数据表名称(包含多张表)和主键ID的名称
     *
     *
     */
    @Override
    public String doEqualSharding(final Collection<String> tableNames, final ShardingValue<Long> shardingValue) {
        for (String each : tableNames) {
            System.out.println("需要分片的 数值"+shardingValue.getValue() % 2 + "");
            if (each.endsWith(shardingValue.getValue() % 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }
    /**
     *
     * @description: 通过制定的键值进行查询
     *
     */
    @Override
    public Collection<String> doInSharding(final Collection<String> tableNames, final ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        for (Long value : shardingValue.getValues()) {
            for (String tableName : tableNames) {
                if (tableName.endsWith(value % 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }
    /**
     * @description: 查询结余数值区间的数值
     *
     */
    @Override
    public Collection<String> doBetweenSharding(final Collection<String> tableNames,
                                                final ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(tableNames.size());
        Range<Long> range = shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : tableNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }

//    @Override
//    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
//        return null;
//    }
//
//    @Override
//    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
//        return null;
//    }
}