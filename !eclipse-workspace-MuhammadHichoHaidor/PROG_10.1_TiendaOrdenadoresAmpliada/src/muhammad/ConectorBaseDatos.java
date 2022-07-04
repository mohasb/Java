package muhammad;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//Clase encargada de la conexion a la base de datos y los DML

public class ConectorBaseDatos {
	// Variables
	private final String host = "127.0.0.1";
	private final String user = "root";
	private final String pass = "";
	private final String nombreDb = "tienda";
	private ResultSet resultSet;

	// Guetters
	public String getHost() {
		return host;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public String getNombreDb() {
		return nombreDb;

	}

	// Método encargado de la conexion a la BBDD
	Connection setConection() {
		// Objeto de la clase Connection encargado de hacer la conexion
		Connection conn = null;

		// Acceso a Base de Datos
		try {
			String urlConexion = "jdbc:mysql://" + getHost() + "/" + getNombreDb() + "?" + "user=" + getUser()
					+ "&password=" + getPass();
			// Conectar a BBDD especificada en URL
			conn = (Connection) DriverManager.getConnection(urlConexion);
		} catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, "Error al cargar a la Base de Datos");
			ex.printStackTrace();
			return null;

		}
		return conn;
	}

	// obtiene todo sobre las categorias y retorna una cadena que se muestra en el
	// txAreaResultado
	String ObetenerCategorias() {

		String texto = "";

		try {
			Statement statement = (Statement) setConection().createStatement();
			String sqlDSelect = "SELECT * FROM categoria";
			ResultSet resultSet = statement.executeQuery(sqlDSelect);
			while (resultSet.next()) {
				String id = resultSet.getString(resultSet.findColumn("id"));
				String nombre = resultSet.getString(resultSet.findColumn("nombre"));
				String descrip = resultSet.getString(resultSet.findColumn("descrip"));

				texto += id + "\t" + nombre + "\t" + descrip + "\n";

			}
			statement.close();
			setConection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return texto;

	}

	// obtiene los numeros de serie de los monitores de la BBDD y los retorna para
	// mostrar en cBoxNSerie
	ArrayList<String> ObtenerNSerieMonitor() {

		ArrayList<String> listaNumSerie = new ArrayList<>();

		try {
			Statement statement = (Statement) setConection().createStatement();
			String sqlDSelect = "SELECT numSerie FROM monitor";
			ResultSet resultSet = statement.executeQuery(sqlDSelect);
			while (resultSet.next()) {
				String numSerie = resultSet.getString(resultSet.findColumn("numSerie"));

				listaNumSerie.add(numSerie);

			}
			statement.close();
			setConection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaNumSerie;

	}

	// obtiene todos los datos del monitor seleccionado en cBoxNSerie y rellena los
	// texbox con sus datos
	Monitor obtenerMonitor(String numSerie) {

		String id = "";
		String categoria = "";
		String tipo = "";
		String pulgadas = "";
		String precio = "";

		try {
			Statement statement = (Statement) setConection().createStatement();
			String sqlDSelect = "SELECT * FROM monitor WHERE numSerie = '" + numSerie + "'";
			resultSet = statement.executeQuery(sqlDSelect);

			while (resultSet.next()) {

				id = resultSet.getString(resultSet.findColumn("id"));
				tipo = resultSet.getString(resultSet.findColumn("tipo"));
				pulgadas = resultSet.getString(resultSet.findColumn("pulgadas"));
				precio = resultSet.getString(resultSet.findColumn("precio"));

			}

			String sqlDSelectCategoria = "SELECT monitor.ID FROM categoria, monitor WHERE categoria.ID = monitor.ID AND numSerie = '"
					+ numSerie + "'";

			resultSet = statement.executeQuery(sqlDSelectCategoria);

			while (resultSet.next()) {
				// Clave ajena
				categoria = resultSet.getString(resultSet.findColumn("id"));
			}
			statement.close();
			setConection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Monitor(id, categoria, numSerie, tipo, Integer.parseInt(pulgadas), Double.parseDouble(precio));
	}

	// Modifica un monitor seleccionado
	boolean modificaMonitor(String id, String categoria, String numSerie, String tipo, int pulgadas, double precio) {

		try {

			Statement statement = (Statement) setConection().createStatement();

			String sqlUpdateMonitor = "UPDATE monitor SET categoria='" + categoria + "', numSerie ='" + numSerie
					+ "', tipo = '" + tipo + "', pulgadas =" + pulgadas + ", precio = " + precio + "WHERE id = '" + id
					+ "'";

			statement.executeUpdate(sqlUpdateMonitor);
			statement.close();
			setConection().close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}

	}

}
