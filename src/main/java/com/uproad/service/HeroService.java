package com.uproad.service;

import java.util.List;

import com.uproad.entity.Hero;

public interface HeroService {
	/**
	 * 获取所有英雄
	 */
	List<Hero> getAllHeroes();
	/**
	 * id获取英雄
	 */
	Hero getHeroById(int id);
	/**
	 * 根据id删除英雄
	 */
	int delHeroById(int id);
	/**
	 * 添加英雄
	 */
	int insertHero(Hero hero);
	/**
	 * 更新英雄
	 */
	int updateHero(Hero hero);
	/**
	 * 根据名字获取英雄
	 */
	Hero getHeroByName(String name);
	/**
	 * 搜索英雄
	 */
	List<Hero> searchHero(String name);
}
