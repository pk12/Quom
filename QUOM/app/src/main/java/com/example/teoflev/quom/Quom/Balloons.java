package com.example.teoflev.quom.Quom;

import java.util.ArrayList;
import java.util.Collections;

public class Balloons extends Minigame{
  private int[][] balloons = new int[2][5];
  private int TimeRemaining;
  private int count;
  private ArrayList<Integer> mixed = new ArrayList<Integer>();


	public boolean start(){
		TimeRemaining = 10;
		count = 1;
		for (int i = 0; i < 10; i++){
			mixed.add(i + 1);
		}
		Collections.shuffle(mixed);
		int k = 0;
		
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 5; j++){
				balloons[i][j] = mixed.get(k++);
				
			}
		}
		 return false;
		

//			if (/*condition*/)
//				return false;
//			else
//				return true;
//		}
    }
}
