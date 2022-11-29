package com.rest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rest.dao.UserDAO;
import com.rest.modele.User;


@WebServlet("/json")
public class JsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> users = UserDAO.getAllUser();
		String usersJson = new Gson().toJson(users);
		
		response.setContentType("application/json");
		response.getWriter().write(usersJson);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email"); 
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if ( email != null && login != null && password != null) {
			if ( UserDAO.createUser(email, login, password))
				response.setStatus(200);
			else
				response.setStatus(424);
		} else {
			response.setStatus(400);
		}
	}
	
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email"); 
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			int id = Integer.parseInt( request.getParameter("id") );	
			
			if ( email != null && login != null && password != null) {
				UserDAO.updateUser(id, email, login, password);
			} else {
				response.setStatus(400);
			}
		} catch (NumberFormatException e) {
			response.setStatus(400);
		}
		

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id") );
			UserDAO.deleteUserById(id);
			response.setStatus(200);				
		} catch (NumberFormatException e) {
			response.setStatus(400);
		}
	}
}



