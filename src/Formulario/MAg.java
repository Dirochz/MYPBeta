package Formulario;

public class MAg extends javax.swing.JFrame {

    public MAg() {
        initComponents();
        setTitle("Menu Agregar");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Producto = new javax.swing.JLabel();
        bo_cerrar = new javax.swing.JButton();
        bo_Producto = new javax.swing.JButton();
        bo_usuario = new javax.swing.JButton();
        Agregar = new javax.swing.JLabel();
        triangulo = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Producto.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Producto.setForeground(new java.awt.Color(0, 0, 0));
        Producto.setText("Producto");
        jPanel1.add(Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, -1, -1));

        bo_cerrar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_cerrar.setForeground(new java.awt.Color(0, 0, 0));
        bo_cerrar.setText("Regresar");
        bo_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_cerrarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bo_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Producto.png"))); // NOI18N
        bo_Producto.setBorderPainted(false);
        bo_Producto.setContentAreaFilled(false);
        bo_Producto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_Producto.setFocusPainted(false);
        bo_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ProductoActionPerformed(evt);
            }
        });
        jPanel1.add(bo_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 157, 157));

        bo_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Usuario.png"))); // NOI18N
        bo_usuario.setBorderPainted(false);
        bo_usuario.setContentAreaFilled(false);
        bo_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_usuario.setFocusPainted(false);
        bo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_usuarioActionPerformed(evt);
            }
        });
        jPanel1.add(bo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 157, 157));

        Agregar.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Agregar.setForeground(new java.awt.Color(0, 0, 0));
        Agregar.setText("Usuario");
        jPanel1.add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        triangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Magregar2.png"))); // NOI18N
        jPanel1.add(triangulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 520));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MAgregar1.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bo_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_cerrarActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_cerrarActionPerformed

    private void bo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_usuarioActionPerformed
        AgUs ag = new AgUs();
        ag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_usuarioActionPerformed

    private void bo_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ProductoActionPerformed
        Agpr ag = new Agpr();
        ag.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_ProductoActionPerformed

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
            java.util.logging.Logger.getLogger(MAg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agregar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Producto;
    private javax.swing.JButton bo_Producto;
    private javax.swing.JButton bo_cerrar;
    private javax.swing.JButton bo_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel triangulo;
    // End of variables declaration//GEN-END:variables
}
