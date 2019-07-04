<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<pre>
<form:form action="save" method="post" modelAttribute="user" >


Name     : <form:input path="userName"/>

Email 	 : <form:input path="userEmail"/>

Sal   	 : <form:input path="userSal"/>

		<input type="submit" value="Register Employee">

</form:form>

</pre>

${msg}


</body>
</html>