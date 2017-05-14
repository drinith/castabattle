package com.castaware.castabattle.control;

import static com.castaware.castabattle.domain.CellType.CRUISER;
import static com.castaware.castabattle.domain.CellType.WATER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.castaware.castabattle.domain.Board;
import com.castaware.castabattle.domain.CellType;

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
	public ModelAndView start()
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
		ModelAndView mv = new ModelAndView("/game.jsp");
		mv.addObject("board",board);
		return mv;
	}	
	
	@RequestMapping("/reset") // .../pswebproj/spring/game/reset
	public ModelAndView reset()
	{
		return start();
	}
	
	@RequestMapping(value="/fire") // .../pswebproj/spring/game/fire
	public ModelAndView fireBoard(@RequestParam String line, @RequestParam String column)
	{
		int l = Integer.parseInt(line);
		int c = Integer.parseInt(column);
		
		
		
		System.out.println(line);
		System.out.println(column);
		System.out.println(l);
		System.out.println(c);
		
		System.out.println(this.board);
		
		CellType type = this.board.fire(c, l);
		
		System.out.println(this.board);
		System.out.println(type);
				
		if (board.hasShip())
		{
			ModelAndView mv = new ModelAndView("/game.jsp");
			mv.addObject("target",type);
			mv.addObject("board",board);
			return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView("/endgame.jsp");
			return mv;
		}
	}
}











	
	
	
	
	
	