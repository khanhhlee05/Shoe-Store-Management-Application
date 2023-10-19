
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AddOrder extends javax.swing.JFrame {

//   public Connection con = null;
//    public PreparedStatement pst = null;
//    public ResultSet rs = null;
    Orders order = new Orders();
 DBConnection connection = new DBConnection();
    public AddOrder() {
        initComponents();
        connection.connect();
        show_storage();
    }

    public ArrayList<Storages> storageList() { //fetch all of the data from the storage table in the database to an ArrayList
                PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        ArrayList<Storages> storagesList = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM storage";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()) {
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getDouble("Quantity"), rs.getDouble("Price"), rs.getDouble("Size"));
                storagesList.add(storage);

            }
        } catch (Exception e) {
            System.out.println(e.toString());

        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
        return storagesList;
    }

    public void show_storage() { //Display the data fetched in the storageList() function in a GUI table
        ArrayList<Storages> list = storageList();
        DefaultTableModel model = (DefaultTableModel) Table_Sto.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getQuantity();
            row[3] = list.get(i).getPrice();
            row[4] = list.get(i).getSize();
            model.addRow(row);
        }
    }

    public ArrayList<Storages> findstorageList() { //fetch the chosen data from the storage table in the database to an ArrayList
                PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
        ArrayList<Storages> storagesList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM storage WHERE storage.ID LIKE ? ;";
            pst = con.prepareStatement(sql);
            pst.setString(1, IDfind.getText());

            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()) {
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getDouble("Quantity"), rs.getDouble("Price"), rs.getDouble("Size"));
                storagesList.add(storage);

            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
        return storagesList;
    }

    public void find_storage() { //Display the data fetched in the findstorageList() function in a GUI table
        ArrayList<Storages> list = findstorageList();
        DefaultTableModel model = (DefaultTableModel) Table_Sto.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getID();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getQuantity();
            row[3] = list.get(i).getPrice();
            row[4] = list.get(i).getSize();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Sto = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        Name = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Address = new javax.swing.JTextField();
        ITEM_1 = new javax.swing.JTextField();
        ITEM_2 = new javax.swing.JTextField();
        ITEM_3 = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        IDfind = new javax.swing.JTextField();
        Find = new javax.swing.JButton();
        showall = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREATE NEW ORDER");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Committed Price");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Address");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("ITEM_1");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("ITEM_2");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("ITEM_3");

        Table_Sto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        jScrollPane1.setViewportView(Table_Sto);

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        Add.setText("Create");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Clear.setText("Clear ");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel12.setText("ITEM ID FINDER");

        Find.setText("Find");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });

        showall.setText("Show All");
        showall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showallActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("CHOOSE ITEM");

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
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ITEM_1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ITEM_2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ITEM_3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13))
                                .addGap(6, 6, 6))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Add)
                            .addGap(18, 18, 18)
                            .addComponent(Clear)
                            .addGap(18, 18, 18)
                            .addComponent(showall))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(IDfind, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Find, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ITEM_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ITEM_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ITEM_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Clear)
                    .addComponent(showall))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(IDfind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Find))
                .addGap(15, 15, 15))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
// Fetching variables from the textfields      
        String id = ID.getText();
        String name = Name.getText();
        String price = Price.getText();
        String email = Email.getText();
        String address = Address.getText();
        String item1 = ITEM_1.getText();
        String item2 = ITEM_2.getText();
        String item3 = ITEM_3.getText();
        double value1 = 1;
        double value2 = 1;
        double value3 = 1;
        PreparedStatement pst = connection.pst;
                Connection con = connection.con;
                ResultSet rs = connection.rs;
                // Adding procedure of the application
        try {
            String sqr = "SELECT * FROM storage WHERE storage.ID LIKE ?;"; // fetching the quantity of item1
            pst = con.prepareStatement(sqr);
            pst.setString(1, ITEM_1.getText());
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()) {
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("Size"));
                System.out.println(storage.getQuantity());

                value1 = storage.getQuantity();
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
        try {
            String sqr = "SELECT * FROM storage WHERE storage.ID LIKE ?;"; // fetching the quantity of item2
            pst = con.prepareStatement(sqr);
            pst.setString(1, ITEM_2.getText());
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()) {
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("Size"));
                System.out.println(storage.getQuantity());

                value2 = storage.getQuantity();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
        try {
            String sqr = "SELECT * FROM storage WHERE storage.ID LIKE ?;"; // fetching the quantity of item3
            pst = con.prepareStatement(sqr);
            pst.setString(1, ITEM_3.getText());
            rs = pst.executeQuery();
            Storages storage;
            while (rs.next()) {
                storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("Size"));
                System.out.println(storage.getQuantity());

                value3 = storage.getQuantity();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }

        if (value1 > 0 && value2 > 0 && value3 > 0) { //check the quantity just fetched from above. If the values > 0, then start to add
            if (id.isEmpty() || name.isEmpty() || price.isEmpty() || email.isEmpty() || address.isEmpty() || item1.isEmpty() && item2.isEmpty() && item3.isEmpty()) {
                jOptionPane1.showMessageDialog(null, "Error: Missing information"); //display information when missing textfield
            } else {
               order.createOrder(id, name, price, email, address, item1, item2, item3);
                String sql = "SELECT * from order1 WHERE order1.ID LIKE? AND order1.Name LIKE? and order1.Address LIKE?;";
                try {
                    pst = con.prepareStatement(sql);
                    pst.setString(1, id);
                    pst.setString(2, name);
                    pst.setString(3, address);

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        jOptionPane1.showMessageDialog(null, "Add Successful");
                        try {
                            String sl = "INSERT INTO History(Action) VALUES (?)";
                            pst = con.prepareStatement(sl);
                            pst.setString(1,"Add new order id: "+id);
                            pst.execute();
                            System.out.println("added");
                            
                            
                        } catch (Exception e){
                            
                        }finally {
                    try {
                        rs.close();
                        pst.close();
                    } catch (Exception e) {

                    }
                }
                        if (!item1.isEmpty()) {
                            try {
                                String sqr = "SELECT * FROM storage WHERE storage.ID LIKE ?;"; //method auto update quantity of added item
                                pst = con.prepareStatement(sqr);
                                pst.setString(1, ITEM_1.getText());
                                rs = pst.executeQuery();
                                Storages storage;
                                while (rs.next()) {
                                    storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("Size"));
                                    System.out.println(storage.getQuantity());
                                    value1 = storage.getQuantity();
                                }
                            } catch (Exception e) {
                                System.out.println(e.toString());
                                e.printStackTrace();
                            } finally {
                                try {
                                    rs.close();
                                    pst.close();
                                } catch (Exception e) {

                                }
                            }
                            try {

                                value1 = value1 - 1.0; //auto update the quantity of the added items

                                String sq = "UPDATE storage SET Quantity = '" + value1 + "' WHERE ID = '" + item1 + "'";
                                pst = con.prepareStatement(sq);
                                pst.execute();

                                show_storage();

                            } catch (Exception e) {
                                System.out.println(e.toString());
                            } finally {
                                try {
                                    rs.close();
                                    pst.close();
                                } catch (Exception e) {

                                }
                            }
                        }
                        if (!item2.isEmpty()) {
                            try {
                                String sq = "SELECT * FROM storage WHERE storage.ID LIKE ?;"; //method auto update quantity of added item
                                pst = con.prepareStatement(sq);
                                pst.setString(1, ITEM_2.getText());
                                rs = pst.executeQuery();
                                Storages storage;
                                while (rs.next()) {
                                    storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("Size"));
                                    System.out.println(storage.getQuantity());
                                    value2 = storage.getQuantity();
                                }
                            } catch (Exception e) {
                                System.out.println(e.toString());
                                e.printStackTrace();
                            } finally {
                                try {
                                    rs.close();
                                    pst.close();
                                } catch (Exception e) {

                                }
                            }
                            try {

                                value2 = value2 - 1.0; //auto update the quantity of the added items

                                String sq = "UPDATE storage SET Quantity = '" + value2 + "' WHERE ID = '" + item2 + "'";
                                pst = con.prepareStatement(sq);
                                pst.execute();

                                show_storage();

                            } catch (Exception e) {
                                System.out.println(e.toString());
                            } finally {
                                try {
                                    rs.close();
                                    pst.close();
                                } catch (Exception e) {

                                }
                            }
                        }
                        if (!item3.isEmpty()) {
                            try {
                                String sqr = "SELECT * FROM storage WHERE storage.ID LIKE ?;"; //method auto update quantity of added item
                                pst = con.prepareStatement(sqr);
                                pst.setString(1, ITEM_3.getText());
                                rs = pst.executeQuery();
                                Storages storage;
                                while (rs.next()) {
                                    storage = new Storages(rs.getString("ID"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Quantity"), rs.getInt("Size"));
                                    System.out.println(storage.getQuantity());

                                    value3 = storage.getQuantity();
                                }
                            } catch (Exception e) {
                                System.out.println(e.toString());
                                e.printStackTrace();
                            } finally {
                                try {
                                    rs.close();
                                    pst.close();
                                } catch (Exception e) {

                                }
                            }
                            try {

                                value3 = value3 - 1.0; //auto update the quantity of the added items

                                String sq = "UPDATE storage SET Quantity = '" + value3 + "' WHERE ID = '" + item3 + "'";
                                pst = con.prepareStatement(sq);
                                pst.execute();

                                show_storage();

                            } catch (Exception e) {
                                System.out.println(e.toString());
                            } finally {
                                try {
                                    rs.close();
                                    pst.close();
                                } catch (Exception e) {

                                }
                            }
                        }

                    } 
                    else {
                        jOptionPane1.showMessageDialog(null, "ERROR: ID IS USED");
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                    e.printStackTrace();
                } finally {
                    try {
                        rs.close();
                        pst.close();
                    } catch (Exception e) {

                    }
                }

            }
        } else
            jOptionPane1.showMessageDialog(null, "ERROR: PLEASE CHECK THE STORAGE. ITEMS ARE OUT OF ORDER");
        
        if (value1 < 0 || value2 < 0 || value3 <0 ){
            jOptionPane1.showMessageDialog(null, "ERROR: PLEASE REVIEW ORDER__" + id + "__ITEMS ARE OUT OF STOCK");
        }
        
      
    }//GEN-LAST:event_AddActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void Table_StoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_StoMouseClicked
      //display information in the textfield when click in the table
        int i = Table_Sto.getSelectedRow();
        TableModel model = Table_Sto.getModel();
        if (ITEM_1.getText().isEmpty()) {
            ITEM_1.setText(model.getValueAt(i, 0).toString());
        } else if (ITEM_2.getText().isEmpty()) {
            ITEM_2.setText(model.getValueAt(i, 0).toString());
        } else if (ITEM_3.getText().isEmpty()) {
            ITEM_3.setText(model.getValueAt(i, 0).toString());
        }

    }//GEN-LAST:event_Table_StoMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ITEM_1.setText(""); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ITEM_2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ITEM_3.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindActionPerformed
;        find_storage();
    }//GEN-LAST:event_FindActionPerformed

    private void showallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showallActionPerformed
        show_storage();
    }//GEN-LAST:event_showallActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        ID.setText("");
        Name.setText("");
        Price.setText("");
        Email.setText("");
        Address.setText("");
        ITEM_1.setText("");
        ITEM_2.setText("");
        ITEM_3.setText("");

    }//GEN-LAST:event_ClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ORDER().setVisible(true);
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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField Address;
    private javax.swing.JButton Clear;
    private javax.swing.JTextField Email;
    private javax.swing.JButton Find;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField IDfind;
    private javax.swing.JTextField ITEM_1;
    private javax.swing.JTextField ITEM_2;
    private javax.swing.JTextField ITEM_3;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Price;
    private javax.swing.JTable Table_Sto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton showall;
    // End of variables declaration//GEN-END:variables
}
