/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import JEmail.ParametrosCorreo;
import ModeloDAO.DatosPersonalesDAO;
import ModeloDAO.RolDAO;
import ModeloDAO.UsuarioDAO;
import ModeloVO.DatosPersonalesVO;
import ModeloVO.RolVO;
import ModeloVO.UsuarioVO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SENA
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //1.  recibir datos de las vistas 
        String usuid = request.getParameter("txtID");
        String usulogin = request.getParameter("txtUsuario");
        String usupassword = request.getParameter("txtClave");
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        //2. ¿Quien tiene los datos de forma segura en el sistema? el VO se instancia
        UsuarioVO usuVO = new UsuarioVO(usuid, usulogin, usupassword);
        //3. ¿quien hace las operaciones ? DAO se instanci el DAO
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        //4.Administrar operaciones 

        String host;
        String puerto;
        String usuario;
        String clave;
        
        switch (opcion) {

            case 1://agreagar registro 
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se registro correctamente");

                    ServletContext context = getServletContext();

                    host = context.getInitParameter("host");
                    puerto = context.getInitParameter("puerto");
                    usuario = context.getInitParameter("usuario");
                    clave = context.getInitParameter("clave");

                    String receptor = request.getParameter("txtUsuario");
                    String asunto = "Bienvenido a Nuestro concesionario web, Correo de Registro";
                    String contenido = "Usted se ha registrado correctamente en nuestro Concesionario" + "\n" + "\n" + "Su usuario es:  "  + request.getParameter("txtUsuario") + "\n" + "\n" + "Su contraseña es:  " + request.getParameter("txtClave") + "\n" + "\n" + "Muchas Gracias por registrarse en nuestra pagina.";
                    String resultadoMensaje = "";
                    try {
                        ParametrosCorreo.envioCorreo(host, puerto, usuario, clave, receptor, asunto, contenido);
                        resultadoMensaje = "El mensaje se envio de forma correcta";
                    } catch (Exception e) {

                        e.printStackTrace();
                        resultadoMensaje = "Error al enviar el mensaje " + e.getMessage();
                    } finally {

                        request.setAttribute("mensaje", resultadoMensaje);
                        getServletContext().getRequestDispatcher("/resultado.jsp");
                    }
                } else {
                    request.setAttribute("mensajeError", "El usuario no se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;

            case 2://Actualizar registro 
                if (usuDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "el usuario se actualizo correctamente");

                } else {
                    request.setAttribute("mensajeError", "el usuario no se actualizo correctamente");
                }
                request.getRequestDispatcher("actualizarUsuario.jsp").forward(request, response);
                break;

            case 3://Eliminar registro 
                if (usuDAO.eliminarRegistro()) {
                    request.setAttribute("mensajeExito", "el usuario se elimino correctamente");

                } else {
                    request.setAttribute("mensajeError", "el usuario no se elimino correctamente");
                }
                request.getRequestDispatcher("eliminoUsuario.jsp").forward(request, response);
                break;

            case 4://Inicio sesion
                String idUsuario = "";
                if (usuDAO.iniciarSesion(usulogin, usupassword)) {

                    HttpSession miSesion = request.getSession(true);
                    usuVO = new UsuarioVO(usuid, usulogin, usupassword);
                    miSesion.setAttribute("datosUsuario", usuVO);

                    RolDAO rolDAO = new RolDAO();
                    RolVO rolVO = new RolVO();
                    ArrayList<RolVO> listaRoles = rolDAO.rol(usulogin);

                    for (int i = 0; i < listaRoles.size(); i++) {
                        rolVO = listaRoles.get(i);
                    }

                    DatosPersonalesVO datVO = new DatosPersonalesVO();
                    DatosPersonalesDAO datDAO = new DatosPersonalesDAO();

                    datVO = datDAO.consultarDatos(usuid);

                    miSesion.setAttribute("datosPersonales", datVO);
                    String tipoR = rolVO.getRolTipo();

                    if (tipoR.equals("Vendedor")) {

                        request.getRequestDispatcher("Vendedor.jsp").forward(request, response);

                    } else if (tipoR.equals("Comprador")) {
                        request.getRequestDispatcher("comprador.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("menu.jsp").forward(request, response);
                    }

                } else {
                    request.setAttribute("mensajeError", "Los datos de ingreso son incorrectos ");

                    request.getRequestDispatcher("Sesiones.jsp").forward(request, response);

                }
                break;
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response
    )
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
