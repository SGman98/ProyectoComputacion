package GUI;

import GUI.Recursos.Funciones;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import src.automatas.*;

public class Modificar extends javax.swing.JPanel {

    HashMap<String, Automata> automatas = new HashMap<>();
    HashMap<String, ArrayList<String>> transiciones = new HashMap<>();
    Funciones f = new Funciones();

    public Modificar(HashMap<String, Automata> automatas) {
        initComponents();
        this.automatas = automatas;
        f.setStyleJComboBox(cbEstadoInicial);
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
        f.setStyleJComboBox(cbAutomata);
        f.setStyleJTextField(txtAceptacion);
        f.setStyleJTextField(txtEstados);
        f.setStyleJTextField(txtGamma);
        f.setStyleJTextField(txtTipo);
        f.setStyleJTextField(txtSigma);
        f.setStyleJTextArea(txtTransiciones, jScrollPane1);

        txtAceptacion.setText("");
        txtEstados.setText("");
        txtGamma.setText("");
        txtTipo.setText("");
        txtTipo.setEditable(false);
        txtSigma.setText("");
        txtTransiciones.setText("");
        if (txtEstados.getText().equals("")) {
            cbEstadoInicial.addItem("Esperando Estados");
            cbEstadoInicial.setEnabled(false);
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
            cbEstadoInicial.removeAllItems();
            if (txtEstados.getText().equals("")) {
                cbEstadoInicial.addItem("Esperando Estados");
                cbEstadoInicial.setEnabled(false);
            } else {
                for (String d : estados) {
                    cbEstadoInicial.setEnabled(true);
                    cbEstadoInicial.addItem(d);
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
        cbEstadoInicial = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 255));
        setPreferredSize(new java.awt.Dimension(750, 510));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Tipo de Automata");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(135, 30));

        txtTipo.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtTipo.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Alfabeto Sigma");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setPreferredSize(new java.awt.Dimension(175, 30));

        txtAceptacion.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtAceptacion.setPreferredSize(new java.awt.Dimension(175, 30));
        txtAceptacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAceptacionKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Estado Inicial");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setPreferredSize(new java.awt.Dimension(135, 30));

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
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Estados De Aceptacion");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setPreferredSize(new java.awt.Dimension(175, 30));

        txtSigma.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtSigma.setPreferredSize(new java.awt.Dimension(175, 30));
        txtSigma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSigmaKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Transiciones");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setPreferredSize(new java.awt.Dimension(175, 30));

        txtTransiciones.setColumns(20);
        txtTransiciones.setRows(5);
        txtTransiciones.setWrapStyleWord(true);
        txtTransiciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTransicionesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtTransiciones);

        txtEstados.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtEstados.setPreferredSize(new java.awt.Dimension(175, 30));
        txtEstados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadosKeyTyped(evt);
            }
        });

        jlGamma.setBackground(new java.awt.Color(255, 255, 255));
        jlGamma.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jlGamma.setForeground(new java.awt.Color(255, 255, 255));
        jlGamma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlGamma.setText("Alfabeto Gamma");
        jlGamma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlGamma.setPreferredSize(new java.awt.Dimension(135, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Automata Disponibles");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MODIFICAR AUTOMATA");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(155, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Estados");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setPreferredSize(new java.awt.Dimension(175, 30));

        txtGamma.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtGamma.setPreferredSize(new java.awt.Dimension(175, 30));
        txtGamma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGammaKeyTyped(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setPreferredSize(new java.awt.Dimension(170, 35));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        cbEstadoInicial.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        cbEstadoInicial.setForeground(new java.awt.Color(255, 255, 255));
        cbEstadoInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esperando Estados" }));
        cbEstadoInicial.setPreferredSize(new java.awt.Dimension(175, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "¿Esta seguro que desea eliminar este automata?",
                "Elminar",
                JOptionPane.OK_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            if (automatas.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "No hay automatas disponibles para modificar",
                        "Lista de automatas vacia",
                        JOptionPane.ERROR_MESSAGE);
            } else {
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
                String inicial = cbEstadoInicial.getItemAt(cbEstadoInicial.getSelectedIndex());
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
                JLabel lb = new JLabel();
                lb.setSize(50, 50);
                JOptionPane.showMessageDialog(null,
                        "El automata fue modificado satisfactoriamente",
                        "Automata modificado",
                        JOptionPane.CLOSED_OPTION,
                        f.setImageBackground("/imagenes/exito.png", lb)
                );
            }
        }
        if (automatas.isEmpty()) {
            allEmpty();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtEstadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadosKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtEstadosKeyTyped

    private void txtSigmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSigmaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtSigmaKeyTyped

    private void txtGammaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGammaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtGammaKeyTyped

    private void txtAceptacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAceptacionKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAceptacionKeyTyped

    private void txtTransicionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTransicionesKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)
                && c != 32
                && c != ','
                && c != ':'
                && c != '~'
                && c != '$'
                && c != ';'
                && c != '<'
                && c != '>'
                && c != '-'
                && c != '!') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTransicionesKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    public javax.swing.JComboBox<String> cbAutomata;
    private javax.swing.JComboBox<String> cbEstadoInicial;
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
