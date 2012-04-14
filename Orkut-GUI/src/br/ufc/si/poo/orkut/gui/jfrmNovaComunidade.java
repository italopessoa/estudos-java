/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jfrmNovaComunidade.java
 *
 * Created on 05/11/2011, 14:47:24
 */
package br.ufc.si.poo.orkut.gui;

import br.ufc.si.poo.orkut.beans.comunidade.Comunidade;
import br.ufc.si.poo.orkut.beans.comunidade.ComunidadePrivada;
import br.ufc.si.poo.orkut.beans.comunidade.ComunidadePublica;
import br.ufc.si.poo.orkut.beans.forum.Forum;
import br.ufc.si.poo.orkut.beans.usuario.Usuario;
import br.ufc.si.poo.orkut.util.Categoria;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author italoney
 */
public class jfrmNovaComunidade extends javax.swing.JFrame {

    //<editor-fold defaultstate="collapsed" desc="Membros privados">
    private Map<String, Comunidade> comunidades;
    private Map<String, Usuario> usuarios;
    private Map<String, Forum> foruns;
    //</editor-fold>      

    /** Creates new form jfrmNovaComunidade */
    public jfrmNovaComunidade() {
        initComponents();
    }

    /**
     * @author italoney
     * Contrutor para inicializar propriedades
     * @param comunidades comunidades disponiveis
     * @param usuarios usuários disponiveis
     * @param foruns foruns disponiveis
     */
    public jfrmNovaComunidade(Map<String, Comunidade> comunidades, Map<String, Usuario> usuarios, Map<String, Forum> foruns) {
        initComponents();
        inicializarCampos();

        this.comunidades = comunidades;
        this.usuarios = usuarios;
        this.foruns = foruns;

        buttonGroup1.add(jrbPublico);
        buttonGroup1.add(jrbPrivado);

        jrbPublico.setSelected(true);

        buttonGroup2.add(jrbSCategoria);
        buttonGroup2.add(jrbEsporte);
        buttonGroup2.add(jrbEducacao);

        jrbSCategoria.setSelected(true);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrbSCategoria = new javax.swing.JRadioButton();
        jrbEsporte = new javax.swing.JRadioButton();
        jtxtTtituloComunidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jrbEducacao = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jrbPublico = new javax.swing.JRadioButton();
        jrbPrivado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Digite os dados da comunidade", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 1, 14))); // NOI18N

        jrbSCategoria.setText("Sem categoria");

        jrbEsporte.setText("Esporte");

        jtxtTtituloComunidade.setText("jtxtTtituloComunidade");

        jLabel3.setText("Categoria:");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jrbEducacao.setText("Educação");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Titulo:");

        jLabel2.setText("Acesso:");

        jrbPublico.setText("Público");

        jrbPrivado.setText("Privado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jtxtTtituloComunidade, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jrbPublico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbPrivado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jrbSCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbEsporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbEducacao))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtTtituloComunidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPublico)
                    .addComponent(jrbPrivado))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbSCategoria)
                    .addComponent(jrbEsporte)
                    .addComponent(jrbEducacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-396)/2, (screenSize.height-255)/2, 396, 255);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Comunidade comunidade = null;
        if (jtxtTtituloComunidade.getText() != null && !jtxtTtituloComunidade.getText().equals("")) {

            String titulo = jtxtTtituloComunidade.getText();
            int categoria = getCategoria();

            if (jrbPublico.isSelected()) {
                comunidade = new ComunidadePublica();
                comunidade.setCategoria(categoria);
                comunidade.setTitulo(titulo);

                this.comunidades.put(comunidade.getTitulo(), comunidade);
                jfrmPrincipal manager = new jfrmPrincipal();
                manager.atualizarListas(this.comunidades, this.usuarios, this.foruns);
                this.dispose();
            } else {
                comunidade = new ComunidadePrivada();
                comunidade.setCategoria(categoria);
                comunidade.setTitulo(titulo);

                this.comunidades.put(comunidade.getTitulo(), comunidade);
                jfrmPrincipal manager = new jfrmPrincipal();
                manager.atualizarListas(this.comunidades, this.usuarios, this.foruns);
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Digite o titulo da comunidade",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jfrmPrincipal manager = new jfrmPrincipal();
        manager.atualizarListas(this.comunidades, this.usuarios, this.foruns);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new jfrmNovaComunidade().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jrbEducacao;
    private javax.swing.JRadioButton jrbEsporte;
    private javax.swing.JRadioButton jrbPrivado;
    private javax.swing.JRadioButton jrbPublico;
    private javax.swing.JRadioButton jrbSCategoria;
    private javax.swing.JTextField jtxtTtituloComunidade;
    // End of variables declaration//GEN-END:variables

    /**
     * @author italoney
     * Identificar categoria selecionada ao criar ma comundiade
     * @return cosigo de cxategoria
     */
    private int getCategoria() {

        if (jrbSCategoria.isSelected()) {
            return Categoria.COD_SEM_CATEGORIA;
        }

        if (jrbEsporte.isSelected()) {
            return Categoria.COD_CATEGORIA_ESPORTE;
        }

        if (jrbSCategoria.isSelected()) {
            return Categoria.COD_SEM_CATEGORIA;
        }

        return 0;
    }

    /**
     * @author italoney
     * Inicializar campos do formulário
     */
    private void inicializarCampos() {
        jtxtTtituloComunidade.setText("");
    }
}
