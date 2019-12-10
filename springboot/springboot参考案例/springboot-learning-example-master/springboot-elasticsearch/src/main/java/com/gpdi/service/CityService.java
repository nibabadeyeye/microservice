
package com.gpdi.service;

import com.gpdi.domain.City;

import java.util.List;

public interface CityService {


    /**
     * @Desc:查询所有城市信息
     */
    public List<City> getAllCity();
    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * 根据关键词，function score query 权重分分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
//    List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent);
}