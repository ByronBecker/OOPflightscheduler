
<%@page contentType="text/html;charset=UTF-8" language="java" %>
	<%@page isELIgnored="false" %>
	
<html>
	<body>
		<h1> Flight Scheduler </h1>

		<h2> Welcome to Flight Scheduler, Login below </h2>
		
		Username: <input name="username" type="text" placeholder="username"> <br/>
		Password: <input name="password" type="text" placeholder="password">
		<button type="submit" onclick="login()"> Submit </button>

	</body>
	
	<SCRIPT LANGUAGE="JavaScript">
        <!--
        function login()
        {
        		let username = document.getElementsByName('username')[0].value;
        		let password = document.getElementsByName('password')[0].value;
        		//let name = username.value;
        		console.log(username, password);
        		//console.log(name);
			//alert(user);
			sessionStorage.setItem('username', username);
			location.href = "http://localhost:8080/flight_scheduler/front";	
			
        }
        // -->
    </SCRIPT>
</html>