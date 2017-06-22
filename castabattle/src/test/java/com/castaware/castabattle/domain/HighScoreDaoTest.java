package com.castaware.castabattle.domain;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.castaware.castabattle.dao.HighScoreDao;
import com.castaware.castabattle.domain.HighScore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/springweb-servlet.xml"})
public class HighScoreDaoTest 
{
	@Autowired
	private HighScoreDao hsDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	@Before
	public void clear()
	{
		jdbcTemplate.execute("delete from highscore");
	}
	
	@Test
	public void testExists()
	{		
		Assert.assertNotNull(hsDao);
	}
			
	@Test
	@Rollback(false)
	public void testInsert()
	{		
		HighScore hs = new HighScore();
		hs.setJogador("Felipe");
		hs.setPontos(100);
		hs.setData1(new Date(System.currentTimeMillis()));
		hs.setData2(new Date(System.currentTimeMillis()));
		
		hsDao.save(hs);
		
		Assert.assertNotNull(hs.getId());		
		
		HighScore hsRetrieve = hsDao.retrieveById(hs.getId());
		Assert.assertEquals(hs.getJogador(), hsRetrieve.getJogador());
		Assert.assertEquals(hs.getPontos(), hsRetrieve.getPontos());
		Assert.assertEquals(df.format(hs.getData1()), df.format(hsRetrieve.getData1()));
		Assert.assertEquals(df.format(hs.getData2()), df.format(hsRetrieve.getData2()));
	}
	
	
}
