<%--
  Created by IntelliJ IDEA.
  User: posei
  Date: 15/08/2021
  Time: 09:16 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Registrar Juegos</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
    <h1>Registrar Juego</h1>
    <form action="${context}/createGames" method="POST">
        <input type="hidden" value="create" name="action">
        <label>Nombre:</label>
        <input class="form-control" type="text" name="name" />
        <br>
        <label>Previa:</label>
        <input class="form-control" type="file" name="imgGame" />
        <br>
        <label>Fecha de Salida</label>
        <input class="form-control" type="date" name="datePremiere" />
        <br>
        <label>Categoria:</label>
        <select class="form-select" name="categoria">
            <option value="1">FPS</option>
            <option value="2">Estrategia</option>
            <option value="3">MOBA</option>
            <option value="4">Plataformas</option>
        </select>
        <label>status:</label>
        <select class="form-select" name="status">
            <option value="1">Activo</option>
            <option value="2">No Activo</option>
        </select>

        <button type="button" class="btn btn-secondary"><i class="fas fa-times"></i> Cancelar</button>
        <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Agregar</button>
    </form>
    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
