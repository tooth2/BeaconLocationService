<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!--<jsp:include page="css.jsp" />-->
<title>BLE Sensor Indoor Location Tracking REST API</title>
</head>
<body>

 <h1>BLE Sensor Indoor Location Tracking REST API</h1>
  <jsp:include page="header.jsp" />
<p>This is the home page for listing examples illustrate how to call Beacon Indoor Location Tracking REST API Call utilizing BLE beacon sesnors deployed in CMU.
<p>To prove that they work, you can execute either of the following links:
<ul>
<p>To utilize beacon Indoor location tracking Service, Here I am sharing REST API specification. 

<li> URL : https://35.164.249.96/Beacon/ </li>
<li> Method Type: POST</li>
<li> Method Name:getLocation </li>
<li> Body(Payload): JSON Format including two key-value pair : "uid" and "accuracy" </li>
<ul></ul>
JSON Object is composed with two parameters: "uid" and "accuracy" 

<ul></ul>
<li> For the value of "uid" Blue tooth device should receive UID frame and parse UID value from there. </li> 
<li> For the value of "accuracy" the app can set either "fine" grained mode location information vs. "coarse" grained location(default is "coarse" ) </li> 
<ul></ul>
As an example, the JSON payload would look like this: 

<li>{"uid":"2A2F6A6A-7800-46AB-9DD9-76C87401CD78","accuracy":"fine"}</li>


The result from REST API would look like this (JSON Format as well) based on previous uid value, for example. 


</p>
<li>Accuracy "fine" mode: {"message": "I am nearby SCS FMS Office/Student Lounge/Connecting to NSH in the Gates Building 4F"}</li>
<li>Accuracy "coarse" mode: {"message": "I am  in the Gates Building 4F"}</li>
</ul>
<!-- <script src="js/scripts.js"></script> -->
 <jsp:include page="footer.jsp" />
</body>
</html>