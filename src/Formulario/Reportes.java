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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import myp.beta.Conexion;

public final class Reportes extends javax.swing.JFrame {
    int resp;
    private FileInputStream fis;
    private int LongitudByte;
    public Reportes() {
        initComponents();
        setTitle("Reporte");
        this.setLocationRelativeTo(null);
        masV();
    }
    
    void masV(){
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT d.ID_Pro PRODUCTO, P.Nom NOMBRE, SUM(d.Cant) CANTIDAD, P.Img IMAGEN FROM d_pedido D INNER JOIN producto P ON D.ID_Pro=P.ID GROUP BY D.ID_Pro");
            ResultSet rs = pst.executeQuery();
               
            if(rs.next()){
                //Datos consultados
                txt_nombre.setText(rs.getString("NOMBRE"));
                CVend.setText((rs.getString("CANTIDAD")));
                //leer Binario
                Blob blob = rs.getBlob(4);
                //pasar el binario a imagen
                byte[] data = blob.getBytes(1, (int) blob.length());
                //lee la imagen
                BufferedImage img = null;
                rs.next();
                //Datos consultados 2
                txt_nombre2.setText(rs.getString("NOMBRE"));
                CVend1.setText((rs.getString("CANTIDAD")));
                //leer Binario 2
                Blob blob2 = rs.getBlob(4);
                //pasar el binario a imagen 2
                byte[] data2 = blob2.getBytes(1, (int) blob2.length());
                //lee la imagen 2
                BufferedImage img2 = null;  
                rs.next();
                //Datos consultados 3
                txt_nombre3.setText(rs.getString("NOMBRE"));
                CVend2.setText((rs.getString("CANTIDAD")));
                //leer Binario 3
                Blob blob3 = rs.getBlob(4);
                //pasar el binario a imagen 3
                byte[] data3 = blob3.getBytes(1, (int) blob3.length());
                //lee la imagen 2
                BufferedImage img3 = null;  
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    img2 = ImageIO.read(new ByteArrayInputStream(data2));
                    img3 = ImageIO.read(new ByteArrayInputStream(data3));
                } catch (IOException e) {
                }
                   
                ImageIcon icono = new ImageIcon(img);
                ImageIcon icono2= new ImageIcon(img2);
                ImageIcon icono3= new ImageIcon(img3);
                Icon imagen1 = new ImageIcon(icono.getImage().getScaledInstance(foto1.getWidth(), foto1.getHeight(), Image.SCALE_DEFAULT));
                Icon imagen2 = new ImageIcon(icono2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT));
                Icon imagen3 = new ImageIcon(icono3.getImage().getScaledInstance(foto3.getWidth(), foto3.getHeight(), Image.SCALE_DEFAULT));
                foto1.setIcon(imagen1);
                foto2.setIcon(imagen2);
                foto3.setIcon(imagen3);
               
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error al cargar!");
            System.out.println("Error al cargar foto: " + e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        todo1 = new javax.swing.JButton();
        txt_folio1 = new javax.swing.JTextField();
        Folio1 = new javax.swing.JButton();
        Folio = new javax.swing.JButton();
        todo = new javax.swing.JButton();
        Fecha = new javax.swing.JButton();
        dp1 = new javax.swing.JLabel();
        dp = new javax.swing.JLabel();
        prodmasv1 = new javax.swing.JLabel();
        prodmasv = new javax.swing.JLabel();
        bo_regresar = new javax.swing.JButton();
        txt_nombre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_folio = new javax.swing.JTextField();
        txt_cal = new com.toedter.calendar.JDateChooser();
        txt_nombre2 = new javax.swing.JLabel();
        txt_nombre3 = new javax.swing.JLabel();
        foto1 = new javax.swing.JLabel();
        foto2 = new javax.swing.JLabel();
        foto3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CVend2 = new javax.swing.JLabel();
        CVend1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CVend = new javax.swing.JLabel();
        triangulo = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        todo1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        todo1.setForeground(new java.awt.Color(0, 0, 0));
        todo1.setText("Todo");
        todo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        todo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todo1ActionPerformed(evt);
            }
        });
        jPanel1.add(todo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 90, 30));

        txt_folio1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txt_folio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_folio1ActionPerformed(evt);
            }
        });
        txt_folio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_folio1KeyTyped(evt);
            }
        });
        jPanel1.add(txt_folio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 60, -1));

        Folio1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Folio1.setForeground(new java.awt.Color(0, 0, 0));
        Folio1.setText("Folio");
        Folio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Folio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Folio1ActionPerformed(evt);
            }
        });
        jPanel1.add(Folio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 130, 30));

        Folio.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Folio.setForeground(new java.awt.Color(0, 0, 0));
        Folio.setText("Folio");
        Folio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FolioActionPerformed(evt);
            }
        });
        jPanel1.add(Folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 130, 30));

        todo.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        todo.setForeground(new java.awt.Color(0, 0, 0));
        todo.setText("Todo");
        todo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoActionPerformed(evt);
            }
        });
        jPanel1.add(todo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 90, 30));

        Fecha.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 0, 0));
        Fecha.setText("Por Fecha");
        Fecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaActionPerformed(evt);
            }
        });
        jPanel1.add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 130, 30));

        dp1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        dp1.setForeground(new java.awt.Color(0, 0, 0));
        dp1.setText("Descargar Tabla Pedidos");
        jPanel1.add(dp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, 30));

        dp.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        dp.setForeground(new java.awt.Color(0, 0, 0));
        dp.setText("Descargar Tabla de Detalle Pedido");
        jPanel1.add(dp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        prodmasv1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        prodmasv1.setForeground(new java.awt.Color(0, 0, 0));
        prodmasv1.setText("más Vendidos");
        jPanel1.add(prodmasv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, -1, 30));

        prodmasv.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        prodmasv.setForeground(new java.awt.Color(0, 0, 0));
        prodmasv.setText("Productos ");
        jPanel1.add(prodmasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, 30));

        bo_regresar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_regresar.setForeground(new java.awt.Color(0, 0, 0));
        bo_regresar.setText("Regresar");
        bo_regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(bo_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 150, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(null);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 780, 20));

        txt_folio.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txt_folio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_folioActionPerformed(evt);
            }
        });
        txt_folio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_folioKeyTyped(evt);
            }
        });
        jPanel1.add(txt_folio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, -1));

        txt_cal.setDateFormatString("yyyy-MM-dd");
        txt_cal.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jPanel1.add(txt_cal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 190, -1));

        txt_nombre2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jPanel1.add(txt_nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 160, 40));

        txt_nombre3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jPanel1.add(txt_nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 150, 40));

        foto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto1.setToolTipText("");
        foto1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 154, 172));

        foto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto2.setToolTipText("");
        foto2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 164, 173));

        foto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto3.setToolTipText("");
        foto3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(foto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 154, 172));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad vendidos: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, -1, -1));

        CVend2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CVend2.setForeground(new java.awt.Color(0, 0, 0));
        CVend2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CVend2.setText("??");
        jPanel1.add(CVend2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 50, 20));

        CVend1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CVend1.setForeground(new java.awt.Color(0, 0, 0));
        CVend1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CVend1.setText("??");
        jPanel1.add(CVend1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, 50, 20));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad vendidos: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cantidad vendidos: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, -1, -1));

        CVend.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        CVend.setForeground(new java.awt.Color(0, 0, 0));
        CVend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CVend.setText("??");
        jPanel1.add(CVend, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 50, 20));

        triangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trianguloinv.png"))); // NOI18N
        jPanel1.add(triangulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 520));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, -1));

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

    private void FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaActionPerformed
        String fecha = ((JTextField) txt_cal.getDateEditor().getUiComponent()).getText();
        if(fecha.equals("")){
            JOptionPane.showMessageDialog(null,"Debes Poner una Fecha");          
        }
        else{
            Document documento = new Document();
            try {
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pedidos.pdf"));

                Paragraph header = new Paragraph();
                header.setAlignment(Paragraph.ALIGN_CENTER);
                header.add("Merceria y Papeleria BETA");
                header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

                Paragraph linea = new Paragraph();
                linea.setAlignment(Paragraph.ALIGN_CENTER);
                linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

                Paragraph Titulo = new Paragraph();
                Titulo.setAlignment(Paragraph.ALIGN_CENTER);
                Titulo.add("Reporte de Pedidos \n\n");
                Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

                documento.open();
                documento.add(linea);
                documento.add(header);
                documento.add(linea);
                documento.add(Titulo);

                PdfPTable tabla = new PdfPTable(7);
                tabla.addCell("Folio");
                tabla.addCell("ID_Vendedor");
                tabla.addCell("Clientes");
                tabla.addCell("Cantidad");
                tabla.addCell("Total");
                tabla.addCell("Cambio");
                tabla.addCell("Fecha");
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select * from pedido WHERE Fecha='"+fecha+"'");    
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
                JOptionPane.showMessageDialog(null, "Reporte de Pedidos se ha Creado.");
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            } catch (IOException ex) {
                Logger.getLogger(ElUs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_FechaActionPerformed

    private void bo_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_regresarActionPerformed
        Menu ma = new Menu();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_regresarActionPerformed

    private void todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pedidos.pdf"));

            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Merceria y Papeleria BETA");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Pedidos \n\n");
            Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(linea);
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);

            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Folio");
            tabla.addCell("ID_Vendedor");
            tabla.addCell("Clientes");
            tabla.addCell("Cantidad");
            tabla.addCell("Total");
            tabla.addCell("Cambio");
            tabla.addCell("Fecha");
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from pedido");    
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
            JOptionPane.showMessageDialog(null, "Reporte de Pedidos se ha Creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(ElUs.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_todoActionPerformed

    private void txt_folioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_folioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_folioActionPerformed

    private void FolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FolioActionPerformed
        String folio = txt_folio.getText().trim();
        if(folio.equals("")){
            JOptionPane.showMessageDialog(null,"Debes Poner el Folio");          
        }
        else{
            Document documento = new Document();
            try {
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Pedidos.pdf"));

                Paragraph header = new Paragraph();
                header.setAlignment(Paragraph.ALIGN_CENTER);
                header.add("Merceria y Papeleria BETA");
                header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

                Paragraph linea = new Paragraph();
                linea.setAlignment(Paragraph.ALIGN_CENTER);
                linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

                Paragraph Titulo = new Paragraph();
                Titulo.setAlignment(Paragraph.ALIGN_CENTER);
                Titulo.add("Reporte de Pedidos \n\n");
                Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

                documento.open();
                documento.add(linea);
                documento.add(header);
                documento.add(linea);
                documento.add(Titulo);

                PdfPTable tabla = new PdfPTable(7);
                tabla.addCell("Folio");
                tabla.addCell("ID_Vendedor");
                tabla.addCell("Clientes");
                tabla.addCell("Cantidad");
                tabla.addCell("Total");
                tabla.addCell("Cambio");
                tabla.addCell("Fecha");
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select * from pedido WHERE Folio='"+folio+"'");    
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
                JOptionPane.showMessageDialog(null, "Reporte de Pedidos se ha Creado.");
                txt_folio.setText("");
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            } catch (IOException ex) {
                Logger.getLogger(ElUs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_FolioActionPerformed

    private void txt_folioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_folioKeyTyped
        //texto folio
        char c = evt.getKeyChar();        
        if(c<'0' || c>'9')evt.consume(); //esto permite solo escribir numeros
    }//GEN-LAST:event_txt_folioKeyTyped

    private void txt_folio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_folio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_folio1ActionPerformed

    private void txt_folio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_folio1KeyTyped
        //texto folio
        char c = evt.getKeyChar();        
        if(c<'0' || c>'9')evt.consume(); //esto permite solo escribir numeros
    }//GEN-LAST:event_txt_folio1KeyTyped

    private void Folio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Folio1ActionPerformed
        String folio = txt_folio1.getText().trim();
        if(folio.equals("")){
            JOptionPane.showMessageDialog(null,"Debes Poner el Folio");          
        }
        else{
            Document documento = new Document();
            try {
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Detalle Pedidos.pdf"));

                Paragraph header = new Paragraph();
                header.setAlignment(Paragraph.ALIGN_CENTER);
                header.add("Merceria y Papeleria BETA");
                header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

                Paragraph linea = new Paragraph();
                linea.setAlignment(Paragraph.ALIGN_CENTER);
                linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

                Paragraph Titulo = new Paragraph();
                Titulo.setAlignment(Paragraph.ALIGN_CENTER);
                Titulo.add("Reporte de Pedidos \n\n");
                Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

                documento.open();
                documento.add(linea);
                documento.add(header);
                documento.add(linea);
                documento.add(Titulo);

                PdfPTable tabla = new PdfPTable(5);
                tabla.addCell("ID");
                tabla.addCell("Folio");
                tabla.addCell("ID Producto");
                tabla.addCell("Cantidad");
                tabla.addCell("Precio");
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement("select * from d_pedido WHERE ID_Folio='"+folio+"'");    
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
                JOptionPane.showMessageDialog(null, "Reporte de Pedidos se ha Creado.");
                txt_folio1.setText("");
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            } catch (IOException ex) {
                Logger.getLogger(ElUs.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Folio1ActionPerformed

    private void todo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todo1ActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Detalle Pedidos.pdf"));

            Paragraph header = new Paragraph();
            header.setAlignment(Paragraph.ALIGN_CENTER);
            header.add("Merceria y Papeleria BETA");
            header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

            Paragraph linea = new Paragraph();
            linea.setAlignment(Paragraph.ALIGN_CENTER);
            linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

            Paragraph Titulo = new Paragraph();
            Titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Titulo.add("Reporte de Pedidos \n\n");
            Titulo.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(linea);
            documento.add(header);
            documento.add(linea);
            documento.add(Titulo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("Folio");
            tabla.addCell("ID Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");    
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from d_pedido");    
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
            JOptionPane.showMessageDialog(null, "Reporte de Pedidos se ha Creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(ElUs.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_todo1ActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CVend;
    private javax.swing.JLabel CVend1;
    private javax.swing.JLabel CVend2;
    private javax.swing.JButton Fecha;
    private javax.swing.JButton Folio;
    private javax.swing.JButton Folio1;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton bo_regresar;
    private javax.swing.JLabel dp;
    private javax.swing.JLabel dp1;
    private javax.swing.JLabel foto1;
    private javax.swing.JLabel foto2;
    private javax.swing.JLabel foto3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel prodmasv;
    private javax.swing.JLabel prodmasv1;
    private javax.swing.JButton todo;
    private javax.swing.JButton todo1;
    private javax.swing.JLabel triangulo;
    private com.toedter.calendar.JDateChooser txt_cal;
    private javax.swing.JTextField txt_folio;
    private javax.swing.JTextField txt_folio1;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_nombre2;
    private javax.swing.JLabel txt_nombre3;
    // End of variables declaration//GEN-END:variables
}
