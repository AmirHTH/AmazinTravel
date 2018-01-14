package impl.miw.persistence.billete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.Billete;
import com.miw.persistence.BilleteDataService;

public class BilleteDAO implements BilleteDataService{
	
	public synchronized Billete crearBillete(Billete billete) throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// Obtenemos la conexiï¿½n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "dflanvin", "amazin");

			ps = con.prepareStatement("select max(billeteid) as maximo from billete");
			rs = ps.executeQuery();
			Integer id=0;
			while (rs.next()) {
				 id = rs.getInt("maximo");
			}
			
			System.out.println("Máximo id encontrado: "+id);
			System.out.println(billete);
			
			billete.setBilleteId((id));
			//Creamos el billete
			
			/*
			 * 		Billeteid
					VIAJEID INTEGER,
					USUARIOID INTEGER,
					PLAZAS_COMPRADAS INTEGER,
					MALETAS15 INTEGER,
					MALETAS20 INTEGER,
					COCHE VARCHAR(50),
					PRECIOFINAL DOUBLE,
					BILLETEVUELTAID INTEGER,
					*/

			ps = con.prepareStatement("insert into billete values (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, id+1);
			ps.setInt(2, billete.getViajeId());
			ps.setInt(3, billete.getUsuarioId());
			ps.setInt(4, billete.getPlazas());
			ps.setInt(5, billete.getNumMaletas15());
			ps.setInt(6, billete.getNumMaletas20());
			ps.setString(7, billete.getCocheTipo());
			ps.setDouble(8,  billete.getPrecioFinal());
			ps.setInt(9, billete.getBilleteVueltaId());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		// Retornamos el vector de resultado.
		return billete;
	}

	@Override
	public int cancelarReserva(int codigoReserva, String email) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Billete getBillete(Billete billete) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();


		try {	
			ps = con.prepareStatement("select * from billete where billeteid = ?");
			ps.setInt(1, billete.getBilleteId()); //Si lo quiere Ida y Vuelta, en la Vuelta, el sitio de Destino será donde se inicie el vuelo
			rs = ps.executeQuery();
			
			billete = null;

			while (rs.next()) {
				// Completamos los datos del viaje en la entidad
				billete = new Billete();
				billete.setViajeId(rs.getInt("Billeteid"));
				billete.setViajeId(rs.getInt("VIAJEID"));
				billete.setUsuarioId(rs.getInt("USUARIOID"));
				billete.setPlazas(rs.getInt("PLAZAS_COMPRADAS"));
				billete.setNumMaletas15(rs.getInt("MALETAS15"));
				billete.setNumMaletas20(rs.getInt("MALETAS20"));
				billete.setCocheTipo(rs.getString("COCHE"));
				billete.setPrecioFinal(rs.getDouble("PRECIOFINAL"));
				billete.setBilleteVueltaId(rs.getInt("BILLETEVUELTAID"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		// Retornamos el vector de resultado.
		return billete;
	}
	
	private Connection conectarConBD(){
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// Obtenemos la conexion a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "dflanvin", "amazin");
			return con;
		}catch(Exception e){
			return null;
		}
	}
	
	

}
