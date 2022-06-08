package Logica;

import Modelo.CatTipoProducto;
import Modelo.GaleriaProducto;
import Modelo.Producto;
import com.mysql.cj.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class CatTipoProductoManager extends Conexion {

    public List<CatTipoProducto> GetCatTipoProd() {
        List<CatTipoProducto> list = new ArrayList<CatTipoProducto>();
        try {
            Connection conexion = getConection();
            String query = "select * from cattipoproducto";
            PreparedStatement st = conexion.prepareStatement(query);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CatTipoProducto cat = new CatTipoProducto();
                cat.setId(rs.getInt(1));
                  cat.setDescripcion(rs.getString(2));
                list.add(cat);
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
}
