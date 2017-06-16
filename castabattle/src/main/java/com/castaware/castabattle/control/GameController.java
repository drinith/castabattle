package com.castaware.castabattle.control;

import static com.castaware.castabattle.domain.CellType.CRUISER;
import static com.castaware.castabattle.domain.CellType.WATER;import java.sql.Date;import java.text.DateFormat;import java.text.SimpleDateFormat;import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;import com.castaware.castabattle.dao.HighScoreDao;import com.castaware.castabattle.domain.Board;
import com.castaware.castabattle.domain.CellType;import com.castaware.castabattle.domain.HighScore;

@Controller
@RequestMapping("/game") // .../pswebproj/spring/game
public class GameController
{
	// TODO - Temporário... Não suporta multiplayer...
	private Board board;
	
	@RequestMapping() // .../pswebproj/spring/game
	public ModelAndView index()
	{	
		ModelAndView mv = new ModelAndView("/index.jsp");
		return mv;
	}	
	
	@RequestMapping("/start") // .../pswebproj/spring/game/start
	public ModelAndView start(@RequestParam String nome)
	{
		CellType[][] template = new CellType[][]  { {WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},   
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},	
			{WATER, WATER,   WATER ,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		                                      
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER , WATER, WATER, WATER},		
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
			{WATER, CRUISER, CRUISER, CRUISER, CRUISER, WATER, WATER, WATER, WATER, WATER},		
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},		
			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER} };

		this.board = new Board();
		this.board.initBoard(template);
		ModelAndView mv = new ModelAndView("/game.jsp");		mv.addObject("nome", nome);		
		mv.addObject("board",board);
		return mv;
	}	
	
	@RequestMapping("/reset") // .../pswebproj/spring/game/reset
	public ModelAndView reset()
	{
		return start(null);
	}
	
	@RequestMapping(value="/fire") // .../pswebproj/spring/game/fire
	public ModelAndView fireBoard(@RequestParam String line, @RequestParam String column, @RequestParam String nome)
	{
		int l = Integer.parseInt(line);
		int c = Integer.parseInt(column);
		
		CellType type = this.board.fire(c, l);
		
				
		if (board.hasShip())
		{
			ModelAndView mv = new ModelAndView("/game.jsp");
			mv.addObject("target",type);
			mv.addObject("board",board);
			return mv;
		}
		else
		{			DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");			HighScore highScore = new HighScore();			highScore.setJogador(nome);												HighScoreDao daoH= new HighScoreDao();			daoH.save(highScore);							
			ModelAndView mv = new ModelAndView("/endgame.jsp");
			return mv;
		}
	}
}











	
	
	
	
	
	