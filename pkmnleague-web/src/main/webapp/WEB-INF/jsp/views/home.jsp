<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<my:layout title="Vítejte!">
<jsp:attribute name="body">
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <h2>Pokémoni <a href="${pageContext.request.contextPath}/pokemon/create" class="btn btn-success btn-sm"><i
                    class="fa fa-plus"></i> Nový pokémon</a></h2>
            <table class="table table-bordered table-striped">
                <thead>
                <th></th>
                <th>Přezdívka</th>
                <th>Typ</th>
                <th>Úroveň</th>
                </thead>
                <tbody>

                <c:forEach var="pkmn" items="${trainer.getPokemon()}">
                    <tr>
                        <td class="col-xs-1">
                            <img src="${pageContext.request.contextPath}/img/icons/${pkmn.speciesId}.png"
                                 alt="#${pkmn.speciesId} ${pkmn.speciesName}">
                        </td>
                        <td>Pikachu</td>
                        <td>
                            <my:type pokemon="${pkmn}"/>
                        </td>
                        <td>${pkmn.level}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-xs-12 col-md-6">
            <h2>Odznaky</h2>
        </div>
    </div>

</jsp:attribute>
</my:layout>