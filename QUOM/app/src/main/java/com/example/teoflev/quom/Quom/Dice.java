package com.example.teoflev.quom.Quom;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.ThreadLocalRandom;

public class Dice extends Minigame{

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public boolean start(){
		points = ThreadLocalRandom.current().nextInt(1, 6 + 1); //ypologismos random int meta3y 1-6
		if (points % 2 == 0)
			return true; //an zygos, you win
		else
			return false; //an peritos, you lose
	}
}
