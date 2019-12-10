package com.example.AddDemo.controller;
import com.example.AddDemo.domain.BusinessExceptionPara;
import com.example.AddDemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Mr whs
 * @Date date
 */
@RestController
public class UserController {


    @Autowired
    private  JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @RequestMapping("/tt")
    public void batchSave(){
        List<Object[]> batchArgs=new ArrayList<Object[]>();
        batchArgs.add(new Object[]{"小明"});
        batchArgs.add(new Object[]{"小红"});
        String sql = "insert into test  values (null,?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @RequestMapping("/bb")
    public void bb(){
        List<User> list = new ArrayList<User>();
        //新增用户
        User user1=new User();
        user1.setName("333");
        User user2=new User();
        user2.setName("666");
        list.add(user1);
        list.add(user2);
        //list.add(new User(null,"王二麻子"));
        //批量转数组
        SqlParameterSource[] beanSources = SqlParameterSourceUtils.createBatch(list.toArray());
        String sql = "INSERT INTO test(id,name) VALUES (:id,:name)";
        namedParameterJdbcTemplate.batchUpdate(sql, beanSources);
    }
    @RequestMapping("/cc")
    public void cc()
    {
        List<BusinessExceptionPara>list=new ArrayList<>();
        BusinessExceptionPara businessExceptionPara1=new BusinessExceptionPara();
        businessExceptionPara1.setBill(11);
        businessExceptionPara1.setBusinessTimes(22);

        BusinessExceptionPara businessExceptionPara2=new BusinessExceptionPara();
        businessExceptionPara2.setBill(33);
        businessExceptionPara2.setBusinessTimes(44);
        list.add(businessExceptionPara1);
        list.add(businessExceptionPara2);

        SqlParameterSource[] beanSources = SqlParameterSourceUtils.createBatch(list.toArray());
        String inesrtSql = "INSERT INTO exceptiontel(id,businessStoreTel,transactionDate,sumBusinessAmount,sumDiscount,bill,countMoreTenNumber,businessTimes,status) " +
                "                    VALUES (:id,:businessStoreTel,:transactionDate,:sumBusinessAmount,:sumDiscount,:bill,:countMoreTenNumber,:businessTimes,:status)";
        namedParameterJdbcTemplate.batchUpdate(inesrtSql, beanSources);
    }




}