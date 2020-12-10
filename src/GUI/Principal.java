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
        automatas.put("Default AFD", new AFD("default.dfa"));
        automatas.put("Default AFPD", new AFPD("default.dpda"));
        automatas.put("Default AFPN", new AFPN("default.pda"));
        automatas.put("Default AF2P", new AF2P("default.msm"));
        automatas.put("Default MT", new MT("default.mt"));
        automatas.put("Default MTP", new MTP("default.ttm"));
        automatas.put("Default MTMC", new MTMC("default.mttm"));
        automatas.put("Default MTN", new MTN("default.ntm"));
        setLocationRelativeTo(null);
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
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEvaluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(750, 550));

        jpPrincipal.setBackground(new java.awt.Color(0, 153, 153));
        jpPrincipal.setPreferredSize(new java.awt.Dimension(750, 510));

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 40));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEvaluar.setText("Evaluar");
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEvaluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addContainerGap(434, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnEvaluar))
                .addContainerGap())
        );

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

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpPrincipal;
    // End of variables declaration//GEN-END:variables
}
