# IoT_BeaconRepository
 Using Beacon, this web service provides CMU beacon's fine/coarse grained location database.

### Sensors are everywhere!
>BLE beacon sensors and your mobile devices
You can locate where you are in the building even in the floor and corridor. 


### Indoor Location Positioning
Now you can locate where you are at the specific building, floor and corridor.
You can see where the hot spot is in CMU. Currently Sesnsors are deployed NSH, Wean Hall and Gates Hall. More to come! Some sensors are attached to hot spots like Cafe or Student Lounge. You can now post and subscribe all the events to those spots.
### REST API
>The Indoor location positioning API is based on REST API and JSON so that it is very easy to use. We provide fine-grained and coarse-grained location positioning services. For example, as for "fine-grained" mode, you will get "I am nearby Tazza Coffee serving table in the Gates Building 3F" whereas in "corase-grained mode"
you will get "I am in the Gates Building 3F".

<title>BLE Sensor Indoor Location Tracking REST API</title>
</head>
<body>

 <h1>BLE Sensor Indoor Location Tracking REST API</h1>
  <jsp:include page="header.jsp" />
<p>This is the home page for listing examples illustrate how to call Beacon Indoor Location Tracking REST API Call utilizing BLE beacon sesnors deployed in CMU.
<p>To prove that they work, you can execute either of the following links:
<ul>
<p>To utilize beacon Indoor location tracking Service, Here I am sharing REST API specification. 
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
