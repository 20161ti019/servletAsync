<%--
  Created by IntelliJ IDEA.
  User: posei
  Date: 15/08/2021
  Time: 02:56 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Videojuegos</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    <link rel="stylesheet" type="text/css" href="webapp/assets/dist/css/styles.css">
    

</head>
<body>
  <div class="modal-dialog text-center">
    <div class="col-sm-8 main-section">
      <div class="modal-content user-img">
        <div class="col-12">
          <img src="https://e7.pngegg.com/pngimages/84/165/png-clipart-united-states-avatar-organization-information-user-avatar-service-computer-wallpaper.png">
        </div>
        <form class="form-group" >
          <div class="form-group" id="user-group">
            <input type="text" class="form-control" name="" id="" placeholder="Correo/usuario">
          </div>
          <div class="form-group" id="contraseña-group">
            <input type="password" class="form-control" name="" id="" placeholder="Contraseña">
          </div>
          <button type="submit" class="btn btn-primary"><i class="fas fa-sing-in-alt"></i> Ingresar</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
