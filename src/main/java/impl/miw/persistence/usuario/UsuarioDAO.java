package impl.miw.persistence.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.Book;
import com.miw.model.ParamBusquedaViaje;
import com.miw.model.Usuario;
import com.miw.model.Viaje;
import com.miw.persistence.BookDataService;
import com.miw.persistence.UsuarioDataService;


public class UsuarioDAO implements UsuarioDataService {
	
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
	
	
		public Usuario getUsuario(Usuario usuario) throws Exception {
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection con = conectarConBD();

			try {
				
				ps = con.prepareStatement("select * from usuario where mail = (?)");
				ps.setString(1, usuario.getMail());
				rs = ps.executeQuery();
				
				
				if (!rs.next() ) {
				    usuario = null;
				} 
				
				else{

					while (rs.next()) {
						// Completamos los datos del usuario
						usuario.setUsuarioId(rs.getInt("usuarioid"));
						usuario.setNombre(rs.getString("nombre"));
						usuario.setApellidos(rs.getString("apellidos"));
						usuario.setDni(rs.getString("dni"));
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
			return usuario;
	}

	public synchronized Usuario crearUsuario(Usuario usuario) throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// Obtenemos la conexiï¿½n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "dflanvin", "amazin");
			
			/*
			 * CREATE MEMORY TABLE USUARIO(
	USUARIOID INTEGER IDENTITY NOT NULL PRIMARY KEY,
	NOMBRE VARCHAR(50),
	APELLIDOS VARCHAR(100),
	DNI VARCHAR(20),
	MAIL VARCHAR(50),
	constraint USUARIO_UN unique (USUARIOID)
	)	*/
			
			
			ps = con.prepareStatement("select max(usuarioid) as maximo from usuario");
			rs = ps.executeQuery();
			Integer id=0;
			while (rs.next()) {
				 id = rs.getInt("maximo");
			}
			
			System.out.println("Máximo id encontrado: "+id);
			
			usuario.setUsuarioId(id);
			//Creamos el usuario
			ps = con.prepareStatement("insert into usuario values (?,?,?,?,?)");
			ps.setInt(1, id+1);
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellidos());
			ps.setString(4, usuario.getDni());
			ps.setString(5, usuario.getMail());
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
		return usuario;
	}

}