package com.castaware.castabattle.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.castaware.castabattle.domain.CellType.WATER;
import static com.castaware.castabattle.domain.CellType.BOAT;       //1 espaço
import static com.castaware.castabattle.domain.CellType.SUBMARINE;  //2 espaços
import static com.castaware.castabattle.domain.CellType.DESTROYER;  //3 espaços
import static com.castaware.castabattle.domain.CellType.CRUISER;    //4 espaços
import static com.castaware.castabattle.domain.CellType.BATTLESHIP; //5 espaços

public class BoardGenerator {

	public static Board getRandomBoard() {

		ArrayList<String> options = new ArrayList<String>();
		options.add("BOAT");
		options.add("SUBMARINE");
		options.add("DESTROYER");
		options.add("CRUISER");
		options.add("BATTLESHIP");

		CellType[][] template = new CellType[][]  {{WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},   
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},	
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		                                      
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER},		
												   {WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER, WATER}};
												   
		int count, rand, linha, coluna, tam = 0, i = 0;
		String result;
		CellType ship = null;
		boolean dimensao = true;
		while(options.size() > 0){
			i = randInt(0, 9);
			dimensao = randInt(0, 1) == 0 ? false : true ; 
			Collections.shuffle(options);
			result = options.get(0);
			if(result.equals("BOAT")){
				tam = 1;
				ship = BOAT;
			}else if (result.equals("SUBMARINE")){
				tam = 2;
				ship = SUBMARINE;
			}else if (result.equals("DESTROYER")){
				tam = 3;
				ship = DESTROYER;
			}else if (result.equals("CRUISER")){
				tam = 4;
				ship = CRUISER;
			}else if (result.equals("BATTLESHIP")){
				tam = 5;
				ship = BATTLESHIP;
			}
			
			linha = i;
			count = 0;
			coluna = randInt(0, (9 - tam));
			if (dimensao) {
				try {
					for (int j = coluna; j < tam; j++) {
						if (template[i][j] != WATER){
							count++;
						}
					}
				} catch (Exception e) {
					continue;
				}
			}else{
				try {
					for (int j = coluna; j < tam; i++) {
						if (template[i][j] != WATER){
							count++;
						}
					}
				} catch (Exception e) {
					continue;
				}
			}
			
			
			if (count == 0) {
				for (int k = 0; k < tam; k++) {
					try {
						if (dimensao) {
							template[linha][(coluna + k)] = ship;
						}else{
							template[(linha + k)][coluna] = ship;
						}
					} catch (Exception e) {
						continue;
					}
					
				}
				options.remove(0);
			}
		}
		
        //Print template board
		System.out.println("\n\n");
        for (int _i = 0; _i < template.length; _i++) {
            for (int j = 0; j < template[_i].length; j++) {
                System.out.print(template[_i][j] + " ");
            }
            System.out.println();
        }
        //
        
        
		Board board = new Board();
		board.initBoard(template);
		return board;
	}
	
	public static void main(String[] args) {
		Board board = BoardGenerator.getRandomBoard();
			
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
}
