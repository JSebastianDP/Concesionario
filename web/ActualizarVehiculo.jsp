<%-- 
    Document   : ActualizarVehiculo
    Created on : 1/07/2022, 05:06:52 PM
    Author     : User
--%>

<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloVO.VehiculoVO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/actualizarVehiculo.css" rel="stylesheet" type="text/css"/>
        <title>Actualizar Vehiculo</title>
    </head>
    <body><center>
        <header class="header">
           
            <h1 class="titulo">Concesionario</h1>
            <h2 class="title">bienvenid@ a el Concesionario Web </h2>
        </header>
        <form method="post" action="Sesiones">
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>
        <h1 class="principal"><b>Actualizar Vehiculo</h1></b>

    <%
        if (request.getAttribute("VehiculoConsultado") != null) {
            VehiculoVO vehVO = (VehiculoVO) request.getAttribute("VehiculoConsultado");

    %>
    <center>
        <form method="post" action="Vehiculo" class="one">


            <label>Placa Vehiculo</label><br>
            <input type="text" name="txtplaca"  value="<%=vehVO.getVehPlaca()%>" readonly><br>
            <label> Id Datos Personales</label><br>
            <input type="text" name="txtdat" value="<%=vehVO.getDatId()%>"><br>
            <label> Id Categoria</label> <br>
            <select name="txtcat" > 
                <option>Seleccione..</option>
                
                <%
                    CategoriaDAO catDAO = new CategoriaDAO();
                    for(CategoriaVO catVO : catDAO.listar()) 
                    {
                %>
                        <option value="<%=catVO.getCatId()%>"> <%=catVO.getCatIpo()%> </option>
                <%  }
                %>
                
            </select><br><br>
            
            <label>Modelo Vehiculo</label><br>
            <input type="text" name="txtmodelo" value="<%=vehVO.getVehModelo()%>"><br>

            <label> Marca Vehiculo</label><br>
            <select type="text" name="txtmarca" value="<%=vehVO.getVehMarca()%>">
                <option>Seleccione..</option>           
                <option>CHEVROLET</option>
                <option>FORD</option>
                <option>FERRARI</option>
                <option>MERCEDES</option>
            </select><br><br>
            <label> Estado Vehiculo</label><br>
            <select name="txtestado" value="<%=vehVO.getVehEstado()%>">
                <option>Usado</option>
                <option>Nuevo</option>
            </select><br>
            <label>Precio Vehiculo</label><br>
            <input type="text" name="txtprecio" value="<%=vehVO.getVehPrecio()%>"><br>
            <br>
            <button class="btn"> Actualizar </button>
            <input type="hidden" value="2" name="opcion">
            
            <button class="btn"> <a href="ConsultarVehiculo.jsp" class="Atras"> Atras </a> </button>
        </form><br>

      <%
                if (request.getAttribute("mensajeError") != null) 
          { %>
            <h5>
                ${mensajeError} 
            </h5>

            <%} else {%>
            <h5>
                ${mensajeExito}

            </h5>
            <% }%>
    
    <%}else{%>
    
    <h4>No se ha ingresado ningun Vehículo</h4>
    <%}%>

    </center>
</body>
</html>
