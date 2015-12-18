<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:label path="city">City</form:label>
<form:input path="city" id="city"/>
<form:errors path="city" cssClass="error"/>

<br/>

<form:label path="type">Type</form:label>
<form:input path="type" id="type"/>
<form:errors path="type" cssClass="error"/>

<br/>

<form:label path="leader">Leader</form:label>
<form:input path="leader" id="leader"/>
<form:errors path="leader" cssClass="error"/>