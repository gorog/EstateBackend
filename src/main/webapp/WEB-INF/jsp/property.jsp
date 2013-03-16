<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<?xml  version="1.0" encoding="UTF-8"?>
<html>
<head>
<title>EstateBackend - <spring:message code="label.title" /> | gorog</title>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
</head>
<body>

	<h2><spring:message code="label.title" /></h2>

	<form:form method="post" action="add.html" commandName="property">

		<table>
			<tr>
				<td><form:label path="country">
						<spring:message code="label.country" />
					</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message code="label.city" />
					</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="zip_code">
						<spring:message code="label.zip_code" />
					</form:label></td>
				<td><form:input path="zip_code" /></td>
			</tr>
			<tr>
				<td><form:label path="district">
						<spring:message code="label.district" />
					</form:label></td>
				<td><form:input path="district" /></td>
			</tr>
			<tr>
				<td><form:label path="street">
						<spring:message code="label.street" />
					</form:label></td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td><form:label path="house_number">
						<spring:message code="label.house_number" />
					</form:label></td>
				<td><form:input path="house_number" /></td>
			</tr>
			<tr>
				<td><form:label path="floor">
						<spring:message code="label.floor" />
					</form:label></td>
				<td><form:input path="floor" /></td>
			</tr>
			<tr>
				<td><form:label path="room">
						<spring:message code="label.room" />
					</form:label></td>
				<td><form:input path="room" /></td>
			</tr>
			<tr>
				<td><form:label path="longitude">
						<spring:message code="label.longitude" />
					</form:label></td>
				<td><form:input path="longitude" /></td>
			</tr>
			<tr>
				<td><form:label path="latitude">
						<spring:message code="label.latitude" />
					</form:label></td>
				<td><form:input path="latitude" /></td>
			</tr>
			<tr>
				<td><form:label path="offer">
						<spring:message code="label.offer" />
					</form:label></td>
				<td><form:input path="offer" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="BUM" /></td>
			</tr>
		</table>
	</form:form>


	<h3><spring:message code="label.properties" /></h3>
	<c:if test="${!empty propertyList}">
		<table class="data">
			<tr>
				<th>Country</th>
				<th>City</th>
				<th>Zip Code</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${propertyList}" var="property">
				<tr>
					<td>${property.country}</td>
					<td>${property.city}</td>
					<td>${property.zip_code}</td>
					<td><a href="delete/${property.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>