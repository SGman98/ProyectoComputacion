package GUI;

import GUI.Recursos.Funciones;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import src.automatas.*;

public class Eliminar extends javax.swing.JPanel {

    HashMap<String, Automata> automatas = new HashMap<>();
    Funciones f = new Funciones();

    public Eliminar(HashMap<String, Automata> automatas) {
        initComponents();
        this.automatas = automatas;
        allEmpty();
        f.setStyleJButon(btnAceptar);
        if (!this.automatas.isEmpty()) {
            cbAutomata.removeAllItems();
            for (String s : automatas.keySet()) {
                cbAutomata.addItem(s);
            }
            updateValues((String) automatas.keySet().toArray()[0]);
        }
    }

    public void allEmpty() {
        f.setStyleJTextField(txtAceptacion);
        f.setStyleJTextField(txtEstados);
        f.setStyleJTextField(txtGamma);
        f.setStyleJTextField(txtTipo);
        f.setStyleJTextField(txtInicial);
        f.setStyleJTextField(txtSigma);
        f.setStyleJTextArea(txtTransiciones, jScrollPane1);
        f.setStyleJComboBox(cbAutomata);

        txtAceptacion.setText("");
        txtEstados.setText("");
        txtGamma.setText("");
        txtTipo.setText("");
        txtSigma.setText("");
        txtTransiciones.setText("");
        txtInicial.setText("");
        txtInicial.setEditable(false);
        txtAceptacion.setEditable(false);
        txtEstados.setEditable(false);
        txtGamma.setEditable(false);
        txtTipo.setEditable(false);
        txtSigma.setEditable(false);
        txtTransiciones.setEditable(false);
        jScrollPane1.setEnabled(false);
        cbAutomata.removeAllItems();
        cbAutomata.addItem("Ingresar nuevos automatas");

    }

    String transiciones(HashMap hm) {
        String string = hm.toString().replaceAll("\\], ", "\n")
                .replaceAll("=\\[", "~").replaceAll(", ", ";")
                .replaceAll("\\{", "").replaceAll("\\]\\}", "");
        return string;
    }

    public void updateValues(String s) {
        Automata automata = automatas.get(s);
        if (automata != null) {
            txtTipo.setText(automata.getClass().getName().replaceAll("src.automatas.", ""));
            txtAceptacion.setText(automata.getEstadosAceptacion().toString().replace("[", "").replace("]", ""));
            txtEstados.setText(automata.getEstados().toString().replace("[", "").replace("]", ""));
            if (!automata.getClass().getName().replaceAll("src.automatas.", "").equals("AFD")) {
                txtGamma.setText(automata.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            } else {
                txtGamma.setText("");
            }
            txtSigma.setText(automata.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(automata.getTransiciones()));
            txtInicial.setText(automata.getEstadoInicial());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAceptacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbAutomata = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtSigma = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTransiciones = new javax.swing.JTextArea();
        txtEstados = new javax.swing.JTextField();
        jlGamma = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGamma = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        txtInicial = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 0, 0));
        setPreferredSize(new java.awt.Dimension(750, 510));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Automata");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(130, 30));
        add(jLabel2);
        jLabel2.setBounds(383, 124, 130, 30);

        txtTipo.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtTipo.setPreferredSize(new java.awt.Dimension(175, 30));
        add(txtTipo);
        txtTipo.setBounds(517, 122, 175, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Alfabeto Sigma");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setPreferredSize(new java.awt.Dimension(175, 30));
        add(jLabel3);
        jLabel3.setBounds(10, 198, 175, 30);

        txtAceptacion.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtAceptacion.setPreferredSize(new java.awt.Dimension(175, 30));
        add(txtAceptacion);
        txtAceptacion.setBounds(190, 230, 175, 30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Estado Inicial");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setPreferredSize(new java.awt.Dimension(130, 30));
        add(jLabel4);
        jLabel4.setBounds(383, 161, 130, 30);

        cbAutomata.setFont(new java.awt.Font("Leelawadee UI", 0, 9)); // NOI18N
        cbAutomata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cbAutomata.setPreferredSize(new java.awt.Dimension(175, 30));
        cbAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutomataActionPerformed(evt);
            }
        });
        add(cbAutomata);
        cbAutomata.setBounds(190, 123, 175, 30);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Estados De Aceptacion");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setPreferredSize(new java.awt.Dimension(175, 30));
        add(jLabel6);
        jLabel6.setBounds(10, 236, 175, 30);

        txtSigma.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtSigma.setPreferredSize(new java.awt.Dimension(175, 30));
        add(txtSigma);
        txtSigma.setBounds(190, 196, 175, 30);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Transiciones");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setPreferredSize(new java.awt.Dimension(175, 30));
        add(jLabel7);
        jLabel7.setBounds(10, 270, 175, 30);

        txtTransiciones.setColumns(20);
        txtTransiciones.setRows(5);
        txtTransiciones.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtTransiciones);

        add(jScrollPane1);
        jScrollPane1.setBounds(190, 270, 500, 163);

        txtEstados.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtEstados.setPreferredSize(new java.awt.Dimension(175, 30));
        add(txtEstados);
        txtEstados.setBounds(190, 159, 175, 30);

        jlGamma.setBackground(new java.awt.Color(255, 255, 255));
        jlGamma.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jlGamma.setForeground(new java.awt.Color(255, 255, 255));
        jlGamma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlGamma.setText("Alfabeto Gamma");
        jlGamma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlGamma.setPreferredSize(new java.awt.Dimension(130, 30));
        add(jlGamma);
        jlGamma.setBounds(383, 198, 130, 30);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Automata Disponibles");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setPreferredSize(new java.awt.Dimension(175, 30));
        add(jLabel5);
        jLabel5.setBounds(11, 120, 175, 30);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ELIMINAR AUTOMATA");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(155, 30));
        add(jLabel10);
        jLabel10.setBounds(0, 31, 750, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Estados");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setPreferredSize(new java.awt.Dimension(175, 30));
        add(jLabel8);
        jLabel8.setBounds(10, 161, 175, 30);

        txtGamma.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtGamma.setPreferredSize(new java.awt.Dimension(175, 30));
        add(txtGamma);
        txtGamma.setBounds(517, 196, 175, 30);

        btnAceptar.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setPreferredSize(new java.awt.Dimension(170, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar);
        btnAceptar.setBounds(314, 453, 170, 35);

        txtInicial.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtInicial.setPreferredSize(new java.awt.Dimension(175, 30));
        add(txtInicial);
        txtInicial.setBounds(517, 159, 175, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void cbAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutomataActionPerformed
        String in = (String) cbAutomata.getSelectedItem();
        updateValues(in);
    }//GEN-LAST:event_cbAutomataActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int i = JOptionPane.showConfirmDialog(null,
                "¿Esta seguro que desea eliminar este automata?",
                "Elminar",
                JOptionPane.OK_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            if (automatas.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "No hay automatas disponibles para eliminar",
                        "Lista de automatas vacia",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                automatas.remove((String) cbAutomata.getSelectedItem());
                cbAutomata.removeAllItems();
                for (String s : automatas.keySet()) {
                    cbAutomata.addItem(s);
                }
            }
        }
        if (automatas.isEmpty()) {
            allEmpty();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    public javax.swing.JComboBox<String> cbAutomata;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlGamma;
    private javax.swing.JTextField txtAceptacion;
    private javax.swing.JTextField txtEstados;
    private javax.swing.JTextField txtGamma;
    private javax.swing.JTextField txtInicial;
    private javax.swing.JTextField txtSigma;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextArea txtTransiciones;
    // End of variables declaration//GEN-END:variables
}
