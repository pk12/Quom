package com.example.teoflev.quom.Quom;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.ThreadLocalRandom;

public class Slots extends Minigame{
  private int points1;
  private int points2;


	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public boolean start(){
		points = ThreadLocalRandom.current().nextInt(1, 3 + 1);             //  points,points1,points2 3 slots pou mporei
		points1 = ThreadLocalRandom.current().nextInt(1, 3 + 1);            //  na paroun 3 times apo 1-3, an 2 kai panw slots
		points2 = ThreadLocalRandom.current().nextInt(1, 3 + 1);            //  exoun tin idia timi -> win ,mporei na alla3ei se
			if (points != points1 && points1 != points2 && points != points2)   //  3 idia i 2 geitonika (an to points == points2 -> lose)
				return false; //an kanena idio, you lose
			else
				return true; //an 2 i 3 idia, you win
	}
}
