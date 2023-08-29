<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red;
}
</style>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"
	type="text/javascript"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js"
	type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	$('form[id="registerForm"]').validate({
		rules : {
			type : 'required',
			year : 'required',
			vcompanyname : 'required'
		},
		messages : {
			type : 'please enter students name',
			year : 'please enter street no',
			vcompanyname : 'please Enter a city name',
			
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
</script>
</head>
<body>
	<h1 style="color: red">Vehicle Details registration</h1>
	<form:form action="vRegistrationdetails"
		modelAttribute="VehicleDetailsModel" method="POST" id="registerForm">
		<table>

			<tr>
				<th>VehicleType</th>
				<td><form:select path="type" items="${typeList}" /></td>
			</tr>
			<tr>
				<th>Year Of vehicle</th>
				<td>
				<form:select path="year">
				
				 <form:option value="">Select Year</form:option>
        <form:option value="2000">2000</form:option>
        <form:option value="2001">2001</form:option>
        <form:option value="2002">2002</form:option>
 <form:option value="2003">2003</form:option>
        <form:option value="2004">2004</form:option>
        <form:option value="2005">2005</form:option>
         <form:option value="2006">2006</form:option>
        <form:option value="2007">2007</form:option>
        <form:option value="2008">2008</form:option>
         <form:option value="2009">2009</form:option>
        <form:option value="2010">2010</form:option>
        <form:option value="2011">2011</form:option>
			</form:select>
				</td>
			</tr>
			<tr>
				<th>Vehicle Company Name</th>
				<td><form:select path="vcompanyname">
				 <form:option value="">Select VehicleType</form:option>
        <form:option value="Activa">Activa</form:option>
        <form:option value="Bajaj">Bajaj</form:option>
        <form:option value="Honda">Honda</form:option>
				</form:select>
				</td>
				
			</tr>
			<tr>
				<td><input type="button" value="previous"
					onclick="history.back()"></td>
				<td><input type="submit" value="next"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>