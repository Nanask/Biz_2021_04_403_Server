package com.callor.todo.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TodoCommand {
	
	// �����ϴ� ���� �ƴ� ���� throws ServletException, IOException�� ���´�.
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

}
