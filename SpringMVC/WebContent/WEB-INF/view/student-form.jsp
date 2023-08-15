<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
		
		<br><br>

        Country :
		<form:select path="country">
		    <form:options items="${student.countryOptions}" />
		</form:select>

		<br><br>

        Favorite language:
		Java <form:radiobutton path="language" value="Java"/> &emsp;
		C++ <form:radiobutton path="language" value="C++"/> &emsp;
		Python <form:radiobutton path="language" value="Python"/>   &emsp;
		Ruby <form:radiobutton path="language" value="Ruby"/>   &emsp;

		<br><br>

		Which operating system you are comfortable with?
		<br>
		Linux <form:checkbox path="operatingSystem" value="Linux"/>
		Windows <form:checkbox path="operatingSystem" value="Windows"/>
		Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>

		<br><br>
	
		<input type="submit" value="Submit" />
	
	</form:form>


</body>

</html>












