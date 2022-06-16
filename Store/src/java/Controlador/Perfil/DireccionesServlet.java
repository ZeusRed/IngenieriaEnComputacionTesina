/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Perfil;

import Logica.DireccionesManager;
import Logica.UsuariosManager;
import Modelo.Direccion;
import Modelo.Usuario;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "Direcciones", urlPatterns = {"/Direcciones"})
public class DireccionesServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /*Nombre  y permisos*/
            Cookie[] my_cookies = null;

            // Get an array of Cookies associated with the this domain
            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);

            int valorSubmit = Integer.parseInt(val.get());
            UsuariosManager manager = new UsuariosManager();
            Usuario usuario = manager.GetUsuario(valorSubmit);

            if (usuario.getIdUsuario() == 0) {
                // request.setAttribute("detalle", usuario);
                // request.getRequestDispatcher("/Vistas/AccionesUsuario/EditarUsuario.jsp").forward(request, response);
                request.getRequestDispatcher("Vistas/error.jsp").forward(request, response);
            } else {
                DireccionesManager manager2 = new DireccionesManager();

                List<Direccion> direcciones = manager2.getDirecciones(usuario.getIdUsuario());

                request.setAttribute("direcciones", direcciones);
                // request.getRequestDispatcher("/Vistas/AccionesUsuario/EditarUsuario.jsp").forward(request, response);
                // request.getRequestDispatcher("Vistas/Usuarios/detalleUsuario.jsp").forward(request, response);
                request.getRequestDispatcher("Vistas/Direcciones/index.jsp").forward(request, response);
            }
        }
    }

    public Optional<String> leerCookie(String key, Cookie[] cockies) {
        return Arrays.stream(cockies)
                .filter(c -> key.equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
