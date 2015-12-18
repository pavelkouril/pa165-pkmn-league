<%@ tag pageEncoding="utf-8" dynamic-attributes="dynattrs" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pokemon" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<img src="${pageContext.request.contextPath}/img/types/${pokemon.getPrimaryType()}.png" alt="${pokemon.getPrimaryType()}" title="${pokemon.getPrimaryType()}">