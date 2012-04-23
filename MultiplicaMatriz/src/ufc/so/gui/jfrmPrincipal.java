/*
 * jfrmPrincipal.java
 *
 * Created on 17/04/2012, 22:50:23
 */
package ufc.so.gui;

import java.awt.Cursor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ufc.so.gui.data.MatrizFileManager;
import ufc.so.thread.Multiplicar;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class jfrmPrincipal extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc="Atributos privados">
    //vetor com msgs de log
    private static List<String> logs;
    private static int qtdThreadsExecutadas,totalThreads;

    // </editor-fold>
    
    /** Creates new form jfrmPrincipal */
    public jfrmPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnSelectMA = new javax.swing.JButton();
        jtxtPathMA = new javax.swing.JTextField();
        jtxtPathMB = new javax.swing.JTextField();
        jbtnSelectMB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtLinhasMatriz = new javax.swing.JTextField();
        jtxtColunasMatriz = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbtnGerarMatriz = new javax.swing.JButton();
        jbtnMultiplicaThread = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAStatus = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Multiplicação de Matrizes(Italo Pessoa)");
        setMinimumSize(new java.awt.Dimension(611, 409));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione as matrizes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 18))); // NOI18N

        jLabel2.setText("Matriz A:");

        jLabel3.setText("Matriz B:");

        jbtnSelectMA.setText("...");
        jbtnSelectMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectMAActionPerformed(evt);
            }
        });

        jtxtPathMA.setEditable(false);

        jtxtPathMB.setEditable(false);

        jbtnSelectMB.setText("...");
        jbtnSelectMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSelectMBActionPerformed(evt);
            }
        });

        jLabel1.setText("Linhas:");

        jLabel4.setText("Colunas:");

        jbtnGerarMatriz.setText("Gerar Matriz");
        jbtnGerarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGerarMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jtxtPathMA, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnSelectMA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxtPathMB, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnSelectMB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxtColunasMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jbtnGerarMatriz))
                            .addComponent(jtxtLinhasMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtPathMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSelectMA))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtPathMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSelectMB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtLinhasMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jbtnGerarMatriz)
                    .addComponent(jtxtColunasMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbtnMultiplicaThread.setText("Com Thread");
        jbtnMultiplicaThread.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtnMultiplicaThread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMultiplicaThreadActionPerformed(evt);
            }
        });

        jButton2.setText("Sem Thread");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtxtAStatus.setColumns(20);
        jtxtAStatus.setRows(5);
        jScrollPane1.setViewportView(jtxtAStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jbtnMultiplicaThread)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnMultiplicaThread)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-611)/2, (screenSize.height-452)/2, 611, 452);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnMultiplicaThreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMultiplicaThreadActionPerformed
        this.multiplicarComThread();
    }//GEN-LAST:event_jbtnMultiplicaThreadActionPerformed

    private void jbtnSelectMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectMAActionPerformed
        selectMatrizFile("a");
    }//GEN-LAST:event_jbtnSelectMAActionPerformed

    private void jbtnSelectMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSelectMBActionPerformed
        selectMatrizFile("b");
    }//GEN-LAST:event_jbtnSelectMBActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.multiplicarSemThread();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbtnGerarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGerarMatrizActionPerformed
        MatrizFileManager m = new MatrizFileManager();
    
        int l = Integer.parseInt(jtxtLinhasMatriz.getText());
        int c = Integer.parseInt(jtxtColunasMatriz.getText());
        
        m.generateMatrizXML(gerarMatriz(l, c),l, c, "/home/italoney/NetBeansProjects/matrizes/"+l+"x"+c+".xml");
    }//GEN-LAST:event_jbtnGerarMatrizActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        String nativeLF = UIManager.getSystemLookAndFeelClassName();
        try {
            //for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            //  if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(nativeLF);
            //}
            //}
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jfrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jfrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jfrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(jfrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }


        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new jfrmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnGerarMatriz;
    private javax.swing.JButton jbtnMultiplicaThread;
    private javax.swing.JButton jbtnSelectMA;
    private javax.swing.JButton jbtnSelectMB;
    private javax.swing.JTextArea jtxtAStatus;
    private javax.swing.JTextField jtxtColunasMatriz;
    private javax.swing.JTextField jtxtLinhasMatriz;
    private javax.swing.JTextField jtxtPathMA;
    private javax.swing.JTextField jtxtPathMB;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="Métodos privados">

    /**
     * Multiplicar matrizes com threads
     */
    private void multiplicarComThread() {
        
        String matrizFileA = this.aplicarRegex(this.jtxtPathMA.getText());
        String matrizFileB = this.aplicarRegex(this.jtxtPathMB.getText());
        
        int linhaA = 0, linhaB = 0,colunaA = 0, colunaB = 0;

        //Escoler tipo de matriz

        String[] linha_colunaA  = matrizFileA.split("x");
        String[] linha_colunaB  = matrizFileB.split("x");
        
        linhaA = Integer.parseInt(linha_colunaA[0]);
        colunaA = Integer.parseInt(linha_colunaA[1]);
        
        linhaB = Integer.parseInt(linha_colunaB[0]);
        colunaB = Integer.parseInt(linha_colunaB[1]);
       
        //validar matrizes
        
        try {
            if(colunaA != linhaB)
                throw  new Exception("Matrizes incompatíveis");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
                    
        logs = new ArrayList<String>();

        Multiplicar m = new Multiplicar(linhaA, linhaB, colunaA, colunaB, jtxtPathMA.getText() , jtxtPathMB.getText());
        m.multiplicarComThread();

        for (String msg : logs) {
            jtxtAStatus.setText(jtxtAStatus.getText() + msg);
        }
    }
    
    /**
     * Multiplicar matrizes sem threads
     */
    private void multiplicarSemThread() {
        
        String matrizFileA = this.aplicarRegex(this.jtxtPathMA.getText());
        String matrizFileB = this.aplicarRegex(this.jtxtPathMB.getText());
        
        int linhaA = 0, linhaB = 0,colunaA = 0, colunaB = 0;

        // Escolher tipo de matriz

        String[] linha_colunaA  = matrizFileA.split("x");
        String[] linha_colunaB  = matrizFileB.split("x");
        
        linhaA = Integer.parseInt(linha_colunaA[0]);
        colunaA = Integer.parseInt(linha_colunaA[1]);
        
        linhaB = Integer.parseInt(linha_colunaB[0]);
        colunaB = Integer.parseInt(linha_colunaB[1]);
       
        //validar matrizes
        
        try {
            if(colunaA != linhaB)
                throw  new Exception("Matrizes incompatíveis");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
            return;
        }
                    
        logs = new ArrayList<String>();

        Multiplicar m = new Multiplicar(linhaA, linhaB, colunaA, colunaB, jtxtPathMA.getText() , jtxtPathMB.getText());
        m.multiplicarSemThread();

        for (String msg : logs) {
            jtxtAStatus.setText(jtxtAStatus.getText() + msg);
        }
    }

    /**
     * Armazenar log de threads
     * @param msg 
     */
    public static void logThreadStatus(String msg) {
        logs.add(msg);
    }
    
    /**
     * Exibir JFileChooser para selecionar o arquivo xml
     * @param matriz 
     */
    private void selectMatrizFile(String matriz){
        JFileChooser fc = new JFileChooser("/home/italoney/NetBeansProjects/matrizes");
        fc.showDialog(this, "Ok");
        File f = fc.getSelectedFile();
        
        if(matriz.equals("a")){
            this.jtxtPathMA.setText(f.getPath());
        }else{
            this.jtxtPathMB.setText(f.getPath());
        }
    }

    /**
     * Aplicar expressão regular para remover valores desnecessários 
     * do caminho do arquivo xml
     * @param filePath Caminho do arquivo 
     */
    private String aplicarRegex(String filePath){
        Pattern p = Pattern.compile(".*/");
        Matcher m = p.matcher(filePath);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        
        p = Pattern.compile(".xml");
        m = p.matcher(sb.toString());
        sb = new StringBuffer();
        
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        
        m.appendTail(sb);
        
        return sb.toString();
        
    }

    public static void updateQtdThreadsExecutadas(int valor){
        qtdThreadsExecutadas =valor;
        //System.out.println(valor);
    }
    
    public static void updateQtdTotalThreads(int total){
        //System.out.println(total);
        totalThreads = total;
    }

    /**
     * Gerar matriz com valores aleatórios
     * @param l Linhas da matriz
     * @param c Colunas da matriz
     * @return Matriz preenchida
     */
    private int[][] gerarMatriz(int l, int c){
        int [][] m = new int[l][c];
        for(int x=0; x<l; x++){
            for(int y=0; y<c; y++){
                int valor = 1 + (int) (Math.random()*80);  
                m[x][y] = valor;
                //System.out.println("m["+x+"]["+y+"]"+ "="+valor);
            }
        }
        System.out.println("matriz preenchida");
        
        return m;
    }

    // </editor-fold>
}
