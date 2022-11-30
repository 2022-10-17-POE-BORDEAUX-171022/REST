package com.m2i.services;

import java.util.Arrays;
import java.util.Random;

import com.google.gson.Gson;
import com.m2i.modele.Score;


public class GameService {
	Score score = new Score();
	Random r = new Random();
	String[][] table= new String[][] {{"tie",		"lose",		"win"},{"win",		"tie",		"lose"},{"lose",		"win",		"tie"}};

	
	public Score getScore() {
		return score;
	}

	public void setScore(int win, int lose, int tie) {
		
		score.setLose(lose);
		score.setWin(win);
		score.setTie(tie);
		
	}

	public String play(String action) {
		String servAction= new String[]{"rock", "paper", "scissors"}[r.nextInt(3)];
		String result = "";
		
		switch (action) {
			case "rock":
				if ( servAction.equals("rock") )
					result = "tie";
				else if ( servAction.equals("paper"))
					result = "lose";
				else 
					result = "win";
				break;
			case "paper":
				if ( servAction.equals("rock") )
					result = "win";
				else if ( servAction.equals("paper"))
					result = "tie";
				else 
					result = "lose";				
				break;
			case "scissors":
				if ( servAction.equals("rock") )
					result = "lose";
				else if ( servAction.equals("paper"))
					result = "win";
				else 
					result = "tie";
				break;
		}
		
		addScore(result);		
		return "You :" + action + "\tServer :" + servAction + "\tResult :" + result + "\t Score :" + new Gson().toJson(score);
	}
	
	
	public String play2(String action) {
		
		
		int actionJoueurInt = Arrays.asList(new String[] { "rock", "paper", "scissors" }).indexOf(action);
		int servActionInt = r.nextInt(3);
		String servActionString = new String[]{"rock", "paper", "scissors"}[servActionInt];
					  
		String result = table[servActionInt][actionJoueurInt];
		addScore(result);		
		return "You :" + action + "\tServer :" + servActionString + "\tResult :" + result + "\t Score :" + new Gson().toJson(score);
	}
	
	
	public String play3(String action) {
		int actionJoueurInt = Arrays.asList(new String[] {"rock","paper","scissors"}).indexOf(action);
		int servActionInt = r.nextInt(3);
		String servActionString = new String[]{"rock", "paper", "scissors"}[servActionInt];
					
		String result = (new String[] { "tie", "lose", "win" }[(2 * actionJoueurInt + servActionInt) % 3]);
		
		addScore(result);		
		return "You :" + action + "\tServer :" + servActionString + "\tResult :" + result + "\t Score :" + new Gson().toJson(score);

	}
	private void addScore(String result) {
		switch (result) {
		case "win":
			score.addWin();
			break;
		case "lose":
			score.addLose();
			break;
		case "tie":
			score.addTie();
			break;
	}
	}
	
}
