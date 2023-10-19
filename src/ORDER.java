
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ORDER extends javax.swing.JFrame {
//public Connection con = null;
//public PreparedStatement pst = null;
//public ResultSet rs = null; 
Orders order = new Orders();
DBConnection connection = new DBConnection();
 
public ORDER() {
        initComponents();
       connection.connect();
        show_order();
        
    }
public ArrayList<Orders> orderList(){
    
    ArrayList<Orders> ordersList = new ArrayList<>();
     PreparedStatement pst = connection.pst; 
                Connection con = connection.con;
                ResultSet rs = connection.rs;
    try {
        String sql = "SELECT * FROM order1"; // query to fetch data from the local database
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        Orders order;
        System.out.println("a");
        while (rs.next()){
            order = new Orders (rs.getString("ID"), rs.getString("Name"), rs.getDouble("Price"),
                    rs.getString("Status"), rs.getString("Email"), rs.getString("Address"),
                    rs.getString("ITEM_1"), rs.getString("ITEM_2"), rs.getString("ITEM_3"));
            // create an Orders object using the data fetch from the collection resultset rs
            ordersList.add(order); 
            // add the Orders object to an ArrayList
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
     return ordersList;
    
}

public void show_order(){
        ArrayList<Orders> list = orderList(); // use the return ArrayList from orderList() function
        DefaultTableModel model = (DefaultTableModel)Table_Or.getModel(); // create a table model in GUI
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i=0; i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getPrice();    
            row[3]=list.get(i).getStatus();
            model.addRow(row); // display Orders objects in the ArrayList to the table
        }
    }

 public ArrayList<Orders> findorderList(){
    Preparing.setActionCommand("Preparing"); // set a String to Preparing radio button option
    Shipping.setActionCommand("Shipping"); // set a String to Shipping radio button option   
    Received.setActionCommand("Received"); // set a String to Received radio button option
    ArrayList<Orders> ordersList = new ArrayList<>();
     PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
  
    if (buttonGroup1.getSelection() == null){
       
         try {
        // query to fetch data from the local database
        String sql = "SELECT * FROM order1 WHERE order1.ID LIKE? OR order1.Name LIKE? ";
        pst = con.prepareStatement(sql);
        pst.setString(1,ID.getText());
        pst.setString(2,Name.getText());
       
        rs = pst.executeQuery();
        Orders order1;
        
        while (rs.next()){
        order1 = new Orders (rs.getString("ID"), rs.getString("Name"), rs.getDouble("Price"), 
                rs.getString("Status"), rs.getString("Email"), rs.getString("Address")
                , rs.getString("ITEM_1"), rs.getString("ITEM_2"), rs.getString("ITEM_3"));
         // create an Orders object using the data fetch from the collection resultset rs
            ordersList.add(order1);
          // add the Orders object to an ArrayList 
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){   
            }
        }
    } else {
    try {
        String sql = "SELECT * FROM order1 WHERE order1.ID LIKE? OR order1.Name LIKE? OR order1.Status LIKE?";
        pst = con.prepareStatement(sql);
        pst.setString(1,ID.getText());
        pst.setString(2,Name.getText());
        pst.setString(3,buttonGroup1.getSelection().getActionCommand());
        rs = pst.executeQuery();
        Orders order;
        
        while (rs.next()){
        order = new Orders (rs.getString("ID"), rs.getString("Name"), rs.getDouble("Price"), 
                rs.getString("Status"), rs.getString("Email"), rs.getString("Address")
                , rs.getString("ITEM_1"), rs.getString("ITEM_2"), rs.getString("ITEM_3"));
            ordersList.add(order);
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){   
            }
        }}
     return ordersList;
    
}

public void find_order(){ //display the findorderlist() array list
        ArrayList<Orders> list = findorderList();
        DefaultTableModel model = (DefaultTableModel)Table_Or.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i=0; i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getPrice();    
            row[3]=list.get(i).getStatus();
            model.addRow(row);
        }
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Or = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Preparing = new javax.swing.JRadioButton();
        Shipping = new javax.swing.JRadioButton();
        Received = new javax.swing.JRadioButton();
        View = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Find = new javax.swing.JButton();
        ClrAll = new javax.swing.JButton();
        ShowAll = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        Calc = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ORDER");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Price");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Status");

        Table_Or.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Or.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_OrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Or);

        buttonGroup1.add(Preparing);
        Preparing.setText("Preparing");

        buttonGroup1.add(Shipping);
        Shipping.setText("Shipping");

        buttonGroup1.add(Received);
        Received.setText("Received");

        View.setText("View Deltails");
        View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewActionPerformed(evt);
            }
        });

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Find.setText("Find");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });

        ClrAll.setText("Clear All");
        ClrAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClrAllActionPerformed(evt);
            }
        });

        ShowAll.setText("Show All");
        ShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowAllActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Revenue");

        Calc.setText("Calc");
        Calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        reset.setText("Reset Data");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Find, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(View))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(ClrAll, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ID))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(Name))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Preparing, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Received, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Shipping, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Calc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Preparing))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Shipping)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Received)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Find)
                    .addComponent(Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowAll)
                    .addComponent(View))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(ClrAll))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Calc))
                .addContainerGap(23, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
        find_order();
    }//GEN-LAST:event_FindActionPerformed

    private void ClrAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClrAllActionPerformed
        ID.setText("");
        Name.setText("");
        Price.setText("");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_ClrAllActionPerformed

    private void Table_OrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_OrMouseClicked
//display the information of the chosen order from the mouse click in the table    
        int i = Table_Or.getSelectedRow();
        TableModel model = Table_Or.getModel();
        ID.setText(model.getValueAt(i,0).toString());
        Name.setText(model.getValueAt(i,1).toString());
        Price.setText(model.getValueAt(i,2).toString());
        String status = model.getValueAt(i,3).toString();
        if (status.equals("Preparing")){
            Preparing.setSelected(true);
         
        } else if (status.equals("Shipping")) {
            Shipping.setSelected(true);
        } else if (status.equals("Received")){
            Received.setSelected(true);
        }
    }//GEN-LAST:event_Table_OrMouseClicked

    private void ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewActionPerformed
        //viewdetails order procedure to display detailed information of the order in ViewDetails window
    ArrayList<Orders> vieworderList = new ArrayList<>();
     PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
    try {
        String sql = "SELECT * FROM order1 WHERE order1.ID LIKE? AND order1.Name LIKE?";
        pst = con.prepareStatement(sql);
        pst.setString(1,ID.getText());
        pst.setString(2,Name.getText());

        rs = pst.executeQuery();
        Orders order;
       
        while (rs.next()){
        order = new Orders (rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getString("Status"), rs.getString("Email"), rs.getString("Address"), rs.getString("ITEM_1"), rs.getString("ITEM_2"), rs.getString("ITEM_3"));
     
            vieworderList.add(order);
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
     

        new VIEWDETAILS(vieworderList).setVisible(true);
        
    }//GEN-LAST:event_ViewActionPerformed

    private void ShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowAllActionPerformed
         show_order();
    }//GEN-LAST:event_ShowAllActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
    
    //delete order procedure
        boolean flag;
    try {
        flag = order.deleteOrder(ID.getText(), Name.getText(), Price.getText());
    } catch (SQLException ex) {
        Logger.getLogger(ORDER.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if (flag = true){
        
        ID.setText("");
        Name.setText("");
        Price.setText("");
        buttonGroup1.clearSelection();
       jOptionPane1.showMessageDialog(null,"Deleted!");
       show_order();
    }
    
       
    
        
    
    }//GEN-LAST:event_DeleteActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        new AddOrder().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
    //update order procedure
        Preparing.setActionCommand("Preparing");
    Shipping.setActionCommand("Shipping");
    Received.setActionCommand("Received");
         String value1 = ID.getText();
         String value2 = Name.getText();
         String price1 = Price.getText();
         double value3 = Double.parseDouble(Price.getText());
         String value4 = buttonGroup1.getSelection().getActionCommand();
         if (value1.isEmpty() || value2.isEmpty() || value1.isEmpty() || value4.isEmpty()){
               jOptionPane1.showMessageDialog(null,"Missing Information");
         } else if(order.updateOrder(value1, value2, value3 , value4)){
             show_order();
              jOptionPane1.showMessageDialog(null,"Updated");
               ID.setText("");
        Name.setText("");
        Price.setText("");
        buttonGroup1.clearSelection();
             
         } else jOptionPane1.showMessageDialog(null,"ERROR: Please recheck the inputs!");
         
         
             
         
    }//GEN-LAST:event_UpdateActionPerformed

    private void CalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcActionPerformed
    //Revenue Calculation procedure
    //it fetches the price of the chosen/sorted order and sum it up
        double sum = 0;
    Preparing.setActionCommand("Preparing");
    Shipping.setActionCommand("Shipping");
    Received.setActionCommand("Received"); 
     PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        ArrayList<Orders> ordersList = new ArrayList<>();
           try {
        String sql = "SELECT * FROM order1 WHERE order1.Status LIKE?";
        pst = con.prepareStatement(sql);
       
        pst.setString(1,buttonGroup1.getSelection().getActionCommand());
        rs = pst.executeQuery();
        Orders order;
        
        while (rs.next()){
        order = new Orders (rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getString("Status"), rs.getString("Email"), rs.getString("Address"), rs.getString("ITEM_1"), rs.getString("ITEM_2"), rs.getString("ITEM_3"));
     
            ordersList.add(order);
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
            for (int i=0; i<ordersList.size();i++){    
                sum = sum + ordersList.get(i).getPrice();
            }
        priceField.setText("$"+sum);
         
    }//GEN-LAST:event_CalcActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
       //reset order procedure
        int response = jOptionPane1.showConfirmDialog(this, "Do you wish to continue?", "Confirm", jOptionPane1.YES_NO_OPTION, jOptionPane1.QUESTION_MESSAGE);
       
        if (response==jOptionPane1.YES_OPTION){
            order.resetOrder();
                jOptionPane1.showMessageDialog(null,"Updated!");
                show_order();
        }
    }//GEN-LAST:event_resetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Menu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ORDER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ORDER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Calc;
    private javax.swing.JButton ClrAll;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Find;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Name;
    private javax.swing.JRadioButton Preparing;
    private javax.swing.JTextField Price;
    private javax.swing.JRadioButton Received;
    private javax.swing.JRadioButton Shipping;
    private javax.swing.JButton ShowAll;
    private javax.swing.JTable Table_Or;
    private javax.swing.JButton Update;
    private javax.swing.JButton View;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
