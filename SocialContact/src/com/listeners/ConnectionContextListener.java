package com.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionContextListener implements ServletContextListener {

	Connection con;
    public ConnectionContextListener() { }

    public void contextDestroyed(ServletContextEvent ctx) 
    { 
    	try
		{
			Connection con=(Connection) ctx.getServletContext().getAttribute("DBConnection");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//Some change
		}
    }

    public void contextInitialized(ServletContextEvent ctx) 
    { 
//    	String driver=ctx.getServletContext().getInitParameter("driver");	
//		String url=ctx.getServletContext().getInitParameter("url");
    	String url="jdbc:derby:C:\\Users\\Fiona\\Documents\\workspace-sts-3.9.9.RELEASE\\derby\\mydb";
    	String driver="org.apache.derby.jdbc.EmbeddedDriver";
		try
		{
			Class.forName(driver);
			con= DriverManager.getConnection(url);	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ctx.getServletContext().setAttribute("DBConnection",con);	
    }
	
}
