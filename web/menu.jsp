<%-- 
    Document   : menu
    Created on : 25/05/2022, 08:24:22 AM
    Author     : SENA
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/menu.css" rel="stylesheet" type="text/css"/>
        <title>Menú</title>
    </head>
    <body>
    <center>
        <header class="header">
            <h1>Administrador</h1>
            <h1 class="Concesionario">Concesionario Web</h1>
            <h2>Sea Bienvenid@ usuario: <%=usuario%> </h2>
        </header>
        <form method="post" action="Sesiones" class="cerrar" >
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>
        <img src="IMG/Listado.png"  class="Listado"alt=""/>
        <img src="IMG/consultar.jpeg"  class="consultar"alt=""/>
        <img src="IMG/registrar vehiculo.jpg" class="RegistrarV"alt=""/>
        <button class="btn1"><a  href="RegistroVehiculoA.jsp">Registrar Vehiculo</button></a>
        <button class="btn2"><a  href="ConsultarVehiculoADM.jsp">Consultar y Actualizar Vehiculo</button></a>
        <button class="btn3" type="submit"> <a href="ListaVehiculosA.jsp"> Listado de Vehiculo </a> </button>
       
      
    </center>
<br><br>
</body>
</html>
