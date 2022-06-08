
package Logica;

import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.ProductoVenta;
import Modelo.Venta;
import Modelo.VentaUsuario;
import com.mysql.cj.jdbc.Blob;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author Acer ES 15
 */
public class PedidosManager extends Conexion {

    public List<DetalleVenta> ListProductosVenta(int idUsuario) {
        Connection conexion = getConection();
        List<DetalleVenta> productosVentaUsuario = new ArrayList<>();
        try {
            String query = "select * from ventausuario where idusuario=?";

            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();

            List<VentaUsuario> ventasUsuario = new ArrayList<>();
            while (rs.next()) {
                VentaUsuario vu = new VentaUsuario();
                vu.setIdUsuario(rs.getInt(1));
                vu.setIdUsuario(rs.getInt(2));
                vu.setIdVenta(rs.getInt(3));
                ventasUsuario.add(vu);
            }
            System.out.println("Registros obtenidos correctamente 1");
            List<Venta> ventas = new ArrayList<>();

            for (VentaUsuario v : ventasUsuario) {
                String query2 = "select * from venta where idventa=?";

                PreparedStatement st2 = conexion.prepareStatement(query2);
                st2.setInt(1, v.getIdVenta());
                ResultSet rs2 = st2.executeQuery();

                while (rs2.next()) {
                    Venta venta = new Venta();
                    venta.setIdVenta(rs2.getInt(1));
                    venta.setFechaVenta(rs2.getDate(2));
                    venta.setTotalVenta(rs2.getDouble(3));
                    ventas.add(venta);
                }
            }

            System.out.println("Registros obtenidos correctamente 2");
            
           List<ProductoVenta> productosVentas = new ArrayList<>();
            for (Venta v : ventas) {
                String query3 = "select * from productoventa where idventa=?";

                PreparedStatement st3 = conexion.prepareStatement(query3);
                st3.setInt(1, v.getIdVenta());
                ResultSet rs3 = st3.executeQuery();

                while (rs3.next()) {
                    ProductoVenta pv = new ProductoVenta();
                    pv.setIdProductoVenta(rs3.getInt(1));
                    pv.setIdVenta(rs3.getInt(2));
                    pv.setIdProducto(rs3.getInt(3));
                    productosVentas.add(pv);
                }
            }
            List<Producto> productos = new ArrayList<>();
            for (ProductoVenta pv : productosVentas) {
                String query3 = "select * from producto where idproducto=?";

                PreparedStatement st3 = conexion.prepareStatement(query3);
                st3.setInt(1, pv.getIdProducto());
                ResultSet rs3 = st3.executeQuery();

                while (rs3.next()) {
                   Producto prod = new Producto();
                prod.setIdProducto(rs3.getInt(1));
                prod.setDescripcion(rs3.getString(2));
                prod.setPrecio(rs3.getDouble(3));
                prod.setExistencia(rs3.getInt(4));

                prod.setIdcattipoproducto(rs3.getInt(5));

                Blob image = (Blob) rs3.getBlob(6);
                if (image != null) {
                    prod.setImagen(image.getBytes(1, (int) image.length()));

                    prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
                }
                productos.add(prod);
                }
            }
            for(Producto prod   : productos){
                DetalleVenta detalle= new DetalleVenta();
                detalle.setProducto(prod.getDescripcion());
                detalle.setSubtotal(prod.getPrecio());
                detalle.setBase64Image(prod.getBase64Image());
                detalle.setCantidad(1);
                productosVentaUsuario.add(detalle);
            }
            
            System.out.println("Registros obtenidos correctamente 3");
            /*Blob image = (Blob) rs.getBlob(6);
            if (image != null) {
                prod.setImagen(image.getBytes(1, (int) image.length()));

                prod.setBase64Image(Base64.getEncoder().encodeToString(prod.getImagen()));
            }
            prods.add(prod);*/
            return productosVentaUsuario;

        } catch (Exception e) {
            System.out.println("Registros incorrectos........" + e.getMessage());
             return null;
        }
       
    }
}
