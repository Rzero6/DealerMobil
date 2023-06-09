/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.PenjualanControl;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import control.CustomerControl;
import control.KendaraanControl;
import control.StaffControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Customer;
import model.Kendaraan;
import model.Penjualan;
import model.Staff;

/**
 *
 * 
 */
public class PenjualanView extends javax.swing.JInternalFrame {

    /**
     * Creates new form PembelianView
     */
    private PenjualanControl penjualanControl;
    private CustomerControl customerControl;
    private StaffControl staffControl;
    private KendaraanControl kendaraanControl;
    private int selectedID = 0;
    private List<Customer> listCustomer;
    private List<Kendaraan> listKendaraan;
    private List<Staff> listStaff;
    
    public PenjualanView() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        penjualanControl = new PenjualanControl();
        customerControl = new CustomerControl();
        staffControl = new StaffControl();
        kendaraanControl = new KendaraanControl();
        setTablePenjualan();
        setCustomerDropdown();
        setStaffDropdown();
        setKendaraanDropdown();
        setTotalHarga();
        confirmBtn.setEnabled(false);
        checkBoxListener();
        cashCheck.setActionCommand("Cash");
        kreditCheck.setActionCommand("Kredit");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jenisPembayaranGroup = new javax.swing.ButtonGroup();
        kendaraanDropdown = new javax.swing.JComboBox<>();
        customerDropdown = new javax.swing.JComboBox<>();
        staffDropdown = new javax.swing.JComboBox<>();
        totalHargaTxt = new javax.swing.JTextField();
        jumlahInput = new javax.swing.JSpinner();
        cashCheck = new javax.swing.JCheckBox();
        kreditCheck = new javax.swing.JCheckBox();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        kendaraanDropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kendaraanDropdownMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kendaraanDropdownMousePressed(evt);
            }
        });

        customerDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerDropdownActionPerformed(evt);
            }
        });

        totalHargaTxt.setText("0");
        totalHargaTxt.setEnabled(false);

        jumlahInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jumlahInputMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jumlahInputMousePressed(evt);
            }
        });

        jenisPembayaranGroup.add(cashCheck);
        cashCheck.setText("Cash");

        jenisPembayaranGroup.add(kreditCheck);
        kreditCheck.setText("Kredit");

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        tablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePenjualan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kendaraanDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalHargaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlahInput, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(confirmBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cashCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kreditCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {customerDropdown, kendaraanDropdown, staffDropdown});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jumlahInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalHargaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cashCheck)
                            .addComponent(kreditCheck))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmBtn)
                            .addComponent(cancelBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(kendaraanDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(staffDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jumlahInputMouseClicked

    }//GEN-LAST:event_jumlahInputMouseClicked

    private void kendaraanDropdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraanDropdownMouseClicked

    }//GEN-LAST:event_kendaraanDropdownMouseClicked

    private void jumlahInputMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jumlahInputMousePressed
        // TODO add your handling code here:
        setTotalHarga();
    }//GEN-LAST:event_jumlahInputMousePressed

    private void kendaraanDropdownMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kendaraanDropdownMousePressed
        // TODO add your handling code here:
        setTotalHarga();
    }//GEN-LAST:event_kendaraanDropdownMousePressed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        jenisPembayaranGroup.clearSelection();
        jumlahInput.setValue(0);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
        int selectedIndexKendaraan = kendaraanDropdown.getSelectedIndex();
        Kendaraan k = listKendaraan.get(selectedIndexKendaraan);
        int selectedIndexCustomer = customerDropdown.getSelectedIndex();
        Customer c = listCustomer.get(selectedIndexCustomer);
        int selectedIndexStaff = staffDropdown.getSelectedIndex();
        Staff s = listStaff.get(selectedIndexStaff);
        int jumlahMobil = (int) jumlahInput.getValue();
        if(k.getJumlah()>=jumlahMobil){
            Penjualan p = new Penjualan(k.getId(), c.getId(), s.getId(), Float.parseFloat(totalHargaTxt.getText()), jenisPembayaranGroup.getSelection().getActionCommand(), jumlahMobil);
            penjualanControl.insertPenjualan(p);
            kendaraanControl.updateJumlahKendaraan(k.getId(), jumlahMobil,"-");
            setTablePenjualan();
        }else{
            JOptionPane.showConfirmDialog(rootPane, "Stok mobil tidak cukup","Error",JOptionPane.DEFAULT_OPTION);
        }
        
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void customerDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerDropdownActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox cashCheck;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JComboBox<Customer> customerDropdown;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jenisPembayaranGroup;
    private javax.swing.JSpinner jumlahInput;
    private javax.swing.JComboBox<Kendaraan> kendaraanDropdown;
    private javax.swing.JCheckBox kreditCheck;
    private javax.swing.JComboBox<Staff> staffDropdown;
    private javax.swing.JTable tablePenjualan;
    private javax.swing.JTextField totalHargaTxt;
    // End of variables declaration//GEN-END:variables

    private void setTablePenjualan() {
        tablePenjualan.setModel(penjualanControl.getTablePenjualan(""));
    }

    private void setCustomerDropdown() {
        listCustomer = customerControl.getListCustomer("");
        for(Customer item : listCustomer){
            customerDropdown.addItem(item);
        }
    }

    private void setStaffDropdown() {
        listStaff = staffControl.getListStaff("");
        for(Staff item : listStaff){
            staffDropdown.addItem(item);
        }
    }

    private void setKendaraanDropdown() {
        listKendaraan = kendaraanControl.getListKendaraan("");
        for(Kendaraan item : listKendaraan){
            kendaraanDropdown.addItem(item);
        }
    }
    private void setTotalHarga(){
        kendaraanDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalHarga();
            }
        });
        jumlahInput.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) jumlahInput.getValue();
                if (value < 0) {
                    jumlahInput.setValue(0);
                }
                updateTotalHarga();
            }
        });
    }
    private void updateTotalHarga(){
        float totalHarga;
        int selectedIndexKendaraan = kendaraanDropdown.getSelectedIndex();
        Kendaraan k = listKendaraan.get(selectedIndexKendaraan);
        totalHarga=(k.getHarga() * (int)jumlahInput.getValue() * 110f/100f);
        if(totalHarga==0){
            totalHargaTxt.setText("0");
        }else{
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            String formattedValue = decimalFormat.format(totalHarga);
            totalHargaTxt.setText(formattedValue);
        }
        
    }
    private void checkBoxListener(){
        ActionListener checkBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jenisPembayaranGroup.getSelection()!=null){
                    confirmBtn.setEnabled(true);
                }else{
                    confirmBtn.setEnabled(false);
                }
            }
        };
        cashCheck.addActionListener(checkBoxListener);
        kreditCheck.addActionListener(checkBoxListener);
    }
}
