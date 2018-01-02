<%@page import="de.asr.iot.entities.SensorData"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Create data</title>
    </head>
 
    <body>
        <form method="POST" action="PersistenceEJBServlet">
            HostName: &nbsp;&nbsp;&nbsp;<input type="text" name="HostName" /><br>
            SensorName: <input type="text" name="SensorName" /><br>
            SensorType: &nbsp;&nbsp;<input type="text" name="SensorType" /><br>
            CreatedAt: &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="CreatedAt" /><br>
            Value: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Value" /><br>
            Unit: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="Unit" /><br>
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> <%
        
/* 
				.println("<p><form action=\"\" method=\"post\">" 
		                + "HostName:<input type=\"text\" name=\"HostName\">"
						+ "&nbsp;SensorName:<input type=\"text\" name=\"SensorName\">" 
						+ "&nbsp;SensorType:<input type=\"text\" name=\"SensorType\">" 
						+ "&nbsp;CreatedAt:<input type=\"text\" name=\"CreatedAt\">" 
						+ "&nbsp;Value:<input type=\"text\" name=\"Value\">" 
						+ "&nbsp;Unit:<input type=\"text\" name=\"Unit\">" 
		                + "&nbsp;<input type=\"submit\" value=\"Add SensorData\">"
						+ "</form></p>");
*/        
            @SuppressWarnings("unchecked") 
            List<SensorData> sensorData = (List<SensorData>)request.getAttribute("AllSensorData");
            if (sensorData != null) {
                for (SensorData sensorDate : sensorData) { %>
                    <li> <%= sensorDate %> </li> <%
                }
            } %>
        </ol><hr>
     </body>
 </html>