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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js" /></script>
<script type="text/javascript">
	$(function() {
		$('form[id="registerForm"]').validate({
			rules : {
				hno : 'required',
				streetno : 'required',
				city : 'required',
				zip : 'required'
			},
			messages : {
				hno : 'please enter students name',
				streetno : 'please enter street no',
				city : 'please Enter a city name',
				zip : 'please enter a zip code'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<h1 style="color: red">Owner Address</h1>
	<h1 style="color: green">${msg}</h1>
	<form:form action="ownerAddresPost" modelAttribute="ownerAdd"
		method="POST" id="registerForm">
		<table>

			<tr>
				<th>House No::</th>
				<td><form:input path="hno" /></td>
			</tr>
			<tr>
				<th>Street No::</th>
				<td><form:input path="streetno" /></td>
			</tr>
			<tr>
				<th>City Name::</th>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<th>Zip code::</th>
				<td><form:input path="zip" /></td>
			</tr>
			<tr>
				<td><input type="button" value="previous"
					onclick="history.back()"></td>
				<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>