package GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;
import src.automatas.*;

public class Modificar extends javax.swing.JPanel {

    HashMap<String, Automata> automatas = new HashMap<>();
    HashMap<String, ArrayList<String>> transiciones = new HashMap<>();

    public Modificar(HashMap<String, Automata> automatas) {
        initComponents();
        this.automatas = automatas;
        allEmpty();
        if (!this.automatas.isEmpty()) {
            cbAutomata.removeAllItems();
            for (String s : automatas.keySet()) {
                cbAutomata.addItem(s);
            }
            updateValues((String) automatas.keySet().toArray()[0]);
        }
    }

    public void allEmpty() {
        txtAceptacion.setText("");
        txtEstados.setText("");
        txtGamma.setText("");
        txtTipo.setText("");
        txtTipo.setEnabled(false);
        txtSigma.setText("");
        txtTransiciones.setText("");
        if (txtEstados.getText().equals("")) {
            cbInicial.addItem("Esperando Estados");
            cbInicial.setEnabled(false);
        }
        cbAutomata.removeAllItems();
        cbAutomata.addItem("Ingresar nuevos automatas");

    }

    String transiciones(HashMap hm) {
        String string = hm.toString().replaceAll("\\], ", "\n")
                .replaceAll("=\\[", "~").replaceAll(", ", ";")
                .replaceAll("\\{", "").replaceAll("\\]\\}", "");
        return string;
    }

    public HashMap ponerTrancisiones(String transiciones) { // Añadir las trancisiones
        String[] transicion;
        HashMap hashMap = new HashMap();
        ArrayList<String> transicionFinal = new ArrayList<String>();

        transicion = transiciones.split("\\~");
        for (String string : transicion[1].split(";")) {
            transicionFinal.add(string);
        }
        if (transicion[1].split(";").length == 0) {
            transicionFinal.add(transicion[1]);
        }
        this.transiciones.put(transicion[0], new ArrayList<String>(transicionFinal));
        transicionFinal.clear();

        return hashMap;
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
            String[] estados = txtEstados.getText().split(",");
            cbInicial.removeAllItems();
            if (txtEstados.getText().equals("")) {
                cbInicial.addItem("Esperando Estados");
                cbInicial.setEnabled(false);
            } else {
                for (String d : estados) {
                    cbInicial.setEnabled(true);
                    cbInicial.addItem(d);
                }
            }
        }
    }

    ArrayList<String> quitarEspacios(ArrayList<String> list) {
        ArrayList<String> al = new ArrayList<>();
        for (String s : list) {
            al.add(s.replaceAll(" ", ""));
        }
        return al;
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
        cbInicial = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 255));
        setPreferredSize(new java.awt.Dimension(750, 510));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Automata");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(175, 30));

        txtTipo.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtTipo.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Alfabeto Sigma");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setPreferredSize(new java.awt.Dimension(175, 30));

        txtAceptacion.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtAceptacion.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Estado Inicial");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setPreferredSize(new java.awt.Dimension(155, 30));

        cbAutomata.setFont(new java.awt.Font("Leelawadee UI", 0, 9)); // NOI18N
        cbAutomata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cbAutomata.setPreferredSize(new java.awt.Dimension(175, 30));
        cbAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutomataActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Estados De Aceptacion");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setPreferredSize(new java.awt.Dimension(175, 30));

        txtSigma.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtSigma.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Transiciones");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setPreferredSize(new java.awt.Dimension(175, 30));

        txtTransiciones.setColumns(20);
        txtTransiciones.setRows(5);
        txtTransiciones.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtTransiciones);

        txtEstados.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtEstados.setPreferredSize(new java.awt.Dimension(175, 30));

        jlGamma.setBackground(new java.awt.Color(255, 255, 255));
        jlGamma.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jlGamma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlGamma.setText("Alfabeto Gamma");
        jlGamma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlGamma.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Automata Disponibles");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MODIFICAR AUTOMATA");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(155, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Estados");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setPreferredSize(new java.awt.Dimension(175, 30));

        txtGamma.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtGamma.setPreferredSize(new java.awt.Dimension(175, 30));

        btnAceptar.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setPreferredSize(new java.awt.Dimension(170, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        cbInicial.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        cbInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esperando Estados" }));
        cbInicial.setPreferredSize(new java.awt.Dimension(175, 30));
        cbInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cbAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlGamma, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(cbAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutomataActionPerformed
        String in = (String) cbAutomata.getSelectedItem();
        updateValues(in);
    }//GEN-LAST:event_cbAutomataActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int i = JOptionPane.showConfirmDialog(null,
                " esta seguro que desea eliminar este automata",
                "Elminar",
                JOptionPane.OK_OPTION);
        if (i == JOptionPane.YES_OPTION) {

            Automata automata = automatas.get(
                    (String) cbAutomata.getSelectedItem());
            ArrayList<String> estados = new ArrayList<>(Arrays.asList(txtEstados.getText().split(",")));
            estados = quitarEspacios(estados);
            ArrayList<String> estadosAceptacion = new ArrayList<>((Arrays.asList(txtAceptacion.getText().split(","))));
            estadosAceptacion = quitarEspacios(estadosAceptacion);
            ArrayList<String> sigma = new ArrayList<>(Arrays.asList(txtSigma.getText().split(",")));
            sigma = quitarEspacios(sigma);
            ArrayList<String> gamma = new ArrayList<>();
            ArrayList<String> transicionesArr = new ArrayList<>(Arrays.asList(txtTransiciones.getText().split("\n")));
            String inicial = cbInicial.getItemAt(cbInicial.getSelectedIndex());
            if (txtGamma.isEnabled()) {
                gamma = new ArrayList<>(Arrays.asList(txtGamma.getText().split(",")));
                gamma = quitarEspacios(gamma);
            }
            automata.setAlfabeto(sigma);
            automata.setAlfabetoPila(gamma);
            automata.setEstadoInicial(inicial);
            automata.setEstados(estados);
            automata.setEstadosAceptacion(estadosAceptacion);
            for (String string : transicionesArr) {
                this.ponerTrancisiones(string);
            }
            automata.setTransiciones(this.transiciones);
            automatas.put((String) cbAutomata.getSelectedItem(), automata);
            cbAutomata.removeAllItems();
            for (String s : automatas.keySet()) {
                cbAutomata.addItem(s);
            }

        }
        if (automatas.isEmpty()) {
            allEmpty();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cbInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInicialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    public javax.swing.JComboBox<String> cbAutomata;
    private javax.swing.JComboBox<String> cbInicial;
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
    private javax.swing.JTextField txtSigma;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextArea txtTransiciones;
    // End of variables declaration//GEN-END:variables
}
