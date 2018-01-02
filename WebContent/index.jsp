<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>IOT DB OData Data Access</title>
<style type="text/css">
body { font-family: Arial, sans-serif; font-size: 13px; line-height: 18px;
       color: blue; background-color: #ffffff; }
a { color: blue; text-decoration: none; }
a:focus { outline: thin dotted #4076cb; outline-offset: -1px; }
a:hover, a:active { outline: 0; }
a:hover { color: #404a7e; text-decoration: underline; }
h1, h2, h3, h4, h5, h6 { margin: 9px 0; font-family: inherit; font-weight: bold;
                         line-height: 1; color: blue; }
h1 { font-size: 36px; line-height: 40px; }
h2 { font-size: 30px; line-height: 40px; }
h3 { font-size: 24px; line-height: 40px; }
h4 { font-size: 18px; line-height: 20px; }
h5 { font-size: 14px; line-height: 20px; }
h6 { font-size: 12px; line-height: 20px; }
.logo { float: right; }
ul { padding: 0; margin: 0 0 9px 25px; }
ul ul { margin-bottom: 0; }
li { line-height: 18px; }
hr { margin: 18px 0;
     border: 0; border-top: 1px solid #cccccc; border-bottom: 1px solid #ffffff; }
table { border-collapse: collapse; border-spacing: 10px; }
th, td { border: 1px solid; padding: 20px; }
.code { font-family: "Courier New", monospace; font-size: 13px; line-height: 18px; }
</style>
</head>
<body>
	<h1>IOT DB OData Data Access</h1>
	<hr />
	<table>
		<tr>
			<td valign="top">
				<h3>Service Document and Metadata</h3>
				<ul>
					<li><a href="IOT-DB.svc?_wadl"         target="_blank">IOT DB wadl</a></li>
					<li><a href="IOT-DB.svc/"              target="_blank">IOT DB service document</a></li>
					<li><a href="IOT-DB.svc/$metadata"     target="_blank">IOT DB metadata</a></li>
				</ul> 
				
				<h3>Namespaces</h3>
				<ul>
					<li><a href="IOT-DB.svc/Namespaces(1)?$format=json" 
					       target="_blank">Namespaces</a></li>
					<li><a href="IOT-DB.svc/Namespaces(1L)/SensorDataDetails?$format=json" 
					       target="_blank">SensorDataDetails</a></li>
					<li><a href="IOT-DB.svc/Namespaces?$format=json&$expand=SensorDataDetails" 
					       target="_blank">Full expanded</a></li>
					<li><a href="IOT-DB.svc/Namespaces?$format=json&$filter=NamespaceName eq 'namespace01'&$expand=SensorDataDetails" 
					       target="_blank">Filtered</a></li>
					<li><a href="IOT-DB.svc/Namespaces?$format=json&$skip=1&$top=1" 
					       target="_blank">Paged (zero results expected, because there is only one standard test namespace)</a></li>
				</ul>
				
				<h3>Hosts</h3>
				<ul>
					<li><a href="IOT-DB.svc/Hosts(2)?$format=json" 
					       target="_blank">Hosts</a></li>
					<li><a href="IOT-DB.svc/Hosts(2L)/SensorDetails?$format=json" 
					       target="_blank">SensorDetails</a></li>
					<li><a href="IOT-DB.svc/Hosts(2L)/SensorDataDetails?$format=json" 
					       target="_blank">SensorDataDetails</a></li>
					<li><a href="IOT-DB.svc/Hosts?$format=json&$expand=SensorDetails,SensorDataDetails" 
					       target="_blank">Full expanded</a></li>
					<li><a href="IOT-DB.svc/Hosts?$format=json&$filter=HostName eq 'hostname01'&$expand=SensorDetails,SensorDataDetails" 
					       target="_blank">Filtered</a></li>
					<li><a href="IOT-DB.svc/Hosts?$format=json&$skip=1&$top=1" 
					       target="_blank">Paged</a></li>
				</ul>
				
				<h3>Sensors</h3>
				<ul>
					<li><a href="IOT-DB.svc/Sensors(5)?$format=json" 
					       target="_blank">Sensors</a></li>
					<li><a href="IOT-DB.svc/Sensors(5L)/HostDetails?$format=json" 
					       target="_blank">HostDetails</a></li>
					<li><a href="IOT-DB.svc/Sensors(5L)/SensorDataDetails?$format=json" 
					       target="_blank">SensorDataDetails</a></li>
					<li><a href="IOT-DB.svc/Sensors?$format=json&$expand=HostDetails,SensorDataDetails" 
					       target="_blank">Full expanded</a></li>
					<li><a href="IOT-DB.svc/Sensors?$format=json&$filter=HostName eq 'hostname01'&$expand=HostDetails,SensorDataDetails" 
					       target="_blank">Filtered</a></li>
					<li><a href="IOT-DB.svc/Sensors?$format=json&$skip=1&$top=2" 
					       target="_blank">Paged</a></li>
				</ul>

				<h3>SensorDatas</h3>
				<ul>
					<li><a href="IOT-DB.svc/SensorDatas(8)?$format=json" 
					       target="_blank">SensorDatas</a></li>
					<li><a href="IOT-DB.svc/SensorDatas(8L)/NamespaceDetails?$format=json" 
					       target="_blank">NamespaceDetails</a></li>
					<li><a href="IOT-DB.svc/SensorDatas(8L)/HostDetails?$format=json" 
					       target="_blank">HostDetails</a></li>
					<li><a href="IOT-DB.svc/SensorDatas(8L)/SensorDetails?$format=json" 
					       target="_blank">SensorDetails</a></li>
					<li><a href="IOT-DB.svc/SensorDatas?$format=json&$expand=NamespaceDetails,HostDetails,SensorDetails" 
					       target="_blank">Full expanded</a></li>
					<li><a href="IOT-DB.svc/SensorDatas?$format=json&$filter=HostName eq 'hostname01'&$expand=NamespaceDetails,HostDetails,SensorDetails" 
					       target="_blank">Filtered</a></li>
					<li><a href="IOT-DB.svc/SensorDatas?$format=json&$skip=1&$top=2" 
					       target="_blank">Paged</a></li>
				</ul>

				<h3>SensorDatas</h3>
				<ul>
					<li><a href="StoreSensorData?SensorDataCSV=ssdnamespace01;ssdhostname01;ssdsensorname01;ssdsensortype01;1234567890;1.0;ssdunit01" 
					       target="_blank">Add sensor data to database</a></li>
				</ul>

			</td>
			<td valign="top">
				&nbsp;
			</td>
			<td valign="top">
<!--				
				<h3>Function Imports</h3>
				<ul>
					<li><a href="IOT-DB.svc/approveTask?ProcessType='OPEX'&ProcessId='1'&BpmTaskInstanceId='2'&BpmProcessInstanceId='3'&Approve=false&$format=json"
						target="_blank">approveTask('OPEX','1','2','3',false)</a></li>
					<li/>
  				</ul>
-->
				<h3>Applications</h3>
				<ul>
					<li><a href="createData.jsp"
						target="_blank">Create Data</a></li>
				</ul>
				<div class="code">
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
