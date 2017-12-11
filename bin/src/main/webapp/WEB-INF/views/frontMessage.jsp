<%@page contentType="text/html;charset=UTF-8" language="java" %>
	<%@page isELIgnored="false" %>
	
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/style1.css"/>
	</head>
	<body>
		<h1> Flight Scheduler </h1>

		<h2> Main GUI </h2>
		
		<div id="front_gui">		
			<div id="container">
				<nav>
					<ul style="list-style: none">
						<li class="item" onclick="populateContent('search')"> Search </li>
						<li class="item" onclick="populateContent('addFlight')"> Add Flights </li>
						<li class="item" onclick="populateContent('cancelFlight')"> Cancel Flights </li>
						<li class="item" onclick="populateContent('requestFlight')"> Flight Requests </li>
						<li class="item" onclick="populateContent('recentChanges')"> Recent Changes </li>
					</ul>
				</nav>
			</div>
			<div id="content">
			</div>
		</div>

	</body>
	<script src="js/front.js"></script>
	
</html>