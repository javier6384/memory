/*
 *  Juego Memory
 */
package memory;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier Fernández
 */
public class MemoryWin extends javax.swing.JFrame {

    public MemoryWin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        jTextSecuencia.setEditable(false);
        jButtonMostrar.setEnabled(false);
    }
    
    String caracter;
    String secuencia = "";    
    String secuenciaMostrada = "**********";
    String secuenciaProvisional = secuenciaMostrada;
    
    int posicion;
    int orden = posicion;
    int repeticion = 0;
    
    char caracterComparado;
    char caracterActual;
    
    char posicion1;
    char posicion2;
    int aciertos = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextSecuencia = new javax.swing.JTextField();
        jLabelMemory = new javax.swing.JLabel();
        jLabelEscoge = new javax.swing.JLabel();
        jTextPos1 = new javax.swing.JTextField();
        jTextPos2 = new javax.swing.JTextField();
        jButtonMostrar = new javax.swing.JButton();
        jButtonGenerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextSecuencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextSecuencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextSecuencia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextSecuencia.setFocusable(false);

        jLabelMemory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMemory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMemory.setText("Memory");

        jLabelEscoge.setText("Escoge las posiciones a mostrar:");

        jTextPos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextPos2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        jButtonGenerar.setText("Generar");
        jButtonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 7)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextSecuencia)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextPos1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextPos2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonMostrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonGenerar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEscoge)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jLabelMemory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelMemory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextSecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jButtonGenerar)
                .addGap(18, 18, 18)
                .addComponent(jLabelEscoge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextPos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextPos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMostrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarActionPerformed
        
        
        jButtonMostrar.setEnabled(true);
        secuencia = "";
        secuenciaMostrada = "**********";
        Random aleatorio = new Random();              
               
        for(posicion = 0; posicion <= 9; posicion ++){
            int valor = aleatorio.nextInt(5);

            String valorText = String.valueOf(valor);
            caracter = valorText;
            switch (caracter){
                case "0":
                    caracter = "#";
                    break;
                case "1":
                    caracter = "@";
                    break;
                case "2":
                    caracter = "%";
                    break;
                case "3":
                    caracter = "$";
                    break;
                case "4":
                    caracter = "&";
                    break;
            }
            
            secuencia = secuencia.concat(caracter);
            
            for (orden = posicion - 1; orden >= 0; orden --) {
                caracterComparado = secuencia.charAt(orden);
                caracterActual = caracter.charAt(0);
                
                if (caracterActual == caracterComparado){
                    repeticion += 1;
                }
                
                if (repeticion == 2){
                    secuencia = secuencia.substring(0, posicion);
                    repeticion = 0;
                    posicion --;
                }
                
//                System.out.println(caracterComparado);
            }
           
        }
        
        System.out.println(secuencia);        
        jTextSecuencia.setText(secuenciaMostrada); 
        jButtonGenerar.setEnabled(false);
    }//GEN-LAST:event_jButtonGenerarActionPerformed

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        secuenciaProvisional = secuenciaMostrada;
        
        try {
        posicion1 = secuencia.charAt(Integer.valueOf(jTextPos1.getText()) - 1);
        posicion2 = secuencia.charAt(Integer.valueOf(jTextPos2.getText()) - 1);
//        System.out.println(posicion1);
//        System.out.println(posicion2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Debe introducir un número entero entre 1 y 10");
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Debe introducir un número entero entre 1 y 10");
        }
        
        if (posicion1 == posicion2){
            secuenciaMostrada = secuenciaMostrada.substring(0,Integer.valueOf(jTextPos1.getText()) - 1) + 
                    secuencia.substring(Integer.valueOf(jTextPos1.getText())- 1,Integer.valueOf(jTextPos1.getText())) +
                    secuenciaMostrada.substring(Integer.valueOf(jTextPos1.getText()) ,Integer.valueOf(jTextPos2.getText()) - 1) +
                    secuencia.substring(Integer.valueOf(jTextPos2.getText())- 1,Integer.valueOf(jTextPos2.getText())) +
                    secuenciaMostrada.substring(Integer.valueOf(jTextPos2.getText()));
            jTextSecuencia.setText(secuenciaMostrada);
        } else {
            secuenciaProvisional = secuenciaMostrada.substring(0,Integer.valueOf(jTextPos1.getText()) - 1) + 
                    secuencia.substring(Integer.valueOf(jTextPos1.getText())- 1,Integer.valueOf(jTextPos1.getText())) +
                    secuenciaMostrada.substring(Integer.valueOf(jTextPos1.getText()) ,Integer.valueOf(jTextPos2.getText()) - 1) +
                    secuencia.substring(Integer.valueOf(jTextPos2.getText())- 1,Integer.valueOf(jTextPos2.getText())) +
                    secuenciaMostrada.substring(Integer.valueOf(jTextPos2.getText()));
            jTextSecuencia.setText(secuenciaProvisional);
        }
        
        
        if (secuencia.compareTo(secuenciaMostrada) == secuenciaMostrada.compareTo(secuencia)) {
            jTextSecuencia.setText("You Win!!!");
            jButtonGenerar.setEnabled(true);
            jButtonMostrar.setEnabled(false);
            jTextPos1.setText(null);
            jTextPos2.setText(null);
        }
        
        System.out.println(secuencia);
        System.out.println(secuenciaMostrada);
        System.out.println(secuenciaProvisional);
    }//GEN-LAST:event_jButtonMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(MemoryWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoryWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoryWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoryWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoryWin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEscoge;
    private javax.swing.JLabel jLabelMemory;
    private javax.swing.JTextField jTextPos1;
    private javax.swing.JTextField jTextPos2;
    private javax.swing.JTextField jTextSecuencia;
    // End of variables declaration//GEN-END:variables
}
