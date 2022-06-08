package Logica;

import Modelo.CatTipoProducto;
import Modelo.Producto;
import Modelo.ProductoCarrito;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CarritoManager extends Conexion {

    public List<ProductoCarrito> GetCarrito(int idUser) {
        List<ProductoCarrito> list = new ArrayList<>();
        try {
            Connection conexion = getConection();
            String query = "select * from carrito where idUsuario=?";
            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, idUser);
            ResultSet rs = st.executeQuery();

            int idCarrito = 0;
            int idUserDB = 0;
            List<Integer> idProds = new ArrayList<>();

            while (rs.next()) {
                idCarrito = rs.getInt(1);

                idUserDB = rs.getInt(3);
                int idProducto = rs.getInt(2);
                idProds.add(idProducto);

            }
            int iteracion = 0;

            for (int id : idProds) {
                if ((int) list.stream().filter(x -> x.getIdProducto() == id).count() == 0) {
                    int items = (int) idProds.stream().filter(c -> c == id).count();

                    //eliminar repetidos
                    String query2 = "select * from producto where idProducto=?";
                    PreparedStatement st2 = conexion.prepareStatement(query2);
                    st2.setInt(1, id);
                    ResultSet rs2 = st2.executeQuery();

                    while (rs2.next()) {
                        iteracion++;
                        int a = rs2.getInt(1);
                        String b = rs2.getString(2);
                        double c = rs2.getDouble(3);

                        ProductoCarrito pc = new ProductoCarrito();
                        pc.setIdCarrito(idCarrito);
                        pc.setDescripcion(b);
                        pc.setCantidad(items);
                        pc.setIdProducto(id);
                        pc.setIteracion(iteracion);
                        pc.setSubtotal("$" + c);
                        list.add(pc);

                    }
                }
            }

            return list;
        } catch (SQLException e) {
            return null;
        }
    }

    public int addProdUser(int idProd, int idUser) {
        int estatus;
        
        try {
            Connection conexion = getConection();
            String query = "insert into carrito(idProducto,idUsuario) values(?,?)";
            PreparedStatement st = conexion.prepareStatement(query);
            st.setInt(1, idProd);
            st.setInt(2, idUser);
            estatus = st.executeUpdate();
            System.out.println("Registrado correctamente en el carrito---------------------------------->");
            return estatus;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    
    public int deleteProdUser(int idProd, int idUser){
         int estatus = 0;
        try {
            Connection con = getConection();
            String query = "delete from carrito  where idUsuario=? and idProducto=?";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, idUser);
                 st.setInt(2, idProd);
            estatus = st.executeUpdate();

            System.out.println("Producto Eliminado correctamente");
            con.close();
            return estatus;

        } catch (SQLException E) {
            System.out.println("Error al eliminar:" + E.getMessage());
            return 0;
        }
    }

}
