<%@page contentType="text/html;charset=UTF-8" language="java" %>
	<%@page isELIgnored="false" %>
	
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="css/style1.css"/>
	</head>
	<body>
		<h1> Flight Scheduler </h1>

		<h2> Main GUI </h2>
		
		<div id="mainview">
			<nav>
				<ul style="list-style: none">
					<li> <button  onclick="search()"> search </button> </li>
					<li> <button  onclick="Add_Flights()"> Add_Flights </button> </li>
					<li> <button  onclick="Cancel_Flights()"> Cancel_Flights </button> </li>
					<li> <button  onclick="Flight_Requests()"> Flight_Requests </button> </li>
					<li> <button  onclick="Recent_Changes()"> Recent_Changes </button> </li>
				</ul>
			</nav>
		</div>

	</body>
	
	<SCRIPT LANGUAGE="JavaScript">
        <!--
        function login()
        {
        		let username = document.getElementsByName('username')[0].value;
        		let password = document.getElementsByName('password')[0].value;
        		//let name = username.value;
        		console.log(username);
        		//console.log(name);
			//alert(user);
        }
        // -->
    </SCRIPT>
</html>