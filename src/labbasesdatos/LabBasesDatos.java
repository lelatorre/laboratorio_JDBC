package labbasesdatos;

//Librerías para SQL en java.
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LabBasesDatos {

    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/prueba";
        String User = "root";
        String Password = "";

        try {
            //Se inicializa y se registra el driver de MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecemos la conexión con la base de datos.
            Connection conexion = DriverManager.getConnection(URL, User, Password); //Cadena de conexión
            //Preparamos la consulta
            Statement statement = conexion.createStatement();
            //Insertamos valores para la tabla persona de la base de datos prueba.
            statement.executeUpdate("INSERT INTO persona VALUES (null,'Martin Porras Rojas','1996-01-20') ");
            //Consulta a la base de datos
            ResultSet set = statement.executeQuery("SELECT * FROM persona");
            set.next();
            // Recorremos el resultado, mientras haya registros para leer, y mostramos el resultado en pantalla.
            do {
                System.out.println("-ID: " + set.getInt("ID") + " -Nombre: " + set.getString("Nombre") + " -Fecha de nacimiento: " + set.getDate("Nacimiento"));
            } while (set.next());
            //Método para cerrar la conexión a la base de datos.
            conexion.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LabBasesDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
