/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author alumno.desarrollo1
 */
//conexion base de datos Huellas MySQL
import BD.Encriptador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionBD {

    /**
     * @param args the command line arguments
     */
    private static Connection cn = null;
    private static Statement st = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    private static String puerto = "6432";
    private static String nombreBD = "mulchen";
    private static String usuario = "super";
    private static String clave = "sgmcrecic04";
    private static String servidor = "192.168.215.69";

    public static String getServidor() {
        return servidor;
    }

    public static void setServidor(String servidor) throws Exception {
        ConexionBD.servidor = Encriptador.Desencriptar(servidor) ;
    }

    public static String getPuerto() {
        return puerto;
    }

    public static void setPuerto(String puerto) throws Exception {
        ConexionBD.puerto = Encriptador.Desencriptar(puerto);
    }

    public static String getNombreBD() {
        return nombreBD;
    }

    public static void setNombreBD(String nombreBD) throws Exception {
        ConexionBD.nombreBD = Encriptador.Desencriptar(nombreBD);
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) throws Exception {
        ConexionBD.usuario = Encriptador.Desencriptar(usuario);
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) throws Exception {
        ConexionBD.clave = Encriptador.Desencriptar(clave) ;
    }

    Connection conn = null;

    public Connection conectar() {
        try {
            //String ruta="jdbc:mysql://";
            String ruta = "jdbc:postgresql://";
            String servidor_datos = servidor + ":" + puerto + "/";
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(ruta + servidor_datos + nombreBD, usuario, clave);

            if (conn != null) {
                System.out.println("Conexión a base de datos listo...");
            } else if (conn == null) {

                throw new SQLException();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e.getMessage());
        } finally {
            return conn;
        }

    }

    public void desconectar() {
        conn = null;
        System.out.println("Desconexion a base de datos listo...");
    }

    public static boolean conectar_inicial() {
        try {
            Class.forName("org.postgresql.Driver");
            //String url = "jdbc:mysql://localhost:3306/tuto";
            String url = "jdbc:postgresql://" + servidor + ":"+puerto+"/" + nombreBD;
            cn = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            String msg = "";
            if (ex.getErrorCode() == 1049) {
                msg = "La base de datos: " + nombreBD + " no existe.";
            } else if (ex.getErrorCode() == 1044) {
                msg = "El usuario: " + usuario + " no existe.";
            } else if (ex.getErrorCode() == 1045) {
                msg = "Contraseña incorrecta.";
            } else if (ex.getErrorCode() == 0) {
                msg = "La conexión con la base de datos no se puede realizar.\nParece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (cn != null) {
            System.out.println("Coneccion Exitosa.... XD");
            return true;
        }
        return false;

    }

}
