package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Model model;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
        model = new Model(getServletConfig());
        
        
        Action.add(new GetLocation(model)); 
        Action.add(new Welcome());

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("Served at:"+request.getContextPath());
		
		 //String nextPage = performTheAction(request);
	     //sendToNextPage(nextPage, request, response);
	        
        String message = performTheAction(request);
        System.out.println("first doGet meesage"+message);
        
        if (message==null) {
        	System.out.println("message==null");
        	//RequestDispatcher d = request.getRequestDispatcher("WEB-INF/" + "help.html");            
           // d.forward(request, response);
        	 //response.setContentType("application/json");
 	    	PrintWriter out = response.getWriter();
 	    	out.println("<html>"+"<body>"+"<h1>"+"Outch! no messages!"+"</h1></body></html>");
 	    	System.out.println("if Message!=null then message:"+message);
            return;
        	}
        else if (message.equals("index.jsp")){
        	System.out.println("message=>"+message+" requestPath:"+request.getContextPath());
        	
        	//response.sendRedirect("http://localhost:8080/Beacon/WEB-INF/index.jsp");
        	  //RequestDispatcher d = request.getRequestDispatcher("WEB-INF/" + message);
              //d.forward(request, response);
               // response.sendRedirect(message);
        	//sendToNextPage(message,request,response);
              return;
        		
        	
        	}
        
        else if(message != null&& message!="index.jsp") {
        	
        	
	        response.setContentType("application/json");
	    	response.getWriter().write(message);
	    	System.out.println("if Message!=null then message:"+message);
	    	
        }
        
        
        
	}
    private String performTheAction(HttpServletRequest request) {
       // String servletPath = request.getPathInfo();
    	
    	String servletPath= request.getServletPath();
        String action = getActionName(servletPath);
        System.out.println("Path="+request.getServletPath());
        System.out.println("Action Name: " + action);
        
        
    	return Action.perform(action, request);
    }
    
    
    private String getActionName(String path) {
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
/*
	private void sendToNextPage(String nextPage, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (nextPage == null) {
        	System.out.print("next Page ==null");
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }

     
       // if (nextPage.endsWith(".do")) {
         //   response.sendRedirect(nextPage);
           // return;
        //}

        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/"
                    + nextPage);
            d.forward(request, response);
            return;
        }


        throw new ServletException(Controller.class.getName()
                + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }
    */
    
}
