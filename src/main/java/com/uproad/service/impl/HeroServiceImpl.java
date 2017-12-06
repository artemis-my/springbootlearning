package com.uproad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uproad.dao.HeroDao;
import com.uproad.entity.Hero;
import com.uproad.service.HeroService;
@Service
public class HeroServiceImpl implements HeroService {
	@Autowired
	private HeroDao herodao;

	@Override
	public List<Hero> getAllHeroes() {
		List<Hero> heroList=herodao.getAllHeroes();
		return heroList;
	}

	@Override
	public Hero getHeroById(int id) {
		Hero hero=herodao.getHero(id);
		return hero;
	}

	@Override
	public int delHeroById(int id) {
		return herodao.deleteHero(id);
	}

	@Override
	public int insertHero(Hero hero) {
		return herodao.insertHero(hero);
	}

	@Override
	public int updateHero(Hero hero) {
		return herodao.updateHero(hero);
	}

	@Override
	public Hero getHeroByName(String name) {
		return herodao.getHeroByName(name);
	}

	@Override
	public List<Hero> searchHero(String name) {
		name="%"+name+"%";
		return herodao.searchHero(name);
	}

}
