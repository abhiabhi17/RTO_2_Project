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
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript">
$(function() {
	$('form[id="registerForm"]').validate({
		rules : {
			regDate : 'required',
			regCenter : 'required'
		},
		messages : {
			regDate : 'please enter students name',
			regCenter : 'please enter street no'
			
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});

$( function() {
    $( "#datepicker" ).datepicker();
  } );
</script>

</head>
<body>
	<h1 style="color: red">Registration Details</h1>
	<h5 style="color: blue">${msg}</h5>
	<form:form action="genRegNoPost" modelAttribute="regNo" method="POST"
		id="registerForm">
		<table>

			<tr>
				<th>Registration Date::</th>
				<td><form:input path="regDate" id="datepicker"/></td>
			</tr>
			<tr>
				<th>Registration Center::</th>
				<td><form:input path="regCenter" /></td>
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