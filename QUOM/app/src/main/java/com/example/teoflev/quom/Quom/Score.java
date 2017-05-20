package com.example.teoflev.quom.Quom;

public class Score{
	private String name;
	private String end_string;
	private int score;
	
	public Score(String name,int score){
		this.name = name;
		this.score = score;
	}
	
	public String to_string(){
		end_string = name + " " + score	;
		return end_string;
	}

}