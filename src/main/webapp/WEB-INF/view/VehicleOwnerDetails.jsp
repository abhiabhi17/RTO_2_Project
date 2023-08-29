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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"
	type="text/javascript"></script>
	<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js"
	type="text/javascript"></script>
<script type="text/javascript">
$(function() {
	$('form[id="registerForm"]').validate({
		rules : {
			fname : 'required',
			lname : 'required',
			email : 'required',
			ssn:'required',
			dob:'required'
		},
		messages : {
			fname : 'please enter First name',
			lname : 'please enter LastName',
			email : 'please Enter Email',
			ssn:'please enter ssn',
			dob:'please enter dob'
			
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
</script>
<script type="text/javascript">
	$(document).ready(function($) {
		$('#ssn').mask("999 999 9999", {
			placeholder : "xxx xxx xxxx"
		});
	})
	
$( function() {
    $( "#datepicker" ).datepicker();
  } );
  
</script>

</head>
<body>
	<h2 style="color: red;margin-left:200px;">Vehicle Registration
	
	<h1>${msg}</h1>

	<form:form id="registerForm" action="ownerRegistration"
		modelAttribute="owner" method="POST">
		<table  >
			<tr>
				<th>Firstname::</th>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<th>Lastname::</th>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<th>Email::</th>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<th>DOB::</th>
				<td><form:input path="dob" id="datepicker" /></td>
			</tr>
			<tr>
				<th>SSN No::</th>
				<td><form:input path="ssn" id="ssn" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="next"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>