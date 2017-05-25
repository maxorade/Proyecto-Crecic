/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import BD.Encriptador;
import BD.ConexionBD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Crecic_Estudiante
 */
public class Ingreso extends javax.swing.JDialog {

    /**
     * Creates new form Ingreso
     */
    
     String usuario = System.getProperty("user.name");
                String ruta = "C:/Users/" + usuario + "/";
   
    
    private final String config = ruta + "/data.dat";

    public Ingreso(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/logoCrecic.jpg")).getImage());
        setTitle("Crecic S.A");
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        verificarConfiguracion();

    }

    private void verificarConfiguracion() throws Exception {
        File fconfig = exitsFileConfig(config);
        if (fconfig != null) {
            ArrayList rfc = readFileConfig(fconfig);

            if (rfc.size() > 0) {
                // this.txtBd.setText(rfc.get(0).toString());
                // this.txtUser.setText(rfc.get(1).toString());
                ConexionBD.setNombreBD(rfc.get(0).toString());
                ConexionBD.setUsuario(rfc.get(1).toString());

                if (rfc.size() > 2) {
                    ConexionBD.setClave(rfc.get(2).toString());
                    ConexionBD.setPuerto(rfc.get(3).toString());
                    ConexionBD.setServidor(rfc.get(4).toString());

                } else {
                    //   this.pfPass.setText("");
                }
                if (ConexionBD.conectar_inicial()) {
                    // int op = JOptionPane.showConfirmDialog(this, "El Sistema ha encontrado un archivo de configuracion."
                    //         + " y los datos son validos.\nRuta del Archivo:"
                    //         + fconfig.getAbsolutePath() + "\n"
//                            + "¿Desea continuar? ", "¿Desea Continuar?", JOptionPane.YES_NO_OPTION);
//                    if (op == JOptionPane.OK_OPTION) {
                    iniciaClientes();
//                    } else {
//                        this.setVisible(true);
//                    }
                } else {
                    this.setVisible(true);
                }
            }

        } else {
            this.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAviso = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtServidor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pfPass = new javax.swing.JPasswordField();
        bntIngresar = new javax.swing.JButton();
        bntcancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(214, 226, 249));

        lbAviso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAviso.setText("Ingrese Datos de Coneccion:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Puerto:");

        txtPuerto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPuerto.setPreferredSize(new java.awt.Dimension(180, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Servidor:");

        txtServidor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtServidor.setPreferredSize(new java.awt.Dimension(180, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre BD:");

        txtBd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBd.setPreferredSize(new java.awt.Dimension(180, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Usuario:");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser.setPreferredSize(new java.awt.Dimension(180, 23));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        pfPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pfPass.setPreferredSize(new java.awt.Dimension(180, 20));

        bntIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso_blanco.PNG"))); // NOI18N
        bntIngresar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bntIngresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ingreso_azul.PNG"))); // NOI18N
        bntIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntIngresarActionPerformed(evt);
            }
        });

        bntcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar_blanco.PNG"))); // NOI18N
        bntcancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bntcancelar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar_azul.PNG"))); // NOI18N
        bntcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbAviso)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtServidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPuerto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntcancelar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(bntIngresar))
                        .addGap(207, 207, 207)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbAviso)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntIngresar)
                    .addComponent(bntcancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntIngresarActionPerformed
        if (this.txtBd.getText().isEmpty() || this.txtUser.getText().isEmpty()) {
            int op = JOptionPane.showConfirmDialog(this, "Laa conexión se realizara con los datos por defecto.\n"
                    + "¿Desea continuar?", "¿Desea Continuar?", JOptionPane.YES_NO_CANCEL_OPTION);
            if (op == JOptionPane.OK_OPTION) {
                if (ConexionBD.conectar_inicial()) {
                    String nombreBD = Encriptador.Encriptar(this.txtBd.getText());
                    String usuario = Encriptador.Encriptar(this.txtUser.getText());
                    String clave = Encriptador.Encriptar(String.valueOf(this.pfPass.getPassword()));
                    String puerto = Encriptador.Encriptar(this.txtPuerto.getText());
                    String servidor = Encriptador.Encriptar(this.txtServidor.getText());
                    
                    writeFile(config, nombreBD + "\n" + usuario + "\n" + clave
                            + "\n" + puerto + "\n" + servidor
                    );
                    iniciaClientes();
                }

            } else {
                this.txtBd.requestFocus();
            }
        } else {
            try {
                String nombreBD = Encriptador.Encriptar(this.txtBd.getText());
                String usuario = Encriptador.Encriptar(this.txtUser.getText());
                String clave = Encriptador.Encriptar(String.valueOf(this.pfPass.getPassword()));
                String puerto = Encriptador.Encriptar(this.txtPuerto.getText());
                String servidor = Encriptador.Encriptar(this.txtServidor.getText());
                ConexionBD.setNombreBD(nombreBD);
                ConexionBD.setUsuario(usuario);
                ConexionBD.setPuerto(puerto);
                ConexionBD.setServidor(servidor);

                if (this.pfPass.getPassword().length > 0) {
                    ConexionBD.setClave(clave);
                } else {
                    ConexionBD.setClave("");
                }
                
                if (ConexionBD.conectar_inicial()) {
                    writeFile(config, nombreBD + "\n" + usuario + "\n" + clave
                            + "\n" + puerto + "\n" + servidor
                    );
                    iniciaClientes();
                }
            } catch (Exception ex) {
                Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bntIngresarActionPerformed


    private void bntcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bntcancelarActionPerformed

    private void iniciaClientes() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturaHuella().setVisible(true);
            }
        });
        this.dispose();
    }

    public void writeFile(String canonicalFilename, String data) {
        try {
            File file = new File(canonicalFilename);
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println(file.getAbsolutePath());
                    BufferedWriter out = new BufferedWriter(new FileWriter(file));
                    out.write(data);
                    JOptionPane.showMessageDialog(this, "Los datos son correctos.\nConfiguracion guardada en: " + file.getAbsolutePath());
                    out.close();
                }

            } else {
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                out.write(data);
                out.close();
                JOptionPane.showMessageDialog(this, "Existia una configuracion previa en: " + file.getAbsolutePath() + " pero se reescribio");
                System.out.println("el archuivo ya existe en: " + file.getAbsolutePath());
            }

        } catch (IOException io) {
        }
    }

    private File exitsFileConfig(String nomefile) {
        File file = new File(nomefile);
        if (file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    private ArrayList readFileConfig(File file) {
        // String data = null;
        ArrayList datos = new ArrayList();
        try {

            File fstream = file;
            BufferedReader br = new BufferedReader(new FileReader(fstream));
            String strLine;
            //Leyendo archivo linea por linea
            while ((strLine = br.readLine()) != null) {
                //data = strLine;
                datos.add(strLine);
            }
            //cerrando el flujo de entrada
            br.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        //System.out.println(data);
        return datos;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ingreso dialog = new Ingreso(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntIngresar;
    private javax.swing.JButton bntcancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbAviso;
    private javax.swing.JPasswordField pfPass;
    private javax.swing.JTextField txtBd;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtServidor;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
