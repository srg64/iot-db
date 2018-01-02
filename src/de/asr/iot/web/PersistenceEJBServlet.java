package de.asr.iot.web;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.asr.iot.entities.PersistenceBean;
import de.asr.iot.entities.SensorData;
import de.asr.iot.entities.SensorDataBean;

/**
 * Servlet implementation class PersistenceEJBServlet
 */
@WebServlet("/PersistenceEJBServlet")
public class PersistenceEJBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceEJBServlet.class);

	//	@EJB
	//	HostBean hostBean;
	//	@EJB
	//	SensorBean sensorBean;
	@EJB
	SensorDataBean sensorDataBean;
	@EJB
	PersistenceBean persistenceBean;
	
	/** {@inheritDoc} */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display the list of guests:
        request.setAttribute("AllSensorData", sensorDataBean.getAllSensorData());
        request.getRequestDispatcher("/createData.jsp").forward(request, response);

//		response.getWriter().println("<p>Persistence with JPA!</p>");
//		try {
//			appendBookTable(response);
//			appendAddForm(response);
//		} catch (Exception e) {
//			response.getWriter().println("Persistence operation failed with reason: " + e.getMessage());
//			LOGGER.error("Persistence operation failed", e);
//		}
	}

	/** {@inheritDoc} */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
        // Handle a new guest:
		doAdd(request);
 
        // Display the list of guests:
        doGet(request, response);
//		try {
//			doAdd(request);
//			doGet(request, response);
//		} catch (Exception e) {
//			response.getWriter().println("Persistence operation failed with reason: " + e.getMessage());
//			LOGGER.error("Persistence operation failed", e);
//		}
	}

	@SuppressWarnings("unused")
	private void appendBookTable(HttpServletResponse response) throws SQLException, IOException {
		// Append table that lists all books
		List<SensorData> resultList = sensorDataBean.getAllSensorData();
		response.getWriter().println("<p><table border=\"1\"><tr><th colspan=\"3\">" + (resultList.isEmpty() ? "" : resultList.size() + " ")
				+ "Entries in the Database</th></tr>");
		if (resultList.isEmpty()) {
			response.getWriter().println("<tr><td colspan=\"3\">Database is empty</td></tr>");
		} else {
			response.getWriter().println("<tr><th>Id</th><th>Version</th><th>HostName</th><th>SensorName</th><th>SensorType</th><th>DateTime</th><th>Value</th><th>Unit</th></tr>");
		}
		// IXSSEncoder xssEncoder = XSSEncoder.getInstance(); TODO Replace it by other encoder for html
		for (SensorData sd : resultList) {
			response.getWriter().println("<tr><td>" 
					+ sd.getId() + "</td><td>"
					+ sd.getVersion() + "</td><td>"
					+ sd.getHostName() + "</td><td>"
					+ sd.getSensorName() + "</td><td>" 
					+ sd.getSensorType() + "</td><td>" 
					+ sd.getCreatedAt() + "</td><td>" 
					+ sd.getValue() + "</td><td>"
					+ sd.getUnit() + "</td><td>");
		}
		response.getWriter().println("</table></p>");
	}

	@SuppressWarnings("unused")
	private void appendAddForm(HttpServletResponse response) throws IOException {
		// Append form through which new SensorData can be added
		response.getWriter()
				.println("<p><form action=\"\" method=\"post\">" 
		                + "HostName:<input type=\"text\" name=\"HostName\">"
						+ "&nbsp;SensorName:<input type=\"text\" name=\"SensorName\">" 
						+ "&nbsp;SensorType:<input type=\"text\" name=\"SensorType\">" 
						+ "&nbsp;CreatedAt:<input type=\"text\" name=\"CreatedAt\">" 
						+ "&nbsp;Value:<input type=\"text\" name=\"Value\">" 
						+ "&nbsp;Unit:<input type=\"text\" name=\"Unit\">" 
		                + "&nbsp;<input type=\"submit\" value=\"Add SensorData\">"
						+ "</form></p>");
	}

	private void doAdd(HttpServletRequest request) throws ServletException, IOException {
		// Extract data of SensorData to be added from request
		String hostName = request.getParameter("HostName");
		String sensorName = request.getParameter("SensorName");
		String sensorType = request.getParameter("SensorType");
		String createdAt = request.getParameter("CreatedAt");
		String value = request.getParameter("Value");
		String unit = request.getParameter("Unit");

		if (   hostName != null && sensorName != null && sensorType != null && createdAt != null && value != null && unit != null 
			&& !hostName.trim().isEmpty() && !sensorName.trim().isEmpty() && !sensorType.trim().isEmpty() && !createdAt.trim().isEmpty() && !value.trim().isEmpty() && !unit.trim().isEmpty()) {
			// Create requested test data
			SensorData sensorData = new SensorData();
			sensorData.setHostName(hostName);
			sensorData.setSensorName(sensorName);
			sensorData.setSensorType(sensorType);
			sensorData.setCreatedAt(new Timestamp(Long.valueOf(createdAt)));
			sensorData.setValue(Double.valueOf(value));
			sensorData.setUnit(unit);
			sensorDataBean.insertSensorData(sensorData);
		} else {
			persistenceBean.createTestData();
		}
	}

//	private void createTestData() {
//		// Create standard test data
//		Host host01 = new Host("hostname01");
//		Host host02 = new Host("hostname02");
//		Sensor sensor01 = new Sensor("hostname01", "sensorname01", "sensortype01", "unit01");
//		Sensor sensor02 = new Sensor("hostname01", "sensorname02", "sensortype02", "unit02");
//		Sensor sensor03 = new Sensor("hostname02", "sensorname03", "sensortype01", "unit01");
//		Sensor sensor04 = new Sensor("hostname02", "sensorname04", "sensortype02", "unit02");
//		SensorData sensor01Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Date(System.currentTimeMillis()),  1.0, "unit01");
//		SensorData sensor02Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Date(System.currentTimeMillis()),  2.0, "unit01");
//		SensorData sensor03Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Date(System.currentTimeMillis()),  3.0, "unit01");
//		SensorData sensor04Data = new SensorData("namespace01", "hostname01", "sensorname01", "sensortype01", new Date(System.currentTimeMillis()),  4.0, "unit01");
//		SensorData sensor05Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Date(System.currentTimeMillis()),  5.0, "unit02");
//		SensorData sensor06Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Date(System.currentTimeMillis()),  6.0, "unit02");
//		SensorData sensor07Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Date(System.currentTimeMillis()),  7.0, "unit02");
//		SensorData sensor08Data = new SensorData("namespace01", "hostname01", "sensorname02", "sensortype02", new Date(System.currentTimeMillis()),  8.0, "unit02");
//		SensorData sensor09Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Date(System.currentTimeMillis()),  9.0, "unit01");
//		SensorData sensor10Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Date(System.currentTimeMillis()), 10.0, "unit01");
//		SensorData sensor11Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Date(System.currentTimeMillis()), 11.0, "unit01");
//		SensorData sensor12Data = new SensorData("namespace01", "hostname02", "sensorname03", "sensortype01", new Date(System.currentTimeMillis()), 12.0, "unit01");
//		SensorData sensor13Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Date(System.currentTimeMillis()), 13.0, "unit02");
//		SensorData sensor14Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Date(System.currentTimeMillis()), 14.0, "unit02");
//		SensorData sensor15Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Date(System.currentTimeMillis()), 15.0, "unit02");
//		SensorData sensor16Data = new SensorData("namespace01", "hostname02", "sensorname04", "sensortype02", new Date(System.currentTimeMillis()), 16.0, "unit02");
//		
//		hostBean.insertHost(host01);
//		hostBean.insertHost(host02);
//		sensorBean.insertSensor(sensor01);
//		sensorBean.insertSensor(sensor02);
//		sensorBean.insertSensor(sensor03);
//		sensorBean.insertSensor(sensor04);
//		sensorDataBean.insertSensorData(sensor01Data);
//		sensorDataBean.insertSensorData(sensor02Data);
//		sensorDataBean.insertSensorData(sensor03Data);
//		sensorDataBean.insertSensorData(sensor04Data);
//		sensorDataBean.insertSensorData(sensor05Data);
//		sensorDataBean.insertSensorData(sensor06Data);
//		sensorDataBean.insertSensorData(sensor07Data);
//		sensorDataBean.insertSensorData(sensor08Data);
//		sensorDataBean.insertSensorData(sensor09Data);
//		sensorDataBean.insertSensorData(sensor10Data);
//		sensorDataBean.insertSensorData(sensor11Data);
//		sensorDataBean.insertSensorData(sensor12Data);
//		sensorDataBean.insertSensorData(sensor13Data);
//		sensorDataBean.insertSensorData(sensor14Data);
//		sensorDataBean.insertSensorData(sensor15Data);
//		sensorDataBean.insertSensorData(sensor16Data);
//		
//		hostBean.attachSensorToHost(host01, sensor01);
//		hostBean.attachSensorToHost(host01, sensor02);
//		hostBean.attachSensorToHost(host02, sensor03);
//		hostBean.attachSensorToHost(host02, sensor04);
//		sensorBean.attachSensorDataToSensor(sensor01, sensor01Data);
//		sensorBean.attachSensorDataToSensor(sensor01, sensor02Data);
//		sensorBean.attachSensorDataToSensor(sensor01, sensor03Data);
//		sensorBean.attachSensorDataToSensor(sensor01, sensor04Data);
//		sensorBean.attachSensorDataToSensor(sensor02, sensor05Data);
//		sensorBean.attachSensorDataToSensor(sensor02, sensor06Data);
//		sensorBean.attachSensorDataToSensor(sensor02, sensor07Data);
//		sensorBean.attachSensorDataToSensor(sensor02, sensor08Data);
//		sensorBean.attachSensorDataToSensor(sensor03, sensor09Data);
//		sensorBean.attachSensorDataToSensor(sensor03, sensor10Data);
//		sensorBean.attachSensorDataToSensor(sensor03, sensor11Data);
//		sensorBean.attachSensorDataToSensor(sensor03, sensor12Data);
//		sensorBean.attachSensorDataToSensor(sensor04, sensor13Data);
//		sensorBean.attachSensorDataToSensor(sensor04, sensor14Data);
//		sensorBean.attachSensorDataToSensor(sensor04, sensor15Data);
//		sensorBean.attachSensorDataToSensor(sensor04, sensor16Data);
//		
//		hostBean.flush();
//	}
}














