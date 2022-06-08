 
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

 
@WebServlet(name = "EditarDatosProducto", urlPatterns = {"/EditarDatosProducto"})
public class EditarDatosProducto extends HttpServlet {
    
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String descrip = request.getParameter("descripcion");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            double precio = Double.parseDouble(request.getParameter("precio"));

            Producto prod = new Producto();
            prod.setIdProducto(id);
            prod.setDescripcion(descrip);
            prod.setPrecio(precio);
            prod.setExistencia(cantidad);

            ProductosManager manager = new ProductosManager();
            int estatus = manager.EditarProd(prod);

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
