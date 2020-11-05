package databeans;

import org.genericdao.PrimaryKey;

//@PrimaryKey("uidNamespace,uidInstance")

@PrimaryKey("uid")
public class Position {
	private String uid;
    private String uidNamespace;
    private String uidInstance;
    private String location;
    private String title;
    private String building;
    private String floor;
    
    /*
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
        	Position other = (Position) obj;
            return uidNamespace.equals(other.uidNamespace);
        }
        return false;
    }
    */

    public String getBuilding(){
    	return building;
    }
    public void setBuilding (String building){
    	this.building= building;
    }
    
    public String getFloor(){
    	return floor;
    }
    public void setFloor (String floor){
    	this.floor= floor;
    }
    
    public String getTitle(){
    	return title;
    }
    public void setTitle (String title){
    	this.title= title;
    }
    
    public String getUid(){
    	return uid;
    }
    public void setUid(String uid){
    	this.uid=uid;
    }
    public String getUidNamespace() {
        return uidNamespace;
    }
    
    public void setUidNamespace(String uidNamespace) {
        this.uidNamespace = uidNamespace;
    }
    
    public String getUidInstance() {
        return uidInstance;
    }
    
    public void setUidInstance(String uidInstance) {
        this.uidInstance = uidInstance;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
}

