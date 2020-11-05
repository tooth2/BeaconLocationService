package controller;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.media.jfxmedia.logging.Logger;

import databeans.Position;
import formbeans.LocationForm;
import model.Model;
import model.PositionDAO;
import java.util.logging.*;




public class GetLocation extends Action{

		private PositionDAO positionDAO;
		private Position position;
		
	    
	    public GetLocation(Model model) {
	        positionDAO = model.getPositionDAO();
	    }
		
		public String getName() {
			return "getLocation";
		}
		
		public String perform (HttpServletRequest request)  {
			JsonObject obj = new JsonObject();
			BufferedReader br;
			String line;
			

			
			try {
				br = request.getReader();
				Gson gson = new Gson();
				line = br.readLine();
				
				Logger.logMsg(0, line);
				
				System.out.println("line:"+line);
				
				LocationForm form = gson.fromJson(line, LocationForm.class);
				
				//System.out.println("Uid from json"+form.getUid()+":"+form.getAccuracy()+"grained");
			
				
				if (form.hasErrors()) {
					obj.addProperty("message", "Form Errors: There seems to be an issue with the UID/accuracy combination that you entered");
				} 
				else {
				
						
					  Transaction.begin();
			        	//Position position = positionDAO.read(form.getUidNamespace(), form.getUidInstace());
				      Position position = positionDAO.read(form.getUid());  
					  if(position==null) {
				        	obj.addProperty("message", "no data for this sensor");
			                Transaction.commit();
			                return obj.toString();
				        	
				        }
				        	
				        	System.out.println("location from db:"+position.getLocation());
			            //Position[] positions = positionDAO.match(MatchArg.equals(form.getUidNamespace(), form.getUidInstace()));
						/*
			            if (positions.length == 0) {
			                obj.addProperty("message", "no data");
			                Transaction.commit();
			                return obj.toString();
			            }
			            */

			            Transaction.commit();
						//form.getUidNamespace().equals(position.getUidNamespace())&&form.getUidInstace().equals(position.getUidInstance())) {
					
			            if ((form.getAccuracy()).equals("fine"))
						obj.addProperty("message", "I am nearby " +   position.getLocation() + " in the "+ position.getBuilding()+ " Building " + position.getFloor());
			            else if ((form.getAccuracy()).equals("coarse"))
			            	obj.addProperty("message", "I am " +   " in the "+ position.getBuilding()+ " Building " + position.getFloor());
			            else obj.addProperty("message", "Accuracy is not determined: I am in this "+  position.getBuilding()+ " Building ");
						
				}

			} catch (IOException e) {
				obj.addProperty("message", "IOException: There seems to be an issue with database access");
			} catch (RollbackException e) {
	            e.printStackTrace(); 
	        } 
			return obj.toString();
			
	
		}
}
