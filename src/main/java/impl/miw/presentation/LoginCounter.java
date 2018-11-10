package impl.miw.presentation;

import java.util.LinkedList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginCounter implements ServletContextListener, HttpSessionListener, ServletRequestListener {
	private static final String ATTRIBUTE_NAME = "impl.miw.presentation.LoginCounter";
	private static int numberOfSessionsCount = 0;
	private static LinkedList<String> sesiones = new LinkedList<String>();

	
	public static int getNumberOfSessionsCount(){
		//System.out.println("------------------------------------------------------------- COUNTER -------------------------------");
	    return numberOfSessionsCount;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("---------------------------------------------------- SESSION CREATED COUNTER -------------------------------");
		//numberOfSessionsCount++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        if(!sesiones.contains(sessionId)){
        	sesiones.add(sessionId);
        	System.out.println("--------------- SESSION CREATED COUNTER -------------------------------");
    		numberOfSessionsCount++;
        }
	}
	
	
		 
	
}
