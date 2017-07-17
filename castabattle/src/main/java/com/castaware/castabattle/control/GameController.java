package com.castaware.castabattle.control;
import static com.castaware.castabattle.domain.CellType.CRUISER;import static com.castaware.castabattle.domain.CellType.WATER;import java.sql.Date;import java.util.Collections;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.RequestParam;import org.springframework.web.servlet.ModelAndView;import com.castaware.castabattle.dao.HighScoreDao;import com.castaware.castabattle.domain.Board;import com.castaware.castabattle.domain.CellType;import com.castaware.castabattle.domain.HighScore;
@Controller
@RequestMapping("/game") // .../pswebproj/spring/game
public class GameController
{	@Autowired	private HighScoreDao hsDao;
	// TODO - Temporário... Não suporta multiplayer...
	private Board board;	private int tiro;	private int pontos;
	@RequestMapping() // .../pswebproj/spring/game
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("/index.jsp");
		return mv;
	}	
	@RequestMapping("/start") // .../pswebproj/spring/game/start
	public ModelAndView start(@RequestParam String nome)
	{		//zerar a contagem tiro		tiro=0;		pontos=100;		
		CellType[][] template = new CellType[][]  {			{WATER, WATER,   WATER,   WATER,   WATER,   WATER, WATER, WATER, WATER, WATER},   
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
		ModelAndView mv = new ModelAndView("/game.jsp");		mv.addObject("nome", nome);		mv.addObject("pontos", pontos);
		mv.addObject("board",board);
		return mv;
	}	
	@RequestMapping("/reset") // .../pswebproj/spring/game/reset
	public ModelAndView reset(@RequestParam String nome)
	{
		return start(nome);
	}
	@RequestMapping(value="/fire", method = RequestMethod.GET) // .../pswebproj/spring/game/fire
	public ModelAndView fireBoard(@RequestParam String line, @RequestParam String column, @RequestParam String nome)
	{		tiro+=1;
		int l = Integer.parseInt(line);
		int c = Integer.parseInt(column);
		CellType type = this.board.fire(c, l);
		if (board.hasShip())
		{						
			ModelAndView mv = new ModelAndView("/game.jsp");
			mv.addObject("target",type);			mv.addObject("pontos",pontos-tiro);
			mv.addObject("board",board);
			return mv;
		}
		else
		{			//Termino do jogo guardar os valores do score do jogador			HighScore hs = new HighScore();			hs.setJogador(nome);			hs.setPontos(100-tiro);			hs.setData1(new Date(System.currentTimeMillis()));			hs.setData2(new Date(System.currentTimeMillis()));			hsDao.save(hs);										//Trazer a lista para listar na página do endgame			List<HighScore> listHigh = hsDao.retrieveAll();						Collections.sort(listHigh);						ModelAndView mv = new ModelAndView("/game.jsp");			mv.addObject("nome",nome);			mv.addObject("listaScore",listHigh);			
			return mv;
		}
	}
}