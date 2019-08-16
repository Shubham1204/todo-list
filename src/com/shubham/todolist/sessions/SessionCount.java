package com.shubham.todolist.sessions;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCount
 *
 */
@WebListener
public class SessionCount implements HttpSessionListener {
	public static int usercount ;
  
    public SessionCount() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	usercount++;
    	System.out.println("Session Created "+usercount);
    }
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	usercount--;
    	System.out.println("Session Kill "+usercount);
    }
	
}