<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 style="color: red">${msg}</h1>
	<table>
		<tr>
	<td>Name</td>
			<td>${Vowner.fname}</td>
		<tr>
		<tr>
			<td>Last Name</td>
			<td>${Vowner.lname}</td>
		</tr>
		<tr>
			<td>Email Id::</td>
			<td>${Vowner.email}</td>
		</tr>
		<!-- <tr>
			<td>Dob </td>
			<td>{Vowner.dob}</td>
		</tr> -->
		<tr>
			<td>SSN No</td>
			<td>${Vowner.ssn}</td>
		</tr>
		<tr>
			<td>house No</td>
			<td>${listForAdd.hno}</td>
		</tr>
		<tr>
			<td>Street No</td>
			<td>${listForAdd.streetno}</td>
		</tr>
		<tr>
			<td>City Name</td>
			<td>${listForAdd.city}</td>
		</tr>
		<tr>
			<td>Vehicle Type</td>
			<td>${listForVehicle.type}</td>
		</tr>
		<tr>
			<td>Vehicle Company</td>
			<td>${listForVehicle.vcompanyname}</td>
		</tr>
		<tr>
			<td>Vehicle Model Year</td>
			<td>${listForVehicle.year}</td>
		</tr>
		<tr>
			<td>Vehicle Type</td>
			<td>${listForVehicle.type}</td>
		</tr>
		<tr>
			<td>Vehicle Reg No::</td>
			<td>${listForReg.regNo}</td>
		</tr>
		<tr>
			<td>Vehicle Reg No::</td>
			<td>${listForReg.regCenter}</td>
		</tr>
		<tr>
			<td>Vehicle Reg No::</td>
			<td>${listForReg.regDate}</td>
		</tr>
	</table>

	<%-- <c:forEach items="${listForReg}" var="reg">

</c:forEach>
 --%>

	<%-- <table border="2" id="" class="display" style="width: 100%">

		<c:forEach items="${Vowner}" var="owner">
			<tr>
				<td>Name</td>
				<td>${owner.fname}</td>
			</tr>
			<tr>
				<td>last Name</td>
				<td>${owner.lname}</td>
			</tr>
			<tr>
				<td>email</td>
				<td>${owner.email}</td>
			</tr>
			<tr>
				<td>DOB</td>
				<td>${owner.dob}</td>
			</tr>
			<tr>
				<td>SSN No</td>
				<td>${owner.ssn}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${listForVehicle}" var="listVehicle">

			<tr>
				<td>Type Of Vehicle</td>
				<td>${listVehicle.type}</td>
			</tr>
			<tr>
				<td>Year Of vehicle</td>
				<td>${listVehicle.year}</td>
			</tr>
			<tr>
				<td>Vehicle Company Name</td>
				<td>${listVehicle.vcompanyname}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${listForAdd}" var="address">
			<tr>
				<td>HouseNo</td>
				<td>${address.hno}</td>
			</tr>
			<tr>

				<td>Street NO</td>
				<td>${address.streetno}</td>
			</tr>
			<tr>
				<td>City</td>
				<td>${address.city}</td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td>${address.zip}</td>
			</tr>
		</c:forEach>
		<c:forEach items="${listForReg}" var="reg">
			<tr>
				<td>Registration No</td>
				<td>${reg.regNo}</td>
			</tr>
			<tr>
				<td>Registration Center</td>
				<td>${reg.regDate}</td>
			</tr>
			<tr>
				<td>RegiStration Date</td>
				<td>${reg.regCenter}</td>
			</tr>
		</c:forEach>
	</table> --%>
</body>
</html>