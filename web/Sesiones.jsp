<%-- 
    Document   : Sesiones
    Created on : 15/06/2022, 09:07:37 AM
    Author     : yuliana
--%>

<%@page import="ModeloVO.DatosPersonalesVO"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/ico" href="IMG/2555021.png" />
        <link href="CSS/menu.css" rel="stylesheet" type="text/css"/>
        <title>Sesiones</title>
    </head>
    <%
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
        response.setDateHeader("Expires", 0);
    %>

    <%
        HttpSession miSesion = (HttpSession) request.getSession();
        String usuario = "";
        if (miSesion.getAttribute("datosUsuario") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else {
            UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("datosUsuario");
            usuario = usuVO.getUsuLogin();

        }

    %>

    <%        DatosPersonalesVO datVO = new DatosPersonalesVO();
        datVO = (DatosPersonalesVO) miSesion.getAttribute("datosPersonales");
    %>

</html>
