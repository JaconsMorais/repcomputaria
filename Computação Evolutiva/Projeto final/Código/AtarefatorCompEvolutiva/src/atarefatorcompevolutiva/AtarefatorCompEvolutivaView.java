/*
 * AtarefatorCompEvolutivaView.java
 */

package atarefatorcompevolutiva;

import atarefatorcompevolutiva.model.Parametros;
import atarefatorcompevolutiva.model.Pesos;
import atarefatorcompevolutiva.model.ScoreMatch;
import atarefatorcompevolutiva.model.ScoreTarefa;
import atarefatorcompevolutiva.model.Tarefa;
import atarefatorcompevolutiva.pso.Populacoes;
import atarefatorcompevolutiva.pso.sort.PSOSort;
import atarefatorcompevolutiva.util.Bases;
import atarefatorcompevolutiva.util.Estatisticas;
import atarefatorcompevolutiva.util.Mensagens;
import atarefatorcompevolutiva.util.Validadores;
import javax.swing.JButton;
import javax.swing.JList;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class AtarefatorCompEvolutivaView extends FrameView {

    private Vector<String> vetorTarefas = new Vector<String>();
    private int indexListaTarefas = -1;
    private String textoListaTarefa = "";
    private boolean atualizaTextoNomeTarefa = false;
    private boolean emCadastro = false;
    private boolean emEdicao = false;
    private List<Tarefa> tarefas =  new ArrayList<Tarefa>();
    private Pesos pesos = new Pesos();
    private Parametros parametros = new Parametros();
    //List<Tarefa> tarefasConcluidas = new ArrayList<Tarefa>();
    //List<Tarefa> tarefasAtrasadas = new ArrayList<Tarefa>();

    public AtarefatorCompEvolutivaView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = AtarefatorCompEvolutivaApp.getApplication().getMainFrame();
            aboutBox = new AtarefatorCompEvolutivaAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        AtarefatorCompEvolutivaApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTarefas = new javax.swing.JList();
        botaoNovaTarefa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comentarios = new javax.swing.JTextArea();
        horasTrabalhadas = new javax.swing.JTextField();
        totalHoras = new javax.swing.JTextField();
        porcentagem = new javax.swing.JSlider();
        porcentagemTexto = new javax.swing.JTextField();
        localTarefa = new javax.swing.JTextField();
        categoria = new javax.swing.JTextField();
        nomeTarefa = new javax.swing.JTextField();
        diaInicio = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        mesInicio = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        horaInicio = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        minInicio = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        horaFinal = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        minFinal = new javax.swing.JComboBox();
        diaFinal = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        mesFinal = new javax.swing.JComboBox();
        prioridade = new javax.swing.JComboBox();
        anoInicio = new javax.swing.JTextField();
        anoFinal = new javax.swing.JTextField();
        botaoExcluirOK = new javax.swing.JButton();
        botaoEditarCancelar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        openBase = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        organizationMenu = new javax.swing.JMenu();
        configurations = new javax.swing.JMenuItem();
        swarmOrganizer = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        listaTarefas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaTarefas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaTarefas.setName("listaTarefas"); // NOI18N
        listaTarefas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaTarefasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaTarefas);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(atarefatorcompevolutiva.AtarefatorCompEvolutivaApp.class).getContext().getResourceMap(AtarefatorCompEvolutivaView.class);
        botaoNovaTarefa.setText(resourceMap.getString("botaoNovaTarefa.text")); // NOI18N
        botaoNovaTarefa.setName("botaoNovaTarefa"); // NOI18N
        botaoNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovaTarefaActionPerformed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        comentarios.setColumns(20);
        comentarios.setRows(5);
        comentarios.setEnabled(false);
        comentarios.setName("comentarios"); // NOI18N
        jScrollPane2.setViewportView(comentarios);

        horasTrabalhadas.setText(resourceMap.getString("horasTrabalhadas.text")); // NOI18N
        horasTrabalhadas.setEnabled(false);
        horasTrabalhadas.setName("horasTrabalhadas"); // NOI18N

        totalHoras.setText(resourceMap.getString("totalHoras.text")); // NOI18N
        totalHoras.setEnabled(false);
        totalHoras.setName("totalHoras"); // NOI18N

        porcentagem.setValue(0);
        porcentagem.setEnabled(false);
        porcentagem.setName("porcentagem"); // NOI18N
        porcentagem.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                porcentagemStateChanged(evt);
            }
        });

        porcentagemTexto.setEditable(false);
        porcentagemTexto.setText(resourceMap.getString("porcentagemTexto.text")); // NOI18N
        porcentagemTexto.setEnabled(false);
        porcentagemTexto.setName("porcentagemTexto"); // NOI18N

        localTarefa.setText(resourceMap.getString("localTarefa.text")); // NOI18N
        localTarefa.setEnabled(false);
        localTarefa.setName("localTarefa"); // NOI18N

        categoria.setText(resourceMap.getString("categoria.text")); // NOI18N
        categoria.setEnabled(false);
        categoria.setName("categoria"); // NOI18N

        nomeTarefa.setText(resourceMap.getString("nomeTarefa.text")); // NOI18N
        nomeTarefa.setEnabled(false);
        nomeTarefa.setName("nomeTarefa"); // NOI18N
        nomeTarefa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeTarefaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomeTarefaKeyTyped(evt);
            }
        });

        diaInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        diaInicio.setEnabled(false);
        diaInicio.setName("diaInicio"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        mesInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        mesInicio.setEnabled(false);
        mesInicio.setName("mesInicio"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        horaInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        horaInicio.setEnabled(false);
        horaInicio.setName("horaInicio"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        minInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        minInicio.setEnabled(false);
        minInicio.setName("minInicio"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        horaFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        horaFinal.setEnabled(false);
        horaFinal.setName("horaFinal"); // NOI18N

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        minFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        minFinal.setEnabled(false);
        minFinal.setName("minFinal"); // NOI18N

        diaFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        diaFinal.setEnabled(false);
        diaFinal.setName("diaFinal"); // NOI18N

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        mesFinal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        mesFinal.setEnabled(false);
        mesFinal.setName("mesFinal"); // NOI18N

        prioridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        prioridade.setEnabled(false);
        prioridade.setName("prioridade"); // NOI18N

        anoInicio.setText(resourceMap.getString("anoInicio.text")); // NOI18N
        anoInicio.setEnabled(false);
        anoInicio.setName("anoInicio"); // NOI18N

        anoFinal.setText(resourceMap.getString("anoFinal.text")); // NOI18N
        anoFinal.setEnabled(false);
        anoFinal.setName("anoFinal"); // NOI18N

        botaoExcluirOK.setText(resourceMap.getString("botaoExcluirOK.text")); // NOI18N
        botaoExcluirOK.setEnabled(false);
        botaoExcluirOK.setName("botaoExcluirOK"); // NOI18N
        botaoExcluirOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirOKActionPerformed(evt);
            }
        });

        botaoEditarCancelar.setText(resourceMap.getString("botaoEditarCancelar.text")); // NOI18N
        botaoEditarCancelar.setEnabled(false);
        botaoEditarCancelar.setName("botaoEditarCancelar"); // NOI18N
        botaoEditarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoNovaTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(botaoExcluirOK)
                                .addGap(18, 18, 18)
                                .addComponent(botaoEditarCancelar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(porcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(porcentagemTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(diaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(diaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(anoFinal)
                                    .addComponent(anoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(horaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))))
                            .addComponent(categoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(localTarefa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(nomeTarefa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(totalHoras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(horasTrabalhadas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                        .addGap(32, 32, 32))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nomeTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(diaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(mesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(minInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(diaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(mesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(anoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(minFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(localTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(porcentagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(porcentagemTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(totalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(horasTrabalhadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
                .addGap(11, 11, 11)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoNovaTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoExcluirOK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoEditarCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        openBase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openBase.setText(resourceMap.getString("openBase.text")); // NOI18N
        openBase.setToolTipText(resourceMap.getString("openBase.toolTipText")); // NOI18N
        openBase.setName("openBase"); // NOI18N
        openBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBaseActionPerformed(evt);
            }
        });
        fileMenu.add(openBase);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(atarefatorcompevolutiva.AtarefatorCompEvolutivaApp.class).getContext().getActionMap(AtarefatorCompEvolutivaView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setToolTipText(resourceMap.getString("exitMenuItem.toolTipText")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        organizationMenu.setText(resourceMap.getString("organizationMenu.text")); // NOI18N
        organizationMenu.setName("organizationMenu"); // NOI18N

        configurations.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        configurations.setText(resourceMap.getString("configMenu.text")); // NOI18N
        configurations.setToolTipText(resourceMap.getString("configMenu.toolTipText")); // NOI18N
        configurations.setName("configMenu"); // NOI18N
        configurations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurationsActionPerformed(evt);
            }
        });
        organizationMenu.add(configurations);

        swarmOrganizer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        swarmOrganizer.setMnemonic('C');
        swarmOrganizer.setText(resourceMap.getString("swarmOrganizer.text")); // NOI18N
        swarmOrganizer.setToolTipText(resourceMap.getString("swarmOrganizer.toolTipText")); // NOI18N
        swarmOrganizer.setName("swarmOrganizer"); // NOI18N
        swarmOrganizer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swarmOrganizerActionPerformed(evt);
            }
        });
        organizationMenu.add(swarmOrganizer);

        menuBar.add(organizationMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setToolTipText(resourceMap.getString("aboutMenuItem.toolTipText")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 570, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void porcentagemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_porcentagemStateChanged
        // TODO add your handling code here:
        javax.swing.JSlider slider = (javax.swing.JSlider) evt.getSource();
        porcentagemTexto.setText(slider.getValue() + "%");
    }//GEN-LAST:event_porcentagemStateChanged

    private void botaoNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovaTarefaActionPerformed
        // TODO add your handling code here:
        if(!emCadastro){
            emCadastro = true;
            botaoNovaTarefa.setEnabled(false);
            vetorTarefas.add("Nova Tarefa");
            listaTarefas.setListData(vetorTarefas);
            habilitaCampos();
            zeraCampos();
            botaoExcluirOK.setText("OK");
            botaoEditarCancelar.setText("Cancelar");
            listaTarefas.setSelectedIndex(vetorTarefas.size() - 1);
        }
    }//GEN-LAST:event_botaoNovaTarefaActionPerformed

    private void botaoExcluirOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirOKActionPerformed
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        if(botao.getText().equals("OK")){            
            //efetua validações
            boolean validarNomeTarefa = Validadores.validaNomeTarefa(nomeTarefa.getText());
            boolean validarDataInicio = Validadores.validaData(diaInicio.getSelectedItem().toString(), mesInicio.getSelectedItem().toString(), anoInicio.getText());
            boolean validarDataFinal = Validadores.validaData(diaFinal.getSelectedItem().toString(), mesFinal.getSelectedItem().toString(), anoFinal.getText());
            boolean validarDatas = false;
            if(validarDataInicio && validarDataFinal) //else não será necessário
                validarDatas = Validadores.validaDataInicialFinal(new Date(diaInicio.getSelectedIndex() + 1,mesInicio.getSelectedIndex(),Integer.parseInt(anoInicio.getText())), new Date(diaFinal.getSelectedIndex() + 1,mesFinal.getSelectedIndex(),Integer.parseInt(anoFinal.getText())));
            boolean validarTotalHoras = Validadores.validaTotalHoras(totalHoras.getText());
            boolean validarHorasTrabalhadas = Validadores.validaHorasTrabalhadas(horasTrabalhadas.getText());

            if(validarNomeTarefa
                && validarDataInicio
                && validarDataFinal
                && validarDatas
                && validarTotalHoras
                && validarHorasTrabalhadas){

                    botao.setText("Excluir");
                    botaoEditarCancelar.setText("Editar");

                    if(emCadastro){
                        cadastrar();
                        //adiciona o elemento do XML
                    }else if(emEdicao){
                        editar(listaTarefas.getSelectedIndex());
                        //edita o elemento do XML
                    }

                    //mais validadores
                    desabilitaCampos();
                    emCadastro = false;
                    emEdicao = false;
                    botaoNovaTarefa.setEnabled(true);
            }else{
                StringBuilder mensagem = new StringBuilder();
                mensagem.append(Mensagens.ERRO_VALIDACAO);
                mensagem.append("\n");

                if(!validarNomeTarefa){
                    mensagem.append("\n");
                    mensagem.append(Mensagens.NOME_TAREFA);
                }
                if(!validarDataInicio){
                    mensagem.append("\n");
                    mensagem.append(Mensagens.DATA_INICIO);
                }
                if(!validarDataFinal){
                    mensagem.append("\n");
                    mensagem.append(Mensagens.DATA_FINAL);
                }
                if(!validarDatas){
                    mensagem.append("\n");
                    mensagem.append(Mensagens.DATA_INICIO_FINAL );
                }
                if(!validarTotalHoras){
                    mensagem.append("\n");
                    mensagem.append(Mensagens.TOTAL_HORAS);
                }
                if(!validarHorasTrabalhadas){
                    mensagem.append("\n");
                    mensagem.append(Mensagens.HORAS_TRABALHADAS);
                }

                JOptionPane.showMessageDialog(mainPanel, mensagem.toString(),"Erro de validação",JOptionPane.ERROR_MESSAGE);

            }
            
        }else if(botao.getText().equals("Excluir")){
            int index = listaTarefas.getSelectedIndex();
            //remove o elemento do XML
            //remove o elemento da lista
            excluir(index);
            listaTarefas.setListData(vetorTarefas);
            //seta o foco para o item acima
            listaTarefas.setSelectedIndex(index-1);
            //popula seus campos com base no anterior
            if(index > 0) populaCampos(index-1);
            else{
                zeraCampos();
                desabilitaCampos();
            }
        }
    }//GEN-LAST:event_botaoExcluirOKActionPerformed

    private void botaoEditarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarCancelarActionPerformed
        // TODO add your handling code here:
        javax.swing.JButton botao = (javax.swing.JButton) evt.getSource();
        if(botao.getText().equals("Editar")){
            emEdicao = true;
            habilitaCampos();
            botaoExcluirOK.setText("OK");
            botao.setText("Cancelar");
        }else if(botao.getText().equals("Cancelar")){
            //mantem valores originais
            botaoExcluirOK.setText("Excluir");
            botao.setText("Editar");

            if(emCadastro){
                listaTarefas.setSelectedIndex(listaTarefas.getSelectedIndex() - 1);
                vetorTarefas.remove(vetorTarefas.size() - 1);
                listaTarefas.setListData(vetorTarefas);
            }else if(emEdicao){
                populaCampos(listaTarefas.getSelectedIndex());
                vetorTarefas.add(listaTarefas.getSelectedIndex(), nomeTarefa.getText());
                vetorTarefas.remove(listaTarefas.getSelectedIndex() + 1);
                listaTarefas.setListData(vetorTarefas);
                listaTarefas.setSelectedIndex(listaTarefas.getSelectedIndex() + 1);
            }

            desabilitaCampos();
            emCadastro = false;
            emEdicao = false;
            botaoNovaTarefa.setEnabled(true);
        }
    }//GEN-LAST:event_botaoEditarCancelarActionPerformed

    private void openBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBaseActionPerformed
        // TODO add your handling code here:
        AtarefatorCompEvolutivaBases dialog = new AtarefatorCompEvolutivaBases(new javax.swing.JFrame(), true, this);

        dialog.setVisible(true);
    }//GEN-LAST:event_openBaseActionPerformed

    private void swarmOrganizerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swarmOrganizerActionPerformed
        // TODO add your handling code here:
        ArrayList<ScoreTarefa> scores = Populacoes.getPop(tarefas);
        
        PSOSort psoSort = new PSOSort();
        long ti = System.nanoTime();
        List<ScoreMatch> matchScores = psoSort.doPSOSort(scores,pesos,parametros);
        long tf = System.nanoTime();
        String nomeTarefa = "";

        StringBuilder sb = new StringBuilder();
        sb.append("Tarefas ordenadas com sucesso!!");
        sb.append("\n\n");
        sb.append("Resultados:");
        sb.append("\n\n");
        for(int i = 0; i < matchScores.size(); i++){
            ScoreMatch match = (ScoreMatch)matchScores.get(i);

            sb.append(i+1);
            sb.append(" - Tarefa: ");
            for(Tarefa t : tarefas){
                if(match.getIdTarefa() == t.getIdTarefa())
                    nomeTarefa = t.getNomeTarefa();
            }
            sb.append(nomeTarefa);
            sb.append(" - Score total: ");
            sb.append(match.getFitness());
            sb.append(" - Match: ");
            sb.append(match.getMatch());
            sb.append("\n");
        }
        sb.append("\n");

        Estatisticas stats = new Estatisticas(matchScores);

        sb.append("Média do score total: ");
        sb.append(stats.getMediaScores());
        sb.append("\n");
        sb.append("Desvio padrão do score total: ");
        sb.append(stats.getDesvioScores());
        sb.append("\n\n");
        sb.append("Média do match: ");
        sb.append(stats.getMediaScoreMatches());
        sb.append("\n");
        sb.append("Desvio padrão do match: ");
        sb.append(stats.getDesvioScoreMatches());
        sb.append("\n\n");
        sb.append("Tempo de execução do método: ");
        double time = (tf-ti)/1000000000;
        sb.append(time);
        sb.append(" segundos");

        JOptionPane.showMessageDialog(mainPanel, sb.toString(), "Informações da ordenação",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_swarmOrganizerActionPerformed

    private void nomeTarefaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeTarefaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTarefaKeyTyped

    private void nomeTarefaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeTarefaKeyReleased
        // TODO add your handling code here:
        javax.swing.JTextField campoTexto = (javax.swing.JTextField) evt.getSource();
        
        int index = listaTarefas.getSelectedIndex();

        if(!atualizaTextoNomeTarefa){
            vetorTarefas.add(index ,campoTexto.getText());
            vetorTarefas.remove(index+1);
            listaTarefas.setListData(vetorTarefas);
            listaTarefas.setSelectedIndex(index);
            atualizaTextoNomeTarefa = true;
        }else atualizaTextoNomeTarefa = false;
    }//GEN-LAST:event_nomeTarefaKeyReleased

    private void listaTarefasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaTarefasValueChanged
        // TODO add your handling code here:
        javax.swing.JList jlist = (javax.swing.JList)evt.getSource();

        //se não estiver mudando texto
        if(jlist.getSelectedIndex() >= 0){
            if(botaoExcluirOK.getText().equals("OK") && !botaoNovaTarefa.isEnabled() && jlist.getSelectedIndex() != indexListaTarefas && jlist.getSelectedIndex() < vetorTarefas.size() - 1){ //estava cadastrando
                //remove o último elemento da lista
                vetorTarefas.remove(vetorTarefas.size() - 1);
                //altera botões
                botaoExcluirOK.setText("Excluir");
                botaoEditarCancelar.setText("Editar");
                botaoNovaTarefa.setEnabled(true);
                //desabilita campos
                desabilitaCampos();
                indexListaTarefas = jlist.getSelectedIndex();
                emCadastro = false;
                emEdicao = false;
                //pega o elemento correspondente e o popula
                populaCampos(indexListaTarefas);
            }else if(botaoNovaTarefa.isEnabled()){
                indexListaTarefas = jlist.getSelectedIndex();
                //pega o elemento correspondente e o popula
                populaCampos(indexListaTarefas);
            }
        }
    }//GEN-LAST:event_listaTarefasValueChanged

    private void configurationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurationsActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AtarefatorCompEvolutivaConfigurar dialog = new AtarefatorCompEvolutivaConfigurar(new javax.swing.JFrame(), true, pesos, parametros);
                /*dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        close(dialog);
                    }
                });*/
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_configurationsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoFinal;
    private javax.swing.JTextField anoInicio;
    private javax.swing.JButton botaoEditarCancelar;
    private javax.swing.JButton botaoExcluirOK;
    private javax.swing.JButton botaoNovaTarefa;
    private javax.swing.JTextField categoria;
    private javax.swing.JTextArea comentarios;
    private javax.swing.JMenuItem configurations;
    private javax.swing.JComboBox diaFinal;
    private javax.swing.JComboBox diaInicio;
    private javax.swing.JComboBox horaFinal;
    private javax.swing.JComboBox horaInicio;
    private javax.swing.JTextField horasTrabalhadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaTarefas;
    private javax.swing.JTextField localTarefa;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox mesFinal;
    private javax.swing.JComboBox mesInicio;
    private javax.swing.JComboBox minFinal;
    private javax.swing.JComboBox minInicio;
    private javax.swing.JTextField nomeTarefa;
    private javax.swing.JMenuItem openBase;
    private javax.swing.JMenu organizationMenu;
    private javax.swing.JSlider porcentagem;
    private javax.swing.JTextField porcentagemTexto;
    private javax.swing.JComboBox prioridade;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenuItem swarmOrganizer;
    private javax.swing.JTextField totalHoras;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    private void habilitaCampos(){
        diaInicio.setEnabled(true);
        mesInicio.setEnabled(true);
        anoInicio.setEnabled(true);
        horaInicio.setEnabled(true);
        minInicio.setEnabled(true);
        diaFinal.setEnabled(true);
        mesFinal.setEnabled(true);
        anoFinal.setEnabled(true);
        horaFinal.setEnabled(true);
        minFinal.setEnabled(true);
        prioridade.setEnabled(true);
        nomeTarefa.setEnabled(true);
        categoria.setEnabled(true);
        porcentagem.setEnabled(true);
        porcentagemTexto.setEnabled(true);
        localTarefa.setEnabled(true);
        totalHoras.setEnabled(true);
        horasTrabalhadas.setEnabled(true);
        comentarios.setEnabled(true);
        botaoExcluirOK.setEnabled(true);
        botaoEditarCancelar.setEnabled(true);
    }

    private void desabilitaCampos(){
        diaInicio.setEnabled(false);
        mesInicio.setEnabled(false);
        anoInicio.setEnabled(false);
        horaInicio.setEnabled(false);
        minInicio.setEnabled(false);
        diaFinal.setEnabled(false);
        mesFinal.setEnabled(false);
        anoFinal.setEnabled(false);
        horaFinal.setEnabled(false);
        minFinal.setEnabled(false);
        prioridade.setEnabled(false);
        nomeTarefa.setEnabled(false);
        categoria.setEnabled(false);
        porcentagem.setEnabled(false);
        porcentagemTexto.setEnabled(false);
        localTarefa.setEnabled(false);
        totalHoras.setEnabled(false);
        horasTrabalhadas.setEnabled(false);
        comentarios.setEnabled(false);
        if(vetorTarefas.size() == 0){
            botaoExcluirOK.setEnabled(false);
            botaoEditarCancelar.setEnabled(false);
        }
    }

    private void zeraCampos(){
        diaInicio.setSelectedIndex(0);
        mesInicio.setSelectedIndex(0);
        anoInicio.setText("");
        horaInicio.setSelectedIndex(0);
        minInicio.setSelectedIndex(0);
        diaFinal.setSelectedIndex(0);
        mesFinal.setSelectedIndex(0);
        anoFinal.setText("");
        horaFinal.setSelectedIndex(0);
        minFinal.setSelectedIndex(0);
        prioridade.setSelectedIndex(0);
        nomeTarefa.setText("");
        categoria.setText("");
        porcentagem.setValue(0);
        porcentagemTexto.setText("0%");
        localTarefa.setText("");
        totalHoras.setText("");
        horasTrabalhadas.setText("");
        comentarios.setText("");
    }

    private void populaCampos(int index){
        Tarefa tarefa = (tarefas.size() > 0) ? (Tarefa)tarefas.get(index) : null;
        if(tarefa != null){
            diaInicio.setSelectedIndex(tarefa.getDataInicio().getDate() - 1);
            mesInicio.setSelectedIndex(tarefa.getDataInicio().getMonth());
            anoInicio.setText(Integer.toString(tarefa.getDataInicio().getYear()));
            horaInicio.setSelectedIndex(tarefa.getDataInicio().getHours());
            minInicio.setSelectedIndex(tarefa.getDataInicio().getMinutes());
            diaFinal.setSelectedIndex(tarefa.getDataFinal().getDate() - 1);
            mesFinal.setSelectedIndex(tarefa.getDataFinal().getMonth());
            anoFinal.setText(Integer.toString(tarefa.getDataFinal().getYear()));
            horaFinal.setSelectedIndex(tarefa.getDataFinal().getHours());
            minFinal.setSelectedIndex(tarefa.getDataFinal().getMinutes());
            prioridade.setSelectedIndex(tarefa.getPrioridade() - 1);
            nomeTarefa.setText(tarefa.getNomeTarefa());
            categoria.setText(tarefa.getCategoria());
            porcentagem.setValue(tarefa.getPorcentagem());
            porcentagemTexto.setText(tarefa.getPorcentagem() + "%");
            localTarefa.setText(tarefa.getLocalTarefa());
            totalHoras.setText(Double.toString(tarefa.getTotalHoras()));
            horasTrabalhadas.setText(Double.toString(tarefa.getHorasTrabalhadas()));
            comentarios.setText(tarefa.getComentários());
        }else zeraCampos();
    }

    private void cadastrar(){
        Tarefa tarefa = new Tarefa();

        Tarefa tarefaId = null;

        if(tarefas.size() <= 0) tarefa.setIdTarefa(1);
        else{
            int id = 0;

            for(int i = 0;i < tarefas.size();i++){
                tarefaId = (Tarefa)tarefas.get(i);

                if(tarefaId.getIdTarefa() > id)
                    id = tarefaId.getIdTarefa();
            }

            tarefa.setIdTarefa(id+1);
        }

        tarefa.setNomeTarefa(nomeTarefa.getText());

        Date inicio = new Date();
        inicio.setDate(diaInicio.getSelectedIndex() + 1);
        inicio.setMonth(mesInicio.getSelectedIndex());
        inicio.setYear(Integer.parseInt(anoInicio.getText()));
        inicio.setHours(horaInicio.getSelectedIndex());
        inicio.setMinutes(minInicio.getSelectedIndex());
        tarefa.setDataInicio(inicio);

        Date fim = new Date();
        fim.setDate(diaFinal.getSelectedIndex() + 1);
        fim.setMonth(mesFinal.getSelectedIndex());
        fim.setYear(Integer.parseInt(anoFinal.getText()));
        fim.setHours(horaFinal.getSelectedIndex());
        fim.setMinutes(minFinal.getSelectedIndex());

        tarefa.setDataFinal(fim);
        tarefa.setPrioridade(prioridade.getSelectedIndex() + 1);
        tarefa.setCategoria(categoria.getText());
        tarefa.setLocalTarefa(localTarefa.getText());
        tarefa.setPorcentagem(porcentagem.getValue());
        tarefa.setTotalHoras(Double.parseDouble(totalHoras.getText()));
        tarefa.setHorasTrabalhadas(Double.parseDouble(horasTrabalhadas.getText()));
        tarefa.setComentários(comentarios.getText());

        tarefas.add(tarefa);
    }

    private void editar(int index){
        Tarefa tarefa = (Tarefa)tarefas.get(index);

        tarefa.setNomeTarefa(nomeTarefa.getText());

        Date inicio = new Date();
        inicio.setDate(diaInicio.getSelectedIndex() + 1);
        inicio.setMonth(mesInicio.getSelectedIndex() + 1);
        inicio.setYear(Integer.parseInt(anoInicio.getText()));
        inicio.setHours(horaInicio.getSelectedIndex() + 1);
        inicio.setMinutes(minInicio.getSelectedIndex() + 1);
        tarefa.setDataInicio(inicio);

        Date fim = new Date();
        fim.setDate(diaFinal.getSelectedIndex() + 1);
        fim.setMonth(mesFinal.getSelectedIndex() + 1);
        fim.setYear(Integer.parseInt(anoFinal.getText()));
        fim.setHours(horaFinal.getSelectedIndex() + 1);
        fim.setMinutes(minFinal.getSelectedIndex() + 1);
        tarefa.setDataFinal(fim);

        tarefa.setPrioridade(prioridade.getSelectedIndex() + 1);
        tarefa.setCategoria(categoria.getText());
        tarefa.setLocalTarefa(localTarefa.getText());
        tarefa.setPorcentagem(porcentagem.getValue());
        tarefa.setTotalHoras(Double.parseDouble(totalHoras.getText()));
        tarefa.setHorasTrabalhadas(Double.parseDouble(horasTrabalhadas.getText()));
        tarefa.setComentários(comentarios.getText());
        
        tarefas.add(index,tarefa);
        tarefas.remove(index+1);
    }

    private void excluir(int index){
        tarefas.remove(index);
        vetorTarefas.remove(index);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public Vector<String> getVetorTarefas() {
        return vetorTarefas;
    }

    public void setVetorTarefas(Vector<String> vetorTarefas) {
        this.vetorTarefas = vetorTarefas;
    }

    public JList getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(JList listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public Pesos getPesos() {
        return pesos;
    }

    public void setPesos(Pesos pesos) {
        this.pesos = pesos;
    }

    public JButton getBotaoEditarCancelar() {
        return botaoEditarCancelar;
    }

    public void setBotaoEditarCancelar(JButton botaoEditarCancelar) {
        this.botaoEditarCancelar = botaoEditarCancelar;
    }

    public JButton getBotaoExcluirOK() {
        return botaoExcluirOK;
    }

    public void setBotaoExcluirOK(JButton botaoExcluirOK) {
        this.botaoExcluirOK = botaoExcluirOK;
    }
}
