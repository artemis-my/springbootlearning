package com.uproad.service;

import com.uproad.entity.City;

public interface CityService {
	/**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}
