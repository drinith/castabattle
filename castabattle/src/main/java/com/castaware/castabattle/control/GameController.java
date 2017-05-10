package com.castaware.castabattle.control;

import static com.castaware.castabattle.domain.CellType.CRUISER;
import static com.castaware.castabattle.domain.CellType.WATER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/fire") // .../pswebproj/spring/game/fire
	public ModelAndView helloRequestParam
	                           (@RequestParam int line,
								@RequestParam int column)
	{
		String x;
		if 		(column == 0) x = "A";
		else if (column == 1) x = "A";
		else if (column == 2) x = "A";
		else if (column == 3) x = "A";
		else if (column == 4) x = "A";
		else if (column == 5) x = "A";
		else if (column == 6) x = "A";
		else if (column == 7) x = "A";
		else if (column == 8) x = "A";
		else if (column == 9) x = "A";
		else
			throw new IllegalArgumentException("Invalid column definition: "+column);
		
		CellType type = board.fire(x, line);
				
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











	
	
	
	
	
	