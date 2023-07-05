<%-- 
    Document   : ConsultarVehiculoADM
    Created on : 1/07/2022, 07:47:12 AM
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.VehiculoDAO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/consultarVehiculo.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/ico" href="IMG/2555021.png" />
        <title>Busca Tu vehiculo</title>
    </head>

<body><center>
        <header class="header">
    
            <h1 class="titulo">Concesionario</h1>
            <h2 class="title">bienvenid@ al Concesionario</h2>
        </header>
        <form method="post" action="Sesiones" class="cerrar" >
            <input type="submit" value="Cerrar Sesión" id="guardar">
        </form>
        <h1 class="titulo2">Ingresa la marca del vehiculo que quieres </h1>

        <form method="post" action="Vehiculo">
            <table class="bus">
                <tr>
                    <th>
                        PLACA VEHÍCULO 
                       <input type="text" name="txtplaca" class="buscar">
                        <button class="cons">Consultar</button>
                        <input type="hidden" value="4" name="opcion">
                        <button class="cons"><a  href="menu.jsp" >Volver Atras</a></button>
                    </th>
                </tr>
            </table>
 
</form><BR>

        <%            if (request.getAttribute("mensajeError") != null) { %>
        <h5>
            ${mensajeError} 
        </h5>

        <%} else {%>
        <h5>
            ${mensajeExito}

        </h5>
        <% }%>
        <form method="post" action="Vehiculo">
            <table>
                <tr>
                    <th >PLACA</th>
                    <th >DATOS</th>
                    <th >CATEGORIA</th>
                    <th >MODELO</th>
                    <th>MARCA</th>
                    <th>ESTADO</th>
                    <th>PRECIO</th>
                    <th>DATOS PERSONALES</th>

                </tr>

                <%
                    VehiculoVO vehVO = new VehiculoVO();
                    VehiculoDAO vehDAO = new VehiculoDAO();

                    ArrayList<VehiculoVO> listaVehiculos = vehDAO.listar();
                    for (int i = 0; i < listaVehiculos.size(); i++) {
                        vehVO = listaVehiculos.get(i);


                %>  
                <tr >
                    <td><%=vehVO.getVehPlaca()%></td>
                    <input type="hidden" value="5" name="opcion">

                    <td><%=vehVO.getDatId()%></td>
                    <td><%=vehVO.getCatId()%></td>
                    <td><%=vehVO.getVehModelo()%></td>
                    <td><%=vehVO.getVehMarca()%></td>
                    <td><%=vehVO.getVehEstado()%></td>
                    <td><%=vehVO.getVehPrecio()%></td>
                    <td><button name="datos" class="datos" value="<%=vehVO.getDatId()%>">Consultar Datos</button></td>

                </tr>

                <% }%>
            </table>
        </form>
    </body></center>
</html>
