
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class STORAGE extends javax.swing.JFrame {

//public Connection con = null;
//public PreparedStatement pst = null;
//public ResultSet rs = null;
  DBConnection connection = new DBConnection();
public Storages storages = new Storages();
   
    public STORAGE() {
        initComponents();
        connection.connect();
        show_storage();
    }
    public ArrayList<Storages> storageList (){ //fetch data all of the items information in storage table in the database into an ArrayList
        ArrayList<Storages> storagesList = new ArrayList<>();
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        try {
            String sql = "SELECT * FROM storage";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()){
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getDouble("Quantity"), rs.getDouble("Price"), rs.getDouble("Size"));
                storagesList.add(storage);
                 
            }
        } catch (Exception e){
            System.out.println(e.toString());
            
        }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
        return storagesList;
    }
    public void show_storage(){ //display the arraylist in the storageList()function above in a GUI table
        ArrayList<Storages> list = storageList();
        DefaultTableModel model = (DefaultTableModel)Table_Sto.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i=0; i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getQuantity();    
            row[3]=list.get(i).getPrice();
            row[4]=list.get(i).getSize();
            model.addRow(row);
        }
    }
    public ArrayList<Storages> findstorageList (){ //fetch the chosen items'information in the storage table in the database to an ArrayList
        ArrayList<Storages> storagesList = new ArrayList<>();
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
       if (Price.getText().isEmpty()){
           
        try {
            String sql = "SELECT * FROM storage WHERE storage.ID LIKE ? OR storage.Name LIKE? OR storage.Size = ? OR storage.Price = ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1,ID.getText());
            pst.setString(2,Name.getText());
            pst.setString(3,Size.getText());
            pst.setString(4,Price.getText());
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()){
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getDouble("Quantity"), rs.getDouble("Price"), rs.getDouble("Size"));
                storagesList.add(storage);
                
            }
        } catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }} else{
           try {
            String sql = "SELECT * FROM storage WHERE storage.ID LIKE ? OR storage.Name LIKE? OR storage.Size = ? OR storage.Price <= ?;";
            pst = con.prepareStatement(sql);
            pst.setString(1,ID.getText());
            pst.setString(2,Name.getText());
            pst.setString(3,Size.getText());
            pst.setString(4,Price.getText());
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()){
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getDouble("Quantity"), rs.getDouble("Price"), rs.getDouble("Size"));
                storagesList.add(storage);
                
            }
        } catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
       }
        return storagesList; 
    }
    public void find_storage(){ //display the information in findStoragelist() in the table GUI
        ArrayList<Storages> list = findstorageList();
        DefaultTableModel model = (DefaultTableModel)Table_Sto.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i=0; i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getQuantity();    
            row[3]=list.get(i).getPrice();
            row[4]=list.get(i).getSize();
            model.addRow(row);
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Quantity = new javax.swing.JTextField();
        addbut = new javax.swing.JButton();
        deletebut = new javax.swing.JButton();
        updatebut = new javax.swing.JButton();
        findbut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Sto = new javax.swing.JTable();
        showall = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Size = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("STORAGE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Price");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        addbut.setText("ADD");
        addbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbutActionPerformed(evt);
            }
        });

        deletebut.setText("DELETE");
        deletebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebutActionPerformed(evt);
            }
        });

        updatebut.setText("UPDATE");
        updatebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebutActionPerformed(evt);
            }
        });

        findbut.setText("FIND");
        findbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findbutActionPerformed(evt);
            }
        });

        Table_Sto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Sto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_StoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_Sto);

        showall.setText("Show All");
        showall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showallActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Size");

        jButton1.setText("Clear All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Price, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Quantity, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(ID))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(Name))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(Size))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(updatebut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addbut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(deletebut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(findbut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(showall, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
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
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletebut)
                    .addComponent(addbut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findbut)
                    .addComponent(updatebut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showall)
                    .addComponent(jButton1))
                .addContainerGap(34, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table_StoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_StoMouseClicked
       //display corresponding information of chosen items from the table in the textfields
        int i = Table_Sto.getSelectedRow();
        TableModel model = Table_Sto.getModel();
        ID.setText(model.getValueAt(i,0).toString());
        Name.setText(model.getValueAt(i,1).toString());
        Price.setText(model.getValueAt(i,2).toString());
        Quantity.setText(model.getValueAt(i,3).toString());
        Size.setText(model.getValueAt(i,4).toString());
    }//GEN-LAST:event_Table_StoMouseClicked

    private void updatebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebutActionPerformed
        //update procedure
        String value1 = ID.getText();
         String value2 = Name.getText();
         String value3 = Price.getText();
         String value4 = Quantity.getText();
         String value5 = Size.getText();
         if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty() || value4.isEmpty() || value5.isEmpty()){
               jOptionPane1.showMessageDialog(null,"Missing Information");
         }
         else {
      
        
                storages.updateStorage(ID.getText(), Name.getText(), Double.parseDouble(Price.getText()), Double.parseDouble(Quantity.getText()) ,  Double.parseDouble(Size.getText()));
             jOptionPane1.showMessageDialog(null,"Updated!");
           show_storage();
        } 
         
         
     
            
        
         
    }//GEN-LAST:event_updatebutActionPerformed

    private void addbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbutActionPerformed
        //add new items procedure
        String value1 = ID.getText();
         String value2 = Name.getText();
         String value3 = Price.getText();
         String value4 = Quantity.getText();
         String value5 = Size.getText();
         PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
         if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty() || value4.isEmpty() || value5.isEmpty()){
               jOptionPane1.showMessageDialog(null,"Missing Information");
         }
         else {
             String sql = "SELECT * from storage WHERE storage.ID LIKE? ;";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,ID.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
              jOptionPane1.showMessageDialog(null,"ID has been used"); 
             
            } else {
                 jOptionPane1.showMessageDialog(null,"Added"); 
                 try {
                     String sl = "INSERT INTO History(Action) VALUES (?)";
                            pst = con.prepareStatement(sl);
                            pst.setString(1,"Add new item to storage:"+value1);
                            pst.execute();
                            System.out.println("added");
                 } catch (Exception e){
                     
                 }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
            } 
                }
        catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }finally{
            try{
                rs.close();
                pst.close();
            }catch (Exception e){
                
            }
        }
        storages.addStorage(value1, value2, value3, value4, value5);
        show_storage();
        
        
        
         }
        
    }//GEN-LAST:event_addbutActionPerformed

    private void findbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findbutActionPerformed
      //sort items list procedure
        find_storage();
    }//GEN-LAST:event_findbutActionPerformed

    private void showallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showallActionPerformed
       //show the original items table
        show_storage();
    }//GEN-LAST:event_showallActionPerformed

    private void deletebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebutActionPerformed
      //delete the item in the storage table
        storages.deleteStorage(ID.getText(), Name.getText(), Price.getText(), Quantity.getText(), Size.getText());
        
        jOptionPane1.showMessageDialog(null,"Deleted"); 
        
      show_storage();
        
         ID.setText("");
         Name.setText("");
         Price.setText("");
         Quantity.setText("");
         Size.setText("");
    }//GEN-LAST:event_deletebutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ID.setText("");
         Name.setText("");
         Price.setText("");
         Quantity.setText("");
         Size.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Menu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

   
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
            java.util.logging.Logger.getLogger(STORAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STORAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STORAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STORAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STORAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField Quantity;
    private javax.swing.JTextField Size;
    private javax.swing.JTable Table_Sto;
    private javax.swing.JButton addbut;
    private javax.swing.JButton deletebut;
    private javax.swing.JButton findbut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton showall;
    private javax.swing.JButton updatebut;
    // End of variables declaration//GEN-END:variables
}
