/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ADMIN
 */
public class Users extends javax.swing.JFrame {

    /**
     * Creates new form Users
     */
    public Users() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        Sine_Panel = new javax.swing.JPanel();
        Freq_Sine = new javax.swing.JSlider();
        Freq_Sine_Label = new javax.swing.JLabel();
        Amp_Sine = new javax.swing.JSlider();
        Amp_Sine_Label = new javax.swing.JLabel();
        Freq_Test = new javax.swing.JLabel();
        Amp_Test = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Rectangular_Panel = new javax.swing.JPanel();
        Mod_Rectangular = new javax.swing.JSlider();
        Mod_Rectangular_Label = new javax.swing.JLabel();
        Mod_Test = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Sawtooth_Panel = new javax.swing.JPanel();
        Freq_Sawtooth = new javax.swing.JSlider();
        Freq_Sawtooth_Label = new javax.swing.JLabel();
        Freq_Sawtooth_Test = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Apply_Button = new javax.swing.JButton();
        Close_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Signal Generator");

        jTabbedPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Freq_Sine.setMajorTickSpacing(100);
        Freq_Sine.setMinorTickSpacing(10);
        Freq_Sine.setPaintLabels(true);
        Freq_Sine.setPaintTicks(true);
        Freq_Sine.setValue(0);
        Freq_Sine.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Freq_SineStateChanged(evt);
            }
        });

        Freq_Sine_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Freq_Sine_Label.setText("FREQUENCY (Hz)");

        Amp_Sine.setMajorTickSpacing(100);
        Amp_Sine.setMinorTickSpacing(10);
        Amp_Sine.setPaintLabels(true);
        Amp_Sine.setPaintTicks(true);
        Amp_Sine.setToolTipText("");
        Amp_Sine.setValue(0);
        Amp_Sine.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Amp_SineStateChanged(evt);
            }
        });

        Amp_Sine_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Amp_Sine_Label.setText("AMPLITUDE");

        Freq_Test.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Freq_Test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Freq_Test.setText("0");
        Freq_Test.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Amp_Test.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Amp_Test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Amp_Test.setText("0");
        Amp_Test.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Sine_PanelLayout = new javax.swing.GroupLayout(Sine_Panel);
        Sine_Panel.setLayout(Sine_PanelLayout);
        Sine_PanelLayout.setHorizontalGroup(
            Sine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sine_PanelLayout.createSequentialGroup()
                .addGroup(Sine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Sine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Sine_PanelLayout.createSequentialGroup()
                            .addComponent(Freq_Sine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Freq_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Sine_PanelLayout.createSequentialGroup()
                            .addComponent(Amp_Sine, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Amp_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Sine_PanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(Freq_Sine_Label))
                    .addGroup(Sine_PanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(Amp_Sine_Label)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Sine_PanelLayout.setVerticalGroup(
            Sine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sine_PanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Freq_Sine_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Sine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Freq_Sine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Freq_Test))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(Amp_Sine_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Sine_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Amp_Sine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amp_Test))
                .addGap(46, 46, 46))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Sine", Sine_Panel);

        Mod_Rectangular.setMajorTickSpacing(100);
        Mod_Rectangular.setMinorTickSpacing(10);
        Mod_Rectangular.setPaintLabels(true);
        Mod_Rectangular.setPaintTicks(true);
        Mod_Rectangular.setValue(0);
        Mod_Rectangular.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Mod_RectangularStateChanged(evt);
            }
        });

        Mod_Rectangular_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Mod_Rectangular_Label.setText("MODULATION ");

        Mod_Test.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Mod_Test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Mod_Test.setText("0");
        Mod_Test.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Rectangular_PanelLayout = new javax.swing.GroupLayout(Rectangular_Panel);
        Rectangular_Panel.setLayout(Rectangular_PanelLayout);
        Rectangular_PanelLayout.setHorizontalGroup(
            Rectangular_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Rectangular_PanelLayout.createSequentialGroup()
                .addGroup(Rectangular_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Rectangular_PanelLayout.createSequentialGroup()
                        .addComponent(Mod_Rectangular, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Mod_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(Rectangular_PanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(Mod_Rectangular_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Rectangular_PanelLayout.setVerticalGroup(
            Rectangular_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Rectangular_PanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(Mod_Rectangular_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Rectangular_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mod_Rectangular, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Mod_Test))
                .addContainerGap(297, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Rectangular", Rectangular_Panel);

        Freq_Sawtooth.setMajorTickSpacing(100);
        Freq_Sawtooth.setMinorTickSpacing(10);
        Freq_Sawtooth.setPaintLabels(true);
        Freq_Sawtooth.setPaintTicks(true);
        Freq_Sawtooth.setValue(0);
        Freq_Sawtooth.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Freq_Sawtooth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Freq_SawtoothStateChanged(evt);
            }
        });

        Freq_Sawtooth_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Freq_Sawtooth_Label.setText("FREQUENCY (Hz)");

        Freq_Sawtooth_Test.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Freq_Sawtooth_Test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Freq_Sawtooth_Test.setText("0");
        Freq_Sawtooth_Test.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Sawtooth_PanelLayout = new javax.swing.GroupLayout(Sawtooth_Panel);
        Sawtooth_Panel.setLayout(Sawtooth_PanelLayout);
        Sawtooth_PanelLayout.setHorizontalGroup(
            Sawtooth_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sawtooth_PanelLayout.createSequentialGroup()
                .addGroup(Sawtooth_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Sawtooth_PanelLayout.createSequentialGroup()
                        .addComponent(Freq_Sawtooth, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Freq_Sawtooth_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(Sawtooth_PanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Freq_Sawtooth_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Sawtooth_PanelLayout.setVerticalGroup(
            Sawtooth_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sawtooth_PanelLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(Freq_Sawtooth_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Sawtooth_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Freq_Sawtooth_Test)
                    .addComponent(Freq_Sawtooth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(299, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Saw Tooth", Sawtooth_Panel);

        Apply_Button.setText("Apply");
        Apply_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apply_ButtonActionPerformed(evt);
            }
        });

        Close_Button.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Apply_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(Close_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apply_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Close_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("");
        jTabbedPane3.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Apply_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apply_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apply_ButtonActionPerformed

    private void Freq_SineStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Freq_SineStateChanged
        // TODO add your handling code here:
        Freq_Test.setText(Integer.toString(Freq_Sine.getValue()));
    }//GEN-LAST:event_Freq_SineStateChanged

    private void Amp_SineStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Amp_SineStateChanged
        // TODO add your handling code here:
        Amp_Test.setText(Integer.toString(Amp_Sine.getValue()));

    }//GEN-LAST:event_Amp_SineStateChanged

    private void Mod_RectangularStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Mod_RectangularStateChanged
        // TODO add your handling code here:
         Mod_Test.setText(Integer.toString(Mod_Rectangular.getValue()));
    }//GEN-LAST:event_Mod_RectangularStateChanged

    private void Freq_SawtoothStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Freq_SawtoothStateChanged
        // TODO add your handling code here:
        Freq_Sawtooth_Test.setText(Integer.toString(Freq_Sawtooth.getValue()));
    }//GEN-LAST:event_Freq_SawtoothStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }   
            } catch (ClassNotFoundException ex) {
                   java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                 java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
       /* Create and display the form */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider Amp_Sine;
    private javax.swing.JLabel Amp_Sine_Label;
    private javax.swing.JLabel Amp_Test;
    private javax.swing.JButton Apply_Button;
    private javax.swing.JButton Close_Button;
    private javax.swing.JSlider Freq_Sawtooth;
    private javax.swing.JLabel Freq_Sawtooth_Label;
    private javax.swing.JLabel Freq_Sawtooth_Test;
    private javax.swing.JSlider Freq_Sine;
    private javax.swing.JLabel Freq_Sine_Label;
    private javax.swing.JLabel Freq_Test;
    private javax.swing.JSlider Mod_Rectangular;
    private javax.swing.JLabel Mod_Rectangular_Label;
    private javax.swing.JLabel Mod_Test;
    private javax.swing.JPanel Rectangular_Panel;
    private javax.swing.JPanel Sawtooth_Panel;
    private javax.swing.JPanel Sine_Panel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables
}