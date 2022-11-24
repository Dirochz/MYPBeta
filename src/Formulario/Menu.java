package Formulario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import myp.beta.Conexion;

public final class Menu extends javax.swing.JFrame {
    int resp=1, Bus=0,respc=0;
    String nom,user,Nombre,Appa,Apma;
    public Menu() {
        initComponents();
        setTitle("Menu");
        this.setLocationRelativeTo(null);
        user = Login.nick;
        nombre();
        checar();
    }
    
    void nombre(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("Select Nom, ApPa, ApMa "
                    + "from usuario where Nickname ='"+user+ "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ 
                Nombre = rs.getString("Nom"); 
                Appa = rs.getString("ApPa"); 
                Apma = rs.getString("ApMa"); 
                usuario.setText("Bienvenid@ "+Nombre+" "+Appa+" "+Apma);
            }
        }catch (SQLException e){           
        }
    }
    
    void checar(){
        try{       
            Connection cn = Conexion.conectar();
            String query;
            query = "select Nom from producto Where Can='"+Bus+"'";
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){         
                nom = rs.getString("Nom");
                resp = JOptionPane.showConfirmDialog(null,"El Producto: "+nom+"\nYa no hay en el Inventario\n ¿Quieres borrarlo?","Aviso del Producto",YES_NO_OPTION,INFORMATION_MESSAGE,null);
            }             
        }catch(SQLException e){            
            System.out.println("Error en verificar el producto: " + e);
        }
        try{
            if(resp==0){
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("delete from producto where Nom='"+nom+"'");             
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente");
            }
        }catch(SQLException e){  
            System.out.println("Error al intentar eleiminar un productos desde el aviso");
            System.out.println(""+e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usuario = new javax.swing.JLabel();
        bo_ticket = new javax.swing.JButton();
        Ticket = new javax.swing.JLabel();
        bo_reporte = new javax.swing.JButton();
        Reporte = new javax.swing.JLabel();
        bo_eliminar = new javax.swing.JButton();
        Eliminar = new javax.swing.JLabel();
        bo_agregar = new javax.swing.JButton();
        Agregar = new javax.swing.JLabel();
        bo_cerrar = new javax.swing.JButton();
        curva = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 40));

        bo_ticket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ticket.png"))); // NOI18N
        bo_ticket.setBorderPainted(false);
        bo_ticket.setContentAreaFilled(false);
        bo_ticket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ticket.setFocusPainted(false);
        bo_ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ticketActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 157, 157));

        Ticket.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Ticket.setForeground(new java.awt.Color(0, 0, 0));
        Ticket.setText("Ticket");
        jPanel1.add(Ticket, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, -1, -1));

        bo_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Reportes.png"))); // NOI18N
        bo_reporte.setBorderPainted(false);
        bo_reporte.setContentAreaFilled(false);
        bo_reporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_reporte.setFocusPainted(false);
        bo_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_reporteActionPerformed(evt);
            }
        });
        jPanel1.add(bo_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 157, 157));

        Reporte.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Reporte.setForeground(new java.awt.Color(0, 0, 0));
        Reporte.setText("Reporte");
        jPanel1.add(Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, -1));

        bo_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Eliminar.png"))); // NOI18N
        bo_eliminar.setBorderPainted(false);
        bo_eliminar.setContentAreaFilled(false);
        bo_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_eliminar.setFocusPainted(false);
        bo_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 157, 157));

        Eliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(0, 0, 0));
        Eliminar.setText("Eliminar");
        jPanel1.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        bo_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Agregar.png"))); // NOI18N
        bo_agregar.setBorderPainted(false);
        bo_agregar.setContentAreaFilled(false);
        bo_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_agregar.setFocusPainted(false);
        bo_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 157, 157));

        Agregar.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Agregar.setForeground(new java.awt.Color(0, 0, 0));
        Agregar.setText("Agregar");
        jPanel1.add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        bo_cerrar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_cerrar.setForeground(new java.awt.Color(0, 0, 0));
        bo_cerrar.setText("Cerrar Sesión");
        bo_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_cerrarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        curva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu2.png"))); // NOI18N
        jPanel1.add(curva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 996, 125));

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

    private void bo_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_eliminarActionPerformed
        MEl ma = new MEl();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_eliminarActionPerformed

    private void bo_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_cerrarActionPerformed
        respc = JOptionPane.showConfirmDialog(null,"¿Seguro que quieres Cerrar Sesión?","Salir",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,null);
        if(respc==0){
            Login l = new Login();
            l.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_bo_cerrarActionPerformed

    private void bo_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agregarActionPerformed
        MAg ma = new MAg();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_agregarActionPerformed

    private void bo_ticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ticketActionPerformed
        Ticket ma = new Ticket();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_ticketActionPerformed

    private void bo_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_reporteActionPerformed
        Reportes ma = new Reportes();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_reporteActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        }); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agregar;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Reporte;
    private javax.swing.JLabel Ticket;
    private javax.swing.JButton bo_agregar;
    private javax.swing.JButton bo_cerrar;
    private javax.swing.JButton bo_eliminar;
    private javax.swing.JButton bo_reporte;
    private javax.swing.JButton bo_ticket;
    private javax.swing.JLabel curva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
