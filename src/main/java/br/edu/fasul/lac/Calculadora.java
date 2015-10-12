package br.edu.fasul.lac;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Calculadora extends javax.swing.JFrame {

    public Calculadora() {
        initComponents();
        centralize();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entradaField = new javax.swing.JTextField();
        entradaLabel = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        calcularButton = new javax.swing.JButton();
        resultadoLabel = new javax.swing.JLabel();
        respostaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora Lógica");
        setResizable(false);

        entradaField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                entradaFieldFocusGained(evt);
            }
        });
        entradaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entradaFieldKeyPressed(evt);
            }
        });

        entradaLabel.setText("Digite a expressão lógica:");

        titulo.setFont(new java.awt.Font("Tahoma", 1, 14));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Calculadora de expressões lógicas");

        calcularButton.setText("Calcular");
        calcularButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularButtonActionPerformed(evt);
            }
        });

        resultadoLabel.setText("Resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(entradaField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(entradaLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calcularButton, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultadoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(respostaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(entradaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entradaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calcularButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultadoLabel)
                    .addComponent(respostaLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void calcularButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularButtonActionPerformed
    ExpressaoLogica expLogica = new ExpressaoLogica(entradaField.getText());
    if (ExpressaoLogica.isValida(entradaField.getText())) {
        expLogica.executa();
        respostaLabel.setText(entradaField.getText().toUpperCase().replaceAll("V", "v").replaceAll(" ", "").replaceAll("", " ").replaceAll("< - >", "<->").replaceAll("- >", "->").trim() + " = " + expLogica.resposta());
    } else {
        respostaLabel.setText("Expressão Inválida");
    }
}//GEN-LAST:event_calcularButtonActionPerformed

private void entradaFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_entradaFieldFocusGained
// Limpa a resposta e a caixa de texto
    entradaField.setText("");
    respostaLabel.setText("");
}//GEN-LAST:event_entradaFieldFocusGained

private void entradaFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entradaFieldKeyPressed
    if (evt.getKeyCode() == 10)
        calcularButtonActionPerformed(null);
}//GEN-LAST:event_entradaFieldKeyPressed

    public void centralize() {
        Dimension t = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension j = getSize();
        if (j.height > t.height) {
            setSize(j.width, t.height);
        }
        if (j.width > t.width) {
            setSize(t.width, j.height);
        }
        setLocation((t.width - j.width) / 2, (t.height - j.height) / 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularButton;
    private javax.swing.JTextField entradaField;
    private javax.swing.JLabel entradaLabel;
    private javax.swing.JLabel respostaLabel;
    private javax.swing.JLabel resultadoLabel;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
