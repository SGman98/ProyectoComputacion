package GUI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import src.automatas.*;

public class Agregar extends javax.swing.JPanel {

    HashMap<String, Automata> automatas = new HashMap<>();

    public Agregar(HashMap<String, Automata> automatas) {
        initComponents();
        this.automatas = automatas;
        allEmpty();
    }

    public void allEmpty() {
        txtAceptacion.setText("");
        txtEstados.setText("");
        txtGamma.setText("");
        txtGamma.setEnabled(false);
        txtNombre.setText("");
        txtSigma.setText("");
        txtTransiciones.setText("");
        cbAutomata.setSelectedIndex(0);
        cbInicial.removeAllItems();
        cbInicial.addItem("Esperando Estados");
        cbInicial.setEnabled(false);
    }

    String transiciones(HashMap hm) {
        String string = hm.toString().replaceAll("\\], ", "\n")
                .replaceAll("=\\[", "~").replaceAll(", ", ";")
                .replaceAll("\\{", "").replaceAll("\\]\\}", "");
        return string;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAceptacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbAutomata = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtSigma = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTransiciones = new javax.swing.JTextArea();
        btnBorrar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        txtEstados = new javax.swing.JTextField();
        jlGamma = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbInicial = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGamma = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 51));
        setPreferredSize(new java.awt.Dimension(750, 510));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre del Automata");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(175, 30));

        txtNombre.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtNombre.setPreferredSize(new java.awt.Dimension(175, 30));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Alfabeto Sigma");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setPreferredSize(new java.awt.Dimension(155, 30));

        txtAceptacion.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtAceptacion.setPreferredSize(new java.awt.Dimension(175, 30));
        txtAceptacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAceptacionKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Estado Inicial");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setPreferredSize(new java.awt.Dimension(155, 30));

        cbAutomata.setFont(new java.awt.Font("Leelawadee UI", 0, 9)); // NOI18N
        cbAutomata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Autómata Finito Determinista (AFD)", "Autómata Finito con Pila Determinista (AFPD)", "Autómata Finito con Pila No Determinista (AFPN)", "Autómata Finito con 2 Pilas (AF2P)", "Máquina de Turing – Modelo Estándar (MT)", "Máquina de Turing Modelo con una Cinta dividida en Pistas (MTP)", "Máquina de Turing Modelo con Múltiples Cintas (MTMC)", "Máquina de Turing No Determinista (MTN)" }));
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
        txtSigma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSigmaKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
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

        btnBorrar.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        btnBorrar.setText("Borrar Todo");
        btnBorrar.setPreferredSize(new java.awt.Dimension(170, 35));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSeleccionar.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setPreferredSize(new java.awt.Dimension(170, 35));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        txtEstados.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        txtEstados.setPreferredSize(new java.awt.Dimension(175, 30));
        txtEstados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstadosFocusLost(evt);
            }
        });
        txtEstados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadosKeyTyped(evt);
            }
        });

        jlGamma.setBackground(new java.awt.Color(255, 255, 255));
        jlGamma.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jlGamma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlGamma.setText("Alfabeto Gamma");
        jlGamma.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlGamma.setPreferredSize(new java.awt.Dimension(175, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tipo de Automata");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setPreferredSize(new java.awt.Dimension(175, 30));

        cbInicial.setFont(new java.awt.Font("Leelawadee UI", 0, 11)); // NOI18N
        cbInicial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Esperando Estados" }));
        cbInicial.setPreferredSize(new java.awt.Dimension(175, 30));
        cbInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicialActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("AGREGAR AUTOMATA");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(155, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Estados");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setPreferredSize(new java.awt.Dimension(155, 30));

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

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Leelawadee", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Seleccionar Automata");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setPreferredSize(new java.awt.Dimension(160, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlGamma, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(370, 370, 370)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cbAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGamma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSigma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        String archivo = "";
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(this);
        File file = jf.getSelectedFile();
        if (file != null) {
            archivo = file.getAbsolutePath();
        }
        if (archivo.contains(".dfa")) {
            AFD afd = new AFD(archivo, true);
            txtNombre.setText("Default AFD");
            txtAceptacion.setText(afd.getEstadoInicial());
            txtEstados.setText(afd.getEstados().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(afd.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(afd.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : afd.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(0);
        }
        if (archivo.contains(".dpda")) {
            AFPD afpd = new AFPD(archivo, true);
            txtNombre.setText("Default AFPD");
            txtAceptacion.setText(afpd.getEstadoInicial());
            txtEstados.setText(afpd.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(afpd.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(afpd.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(afpd.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : afpd.getEstados()) {
                cbInicial.addItem(s);
                cbInicial.setEnabled(true);
            }
            cbAutomata.setSelectedIndex(1);
        }
        if (archivo.contains(".pda")) {
            AFPN afpn = new AFPN(archivo, true);
            txtNombre.setText("Default AFPN");
            txtAceptacion.setText(afpn.getEstadoInicial());
            txtEstados.setText(afpn.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(afpn.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(afpn.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(afpn.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : afpn.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(2);
        }
        if (archivo.contains(".msm")) {
            AF2P af2p = new AF2P(archivo, true);
            txtNombre.setText("Default AF2P");
            txtAceptacion.setText(af2p.getEstadoInicial());
            txtEstados.setText(af2p.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(af2p.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(af2p.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(af2p.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : af2p.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(3);
        }
        if (archivo.contains(".mt")) {
            MT mt = new MT(archivo, true);
            txtNombre.setText("Default MT");
            txtAceptacion.setText(mt.getEstadoInicial());
            txtEstados.setText(mt.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(mt.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(mt.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(mt.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : mt.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(4);
        }
        if (archivo.contains(".ttm")) {
            MTP mtp = new MTP(archivo, true);
            txtNombre.setText("Default MTP");
            txtAceptacion.setText(mtp.getEstadoInicial());
            txtEstados.setText(mtp.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(mtp.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(mtp.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(mtp.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : mtp.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(5);
        }
        if (archivo.contains(".mttm")) {
            MTMC mtmc = new MTMC(archivo, true);
            txtNombre.setText("Deafault MTMC");
            txtAceptacion.setText(mtmc.getEstadoInicial());
            txtEstados.setText(mtmc.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(mtmc.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(mtmc.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(mtmc.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : mtmc.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(6);
        }
        if (archivo.contains(".ntm")) {
            MTN mtn = new MTN(archivo, true);
            txtNombre.setText("Deafault MTN");
            txtAceptacion.setText(mtn.getEstadoInicial());
            txtEstados.setText(mtn.getEstados().toString().replace("[", "").replace("]", ""));
            txtGamma.setEnabled(true);
            txtGamma.setText(mtn.getAlfabetoPila().toString().replace("[", "").replace("]", ""));
            txtSigma.setText(mtn.getAlfabeto().toString().replace("[", "").replace("]", ""));
            txtTransiciones.setText(transiciones(mtn.getTransiciones()));
            cbInicial.removeAllItems();
            for (String s : mtn.getEstados()) {
                cbInicial.addItem(s);
            }
            cbInicial.setEnabled(true);
            cbAutomata.setSelectedIndex(7);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void cbAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutomataActionPerformed
        if (cbAutomata.getSelectedIndex() == 0) {
            txtGamma.setEnabled(false);
        } else {
            txtGamma.setEnabled(true);
        }
    }//GEN-LAST:event_cbAutomataActionPerformed

    private void cbInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicialActionPerformed
     
    }//GEN-LAST:event_cbInicialActionPerformed

    private void txtEstadosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstadosFocusLost
        String[] estados = txtEstados.getText().split(",");
        cbInicial.removeAllItems();
        if (txtEstados.getText().equals("")) {
            cbInicial.addItem("Esperando Estados");
            cbInicial.setEnabled(false);
        } else {
            for (String s : estados) {
                cbInicial.setEnabled(true);
                cbInicial.addItem(s);
            }
        }
    }//GEN-LAST:event_txtEstadosFocusLost

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtEstadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadosKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtEstadosKeyTyped

    private void txtAceptacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAceptacionKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtAceptacionKeyTyped

    private void txtSigmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSigmaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSigmaKeyTyped

    private void txtGammaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGammaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && c != 32 && c != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_txtGammaKeyTyped

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

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int in = JOptionPane.showConfirmDialog(null, "¿Seguro Desea Elimiar Todo?", "Elimiar Todo", JOptionPane.YES_NO_OPTION);
        if (in == JOptionPane.YES_OPTION) {
            allEmpty();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        if (automatas.get(txtNombre.getText()) == null) {
            int aceptar = cbAutomata.getSelectedIndex();
            ArrayList<String> estados = new ArrayList<>(Arrays.asList(txtEstados.getText().split(",")));
            ArrayList<String> estadosAceptacion = new ArrayList<>((Arrays.asList(txtAceptacion.getText().split(","))));
            ArrayList<String> sigma = new ArrayList<>(Arrays.asList(txtSigma.getText().split(",")));
            ArrayList<String> gamma = new ArrayList<>();
            ArrayList<String> transiciones = new ArrayList<>(Arrays.asList(txtTransiciones.getText().split("\n")));
            String inicial = cbInicial.getItemAt(cbInicial.getSelectedIndex());
            if (txtGamma.isEnabled()) {
                gamma = new ArrayList<>(Arrays.asList(txtGamma.getText().split(",")));
            }
            switch (aceptar) {
                case 0:
                    AFD afd = new AFD(sigma,
                            estados,
                            inicial,
                            estadosAceptacion,
                            transiciones);
                    automatas.put(txtNombre.getText(), afd);
                    break;
                case 1:
                    AFPD afpd = new AFPD(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), afpd);
                    break;
                case 2:
                    AFPN afpn = new AFPN(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), afpn);
                    break;
                case 3:
                    AF2P af2p = new AF2P(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), af2p);
                    break;
                case 4:
                    MT mt = new MT(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), mt);
                    break;
                case 5:
                    MTP mtp = new MTP(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), mtp);
                    break;
                case 6:
                    MTMC mtmc = new MTMC(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), mtmc);
                    break;
                case 7:
                    MTN mtn = new MTN(estados,
                            (String) cbInicial.getSelectedItem(),
                            estadosAceptacion,
                            sigma,
                            gamma,
                            transiciones);
                    automatas.put(txtNombre.getText(), mtn);
                    break;
            }
            JOptionPane.showConfirmDialog(null,
                    "Automata agregado satisfactoriamente",
                    "Agregado exitosamente",
                    JOptionPane.OK_OPTION);
        }else{
        JOptionPane.showConfirmDialog(null,
                    "El automata ya esta agregado",
                    "Agregado existente",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBorrar;
    public javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbAutomata;
    private javax.swing.JComboBox<String> cbInicial;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSigma;
    private javax.swing.JTextArea txtTransiciones;
    // End of variables declaration//GEN-END:variables
}
