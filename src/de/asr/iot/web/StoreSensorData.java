package de.asr.iot.web;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.asr.iot.entities.PersistenceBean;

/**
 * Servlet implementation class StoreSensorData
 */
@WebServlet(name = "StoreSensorData", description = "Store sensor data in data base in order to make it available for further use", urlPatterns = { "/StoreSensorData" })
public class StoreSensorData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PersistenceBean persistenceBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreSensorData() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sensorDataCSV = request.getParameter("SensorDataCSV").toLowerCase();
		// Check parameter
		if (sensorDataCSV == null || sensorDataCSV.isEmpty()) {
			response.sendError(500);
			return;
		}
		String[] sensorDataSet = sensorDataCSV.split("\\s{1,2}");
		if (sensorDataSet == null || sensorDataSet.length == 0) {
			response.sendError(500);
			return;
		}
		for (int i = 0; i < sensorDataSet.length; i++) {
			String[] sensorDataParameters = sensorDataSet[i].split(";");
			if (sensorDataParameters == null || sensorDataParameters.length != 7) {
				response.sendError(500);
				return;
			}
			try {
				//Date createdAt = 
				new Date(Long.parseLong(sensorDataParameters[4]));
				//Double value = 
				Double.valueOf(sensorDataParameters[5]);
			} catch (NumberFormatException e) {
				response.sendError(500);
				return;
			}
		}
		persistenceBean.addSensorDataToDataBase(sensorDataCSV);
	}
}

