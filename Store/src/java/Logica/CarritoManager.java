package Logica;

import Modelo.CatTipoProducto;
import Modelo.Producto;
import Modelo.ProductoCarrito;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
                        pc.setSubtotal("$" + c * items);
                        pc.setSubtotalD(c);
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

    public int deleteProdUser(int idProd, int idUser) {
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

    public int confirmarCompra(int idUser, String noTarjeta, String codigoSeg, String fechaSeg, int idDir) {
        int estatus;
        //get prods carrito 
        List<ProductoCarrito> carritoProd = GetCarrito(idUser);
        if (carritoProd.size() > 0) {
            //get totalprods
            double totalProds = 0;
            for (ProductoCarrito pc : carritoProd) {
                int cantidad = pc.getCantidad();
                double subtotal = pc.getSubtotalD();
                totalProds += cantidad * subtotal;
            }

            //create venta
            try {
                Connection conexion = getConection();
                String query = "insert into venta(fechaVenta,TotalVenta,idDireccion,tarjetaPago,codigoTarjeta,fechaTarjeta) values(?,?,?,?,?,?)";
                PreparedStatement st = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());

                st.setDate(1, date);
                st.setDouble(2, totalProds);
                st.setInt(3, idDir);
                st.setString(4, noTarjeta);
                st.setString(5, codigoSeg);
                st.setString(6, fechaSeg);
                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();
                int id = 0;

                if (rs.next()) {
                    id = rs.getInt(1);
                    System.out.println("Inserted ID -" + id);
                }
                if (id != 0) {
                    System.out.println("Compra correctamente generada---------------------------------->");

                    //create productoventa
                    for (ProductoCarrito pc : carritoProd) {
                        String query2 = "insert into productoventa(idventa,idproducto,cantidad) values(?,?,?)";
                        PreparedStatement st2 = conexion.prepareStatement(query2);
                        st2.setInt(1, id);
                        st2.setInt(2, pc.getIdProducto());
                        st2.setInt(3, pc.getCantidad());
                        estatus = st2.executeUpdate();
                        System.out.println("Registrado correctamente en la compra---------------------------------->");
                    }

                    //create ventausuario
                    String query3 = "insert into ventausuario(idusuario,idventa) values(?,?)";
                    PreparedStatement st3 = conexion.prepareStatement(query3);

                    st3.setInt(1, idUser);
                    st3.setInt(2, id);
                    estatus = st3.executeUpdate();

                    String queryd = "delete from carrito  where idUsuario=?";
                    PreparedStatement std = conexion.prepareStatement(queryd);
                    std.setInt(1, idUser);

                    estatus = std.executeUpdate();

                    System.out.println("Registrado correctamente en la compra---------------------------------->");

                    System.out.println("Registrado correctamente en la compra---------------------------------->");
                    return estatus = 1;
                } else {
                    System.out.println("Compra no generada---------------------------------->");
                    return 0;
                }
            } catch (SQLException e) {
                return 0;
            }
        } else {
            System.out.println("Compra no generada por falta de productos---------------------------------->");
            return 0;
        }

    }

}
