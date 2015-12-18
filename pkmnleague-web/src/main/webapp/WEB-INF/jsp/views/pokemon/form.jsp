<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:label path="nickname">Name</form:label>
<form:input path="nickname" id="nickname"/>
<form:errors path="nickname" cssClass="error"/>

<form:label path="level">Level</form:label>
<form:input path="level" id="level"/>
<form:errors path="level" cssClass="error"/>

<form:label path="primaryType">Primary Type</form:label>
<form:input path="primaryType" id="type"/>
<form:errors path="primaryType" cssClass="error"/>

<form:label path="secondaryType">Secondary Type</form:label>
<form:input path="secondaryType" id="secondaryType"/>
<form:errors path="secondaryType" cssClass="error"/>

