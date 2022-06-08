/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Perfil;

import Logica.UsuariosManager;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;
import org.json.simple.JSONObject;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "UpdatePerfil", urlPatterns = {"/UpdatePerfil"})
public class UpdatePerfilServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Cookie[] my_cookies = null;
            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);
            int valorSubmit = Integer.parseInt(val.get());

            String nombre = request.getParameter("nombre");
            String ap = request.getParameter("apaterno");
            String am = request.getParameter("amaterno");
            // String correo=request.getParameter("email");

            Usuario user = new Usuario();
            user.setIdUsuario(valorSubmit);
            user.setNombre(nombre);
            user.setApPaterno(ap);
            user.setApMaterno(am);

            UsuariosManager manager = new UsuariosManager();
            int status = manager.ActualizaUsuario(user);
            if (status != 0) {
                Usuario usuario = manager.GetUsuario(valorSubmit);
                request.setAttribute("detalle", usuario);
                   JSONObject data = new JSONObject();
                    data.put("isready", true);
            } else {
                request.getRequestDispatcher("Vistas/error.jsp").forward(request, response);
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
