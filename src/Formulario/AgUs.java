package Formulario;
import java.sql.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import myp.beta.Conexion;

public class AgUs extends javax.swing.JFrame {
    int resp;
    public AgUs() {
        initComponents();
        setTitle("Agregar Usuario");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_ni = new javax.swing.JTextField();
        Nickname1 = new javax.swing.JLabel();
        bo_ag = new javax.swing.JButton();
        Contraseña = new javax.swing.JLabel();
        txt_co = new javax.swing.JTextField();
        Nickname = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        Apma = new javax.swing.JLabel();
        txt_apma = new javax.swing.JTextField();
        Appa = new javax.swing.JLabel();
        txt_appa = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        txt_na = new javax.swing.JTextField();
        bo_regresar = new javax.swing.JButton();
        cuadros = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ni.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_ni.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 230, -1));

        Nickname1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Nickname1.setForeground(new java.awt.Color(0, 0, 0));
        Nickname1.setText("Nickname:");
        jPanel1.add(Nickname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Ingresar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, -1, -1));

        Contraseña.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(0, 0, 0));
        Contraseña.setText("Contraseña:");
        jPanel1.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));

        txt_co.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_co.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_co, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 230, -1));

        Nickname.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Nickname.setForeground(new java.awt.Color(0, 0, 0));
        Nickname.setText("Telefono:");
        jPanel1.add(Nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        txt_tel.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_tel.setForeground(new java.awt.Color(0, 0, 0));
        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });
        jPanel1.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 230, -1));

        Apma.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Apma.setForeground(new java.awt.Color(0, 0, 0));
        Apma.setText("Apellido Materno:");
        jPanel1.add(Apma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        txt_apma.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_apma.setForeground(new java.awt.Color(0, 0, 0));
        txt_apma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apmaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_apma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 230, -1));

        Appa.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Appa.setForeground(new java.awt.Color(0, 0, 0));
        Appa.setText("Apellido Paterno:");
        jPanel1.add(Appa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txt_appa.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_appa.setForeground(new java.awt.Color(0, 0, 0));
        txt_appa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_appaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_appa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 230, -1));

        Nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Nombre.setForeground(new java.awt.Color(0, 0, 0));
        Nombre.setText("Nombre:");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        txt_na.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        txt_na.setForeground(new java.awt.Color(0, 0, 0));
        txt_na.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_naKeyTyped(evt);
            }
        });
        jPanel1.add(txt_na, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 230, -1));

        bo_regresar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_regresar.setForeground(new java.awt.Color(0, 0, 0));
        bo_regresar.setText("Regresar");
        bo_regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cuadros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cuadros.png"))); // NOI18N
        jPanel1.add(cuadros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 996, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bo_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agActionPerformed
        String nom = txt_na.getText().trim();
        String appa = txt_appa.getText().trim();
        String apma = txt_apma.getText().trim();
        String tel = txt_tel.getText().trim();
        String con = txt_co.getText().trim();
        String nic = txt_ni.getText().trim();
        try{
            if(!nom.equals("") && !appa.equals("") && !apma.equals("") && !tel.equals("") && !con.equals("") && !nic.equals("")){
                resp = JOptionPane.showConfirmDialog(null,"¿Quieres Agregar Otro Usuario?","Usuario",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
                    pst.setString(1, "0");
                    pst.setString(2, nom);
                    pst.setString(3, appa);
                    pst.setString(4, apma);
                    pst.setString(5, tel);
                    pst.setString(6, nic);
                    pst.setString(7, con);
                    pst.executeUpdate();
                    
                    txt_na.setText("");
                    txt_appa.setText("");
                    txt_apma.setText("");
                    txt_tel.setText("");
                    txt_co.setText("");
                    txt_ni.setText("");
                }
                else if(resp==1){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into usuario values(?,?,?,?,?,?,?)");
                    pst.setString(1, "0");
                    pst.setString(2, nom);
                    pst.setString(3, appa);
                    pst.setString(4, apma);
                    pst.setString(5, tel);
                    pst.setString(6, nic);
                    pst.setString(7, con);
                    pst.executeUpdate();
                    
                    txt_na.setText("");
                    txt_appa.setText("");
                    txt_apma.setText("");
                    txt_tel.setText("");
                    txt_co.setText("");
                    txt_ni.setText("");
                    ElUs ma = new ElUs();
                    ma.setVisible(true);
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }catch (Exception e){      
        }
    }//GEN-LAST:event_bo_agActionPerformed

    private void bo_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_regresarActionPerformed
        MAg ma = new MAg();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_regresarActionPerformed

    private void txt_naKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_naKeyTyped
        char c = evt.getKeyChar(); //se crea un caracter c         
        if((c<'a' || c>'z')&&(c<'A'|c>'Z') 
           && (c !='á') && (c !='é') && (c !='í') && (c !='ó') && (c !='ú') && (c !='ñ')&& (c !='Ñ')
           && (c != (char) KeyEvent.VK_SPACE))evt.consume();
    }//GEN-LAST:event_txt_naKeyTyped

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
        char c = evt.getKeyChar();        
        if((c<'0' || c>'9') && (c!='.'))evt.consume();
    }//GEN-LAST:event_txt_telKeyTyped

    private void txt_appaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_appaKeyTyped
        char c = evt.getKeyChar(); //se crea un caracter c         
        if((c<'a' || c>'z')&&(c<'A'|c>'Z') 
           && (c !='á') && (c !='é') && (c !='í') && (c !='ó') && (c !='ú') && (c !='ñ')&& (c !='Ñ')
           && (c != (char) KeyEvent.VK_SPACE))evt.consume();
    }//GEN-LAST:event_txt_appaKeyTyped

    private void txt_apmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apmaKeyTyped
        char c = evt.getKeyChar(); //se crea un caracter c         
        if((c<'a' || c>'z')&&(c<'A'|c>'Z') 
           && (c !='á') && (c !='é') && (c !='í') && (c !='ó') && (c !='ú') && (c !='ñ')&& (c !='Ñ')
           && (c != (char) KeyEvent.VK_SPACE))evt.consume();
    }//GEN-LAST:event_txt_apmaKeyTyped

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
            java.util.logging.Logger.getLogger(AgUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgUs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apma;
    private javax.swing.JLabel Appa;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Nickname;
    private javax.swing.JLabel Nickname1;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton bo_ag;
    private javax.swing.JButton bo_regresar;
    private javax.swing.JLabel cuadros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_apma;
    private javax.swing.JTextField txt_appa;
    private javax.swing.JTextField txt_co;
    private javax.swing.JTextField txt_na;
    private javax.swing.JTextField txt_ni;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
