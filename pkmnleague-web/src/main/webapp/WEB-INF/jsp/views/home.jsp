<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:layout title="Welcome!">
<jsp:attribute name="body">
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <h2>Pokémon <a href="${pageContext.request.contextPath}/pokemon/create" class="btn btn-success btn-sm"><i
                    class="fa fa-plus"></i> New pokemon</a></h2>

            <table class="table table-bordered table-striped">
                <thead>
                <th></th>
                <th>Nickname</th>
                <th>Type</th>
                <th>Level</th>
                </thead>
                <tbody>

                <c:forEach var="pkmn" items="${trainer.pokemon}">
                    <tr>
                        <td class="col-xs-1">
                            <my:pkmn-icon pokemon="${pkmn}"/>
                        </td>
                        <td>${pkmn.nickname}</td>
                        <td>
                            <my:pkmn-type pokemon="${pkmn}"/>
                        </td>
                        <td>${pkmn.level}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-xs-12 col-md-6">
            <h2>Obtained Badges</h2>
        </div>
    </div>

</jsp:attribute>
</my:layout>