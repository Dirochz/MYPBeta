package Formulario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import myp.beta.Conexion;

public final class ElUs extends javax.swing.JFrame {
    int fila=0,id, resp,i;
    DefaultTableModel modelo; 
    public ElUs() {
        initComponents();
        setTitle("Eliminar Usuario");
        this.setLocationRelativeTo(null);     
        setIconImage(getIconImage());
        table();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/logo.png"));
        return retValue;
    }
    
    void table(){
        modelo = (DefaultTableModel)u.getModel();
        u.setModel(modelo);
        Object[] usu = new Object[7];
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select ID,Nom,ApPa,ApMa,Tel,Nickname,Cont from usuario");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                usu[0] = rs.getInt("ID");
                usu[1] = rs.getString("Nom");
                usu[2] = rs.getString("ApPa");
                usu[3] = rs.getString("ApMa");
                usu[4] = rs.getString("Tel");
                usu[5] = rs.getString("Nickname");
                usu[6] = rs.getString("Cont");
                modelo.addRow(usu);
            }
            u.setModel(modelo);
        }catch(SQLException e){
        }
    }
    
    void Mod(){
        fila = u.getSelectedRow();
        id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
        String nom = u.getValueAt(fila, 1).toString();
        String appa = u.getValueAt(fila, 2).toString();
        String apma = u.getValueAt(fila, 3).toString();
        String tel = u.getValueAt(fila, 4).toString();
        String nic = u.getValueAt(fila, 5).toString();
        String con = u.getValueAt(fila, 6).toString();
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE usuario SET Nom='"+nom+"', ApPa='"+appa+"', ApMa='"+apma+"', Tel='"+tel+
                    "', Nickname='"+nic+"', Cont='"+con+"' Where ID = '"+id+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha Modificado Exitosamente");
        }catch(SQLException e){
            System.out.println("Aqui en tabla de Modificar Usuario = "+id+" Fila: "+fila);
            System.out.println(""+e);
        }
    }
    
    void Elus(){
        fila = u.getSelectedRow();
        id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
        if(fila>-1){
               
            try{
                resp = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere eliminar este usuario? "+id+"","Eliminar Usuario",YES_NO_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from usuario where ID='"+id+"'");             
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se ha Eliminado Exitosamente");
                }
            }catch(SQLException e){  
                System.out.println("Aqui en tabla al intentar eliminar Usuario = "+id+" Fila: "+fila);
                System.out.println(""+e);
            }  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bo_ag = new javax.swing.JButton();
        bo_El = new javax.swing.JButton();
        bo_regresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        u = new javax.swing.JTable();
        usuario = new javax.swing.JLabel();
        ce_el = new javax.swing.JCheckBox();
        ce_mod = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        cuadros = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Agregar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, -1, -1));

        bo_El.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_El.setForeground(new java.awt.Color(0, 0, 0));
        bo_El.setText("Eliminar");
        bo_El.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_El.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ElActionPerformed(evt);
            }
        });
        jPanel1.add(bo_El, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, -1, -1));

        bo_regresar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_regresar.setForeground(new java.awt.Color(0, 0, 0));
        bo_regresar.setText("Regresar");
        bo_regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        u.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        u.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Nickname", "Contraseña"
            }
        ));
        u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        u.setName(""); // NOI18N
        u.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(u);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 790, -1));

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Usuario.png"))); // NOI18N
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, -1, -1));

        ce_el.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ce_el.setForeground(new java.awt.Color(0, 0, 0));
        ce_el.setText("Modo Eliminar");
        ce_el.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ce_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ce_elActionPerformed(evt);
            }
        });
        jPanel1.add(ce_el, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        ce_mod.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ce_mod.setForeground(new java.awt.Color(0, 0, 0));
        ce_mod.setText("Modo Editar");
        ce_mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ce_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ce_modActionPerformed(evt);
            }
        });
        jPanel1.add(ce_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        cuadros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/elus.png"))); // NOI18N
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

    private void bo_ElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ElActionPerformed
        fila = u.getSelectedRow();
        if(fila>-1){
            id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
            try{
                resp = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere eliminar este usuario? "+id+"","Eliminar Usuario",YES_NO_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from usuario where ID='"+id+"'");             
                    pst.executeUpdate();
                    modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente");
                }
            }catch(SQLException e){  
                System.out.println("Aqui en tabla al intentar Eliminar Usuario = "+id+" Fila: "+fila);
                System.out.println(""+e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione un Usuario");
            System.out.println("La Fila es: "+fila);
            System.out.println("Id = "+id);
        }
    }//GEN-LAST:event_bo_ElActionPerformed

    private void bo_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_regresarActionPerformed
        MEl ma = new MEl();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_regresarActionPerformed

    private void uKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(i==1){
                Mod();
            }
            else if(i==3){
                Elus();
            }
        }
    }//GEN-LAST:event_uKeyReleased

    private void ce_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ce_modActionPerformed
        if(ce_el.isSelected()){
            JOptionPane.showMessageDialog(null,"Solo debe estar un modo Activado");
            ce_mod.setSelected(false);
        }
        else{
            i=1;
            System.out.println("La i es: "+i);
        }
    }//GEN-LAST:event_ce_modActionPerformed

    private void ce_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ce_elActionPerformed
        if(ce_mod.isSelected()){
            JOptionPane.showMessageDialog(null,"Solo debe estar un modo Activado");
            ce_el.setSelected(false);
        }
        else{
            i=3;
            System.out.println("La i es: "+i);
        }
    }//GEN-LAST:event_ce_elActionPerformed

    private void bo_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agActionPerformed
        AgUs ma = new AgUs();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_agActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Usuario.pdf"));
            
            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Merceria y Papeleria BETA");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Usuarios \n\n");
            Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(linea);
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);
            
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido Paterno");
            tabla.addCell("Apellido Materno");
            tabla.addCell("Telefono");
            tabla.addCell("Nickname");
            tabla.addCell("Contraseña");
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from usuario");    
                ResultSet rs = pst.executeQuery();
                if(rs.next()){                               
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                    documento.add(tabla);                    
                }          
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de Usuario se ha Creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(ElUs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ElUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElUs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton bo_El;
    private javax.swing.JButton bo_ag;
    private javax.swing.JButton bo_regresar;
    private javax.swing.JCheckBox ce_el;
    private javax.swing.JCheckBox ce_mod;
    private javax.swing.JLabel cuadros;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable u;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
