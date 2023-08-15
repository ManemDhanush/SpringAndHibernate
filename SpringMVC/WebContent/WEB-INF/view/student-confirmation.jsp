<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

The student is from : ${student.country}

<br><br>

The students favourite subject is ${student.language}

<br><br>

The student knows :

<ul>
    <c:forEach var="temp" items = "${student.operatingSystem}">
        <li> ${temp} </li>
    </c:forEach>
</ul>
</body>

</html>







