/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Usuarios;

import Logica.CatTipoUsuarioManager;
import Modelo.CatTipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Acer ES 15
 */
@WebServlet(name = "CattipoUsuario", urlPatterns = {"/CattipoUsuario"})
public class CattipoUsuario extends HttpServlet {

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
        // response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            System.out.println(request.getParameter("reqValue"));
            // response.setContentType("text/html;charset=UTF-8");
            // response.getWriter().write("Success Data");
            response.setContentType("application/json");
            out.print("I miss you ha ha!");
            out.close();

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            System.out.println(request.getParameter("reqValue"));
            // response.setContentType("text/html;charset=UTF-8");
            // response.getWriter().write("Success Data");
            request.setCharacterEncoding("utf8");
            //response.setCharacterEncoding("utf8");
            response.setContentType("application/json");
            CatTipoUsuarioManager manager = new CatTipoUsuarioManager();
            List<CatTipoUsuario> tipos = manager.GetListCatTipoUsuario();
            // JSONObject jsonObj = (JSONObject) JSONValue.parse(request.getParameter("reqValue"));
            // System.out.println(jsonObj.get("message"));
            //  JSONObject obj = new JSONObject();
            //obj.put("message", "hello from server");
            // System.out.println(obj.toString());
            //out.print(obj.toString());
            JSONArray jsonArray = new JSONArray();
            for (CatTipoUsuario tipo : tipos) {
                JSONObject data = new JSONObject();
                data.put("id", tipo.getIdcattipoUsuario());
                data.put("descripcion", tipo.getDescripcion());
                jsonArray.add(data);

            }
            out.print(jsonArray.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
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
