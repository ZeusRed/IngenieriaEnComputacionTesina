package Controlador.WishList;

import Logica.PedidosManager;
import Logica.WishlistManager;
import Modelo.WishlistDetalle;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "WishList", urlPatterns = {"/WishList"})
public class WishListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*Nombre  y permisos*/
            String nombreUsuario = "Reynaldo Mejía Rivera";
            String perfilTipo = "1"; // 1:administrador  - 0 comprador

            request.setAttribute("tipoPerfil", perfilTipo);
            request.setAttribute("nombreUsuario", nombreUsuario);

            List<WishlistDetalle> listaProds = new ArrayList<>();
            Cookie[] my_cookies = null;

            // Get an array of Cookies associated with the this domain
            my_cookies = request.getCookies();
            Optional<String> val = leerCookie("User_id", my_cookies);
            if (val != null) {
                WishlistManager manager = new WishlistManager();
                int id = Integer.parseInt(val.get());
               
                listaProds = manager.ListProductosWishList(id);
                request.setAttribute("whis", listaProds);

            } else {
                request.setAttribute("whis", listaProds);
            }
            request.getRequestDispatcher("Vistas/WishList/index.jsp").forward(request, response);
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
