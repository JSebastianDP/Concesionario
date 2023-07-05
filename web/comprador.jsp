<%-- 
    Document   : Comprador
    Created on : 27/06/2022, 06:35:20 PM
    Author     : Yuliana
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Sesiones.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/comprador.css" rel="stylesheet" type="text/css"/>
        <title>Comprador</title>
    </head>
    <body>
        <header class="header">
            
            <h1 class="titulo">Concesionario</h1>
            <h1 class="comp">Comprador</h1>
            <h2 class="title-1">Sea Bienvenid@ usuario:  <%=usuario%> </h2>
        </header>
        <form method="post" action="Sesiones" class="cerrar" >
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>
        <img src="IMG/Listado.png"  class="Listado"alt=""/>
        <img src="IMG/consultar.jpeg"  class="consultar"alt=""/>
        <button class="btn1" type="submit"> <a href="ConsultarVehiculo.jsp"> Consultar Vehiculo </a> </button>
        <button class="btn2" type="submit"> <a href="LisVehiculosCom.jsp"> Listado de Vehiculo </a> </button>
        <br><br>
    
    </body>
</html>
