package controller;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;

import databeans.Position;
import model.Model;
import model.PositionDAO;

public class Welcome extends Action{
	
	private PositionDAO positionDAO;
	private Position position;
	
    
    
	
	public String getName() {
		return "help";
	}
	
	public String perform (HttpServletRequest request)  {
		return "index.jsp"; 
	}


}
