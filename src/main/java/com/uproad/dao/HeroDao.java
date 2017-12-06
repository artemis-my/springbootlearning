package com.uproad.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.uproad.entity.Hero;

/**
 * hero dao
 * @author jsmen
 *
 */
@Mapper
public interface HeroDao {
	@Select("select * from hero")
	@Results({
			@Result(property="id",column="id"),
			@Result(property="name",column="name")
			})
	List<Hero> getAllHeroes();
	@Select("select * from hero where id=#{id}")
	@Results({
			@Result(property="id",column="id"),
			@Result(property="name",column="name")
			})
	Hero getHero(int id);
	@Update("update hero set name=#{name} where id=#{id}")
	int updateHero(Hero hero);
	@Insert("insert into hero values(0,#{name})")
	int insertHero(Hero hero);
	@Delete("delete from hero where id=#{id}")
	int deleteHero(int id);
	@Select("select * from hero where name=#{name}")
	@Results({
			@Result(property="id",column="id"),
			@Result(property="name",column="name")
			})
	Hero getHeroByName(String name);
	@Select("select * from hero where name like #{name}")
	@Results({
		@Result(property="id",column="id"),
		@Result(property="name",column="name")
		})
	List<Hero> searchHero(String name);
}
