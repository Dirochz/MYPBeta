package Formulario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Date;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import myp.beta.Conexion;

public final class Ticket extends javax.swing.JFrame {
    int canti,ca_b,cont=0,ca_a = 0,i=0,id_c,id_p,s=0,ca,ca_t,a=0,id_us,id_para_eliminar=-1,folio,con_i=0,fila,id_pr,cantii,pi=1;
    double pre,prea=0,his=0,cambi;
    String user,Nombre,Appa;
    Date fech;
    ArrayList<Object[]> productos_vendidos = new ArrayList<>();
    ArrayList<Object[]> productos = new ArrayList<>();
    ArrayList<Object[]> productos_i = new ArrayList<>();
    DefaultTableModel modelo; 
    public Ticket() {
        initComponents();
        setTitle("Ticket");
        this.setLocationRelativeTo(null);
        inf.setVisible(false);
        user = Login.nick;
        dbox();
        table();
        nombre();
        setIconImage(getIconImage());
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Img/logo.png"));
        return retValue;
    }
    
    void nombre(){
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement("Select ID, Nom, ApPa "
                    + "from usuario where Nickname ='"+user+ "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ 
                id_us = rs.getInt("ID"); 
                Nombre = rs.getString("Nom"); 
                Appa = rs.getString("ApPa");
                usuario.setText("Vendedor: "+Nombre+" "+Appa);
            }
        }catch (SQLException e){           
        }
    }
    
    void dbox(){
        try {
            ArrayList<String> nombres = new ArrayList<>();         
            Connection cn = Conexion.conectar(); 
            PreparedStatement pst;
            pst = cn.prepareStatement("select ID from producto"); 
            nombres.add("Seleccionar");          
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombres.add(rs.getString("ID"));
            }
            String[] usuarios = nombres.toArray(new String[0]);
            co_id.setModel(new javax.swing.DefaultComboBoxModel<>(usuarios));
        }catch (SQLException e){    
            System.out.println("Error en conexión local en colocar el combo box: " + e);
        }
    }
    
    void table(){
        modelo = (DefaultTableModel)u1.getModel();
        u1.setModel(modelo);
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
            u1.setModel(modelo);
        }catch(SQLException e){
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fe1 = new javax.swing.JLabel();
        txt_cl = new javax.swing.JTextField();
        pago = new javax.swing.JSpinner();
        lb_pa = new javax.swing.JLabel();
        cam = new javax.swing.JLabel();
        Cam = new javax.swing.JLabel();
        fe = new javax.swing.JLabel();
        txt_cal = new com.toedter.calendar.JDateChooser();
        usuario = new javax.swing.JLabel();
        cant = new javax.swing.JSpinner();
        lb_c = new javax.swing.JLabel();
        lb_p = new javax.swing.JLabel();
        bo_Ver = new javax.swing.JButton();
        bo_ag = new javax.swing.JButton();
        bo_El = new javax.swing.JButton();
        bo_regresar = new javax.swing.JButton();
        inf = new javax.swing.JScrollPane();
        u1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        u = new javax.swing.JTable();
        co_id = new javax.swing.JComboBox<>();
        bo_i = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        cuadros = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fe1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        fe1.setForeground(new java.awt.Color(0, 0, 0));
        fe1.setText("Cliente:");
        jPanel1.add(fe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, -1, -1));

        txt_cl.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txt_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 140, 40));

        pago.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pago.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.05d));
        jPanel1.add(pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 140, 30));

        lb_pa.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lb_pa.setForeground(new java.awt.Color(0, 0, 0));
        lb_pa.setText("Pago: $");
        jPanel1.add(lb_pa, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, -1, -1));

        cam.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cam.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 260, 150, 30));

        Cam.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Cam.setForeground(new java.awt.Color(0, 0, 0));
        Cam.setText("Cambio: $");
        jPanel1.add(Cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, -1, -1));

        fe.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        fe.setForeground(new java.awt.Color(0, 0, 0));
        fe.setText("Fecha:");
        jPanel1.add(fe, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, -1));

        txt_cal.setDateFormatString("yyyy-MM-dd");
        txt_cal.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jPanel1.add(txt_cal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 140, -1));

        usuario.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 280, 20));

        cant.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        cant.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel1.add(cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 30));

        lb_c.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lb_c.setForeground(new java.awt.Color(0, 0, 0));
        lb_c.setText("Cantidad:");
        jPanel1.add(lb_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lb_p.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        lb_p.setForeground(new java.awt.Color(0, 0, 0));
        lb_p.setText("ID Producto: ");
        jPanel1.add(lb_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        bo_Ver.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_Ver.setForeground(new java.awt.Color(0, 0, 0));
        bo_Ver.setText("Venta");
        bo_Ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_VerActionPerformed(evt);
            }
        });
        jPanel1.add(bo_Ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, -1, -1));

        bo_ag.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        bo_ag.setForeground(new java.awt.Color(0, 0, 0));
        bo_ag.setText("Agregar");
        bo_ag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_agActionPerformed(evt);
            }
        });
        jPanel1.add(bo_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 130, -1));

        bo_El.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        bo_El.setForeground(new java.awt.Color(0, 0, 0));
        bo_El.setText("Eliminar");
        bo_El.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_El.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_ElActionPerformed(evt);
            }
        });
        jPanel1.add(bo_El, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

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

        u1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        u1.setModel(new javax.swing.table.DefaultTableModel(
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
        u1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        u1.setEnabled(false);
        u1.setName(""); // NOI18N
        u1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                u1KeyReleased(evt);
            }
        });
        inf.setViewportView(u1);

        jPanel1.add(inf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 800, 170));

        u.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        u.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 530, 190));

        co_id.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        co_id.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        co_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co_idActionPerformed(evt);
            }
        });
        jPanel1.add(co_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 30));

        bo_i.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/info.png"))); // NOI18N
        bo_i.setBorder(null);
        bo_i.setContentAreaFilled(false);
        bo_i.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bo_i.setFocusPainted(false);
        bo_i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bo_iActionPerformed(evt);
            }
        });
        jPanel1.add(bo_i, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 40, 40));

        Total.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setText("Total: $");
        jPanel1.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        to.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        to.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        cuadros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Vector.png"))); // NOI18N
        jPanel1.add(cuadros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 994, Short.MAX_VALUE)
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
            double precio_a_eliminar = (double) productos_vendidos.get(id_para_eliminar)[3];
            int cant_a_eliminar = (int) productos_vendidos.get(id_para_eliminar)[2];
            double subtotal_a_eliminar = precio_a_eliminar * cant_a_eliminar;
            System.out.println("\nCantidad a Eliminar: "+cant_a_eliminar);
            his = his - subtotal_a_eliminar;
            cont--;
            productos_vendidos.remove(id_para_eliminar);
            modelo = (DefaultTableModel)u.getModel();
            modelo.removeRow(id_para_eliminar);
            u.setModel(modelo);
            to.setText(String.format("%.2f",his));
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione un Producto");
            System.out.println("La Fila es: "+fila);
        }
        
    }//GEN-LAST:event_bo_ElActionPerformed

    private void bo_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_regresarActionPerformed
        Menu ma = new Menu();
        ma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bo_regresarActionPerformed

    private void uKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uKeyReleased
       
    }//GEN-LAST:event_uKeyReleased

    private void bo_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_agActionPerformed
        String can = cant.getValue().toString(); 
        String id = co_id.getSelectedItem().toString();
        modelo = (DefaultTableModel)u.getModel();
        u.setModel(modelo);
        Object[] imgan = new Object[5];
        
        //Consigue la ID del Producto
        try{
            Connection cn = Conexion.conectar(); 
            PreparedStatement pst;
            pst = cn.prepareStatement("select ID from producto WHERE ID= '"+id+"'"); 
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id_p = rs.getInt("ID");   
        }
        }catch(SQLException e){
        }
        System.out.println("\nProducto: "+id_p);////////////////////////////////////
        
        //Consigue la cantidad del producto
        try{
            Connection cn = Conexion.conectar(); 
            PreparedStatement pst;
            pst = cn.prepareStatement("select Can from producto WHERE ID= '"+id+"'"); 
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ca_b = rs.getInt("Can");   
            }
        }catch(SQLException e){
        }
        
        //Guarda toda la informacion del producto
        try{ 
            //checa que los campos esten llenos
            if(!id.equals("Seleccionar") && !can.equals("0")){ 
                canti = (int) cant.getValue();
                ca=canti;
                System.out.println("Cantidad: "+canti);////////////////////////////////////
                int np = 0;
                a=0;
                Connection cn = Conexion.conectar(); 
                PreparedStatement pst = cn.prepareStatement("select ID,Nom,Can,Pre from producto WHERE ID ='"+id+"'");
                ResultSet rs = pst.executeQuery();
                //Checa si el producto existe
                if (!rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null,"¡El producto no fue encontrado!");
                    np=1;
                }
                //pasa por todos los productos que hay en el arreglo
                for (int i = 0; i < productos_vendidos.size(); i++) {   
                    int id_v = (int) productos_vendidos.get(i)[0];
                    //verifica que si el producto esta en la tabla
                    if(id_v==id_p){
                        s=1;
                        int cana = (int) productos_vendidos.get(i)[2];
                        int canaa = (int) productos_vendidos.get(i)[4];
                        productos_vendidos.remove(i);
                        ca= cana;
                        cana= cana+canti;
                        ca_t = ca_b - cana;
                        //verifica si hay stock del producto
                        if ( ca_t < 0) {
                            JOptionPane.showMessageDialog(null,"¡No hay suficiente Stock!");
                            a=1;
                            s=3;
                        }
                        else{
                            a=0;
                            ca_a = canaa - canti;
                            ca= ca+canti;
                            System.out.println("cantidad Agregada: "+ca);////////////////////////
                            this.u.setValueAt(ca, i, 2);
                        }                    
                    }
                }
                //Hace la Instrucciones de la base de datos
                while(rs.next()){
                    //Si el producto no esta en la tabla consigue la informacion
                    if(s==0){
                        imgan [0] = rs.getInt("ID");
                        imgan [1] = rs.getString("Nom");
                        imgan [2] = ca;
                        imgan [3] = rs.getDouble("Pre");                
                        ca_b = rs.getInt("Can"); 
                        pre = rs.getDouble("Pre");
                        //Checa si hay stock del Producto
                        if (ca_b - canti < 0) {
                            JOptionPane.showMessageDialog(null,"¡No hay suficiente Stock!");
                            a=1;
                        } 
                        else{
                            System.out.println("cantidad guardada sin filtro: "+ca);//////////////////////////////
                            modelo.addRow(imgan);
                            ca_a = ca_b - canti;
                            productos_vendidos.add(imgan);
                        } 
                    }
                    //Si el producto esta en la tabla consigue esta informacion
                    else if(s==1){
                        imgan [0] = rs.getInt("ID");
                        imgan [1] = rs.getString("Nom");
                        imgan [2] = ca;
                        imgan [3] = rs.getDouble("Pre");
                        System.out.println("cantidad guardada con filtro: "+ca);//////////////////////////////
                        productos_vendidos.add(imgan);
                    }                
                } 
                s=0;
                //Verifica que si hay Producto
                if(a==0){
                    cont=cont+1;
                    System.out.println("productos contados: "+cont);//////////////////////////////
                    System.out.println("CANTIDAD A que se modificara al inventario: "+ca_a);//////////////////////////////
                    //Verifica que el producto sea mayor a 0 y que exista el producto
                    if (ca_a >= 0 && np == 0 && pi==1) {               
                        prea = pre * canti;
                        his = his + prea;
                        imgan[4] = ca_a; 
                        to.setText(String.format("%.2f",his));
                        this.u.setModel(modelo);
                    }
                }
                co_id.setSelectedItem("Seleccionar");
                cant.setValue(0); 
            }
            else{
                JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
            }
        }catch (HeadlessException | NumberFormatException | SQLException e){      
        }
    }//GEN-LAST:event_bo_agActionPerformed

    private void bo_VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_VerActionPerformed
        String fecha = ((JTextField)txt_cal.getDateEditor().getUiComponent()).getText();
        String pag = pago.getValue().toString();
        String cli = txt_cl.getText().trim();
        if(cli.equals("") || pag.equals(0) || fecha.equals("")){
            JOptionPane.showMessageDialog(null,"Debes llenar los datos");          
        } 
        
        double pagocli = Double.parseDouble(pag);
        cambi = pagocli-his;       
        
        if(his<=pagocli){          
            cam.setText(String.format("%.2f", cambi));
            JOptionPane.showMessageDialog(null,"Venta Realizada: Fecha: "+fecha);
          
            try {
            
                int cantidad_total = 0;
                Object[] temp = new Object[4];
            
                for (int i = 0; i < productos_vendidos.size(); i++) {   
                    int cant = (int) productos_vendidos.get(i)[2];
                    cantidad_total += cant;
                }
            
                //Folio, Usuario, cliente, cantidad, total, cambio, fecha
                Connection cn = Conexion.conectar(); 
                PreparedStatement pst = cn.prepareStatement("insert into pedido values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);              
                pst.setInt(1, 0);
                pst.setInt(2, id_us);
                pst.setString(3, cli);
                pst.setInt(4, cantidad_total);
                pst.setDouble(5, his);
                pst.setDouble(6, cambi);
                pst.setString(7, fecha);
                pst.executeUpdate();
                ResultSet res = pst.getGeneratedKeys();
            
                while (res.next()) {
                    folio = res.getInt(1);
                }    
            
                //ID, ID.folio, ID.producto, Cantidad, Precio
                for (int i = 0; i < productos_vendidos.size(); i++) {
                    PreparedStatement dpedido = cn.prepareStatement("insert into d_pedido values(?,?,?,?,?)");             
                    dpedido.setInt(1, 0);
                    dpedido.setInt(2, folio);
                    dpedido.setInt(3, (int) productos_vendidos.get(i)[0]);
                    dpedido.setInt(4, (int) productos_vendidos.get(i)[2]);
                    dpedido.setDouble(5, (double) productos_vendidos.get(i)[3]);
                    dpedido.executeUpdate();
                
                    //producto, Can
                    PreparedStatement update_cantidad = cn.prepareStatement("UPDATE producto SET Can = ? WHERE ID = ?");
                    update_cantidad.setInt(1, (int) productos_vendidos.get(i)[4]); 
                    update_cantidad.setString(2, productos_vendidos.get(i)[0].toString()); 
                    update_cantidad.executeUpdate(); 
                }  
            }catch (SQLException e) {
                System.out.println(e);
            } 
            
            Document documento = new Document();  
            try {
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/"+cli+".pdf"));
            
                Paragraph header = new Paragraph();
                header.setAlignment(Paragraph.ALIGN_CENTER);
                header.add("Merceria y Papeleria BETA");
                header.setFont(FontFactory.getFont("Arial",30,Font.BOLD, BaseColor.DARK_GRAY));
            
                Paragraph linea = new Paragraph();
                linea.setAlignment(Paragraph.ALIGN_CENTER);
                linea.add("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
            
                Paragraph local = new Paragraph();
                local.setAlignment(Paragraph.ALIGN_CENTER);
                local.add("Sucursal: Calle beta #5436, Villa Cumbre, Monterrey Nuevo León\n");
            
                Paragraph datos = new Paragraph();
                datos.setAlignment(Paragraph.ALIGN_CENTER);
                datos.add("ID Vendedor: "+id_us+"\n"
                    + "Nombre del Vendedor: "+Nombre+"\n"
                    + "Nombre del Cliente: "+cli+"\n"
                    + "Folio de la Venta: "+folio+"\n");
                datos.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));
            
                Paragraph venta = new Paragraph();
                venta.setAlignment(Paragraph.ALIGN_CENTER);
                venta.add("Venta");
                venta.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));
            
                Paragraph prelist = new Paragraph();
                prelist.setAlignment(Paragraph.ALIGN_LEFT);
                prelist.add(""
                + "                             ID         Productos -------------------------------------------- Cantidad");
                prelist.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));
            
                Paragraph list = new Paragraph();
                list.setAlignment(Paragraph.LIST);
                list.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));           
            
                Paragraph fin = new Paragraph();
                fin.setAlignment(Paragraph.ALIGN_RIGHT);
                fin.add("\nTotal: $"+String.format("%.2f",his)+" Pesos\n"
                  + "Pago: $"+pag+" Pesos\n"
                  + "Cambio: $"+String.format("%.2f",cambi)+" Pesos");
                fin.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));            
            
                Paragraph fe = new Paragraph();
                fe.setAlignment(Paragraph.ALIGN_CENTER);
                fe.add("Fecha de la compra: "+fecha);
                fe.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));
            
                Paragraph credito = new Paragraph();
                credito.setAlignment(Paragraph.ALIGN_CENTER);
                credito.add("Cliente\n"
                    + "<GRACIAS POR SU COMPRA>\n"
                    + "Favor de Verificar su Cambio\n"
                    + "No Hay Cambio o Devoluciones\n"
                    + "No se Admite Reclamaciones");
                credito.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD, BaseColor.DARK_GRAY));
                
                documento.open();
                documento.add(linea);
                documento.add(header);
                documento.add(linea);
                documento.add(local);
                documento.add(datos);
                documento.add(fe);            
                documento.add(linea);
                documento.add(venta);
                documento.add(prelist);      
                
                for (int i = 0; i < productos_vendidos.size(); i++) {                             
                    list.add("\n"
                    + "                       "+(int) productos_vendidos.get(i)[0]+"       "+productos_vendidos.get(i)[1]+" ---------------------------------------- "+(int) productos_vendidos.get(i)[2]);              
                    System.out.println("\nid: "+productos_vendidos.get(i)[0]);//////////////////////////////
                    System.out.println("Nombre: "+productos_vendidos.get(i)[1]);//////////////////////////////
                    System.out.println("Cantidad: "+productos_vendidos.get(i)[2]);//////////////////////////////
                    con_i=con_i+1;
                }
                
                documento.add(list);
                documento.add(fin);
                documento.add(linea);
                documento.add(credito);
                documento.add(linea);
                documento.close();
                Ticket ma = new Ticket();
                ma.setVisible(true);
                this.setVisible(false);
            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            } catch (IOException ex) {
                Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }  
        else{
            JOptionPane.showMessageDialog(null,"Saldo Insuficiente");
        }
    }//GEN-LAST:event_bo_VerActionPerformed

    private void co_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_co_idActionPerformed
    
    }//GEN-LAST:event_co_idActionPerformed

    private void bo_iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bo_iActionPerformed
        if(i==0){
            inf.setVisible(true);
            i=1;
        }
        else{
            inf.setVisible(false);
            i=0;
        } 
    }//GEN-LAST:event_bo_iActionPerformed

    private void u1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_u1KeyReleased

    }//GEN-LAST:event_u1KeyReleased

    private void txt_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clActionPerformed

    private void uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uMouseClicked
        id_para_eliminar = u.getSelectedRow();
    }//GEN-LAST:event_uMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cam;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Total;
    private javax.swing.JButton bo_El;
    private javax.swing.JButton bo_Ver;
    private javax.swing.JButton bo_ag;
    private javax.swing.JButton bo_i;
    private javax.swing.JButton bo_regresar;
    private javax.swing.JLabel cam;
    private javax.swing.JSpinner cant;
    private javax.swing.JComboBox<String> co_id;
    private javax.swing.JLabel cuadros;
    private javax.swing.JLabel fe;
    private javax.swing.JLabel fe1;
    private javax.swing.JScrollPane inf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_c;
    private javax.swing.JLabel lb_p;
    private javax.swing.JLabel lb_pa;
    private javax.swing.JSpinner pago;
    private javax.swing.JLabel to;
    private com.toedter.calendar.JDateChooser txt_cal;
    private javax.swing.JTextField txt_cl;
    private javax.swing.JTable u;
    private javax.swing.JTable u1;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
