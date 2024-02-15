package componentePrueba;

import javax.swing.JOptionPane;

public class PruebaComponente extends javax.swing.JFrame {

    public PruebaComponente() {
        // Inicializa los componentes de la interfaz
        initComponents();
    }

    // Método generado por NetBeans, suprime advertencias de unchecked
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        relojBean1 = new Componentes.RelojBean();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        relojBean1.setAlarmaActivada(true);
        relojBean1.setHoraAlarma(3);
        relojBean1.setMinutosAlarma(25);
        relojBean1.addAlarmaListener(new Componentes.RelojBean.AlarmaListener() {
            public void alarmaOcurred(Componentes.AlarmaEvent evt) {
                relojBean1AlarmaOcurred(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(relojBean1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(relojBean1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void relojBean1AlarmaOcurred(Componentes.AlarmaEvent evt) {//GEN-FIRST:event_relojBean1AlarmaOcurred
        JOptionPane.showMessageDialog(null, "La cuenta atrás ha terminado", "Aviso",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_relojBean1AlarmaOcurred

    public static void main(String args[]) {
        // Ejecuta el código en el subproceso de despacho de eventos de la AWT
        java.awt.EventQueue.invokeLater(new Runnable() {
        // Implementación del método run de la interfaz Runnable
          public void run() {
              // Crea una nueva instancia de PruebaComponente y la hace visible
               new PruebaComponente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.RelojBean relojBean1;
    // End of variables declaration//GEN-END:variables
}
