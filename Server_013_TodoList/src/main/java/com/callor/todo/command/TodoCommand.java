package com.callor.todo.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TodoCommand {
	
	// 연동하는 것이 아닌 직접 throws ServletException, IOException를 적는다.
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}
