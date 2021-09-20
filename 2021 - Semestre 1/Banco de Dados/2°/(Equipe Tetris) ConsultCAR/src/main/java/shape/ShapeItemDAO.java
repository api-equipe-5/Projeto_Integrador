package shape;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.locationtech.jts.io.WKBWriter;

import db_connection.ConnectionFactory;



public class ShapeItemDAO {
	
	
	public void save(ShapeItem shape) throws SQLException, ClassNotFoundException, IOException {
		String sql = "INSERT INTO consult_car (num_area, cod_estado, nome_municipio, num_modulo, tipo_imovel, situacao, condicao_imovel, geom, cod_imovel) VALUES (?, ?, ?, ?, ?, ?, ?, ST_GeomFromWKB(?), ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		WKBWriter writer = new WKBWriter();
		
		try {
			conn = ConnectionFactory.createConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, shape.getNum_area());
			pstm.setString(2, shape.getCod_estado());
			pstm.setString(3, shape.getNome_municipio());
			pstm.setDouble(4, shape.getNum_modulo());
			pstm.setString(5, shape.getTipo_imovel());
			pstm.setString(6, shape.getSituacao());
			pstm.setString(7, shape.getCondicao_imovel());
			pstm.setBytes(8, writer.write(shape.getGeom()));
			pstm.setString(9, shape.getCod_imovel());
			
			pstm.execute();
		} finally {
		   
			try {
				if(pstm != null ) {
					pstm.close();
				}
				
				if(conn != null ) {
					conn.close();
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

}
