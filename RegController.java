package com.sakha.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegController
 */
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("uname");  
		String e=request.getParameter("email");  
		String p=request.getParameter("pwd");  
		String d=request.getParameter("date");  
		 
		try{  
			
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/test", "root", "root123");  
		  System.out.println("coonection is raised");
		PreparedStatement ps=con.prepareStatement(  
		"insert into UserLogin(Username,Email,PassWord,DOB) values(?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,e);  
		ps.setString(3,p);  
		ps.setDate(4,new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(d).getTime()));  
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		
		          
		}
		catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		  
		 
	}


