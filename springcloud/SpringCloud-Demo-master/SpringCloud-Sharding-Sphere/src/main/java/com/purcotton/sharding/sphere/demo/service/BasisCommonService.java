package com.purcotton.sharding.sphere.demo.service;

import com.purcotton.sharding.sphere.demo.entity.Order;
import com.purcotton.sharding.sphere.demo.entity.OrderItem;
import com.purcotton.sharding.sphere.demo.repository.OrderItemRepository;
import com.purcotton.sharding.sphere.demo.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * [简要描述]:
 * [详细描述]:
 *
 * @author llxiao
 * @version 1.0, 2018/11/14 11:15
 * @since JDK 1.8
 */
public abstract class BasisCommonService implements CommonService
{
    @Override
    public void initEnvironment()
    {
        getOrderRepository().createTableIfNotExists();
        getOrderItemRepository().createTableIfNotExists();
        getOrderRepository().truncateTable();
        getOrderItemRepository().truncateTable();
    }

    @Override
    public void cleanEnvironment()
    {
        getOrderRepository().dropTable();
        getOrderItemRepository().dropTable();
    }

    @Transactional
    @Override
    public void processSuccess(final boolean isRangeSharding)
    {
        System.out.println("-------------- Process Success Begin ---------------");
        List<Long> orderIds = insertData();
        printData(isRangeSharding);
        //deleteData(orderIds);
        //printData(isRangeSharding);
        System.out.println("-------------- Process Success Finish --------------");
    }

    @Transactional
    @Override
    public void processFailure()
    {
        System.out.println("-------------- Process Failure Begin ---------------");
        insertData();
        System.out.println("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }

    private List<Long> insertData()
    {
        System.out.println("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++)
        {
            Order order = newOrder();
            order.setUserId(i);
            order.setStatus("INSERT_TEST");
            getOrderRepository().insert(order);
            OrderItem item = newOrderItem();
            item.setOrderId(order.getOrderId());
            item.setUserId(i);
            item.setStatus("INSERT_TEST");
            getOrderItemRepository().insert(item);
            result.add(order.getOrderId());
        }
        return result;
    }

    private void deleteData(final List<Long> orderIds)
    {
        System.out.println("---------------------------- Delete Data ----------------------------");
        for (Long each : orderIds)
        {
            getOrderRepository().delete(each);
            getOrderItemRepository().delete(each);
        }
    }

    @Override
    public void printData(final boolean isRangeSharding)
    {
        if (isRangeSharding)
        {
            printDataRange();
        }
        else
        {
            printDataAll();
        }
    }

    private void printDataRange()
    {
        System.out.println("---------------------------- Print Order Data -----------------------");
        for (Object each : getOrderRepository().selectRange())
        {
            System.out.println(each);
        }
        System.out.println("---------------------------- Print OrderItem Data -------------------");
        for (Object each : getOrderItemRepository().selectRange())
        {
            System.out.println(each);
        }
    }

    private void printDataAll()
    {
        System.out.println("---------------------------- Print Order Data -----------------------");
        for (Object each : getOrderRepository().selectAll())
        {
            System.out.println(each);
        }
        System.out.println("---------------------------- Print OrderItem Data -------------------");
        for (Object each : getOrderItemRepository().selectAll())
        {
            System.out.println(each);
        }
    }

    protected abstract OrderRepository getOrderRepository();

    protected abstract OrderItemRepository getOrderItemRepository();

    protected abstract Order newOrder();

    protected abstract OrderItem newOrderItem();
}
