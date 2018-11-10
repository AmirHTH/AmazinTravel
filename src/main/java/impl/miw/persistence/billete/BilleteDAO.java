package impl.miw.persistence.billete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Vector;

import com.miw.model.Billete;
import com.miw.model.Usuario;
import com.miw.model.Viaje;
import com.miw.persistence.BilleteDataService;

public class BilleteDAO implements BilleteDataService{
	
	public synchronized Billete crearBillete(Billete billete) throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();

		try {
			
			
			ps = con.prepareStatement("select max(billeteid) as maximo from billete");
			rs = ps.executeQuery();
			Integer id=0;
			while (rs.next()) {
				 id = rs.getInt("maximo");
			}
			
			System.out.println("Máximo id encontrado: "+id);
			System.out.println(billete);
			
			billete.setBilleteId((id+1));
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

			ps = con.prepareStatement("insert into billete values (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, id+1);
			ps.setInt(2, billete.getViajeId());
			ps.setInt(3, billete.getUsuarioId());
			ps.setInt(4, billete.getPlazas());
			ps.setInt(5, billete.getNumMaletas15());
			ps.setInt(6, billete.getNumMaletas20());
			ps.setString(7, billete.getCocheTipo());
			ps.setDouble(8,  billete.getPrecioFinal());
			ps.setString(9, billete.getEstado());
			ps.setInt(10, billete.getBilleteVueltaId());
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
	public Billete cancelarReserva(Billete billete) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();

		try {				
			ps = con.prepareStatement("update billete set ESTADO = ? where billeteid = ?");
			ps.setString(1, Billete.ESTADO_CANCELADO); 
			ps.setInt(2, billete.getBilleteId()); 
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
		
		return billete;
	}
	
	@Override
	public Billete getBilleteByIdAndUser(Billete billete) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();
		Billete billeteEncontrado = null;

		try {	
			ps = con.prepareStatement("select * from billete where billeteid=? and usuarioid=?");
			ps.setInt(1, billete.getBilleteId()); //Si lo quiere Ida y Vuelta, en la Vuelta, el sitio de Destino será donde se inicie el vuelo
			ps.setInt(2, billete.getUsuarioId());
			rs = ps.executeQuery();
			
			//billete = null;
			
			if (rs.next() ) {
				billeteEncontrado = new Billete();
				// Completamos los datos del viaje en la entidad
				
				billeteEncontrado.setBilleteId(rs.getInt("BilleteId"));
				billeteEncontrado.setViajeId(rs.getInt("VIAJEID"));
				billeteEncontrado.setUsuarioId(rs.getInt("USUARIOID"));
				billeteEncontrado.setPlazas(rs.getInt("PLAZAS_COMPRADAS"));
				billeteEncontrado.setNumMaletas15(rs.getInt("MALETAS15"));
				billeteEncontrado.setNumMaletas20(rs.getInt("MALETAS20"));
				billeteEncontrado.setCocheTipo(rs.getString("COCHE"));
				billeteEncontrado.setPrecioFinal(rs.getDouble("PRECIOFINAL"));
				billeteEncontrado.setEstado(rs.getString("ESTADO"));
				billeteEncontrado.setBilleteVueltaId(rs.getInt("BILLETEVUELTAID"));
				
				if(billeteEncontrado.getBilleteVueltaId() != 0){
					billeteEncontrado.setTipo(Billete.VUELTA);
				}
				
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
		return billeteEncontrado;
	}
	
	
	@Override
	public Vector<Billete> getBilletesUsuario(Usuario usuario) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();
		

		Vector<Billete> resultado = new Vector<Billete>();

		
		try {	
			ps = con.prepareStatement("select * from billete where usuarioId = ?");
			ps.setInt(1, usuario.getUsuarioId()); //Si lo quiere Ida y Vuelta, en la Vuelta, el sitio de Destino será donde se inicie el vuelo
			rs = ps.executeQuery();
			
			

			while (rs.next()) {
				// Completamos los datos del billete en la entidad
				Billete billete = new Billete();
				billete.setBilleteId(rs.getInt("Billeteid"));
				billete.setViajeId(rs.getInt("VIAJEID"));
				billete.setUsuarioId(rs.getInt("USUARIOID"));
				billete.setPlazas(rs.getInt("PLAZAS_COMPRADAS"));
				billete.setNumMaletas15(rs.getInt("MALETAS15"));
				billete.setNumMaletas20(rs.getInt("MALETAS20"));
				billete.setCocheTipo(rs.getString("COCHE"));
				billete.setPrecioFinal(rs.getDouble("PRECIOFINAL"));
				billete.setEstado(rs.getString("ESTADO"));
				billete.setBilleteVueltaId(rs.getInt("BILLETEVUELTAID"));
				
				if(billete.getBilleteVueltaId() != 0){
					billete.setTipo(Billete.VUELTA);
				}
				
				resultado.add(billete);
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
		return resultado;
	}
	
	
	@Override
	public Vector<Billete> getAllBilletes() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();
		
		Vector<Billete> resultado = new Vector<Billete>();


		try {	
			ps = con.prepareStatement("select * from billete");
			rs = ps.executeQuery();
			
			

			while (rs.next()) {
				// Completamos los datos del billete en la entidad
				Billete billete = new Billete();
				billete.setViajeId(rs.getInt("Billeteid"));
				billete.setViajeId(rs.getInt("VIAJEID"));
				billete.setUsuarioId(rs.getInt("USUARIOID"));
				billete.setPlazas(rs.getInt("PLAZAS_COMPRADAS"));
				billete.setNumMaletas15(rs.getInt("MALETAS15"));
				billete.setNumMaletas20(rs.getInt("MALETAS20"));
				billete.setCocheTipo(rs.getString("COCHE"));
				billete.setPrecioFinal(rs.getDouble("PRECIOFINAL"));
				billete.setEstado(rs.getString("ESTADO"));
				billete.setBilleteVueltaId(rs.getInt("BILLETEVUELTAID"));
				
				if(billete.getBilleteVueltaId() != 0){
					billete.setTipo(Billete.VUELTA);
				}
				
				resultado.add(billete);
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
		return resultado;
	}
	
	
	private Connection conectarConBD(){
		Connection con = null;

		try {
			//String SQL_DRV = "org.hsqldb.jdbcDriver";
			//String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";
			
			String SQL_DRV = "org.mariadb.jdbc.Driver";
			String SQL_URL = "jdbc:mariadb://localhost/amazin";

			// Obtenemos la conexion a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "dflanvin", "amazin");
			return con;
		}catch(Exception e){
			return null;
		}
	}
	
	
	@Override
	public LinkedHashMap<Integer,String> getDestinosMasPopulares(int numeroResultados) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectarConBD();
		
		LinkedHashMap<Integer, String> resultado = new LinkedHashMap<Integer, String> ();


		try {	
			ps = con.prepareStatement("select count(*) as numero_viajes, sum(billete.PLAZAS_COMPRADAS) as numero_plazas, destino from billete left join viaje on billete.VIAJEID=viaje.viajeID or billete.BILLETEVUELTAID=viaje.viajeID where estado='Confirmado' group by destino order by numero_plazas desc limit ?");
			ps.setInt(1, numeroResultados);
			rs = ps.executeQuery();
			
			

			while (rs.next()) {
				// Completamos los datos del billete en la entidad
				resultado.put(rs.getInt("numero_plazas"), rs.getString("destino"));
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
		return resultado;
	}
	
	

}
