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
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import myp.beta.Conexion;

public final class ElPr extends javax.swing.JFrame {
    int fila=0,id, resp,i,ca,id_ar;
    double pr;
    ImageIcon foto;
    InputStream is;
    DefaultTableModel modelo; 
    public ElPr() {
        initComponents();
        setTitle("Eliminar Producto");
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        table();
        dbox();
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/logo.png"));
        return retValue;
    }
    
    void dbox(){
        try {
            ArrayList<String> nombres = new ArrayList<>();         
            Connection cn = Conexion.conectar(); 
            PreparedStatement pst;
            pst = cn.prepareStatement("select Nom from producto"); 
            nombres.add("Seleccionar");
            nombres.add("Todos");          
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombres.add(rs.getString("Nom"));
            }
            String[] usuarios = nombres.toArray(new String[0]);
            co_bu.setModel(new javax.swing.DefaultComboBoxModel<>(usuarios));
        }catch (SQLException e){    
            System.out.println("Error en conexión local en colocar el combo box: " + e);
        }
    }
    
    void table(){
        modelo = (DefaultTableModel)u.getModel();
        u.setModel(modelo);
        Object[] usu = new Object[5];
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("select ID,Nom,Can,Pre,Des from producto");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                usu[0] = rs.getInt("ID");
                usu[1] = rs.getString("Nom");
                usu[2] = rs.getInt("Can");
                usu[3] = rs.getDouble("Pre");
                usu[4] = rs.getString("Des");
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
        ca = Integer.parseInt(this.u.getValueAt(fila,2).toString());
        pr = (double) this.u.getValueAt(fila,3);
        String des = u.getValueAt(fila, 4).toString();
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE producto SET Nom='"+nom+"', Can='"+ca+"', Pre='"+pr+"', Des='"+des+
                    "' Where ID = '"+id+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha Modificado Exitosamente");
        }catch(SQLException e){
            System.out.println("Aqui en tabla de Modificar Prodcuto = "+id+" Fila: "+fila);
            System.out.println(""+e);
        }
    }
    
    void Elus(){
        fila = u.getSelectedRow();
        id = Integer.parseInt(this.u.getValueAt(fila, 0).toString());
        if(fila>-1){               
            try{
                resp = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere eliminar este Producto? "+id+"","Eliminar Producto",YES_NO_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from producto where ID='"+id+"'");             
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se ha Eliminado Exitosamente");
                }
            }catch(SQLException e){  
                System.out.println("Aqui en tabla al intentar eliminar Producto = "+id+" Fila: "+fila);
                System.out.println(""+e);
            }  
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_img = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        bo_bu = new javax.swing.JButton();
        bo_ag = new javax.swing.JButton();
        bo_El = new javax.swing.JButton();
        bo_regresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        u = new javax.swing.JTable();
        ce_el = new javax.swing.JCheckBox();
        ce_mod = new javax.swing.JCheckBox();
        txt_bu = new javax.swing.JTextField();
        co_bu = new javax.swing.JComboBox<>();
        pdf = new javax.swing.JButton();
        cuadros = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lb_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 230, 230));

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inventario.png"))); // NOI18N
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        bo_bu.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_bu.setText("Buscar");
        bo_bu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_bu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_buActionPerformed(evt);
            }
        });
        jPanel1.add(bo_bu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 120, 30));

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Agregar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, -1, -1));

        bo_El.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_El.setForeground(new java.awt.Color(0, 0, 0));
        bo_El.setText("Eliminar");
        bo_El.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_El.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ElActionPerformed(evt);
            }
        });
        jPanel1.add(bo_El, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, -1));

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
                "ID", "Nombre", "Cantidad", "Precio", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        u.setName(""); // NOI18N
        u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uMouseClicked(evt);
            }
        });
        u.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                uKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(u);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 760, -1));

        ce_el.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ce_el.setForeground(new java.awt.Color(0, 0, 0));
        ce_el.setText("Modo Eliminar");
        ce_el.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ce_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ce_elActionPerformed(evt);
            }
        });
        jPanel1.add(ce_el, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, -1, -1));

        ce_mod.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        ce_mod.setForeground(new java.awt.Color(0, 0, 0));
        ce_mod.setText("Modo Editar");
        ce_mod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ce_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ce_modActionPerformed(evt);
            }
        });
        jPanel1.add(ce_mod, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 240, -1, -1));

        txt_bu.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        txt_bu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buActionPerformed(evt);
            }
        });
        txt_bu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buKeyReleased(evt);
            }
        });
        jPanel1.add(txt_bu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 170, 30));

        co_bu.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        co_bu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        co_bu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co_buActionPerformed(evt);
            }
        });
        jPanel1.add(co_bu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 140, 30));

        pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        pdf.setBorder(null);
        pdf.setContentAreaFilled(false);
        pdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pdf.setFocusPainted(false);
        pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfActionPerformed(evt);
            }
        });
        jPanel1.add(pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, -1, -1));

        cuadros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/elpro.png"))); // NOI18N
        jPanel1.add(cuadros, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 470, -1));

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
                resp = JOptionPane.showConfirmDialog(null,"¿Seguro que quiere eliminar este Producto? "+id+"","Eliminar Producto",YES_NO_OPTION,INFORMATION_MESSAGE,null);
                if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("delete from producto where ID='"+id+"'");             
                    pst.executeUpdate();
                    modelo.removeRow(fila);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado exitosamente");
                }
            }catch(SQLException e){  
                System.out.println("Aqui en tabla al intentar Eliminar Producto = "+id+" Fila: "+fila);
                System.out.println(""+e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione un Producto");
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
        Agpr ma = new Agpr();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_agActionPerformed

    private void pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfActionPerformed
        Document documento = new Document();
        
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Producto.pdf"));
            
            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Merceria y Papeleria BETA");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            
            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Producto \n\n");
            Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
            documento.open();
            documento.add(linea);
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from producto");    
                ResultSet rs = pst.executeQuery();
                if(rs.next()){                               
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);                    
                }          
            } catch (DocumentException | SQLException e) {
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte de Producto se ha Creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        }
    }//GEN-LAST:event_pdfActionPerformed

    private void txt_buActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buActionPerformed

    private void bo_buActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_buActionPerformed
        modelo.setRowCount(0);
        String Bus = txt_bu.getText().trim();
        try{       
            Connection cn = Conexion.conectar();
            String query;
            if(Bus.equals("")){
                query = "select * from producto";    
            }
            else{
                query = "select * from producto Where ID='"+Bus+"' or Nom='"+Bus+"' or Can='"+Bus+"' or Pre='"+Bus+"' or Des='"+Bus+"'";
            }
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Object[] imgan = new Object[6];
            while(rs.next()){         
                imgan[0] = rs.getInt("ID");
                imgan[1] = rs.getString("Nom");
                imgan[2] = rs.getInt("Can");
                imgan[3] = rs.getDouble("Pre");
                imgan[4] = rs.getString("Des");
                modelo.addRow(imgan);            
            }
            u.setModel(modelo); 
        }catch(SQLException e){            
            System.out.println("Error en conexión local al textear el buscar" + e);
        }
        txt_bu.setText("");
    }//GEN-LAST:event_bo_buActionPerformed

    private void co_buActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co_buActionPerformed
        modelo.setRowCount(0);
        String con = co_bu.getSelectedItem().toString();
        try{
            Connection cn = Conexion.conectar();
            String query;
            if(con.equals("Todos")){
                query = "select * from producto";
            }
            else{
                query = "select * from producto Where Nom='"+con+"'";
            }
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            Object[] imgan = new Object[6];
            while(rs.next()){
                imgan[0] = rs.getInt("ID");
                imgan[1] = rs.getString("Nom");
                imgan[2] = rs.getInt("Can");
                imgan[3] = rs.getDouble("Pre");
                imgan[4] = rs.getString("Des");
                modelo.addRow(imgan);
            }
            u.setModel(modelo);
        }catch(SQLException e){
            System.out.println("Error en buscar con el combo box: " + e);
        }
    }//GEN-LAST:event_co_buActionPerformed

    private void txt_buKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            modelo.setRowCount(0);
            String Bus = txt_bu.getText().trim();
            try{       
                Connection cn = Conexion.conectar();
                String query;
                if(Bus.equals("")){
                    query = "select * from producto";    
                }
                else{
                    query = "select * from producto Where ID='"+Bus+"' or Nom='"+Bus+"' or Can='"+Bus+"' or Pre='"+Bus+"' or Des='"+Bus+"'";
                }
                PreparedStatement pst = cn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                Object[] imgan = new Object[6];
                while(rs.next()){         
                    imgan[0] = rs.getInt("ID");
                    imgan[1] = rs.getString("Nom");
                    imgan[2] = rs.getInt("Can");
                    imgan[3] = rs.getDouble("Pre");
                    imgan[4] = rs.getString("Des");
                    modelo.addRow(imgan);            
                }
                u.setModel(modelo); 
            }catch(SQLException e){            
                System.out.println("Error en conexión local al textear el buscar" + e);
            }
            txt_bu.setText("");
        }
    }//GEN-LAST:event_txt_buKeyReleased

    private void uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uMouseClicked
        int filaa = u.getSelectedRow();
        id_ar = Integer.parseInt(this.u.getValueAt(filaa,0).toString());
        try{
            Connection cn = Conexion.conectar();
            java.sql.PreparedStatement pst = cn.prepareStatement("SELECT Img from producto where ID='"+id_ar+"'");             
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                is = rs.getBinaryStream("Img");
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon (bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(230,230, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon (newimg);
                lb_img.setIcon(newicon);
            }
        }catch(SQLException e){           
        } catch (IOException ex) {
            Logger.getLogger(ElPr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElPr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(() -> {
            new ElPr().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton bo_El;
    private javax.swing.JButton bo_ag;
    private javax.swing.JButton bo_bu;
    private javax.swing.JButton bo_regresar;
    private javax.swing.JCheckBox ce_el;
    private javax.swing.JCheckBox ce_mod;
    private javax.swing.JComboBox<String> co_bu;
    private javax.swing.JLabel cuadros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_img;
    private javax.swing.JButton pdf;
    private javax.swing.JTextField txt_bu;
    private javax.swing.JTable u;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
