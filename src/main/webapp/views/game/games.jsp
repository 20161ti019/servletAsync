<%--
  Created by IntelliJ IDEA.
  User: posei
  Date: 15/08/2021
  Time: 01:50 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}">
<html>
<head>
    <title>Games</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <a href="${context}/views/game/register.jsp" class="btn btn-info" data-toggle="modal"> <i class="far fa-plus-square">Nuevo Juego</i></a>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="row">
            <div class="col-lg-12">
                <div class="table-responsive">
                    <table id="tablaGames" class="table table-striped table-bordered table-condensed" style="width: 100%">
                        <thead class="text-center">
                        <tr>
                        <td>Id</td>
                        <td>Nombre</td>
                        <td>Previa</td>
                        <td>Fecha de salida</td>
                        <td>Categoria</td>
                        <td>Estatus</td>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="${context}/assets/dist/js/main.js"> </script>
</body>
</html>