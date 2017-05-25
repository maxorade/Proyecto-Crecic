/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SFTP;


import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.IOException;

/**
 *
 * @author alumno.desarrollo1
 */
public class ConexionSFTP {
    
    private static final String USERNAME = "ricardo.melo";
    private static final String HOST = "baker";
    private static final int PORT = 22;
    private static final String PASSWORD = "passRMcrecic";
 
    public static void main(String[] args) {
 
        SFTPConnector sshConnector = new SFTPConnector();
        sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
        sshConnector.addFile("/sistemas/home/ricardo.melo/public_html/WEBSGM/huella", "C:/Users/alumno.desarrollo1/Documents/imagen.jpg",
                "imagen.jpg");
        sshConnector.disconnect();
    }
    
}
