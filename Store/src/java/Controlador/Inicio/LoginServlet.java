/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Inicio;

import Logica.Mail;
import Logica.SessionLogic;
import Logica.UsuariosManager;
 
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
 

 
@WebServlet(name = "LoginAccess", urlPatterns = {"/LoginAccess"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String correo = request.getParameter("correo");
            String password = request.getParameter("pwd");
            System.out.println(request.getParameter("correo"));
            System.out.println(request.getParameter("pwd"));
            if (correo != null && password != null) {
                UsuariosManager manager = new UsuariosManager();

                int isAcceso = manager.LoginUsuario(correo, password);
                if (isAcceso != 0) {
                    //Crea objeto de session
                    SessionLogic sl = new SessionLogic();
                    sl.setCorreo(correo);
                    sl.setPassword(password);
                    sl.setTiempoInactivoPermitido(10);
                    sl.setIdUsuario(isAcceso);
                    int tiempoPermitido = sl.getTiempoInactivoPermitido();
                    HttpSession session = request.getSession();

                    session.setMaxInactiveInterval(tiempoPermitido);

                    session.setAttribute("sessionUsuario", sl);
                    String id= Integer.toString(isAcceso);
                   Cookie name = new Cookie("User_id",id);
                    response.addCookie( name );
                    
                    UsuariosManager manager2 = new UsuariosManager();
                    //-----------------------------------
                    //List<Producto> prods2 = manager2.GetProds();
                    //String base64Image = "";
                  //  for (Producto prod : prods2) {
                    //    base64Image = Base64.getEncoder().encodeToString(prod.getImagen());
                    //}
                    //int prod=manager2.RegistraProd();
                    //--------------------------------
                   
                   JSONObject data = new JSONObject();
                    data.put("acceso", true);
                     out.print(data.toString());
              
                   
                //    data.put("imagen", base64Image);
               
                   
                } else {
                    JSONObject data = new JSONObject();
                    data.put("acceso", false);
                    out.print(data.toString());
                }

            } else {

                JSONObject data = new JSONObject();
                data.put("acceso", false);
                out.print(data.toString());

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  
}
