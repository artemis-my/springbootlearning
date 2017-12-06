package com.uproad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uproad.dao.CityDao;
import com.uproad.entity.City;
import com.uproad.service.CityService;
/**
 * 城市业务逻辑实现类
 *
 * Created by xchunzhao on 02/05/2017.
 */
@Service
public class CityServiceImpl implements CityService {
	@Autowired
    private CityDao cityDao;
	@Override
	public City findCityByName(String cityName) {   
		return cityDao.findByName(cityName);
	}

}
