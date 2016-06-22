<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:spring="http://www.springframework.org/tags">
<head>
<title>Bach - IFI - P20 - TP1 - GLA</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

.search {
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}
</style>
</head>
<body>
	<c:url var="addAction" value="/person/add" />
	<c:url var="editAction" value="/edit" />
	<c:url var="removeAction" value="/remove" />
	<c:url var="searchAction" value="/search" />
	<c:url var="editAddressAction" value="/edit/${person.personId}/address" />
	<c:url var="editPhoneNumberAction"
		value="/edit/${person.personId}/phone" />
	<c:url var="removeAddressAction" value="/removeaddress/${person.personId}" />
	<c:url var="removePhoneNumberAction"
		value="/removephone/${person.personId}" />

	<table style="width: 100%">
		<tr>
			<td style="width: 50%">
				<h1>
					<a href="<c:url value='/persons'/>">[HOME / Afficher toutes]</a>
				</h1> <c:if test="${!empty msg }">
					<h3 style="color: red">Message: ${msg}</h3>
				</c:if> <form:form action="${addAction}" id="addForm" commandName="person">

					<table>

						<c:if test="${person.personId!=0}">
							<tr>
								<td><form:label path="personId">
										<spring:message text="ID" />
									</form:label></td>
								<td><form:input path="personId" readonly="true" size="8"
										disabled="true" /> <form:hidden path="personId" /></td>
							</tr>
						</c:if>

						<tr>
							<td><form:label path="fullName.firstName">
									<spring:message text="First Name" />
								</form:label></td>
							<td><form:input path="fullName.firstName" /></td>
						</tr>

						<tr>
							<td><form:label path="fullName.lastName">
									<spring:message text="Last Name" />
								</form:label></td>
							<td><form:input path="fullName.lastName" /></td>
						</tr>

						<tr>
							<td><input type="submit"
								value="${(person.personId!=0)?'Edit Person':'Add Person'}" /></td>
							<td style="display:${(person.personId!=0)?'':'none'}"><a
								href="${removeAction}/${person.personId}">[ Delete ]</a></td>
						</tr>

					</table>

				</form:form> <br /> <c:if test="${person.personId != 0}">
					<h3>Liste des Adress</h3>
					<table class="tg">
						<tr>
							<th width="40">ID</th>
							<th width="60">number</th>
							<th width="60">street</th>
							<th width="60">arrondissement</th>
							<th width="60">province</th>
							<th width="60">Add</th>
						</tr>
						<c:forEach items="${person.addresses}" var="a">
							<tr>
								<td>${a.addressId}</td>
								<td>${a.number}</td>
								<td>${a.street}</td>
								<td>${a.arrondissement}</td>
								<td>${a.province}</td>
								<td><%-- <a
								href="${removeAddressAction}/${a.addressId}">[ Delete ]</a> --%></td>
							</tr>
						</c:forEach>
						<tr>
							<form:form action="${editAddressAction}" id="addAddress"
								method="post" commandName="address">
								<td></td>
								<td><form:input path="number" size="5" /></td>
								<td><form:input path="street" size="5" /></td>
								<td><form:input path="arrondissement" size="5" /></td>
								<td><form:input path="province" size="5" /></td>
								<td><input type="submit" value="Add" /></td>
							</form:form>
						</tr>
					</table>
				</c:if> <c:if test="${person.personId != 0}">
					<h3>Liste des PhoneNumbers</h3>
					<table class="tg">
						<tr>
							<th width="40">ID</th>
							<th width="60">number</th>
							<th width="60">type</th>
							<th width="60">Add</th>
						</tr>
						<c:forEach items="${person.phoneNumbers}" var="pn">
							<tr>
								<td>${pn.phoneNumberId}</td>
								<td>${pn.number}</td>
								<td>${pn.type}</td>
								<td><%-- <a
								href="${removePhoneNumberAction}/${pn.phoneNumberId}">[ Delete ]</a> --%></td>
							</tr>
						</c:forEach>
						<tr>
							<form:form action="${editPhoneNumberAction}" id="addPhoneNumber"
								method="post" commandName="phoneNumber">
								<td></td>
								<td><form:input path="number" size="12" /></td>
								<td><form:select path="type">
										<form:option value="work_phone">work_phone</form:option>
										<form:option value="home_phone">home_phone</form:option>
									</form:select></td>
								<td><input type="submit" value="Add" /></td>
							</form:form>
						</tr>
					</table>
				</c:if>
			</td>
			<td>

				<div class="search">
					<form:form action="${searchAction}" id="search" method="get">
						<label> <spring:message text="Chercher" />
						</label>
						<input name="personName" size="20" />
						<input type="submit" value="Search" />
					</form:form>
				</div>
				<h3>Liste des Personnes</h3> <c:if test="${!empty listPersons}">
					<table class="tg">
						<tr>
							<th width="40">ID</th>
							<th width="120">First Name</th>
							<th width="120">Last Name</th>
							<th width="60">Edit/Show</th>
							<th width="60">Delete</th>
						</tr>
						<c:forEach items="${listPersons}" var="p">
							<tr>
								<td>${p.personId}</td>
								<td>${p.fullName.firstName}</td>
								<td>${p.fullName.lastName}</td>
								<td><a href="${editAction}/${p.personId}">Edit/Show</a></td>
								<td><a href="${removeAction}/${p.personId}">Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if> <c:if test="${empty listPersons}">
					<h4>On ne trouve rien !</h4>
				</c:if>
			</td>
		</tr>
	</table>




</body>
</html>