package muhammad;

import java.sql.*;
//Clase encargada de conectar con la base de datos y consultas en base de datos
public class ConectorBaseDatos {
	
	
    //Statement stmt = null;
    //ResultSet rs = null;
    private final String host = "127.0.0.1";
    private final String user = "root";
    private final String pass = "";
    private final String nombreDb = "tienda";

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


	public Connection setConection() {
  	  //Objeto de la clase Connection encargado de hacer la conexion
  	  Connection conn = null;

  	  //Acceso a Base de Datos
  	  try
        {
            String urlConexion = "jdbc:mysql://" + getHost() + "/" +
          		  					getNombreDb()+ "?" + "user=" + getUser() +
          		  					"&password=" + getPass();
            conn = (Connection) DriverManager.getConnection(urlConexion);
        }
        catch(SQLException ex)
        {
            System.out.println("Error al conectar a la  Base de Datos");
            ex.printStackTrace();
        }
  	  	return conn;
	}

	public String getConsulta() {
		
		
	String texto = "";
	  
	try {
		Statement c = (Statement) setConection().createStatement();
		String sqlDSelect = "SELECT * FROM categoria";
	  	  ResultSet resultSet = c.executeQuery(sqlDSelect);
	  	  while (resultSet.next()){
	  	      String id = resultSet.getString(resultSet.findColumn("id"));
	  	      String nombre = resultSet.getString(resultSet.findColumn("nombre"));
	  	      String descrip = resultSet.getString(resultSet.findColumn("descrip"));
	  	      
	  	      
	  	      texto += id + "\t" + nombre + "\t\t" + descrip + "\n";
	  	  }
	} catch (SQLException e) {
        System.out.println("Error al cargar la  Base de Datos");
		e.printStackTrace();
	}
      return texto;  	  
		
	}

}
