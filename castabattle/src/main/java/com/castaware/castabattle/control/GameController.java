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

		board = new Board();
		board.initBoard(template);
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
		
		String x;
		if 		(c == 1) x = "A";
		else if (c == 2) x = "B";
		else if (c == 3) x = "C";
		else if (c == 4) x = "D";
		else if (c == 5) x = "E";
		else if (c == 6) x = "F";
		else if (c == 7) x = "G";
		else if (c == 8) x = "H";
		else if (c == 9) x = "I";
		else if (c == 10) x = "J";
		else
			throw new IllegalArgumentException("Invalid column definition: "+column);
		
		System.out.println(line);
		System.out.println(column);
		System.out.println(l);
		System.out.println(c);
		
		CellType type = board.fire(x, l);
		
		System.out.println(board);
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











	
	
	
	
	
	