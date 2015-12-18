<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:layout title="Gym">
<jsp:attribute name="body">
    <h1> Gyms </h1>
      <table class="table">
          <tr>
              <th>Pokemon</th>
              <th>Pokemon type</th>
              <th>Name</th>
              <th>Level</th>
          </tr>
          <c:forEach items="${gyms}" var="gym">
              <tr>
                  <td><c:out value="${gym.name}"/></td>
                  <td><c:out value="${gym.type}"/></td>
                  <td><c:out value="${gym.city}"/></td>
              </tr>
          </c:forEach>
      </table>

    <a class ="btn btn-info" href="${pageContext.request.contextPath}/gym/create">Create</a>
</jsp:attribute>
</my:layout>