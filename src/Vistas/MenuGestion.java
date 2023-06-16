
package Vistas;

public class MenuGestion extends javax.swing.JFrame {

   
    public MenuGestion() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jFormProyecto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jFormEquipo = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jFormEquipoMiembros = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jFormMiembros = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jFormTareas = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jFormComentarios = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jMenu1.setText("Proyectos");

        jFormProyecto.setText("Formulario Proyectos");
        jFormProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormProyectoActionPerformed(evt);
            }
        });
        jMenu1.add(jFormProyecto);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Equipo");

        jFormEquipo.setText("Formulario  Equipo");
        jFormEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormEquipoActionPerformed(evt);
            }
        });
        jMenu2.add(jFormEquipo);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("Equipo Miembros");

        jFormEquipoMiembros.setText("FormularioEquipoMiembros");
        jMenu7.add(jFormEquipoMiembros);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Miembros");

        jFormMiembros.setText("Formulario Miembros");
        jMenu8.add(jFormMiembros);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Tareas");

        jFormTareas.setText("Formulario Tareas");
        jFormTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormTareasActionPerformed(evt);
            }
        });
        jMenu9.add(jFormTareas);

        jMenuBar1.add(jMenu9);

        jMenu10.setText("Comentarios");

        jFormComentarios.setText("Formulario Comentarios");
        jMenu10.add(jFormComentarios);

        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormProyectoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaProyectos vp = new VistaProyectos();
        vp.setVisible(true);
        escritorio.add(vp);
        escritorio.moveToFront(vp);
    }//GEN-LAST:event_jFormProyectoActionPerformed

    private void jFormEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormEquipoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaEquipo ve = new VistaEquipo();
        ve.setVisible(true);
        escritorio.add(ve);
        escritorio.moveToFront(ve);
    }//GEN-LAST:event_jFormEquipoActionPerformed

    private void jFormTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormTareasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaTareas vt = new VistaTareas();
        vt.setVisible(true);
        escritorio.add(vt);
        escritorio.moveToFront(vt);
    }//GEN-LAST:event_jFormTareasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jFormComentarios;
    private javax.swing.JMenuItem jFormEquipo;
    private javax.swing.JMenuItem jFormEquipoMiembros;
    private javax.swing.JMenuItem jFormMiembros;
    private javax.swing.JMenuItem jFormProyecto;
    private javax.swing.JMenuItem jFormTareas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    // End of variables declaration//GEN-END:variables
}
