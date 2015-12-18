<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:label path="name">Name</form:label>
<form:input path="name" id="name"/>
<form:errors path="name" cssClass="error"/>


<form:label path="type">Type</form:label>
<form:input path="type" id="type"/>
<form:errors path="type" cssClass="error"/>

<form:label path="city">City</form:label>
<form:input path="city" id="city"/>
<form:errors path="city" cssClass="error"/>