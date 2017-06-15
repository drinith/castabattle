package com.castaware.castabattle.dao;

import org.springframework.stereotype.Repository;

import com.castaware.castabattle.domain.HighScore;

@Repository
public class HighScoreDao extends _CrudDaoHibernate<HighScore> 
{
	@Override
	public Class<HighScore> getPersistentClass() 
	{
		return HighScore.class;
	}

}
