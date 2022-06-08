
package Controlador.Productos;

import Logica.ProductosManager;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

 
@WebServlet(name = "NuevoProdSet", urlPatterns = {"/NuevoProdSet"})
public class NuevoProdSet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       
        }
    }

    
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
         //   int id = Integer.parseInt(request.getParameter("id"));
            String descrip = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            double precio = Double.parseDouble(request.getParameter("precio"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            Producto prod = new Producto();
 
            prod.setDescripcion(descrip);
            prod.setPrecio(precio);
            prod.setExistencia(cantidad);
            prod.setIdcattipoproducto(tipo);
            ProductosManager manager = new ProductosManager();
            int estatus = manager.RegistraProdDatos(prod);

            JSONObject data = new JSONObject();
            if (estatus == 1) {
                data.put("Respuesta", true);

            } else {
                data.put("Respuesta", false);
            }

            out.print(data.toJSONString());
              //request.getRequestDispatcher("Vistas/Productos/index.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
