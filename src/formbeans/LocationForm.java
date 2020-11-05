package formbeans;

import org.mybeans.form.FormBean;

public class LocationForm extends FormBean {
	//private String uidNamespace;
    //private String uidInstance;
    private String uid;
    private String accuracy; 
    
    public String getUid(){
    	return uid;
    }
    public void setUid(String s){
    	uid=trimAndConvert(s,"<>\"");
    }
    
    public String getAccuracy(){
    	return accuracy;
    }
    public void setAccuracy(String s){
    	accuracy=trimAndConvert(s,"<>\"");
    }
    /*
	public String getUidNamespace() {
		return uidNamespace;
	}
	public void setUidNamespacee(String s) {
		uidNamespace = trimAndConvert(s,"<>\"");
	}
	public String getUidInstace() {
		return uidInstance;
	}
	public void setUidInstace(String s) {
		uidInstance = s.trim();
	}
       */
    public boolean hasErrors() {
    	
    	if ((uid==null||uid.length()==0) && (accuracy==null||accuracy.length()==0)){
    		return true;
    	}
    
    	
    	/*if (uidNamespace == null || uidNamespace.length() == 0) {
    		System.out.println(uidNamespace); 
    		return true;
    	}
    	
    	if(uidInstance == null || uidInstance.length() == 0) {
    		System.out.println(uidInstance); 
    		return true;
    	}
    	*/
    	return false;
    }
}
