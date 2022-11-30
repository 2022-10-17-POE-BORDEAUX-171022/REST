package com.m2i.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.m2i.services.GameService;


@WebServlet("/game")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	GameService game = new GameService();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String scoreToJson = new Gson().toJson(game.getScore());
		
		response.setContentType("application/json");
		response.getWriter().write(scoreToJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			
			if (action == null || ( !action.equals("rock") && !action.equals("paper") && !action.equals("scissors") ) )
				throw new Exception();
			else {
				response.setContentType("text/plain");
				response.getWriter().write( game.play2(action) );
			}
			
		} catch (Exception e) {
			response.setStatus(400);
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int win = Integer.parseInt( request.getParameter("win") );
			int lose = Integer.parseInt( request.getParameter("lose"));
			int tie = Integer.parseInt( request.getParameter("tie"));			
			
			game.setScore(win, lose, tie);
			String scoreToJson = new Gson().toJson(game.getScore());
			
			response.setContentType("application/json");
			response.getWriter().write(scoreToJson);

		} catch (Exception e) {
			response.setStatus(400);
		}
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		game.setScore(0, 0, 0);
		String scoreToJson = new Gson().toJson(game.getScore());
		
		response.setContentType("application/json");
		response.getWriter().write(scoreToJson);
		
	}

}
