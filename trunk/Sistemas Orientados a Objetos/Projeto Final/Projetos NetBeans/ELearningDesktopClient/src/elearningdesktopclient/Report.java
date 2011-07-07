/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Report.java
 *
 * Created on 04/07/2011, 22:31:55
 */

package elearningdesktopclient;

import ELearning.services.client.relatorios.Aluno;
import ELearning.services.client.relatorios.DisciplineGradeReport;
import ELearning.services.client.relatorios.EnrollmentCountReport;
import ELearning.services.client.relatorios.EnrollmentCriteriaReport;
import ELearning.services.client.relatorios.Professor;
import ELearning.services.client.relatorios.StudentDisciplineGradeReport;
import ELearning.services.client.relatorios.StudentEnrollmentModel;
import ELearning.services.client.relatorios.StudentListReport;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Acessa SP
 */
public class Report extends javax.swing.JDialog {
    List list = null;

    /** Creates new form Report */
    public Report(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Report(java.awt.Frame parent, boolean modal,Object obj) {
        super(parent, modal);
        initComponents();

        list = (List)obj;

        if(list.size() > 0){
            if(list.get(0) instanceof Professor){
                List<Professor> reportList = list;
                
                String[] colunas = {"Login","Endereço","Telefone"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();

                for(Professor p : reportList){
                    Vector v = new Vector();
                    v.add(p.getLogin());
                    v.add(p.getEndereco());
                    v.add(p.getTelefone());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof Aluno){
                List<Aluno> reportList = list;
                
                String[] colunas = {"Login","Endereço","Telefone"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();
                
                for(Aluno a : reportList){
                    Vector v = new Vector();
                    v.add(a.getLogin());
                    v.add(a.getEndereco());
                    v.add(a.getTelefone());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof StudentEnrollmentModel){
                List<StudentEnrollmentModel> reportList = list;

                String[] colunas = {"Nome da Disciplina","Login","Data Início","Data Fim"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();
                
                for(StudentEnrollmentModel sem : reportList){
                    Vector v = new Vector();
                    v.add(sem.getNomeDisciplina());
                    v.add(sem.getLogin());
                    v.add((sem.getDataInicio() == null) ? "" : sem.getDataInicio());
                    v.add((sem.getDataInicio() == null) ? "" : sem.getDataInicio());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof DisciplineGradeReport){
                List<DisciplineGradeReport> reportList = list;

                String[] colunas = {"Login","Nome da Disciplina","Nota Final"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();

                for(DisciplineGradeReport dgr : reportList){
                    Vector v = new Vector();
                    v.add(dgr.getLogin());
                    v.add(dgr.getNomeDisciplina());
                    v.add(dgr.getNotaFinal());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof EnrollmentCountReport){
                List<EnrollmentCountReport> reportList = list;

                String[] colunas = {"Nome da Disciplina","Quantidade de Alunos"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();

                for(EnrollmentCountReport ecr : reportList){
                    Vector v = new Vector();
                    v.add(ecr.getNomeDisciplina());
                    v.add(ecr.getCountDisciplina());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof EnrollmentCriteriaReport){
                List<EnrollmentCriteriaReport> reportList = list;

                String[] colunas = {"Nome da Disciplina","Nome do Critério","Peso"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();

                for(EnrollmentCriteriaReport ecr : reportList){
                    Vector v = new Vector();
                    v.add(ecr.getNomeDisciplina());
                    v.add(ecr.getNome());
                    v.add(ecr.getPeso());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof StudentDisciplineGradeReport){
                List<StudentDisciplineGradeReport> reportList = list;
               
                String[] colunas = {"Nome da Disciplina","Nota Final"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();

                for(StudentDisciplineGradeReport sdgr : reportList){
                    Vector v = new Vector();
                    v.add(sdgr.getNomeDisciplina());
                    v.add(sdgr.getNotaFinal());
                    reportModel.addRow(v);
                }
            }else if(list.get(0) instanceof StudentListReport){
                List<StudentListReport> reportList = list;

                String[] colunas = {"Login","Nome da Disciplina"};
                relatorio.setModel(new DefaultTableModel(colunas, 0));
                DefaultTableModel reportModel = (DefaultTableModel)relatorio.getModel();

                for(StudentListReport slr : reportList){
                    Vector v = new Vector();
                    v.add(slr.getLogin());
                    v.add(slr.getNomeDisciplina());
                    reportModel.addRow(v);
                }
            }
        }else{
            JOptionPane.showMessageDialog(relatorio,"Relatório sem dados pra exibir!","Erro!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        relatorio = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        relatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        relatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        relatorio.setName("relatorio"); // NOI18N
        jScrollPane1.setViewportView(relatorio);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(elearningdesktopclient.ELearningDesktopClientApp.class).getContext().getResourceMap(Report.class);
        btnFechar.setText(resourceMap.getString("btnFechar.text")); // NOI18N
        btnFechar.setName("btnFechar"); // NOI18N
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Report dialog = new Report(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable relatorio;
    // End of variables declaration//GEN-END:variables

}
