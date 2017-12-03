<!DOCTYPE html> 
<html>
	<head>
		<title> index page </title>
		
		<style>
			.p {
				color: red;
			}
		</style>
		
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/style1.css' />"/>
	</head>
	<body>
		<p>
			Hello World! <br/>
			<%out.print("Hello, Sample JSP code");%>
		</p>
		<button onclick="button1()"> click me </button>
	</body>
	<SCRIPT LANGUAGE="JavaScript">
        <!--
        function button1()
        {
        		alert("works!");
        } 
        // --> 
    </SCRIPT>
</html>