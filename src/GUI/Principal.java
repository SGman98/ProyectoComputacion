package GUI;

import GUI.Recursos.Funciones;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import src.automatas.*;

public class Principal extends javax.swing.JFrame {

    Funciones f = new Funciones();
    Agregar agregar;
    Eliminar eliminar;
    Evaluar evaluar;
    Modificar modificar;
    HashMap<String, Automata> automatas = new HashMap<>();

    public Principal() {
        initComponents();
        setTitle("ITC_UN_app");
        javax.swing.JLabel logo = new javax.swing.JLabel();
        logo.setSize(1000, 1000);
        setIconImage(f.setImageBackground("/imagenes/logo.png", logo).getImage());
        this.logo.setIcon(f.setImageBackground("/imagenes/logo.png", this.logo));
        f.setStyleJButonMenu(btnAgregar);
        f.setStyleJButonMenu(btnEliminar);
        f.setStyleJButonMenu(btnEvaluar);
        f.setStyleJButonMenu(btnModificar);
        automatas.put("Default AFD", new AFD("default.dfa"));
        automatas.put("Default AFPD", new AFPD("default.dpda"));
        automatas.put("Default AFPN", new AFPN("default.pda"));
        automatas.put("Default AF2P", new AF2P("default.msm"));
        automatas.put("Default MT", new MT("default.mt"));
        automatas.put("Default MTP", new MTP("default.ttm"));
        automatas.put("Default MTMC", new MTMC("default.mttm"));
        automatas.put("Default MTN", new MTN("default.ntm"));
        setLocationRelativeTo(null);
        setResizable(false);
        agregar = new Agregar(automatas);
        agregar.setBounds(jpPrincipal.getBounds());
        add(agregar);
        agregar.setVisible(false);
        eliminar = new Eliminar(automatas);
        eliminar.setBounds(jpPrincipal.getBounds());
        add(eliminar);
        eliminar.setVisible(false);
        evaluar = new Evaluar(automatas);
        evaluar.setBounds(jpPrincipal.getBounds());
        add(evaluar);
        evaluar.setVisible(false);
        modificar = new Modificar(automatas);
        modificar.setBounds(jpPrincipal.getBounds());
        add(modificar);
        modificar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPrincipal = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(750, 550));

        jpPrincipal.setBackground(new java.awt.Color(3, 25, 38));
        jpPrincipal.setPreferredSize(new java.awt.Dimension(750, 510));

        logo.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ITC_UN_App");

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(157, 190, 187));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 40));
        jPanel1.setLayout(new java.awt.GridLayout());

        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(75, 25));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setPreferredSize(new java.awt.Dimension(75, 25));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        btnModificar.setText("Modificar");
        btnModificar.setPreferredSize(new java.awt.Dimension(75, 25));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);

        btnEvaluar.setText("Evaluar");
        btnEvaluar.setPreferredSize(new java.awt.Dimension(75, 25));
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEvaluar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        jpPrincipal.setVisible(false);
        eliminar.setVisible(true);
        agregar.setVisible(false);
        evaluar.setVisible(false);
        modificar.setVisible(false);
        if (automatas.isEmpty()) {
            eliminar.allEmpty();
        } else {

            eliminar.cbAutomata.removeAllItems();
            for (String s : automatas.keySet()) {
                eliminar.cbAutomata.addItem(s);
            }
            eliminar.updateValues((String) automatas.keySet().toArray()[0]);

        }
        revalidate();
        repaint();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        jpPrincipal.setVisible(false);
        eliminar.setVisible(false);
        agregar.setVisible(true);
        evaluar.setVisible(false);
        modificar.setVisible(false);
        agregar.allEmpty();
        revalidate();
        repaint();

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed
        jpPrincipal.setVisible(false);
        eliminar.setVisible(false);
        agregar.setVisible(false);
        modificar.setVisible(false);
        evaluar.setVisible(true);
        evaluar.allEmpty();
        if (!automatas.isEmpty()) {
            evaluar.cbAutomata.removeAllItems();
            for (String s : automatas.keySet()) {
                evaluar.cbAutomata.addItem(s);
            }
        }
        revalidate();
        repaint();
    }//GEN-LAST:event_btnEvaluarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        jpPrincipal.setVisible(false);
        eliminar.setVisible(false);
        agregar.setVisible(false);
        modificar.setVisible(true);
        evaluar.setVisible(false);
        if (automatas.isEmpty()) {
            modificar.allEmpty();
        } else {

            modificar.cbAutomata.removeAllItems();
            for (String s : automatas.keySet()) {
                modificar.cbAutomata.addItem(s);
            }
            modificar.updateValues((String) automatas.keySet().toArray()[0]);

        }
        revalidate();
        repaint();
    }//GEN-LAST:event_btnModificarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
