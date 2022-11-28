package Formulario;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;
import myp.beta.Conexion;

public final class Agpr extends javax.swing.JFrame {
    int resp,canti;
    Double pree;
    public Agpr() {
        initComponents();
        setTitle("Agregar Productos");
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/logo.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bo_ag = new javax.swing.JButton();
        bo_ing = new javax.swing.JButton();
        txt_ag = new javax.swing.JTextField();
        Precio1 = new javax.swing.JLabel();
        bo_cerrar = new javax.swing.JButton();
        pre = new javax.swing.JSpinner();
        Precio = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        cant = new javax.swing.JSpinner();
        img = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txt_de = new javax.swing.JTextArea();
        vector = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Agregar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, -1, -1));

        bo_ing.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_ing.setForeground(new java.awt.Color(0, 0, 0));
        bo_ing.setText("Ingresar");
        bo_ing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ingActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ing, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, -1, -1));

        txt_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jPanel1.add(txt_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 290, 50));

        Precio1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        Precio1.setForeground(new java.awt.Color(0, 0, 0));
        Precio1.setText("Descripcion:");
        jPanel1.add(Precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

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

        pre.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        pre.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 0.05d));
        jPanel1.add(pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, 50));

        Precio.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        Precio.setForeground(new java.awt.Color(0, 0, 0));
        Precio.setText("Precio:");
        jPanel1.add(Precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        Cantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        Cantidad.setForeground(new java.awt.Color(0, 0, 0));
        Cantidad.setText("Cantidad:");
        jPanel1.add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        Nombre.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        Nombre.setForeground(new java.awt.Color(0, 0, 0));
        Nombre.setText("Nombre:");
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txt_nom.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 320, 50));

        cant.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        cant.setModel(new javax.swing.SpinnerNumberModel());
        jPanel1.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, 50));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu.png"))); // NOI18N
        img.setBorder(null);
        jPanel1.add(img, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 270, 230));

        Txt_de.setColumns(20);
        Txt_de.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        Txt_de.setRows(5);
        jScrollPane1.setViewportView(Txt_de);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 560, 100));

        vector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Agpr.png"))); // NOI18N
        jPanel1.add(vector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 520));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bo_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_cerrarActionPerformed
        MAg m = new MAg();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_cerrarActionPerformed

    private void bo_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_ingActionPerformed
        File archivo;
        JFileChooser flcAbrirArchivo = new JFileChooser();
        flcAbrirArchivo.setFileFilter(new FileNameExtensionFilter("Archivo de imagen","jpg","jpeg","png")); 
        int respuesta=flcAbrirArchivo.showOpenDialog(this);
        
        if(respuesta == JFileChooser.APPROVE_OPTION){
            archivo = flcAbrirArchivo.getSelectedFile();
            txt_ag.setText(archivo.getAbsolutePath());
            Image foto = Toolkit.getDefaultToolkit().getImage(txt_ag.getText());
            foto = foto.getScaledInstance(290,290, 1);
            img.setIcon(new ImageIcon(foto));
        }
    }//GEN-LAST:event_bo_ingActionPerformed

    private void bo_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agActionPerformed
        FileInputStream archivoFoto;
        String nom = txt_nom.getText().trim();
        String pr = pre.getValue().toString();
        String ca = cant.getValue().toString();
        String n = txt_ag.getText().trim();
        String d = Txt_de.getText().trim();
        
        try{
            if(!nom.equals("") && !pr.equals("0") && !ca.equals("0")&& !n.equals("")){
               resp = JOptionPane.showConfirmDialog(null,"¿Quieres agregar otro articulo?","Articulo",YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE,null); 
               pree = (double) pre.getValue();
               canti = (int) cant.getValue(); 
               
               if(resp==0){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into producto values(?,?,?,?,?,?)");
                    archivoFoto = new FileInputStream(txt_ag.getText());
                    pst.setString(1, "0");
                    pst.setString(2, nom);
                    pst.setInt(3, canti);
                    pst.setDouble(4, pree);
                    pst.setString(5, d);        
                    pst.setBinaryStream(6, archivoFoto);
                    pst.executeUpdate();
                    
                    ImageIcon wall = new ImageIcon("src\\img\\Menu.png");
                    Icon icono = new ImageIcon (wall.getImage().getScaledInstance(img.getWidth(), img.getHeight(),Image.SCALE_DEFAULT)); 
                    img.setIcon(icono);
                    txt_nom.setText("");
                    pre.setValue(0);
                    cant.setValue(0);
                    Txt_de.setText("");
                    txt_ag.setText("");
                }
                else if(resp==1){
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("insert into producto values(?,?,?,?,?,?)");
                    archivoFoto = new FileInputStream(txt_ag.getText());
                    pst.setString(1, "0");
                    pst.setString(2, nom);
                    pst.setInt(3, canti);
                    pst.setDouble(4, pree);
                    pst.setString(5, d);        
                    pst.setBinaryStream(6, archivoFoto);
                    pst.executeUpdate();
                    
                    ElPr m = new ElPr();
                    m.setVisible(true);
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }catch(HeadlessException | FileNotFoundException | SQLException e){
            System.out.println("Error en el try " + e);
        }
    }//GEN-LAST:event_bo_agActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agpr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agpr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agpr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agpr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel Precio1;
    private javax.swing.JTextArea Txt_de;
    private javax.swing.JButton bo_ag;
    private javax.swing.JButton bo_cerrar;
    private javax.swing.JButton bo_ing;
    private javax.swing.JSpinner cant;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner pre;
    private javax.swing.JTextField txt_ag;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JLabel vector;
    // End of variables declaration//GEN-END:variables
}
