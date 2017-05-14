package com.castaware.castabattle.domain;

import java.util.Arrays;

public class Board 
{
	private static int SIZE = 10;
	
	private CellType[][] boardGame = new CellType[SIZE][SIZE];
	private CellType[][] boardTemplate = new CellType[SIZE][SIZE];

	private int hitPoints;
	
	public CellType[][] getBoardGame() {
		return boardGame;
	}
	
	public CellType[][] getBoardTemplate() {
		return boardTemplate;
	}
	
	public void initBoard(CellType[][] boardTemplate)
	{
		for (int i=0;i<SIZE;i++)
		{
			for (int j=0;j<SIZE;j++)
			{
				boardGame[i][j] = CellType.HIDDEN;
			}
		}
		
		this.boardTemplate = boardTemplate;
		
		for (int i=0;i<SIZE;i++)
		{
			for (int j=0;j<SIZE;j++)
			{
				CellType target = boardTemplate[i][j];
				
				if (target.isShip())
					hitPoints++;
			}
		}
	}
	
	public CellType fire(int column,int line)
	{
		int y = line-1;		
		int x = column-1;
		
		CellType target = boardTemplate[y][x];
		
		// Se atingiu alguma embarca��o, marca com fogo
		if (target.isShip())
		{
			boardGame[y][x] = CellType.FIRE;
			hitPoints--;
		}
		else
		{
			boardGame[y][x] = CellType.WATER;
		}		
				
		return target;
	}
	
	public CellType readInGame(int column,int line)
	{
		int y = translateLine(line);		
		int x = translateLine(column);
		
		CellType target = boardGame[y][x];
		
		return target;
	}
	
	public CellType readInTemplate(int column,int line)
	{
		int y = translateLine(line);		
		int x = translateColumn(column);
		
		CellType target = boardTemplate[y][x];
		
		return target;
	}
	
	public boolean hasShip()
	{
		return hitPoints > 0;
	}
	
	@Override
	public String toString()
	{
		String result =   "BOARD\n";
		result = result + "=====\n";
		
		for(int i=0;i<10;i++)
		{
			result = result + Arrays.toString(boardGame[i]) + "\n";
		}
		
		return result;
	}	
	
	
	public String getImprimirFormato()
	{
		String result =   "BOARD\n";
		result = result + "=====\n";
		
		for(int i=0;i<10;i++)
		{
			for (int j = 0; j < boardGame.length; j++) {
				result = result +"<img src=\"/castabattle/images/"+ boardGame[i][j].toString().toLowerCase()+".jpg\"/>";
				System.out.println(result);
			}
			
			result=result+"<br>";
		}
		
		return result;
	}
	
	private int translateColumn(int column) {
		int x = column - 1;

		if (x < 0 || x > 9) {
			throw new IllegalArgumentException("Invalid line definition: " + column);
		}
		return x;
	}

	

	private int translateLine(int line) 
	{
		int y = line-1;
		
		if (y<0 || y>9)
		{
			throw new IllegalArgumentException("Invalid line definition: "+line);
		}
		return y;
	}
	
	
}



















