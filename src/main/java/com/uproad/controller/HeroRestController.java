package com.uproad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uproad.entity.Hero;
import com.uproad.service.HeroService;

@RestController
public class HeroRestController {
	@Autowired
	private HeroService heroservice;
	@RequestMapping(value="/api/hero/all",method=RequestMethod.GET)
	public List<Hero> getAllHero(){
		return heroservice.getAllHeroes();
	}
	@RequestMapping(value="/api/hero/id",method=RequestMethod.GET)
	public Hero getHero(@RequestParam(value="id",required=true) int id){
		return heroservice.getHeroById(id);
	}
	@RequestMapping(value="/api/hero/name",method=RequestMethod.GET)
	public Hero getHeroByName(@RequestParam(value="name",required=true) String name){
		return heroservice.getHeroByName(name);
	}
	@RequestMapping(value="/api/hero",method=RequestMethod.POST)
	public int insertHero(@RequestBody Hero hero){
		//System.out.println(hero.getName());
		return heroservice.insertHero(hero);
	}
	@RequestMapping(value="/api/hero/delete",method=RequestMethod.GET)
	public int delHero(@RequestParam(value="id",required=true) int id){
		return heroservice.delHeroById(id);
	}
	@RequestMapping(value="/api/hero/update",method=RequestMethod.POST)
	public int updateHero(@RequestBody Hero hero){
		return heroservice.updateHero(hero);
	}
	@RequestMapping(value="/api/hero/search",method=RequestMethod.GET)
	public List<Hero> searchHero(@RequestParam(value="name",required=true) String name){
		return heroservice.searchHero(name);
	}
}
