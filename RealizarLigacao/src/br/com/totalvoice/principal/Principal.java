package br.com.totalvoice.principal;

import br.com.totalvoice.TotalVoiceClient;
import br.com.totalvoice.api.Tts;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/*
* 16/08/2018 - 18:05h
* @Abner Rodrigues
* 
* Neste exemplo, eu usei o Regex para separar o
* texto que nós precisamos.
*
* E converti as teclas pressionadas de acordo
* com o que elas representam.
 */
public class Principal extends javax.swing.JFrame {

    JSONObject resultadoChamada;
    String relatorio;

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campotelefone = new javax.swing.JTextField();
        camponome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        voz = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        botaoLigacao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoid = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoResposta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Voz:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        campotelefone.setToolTipText("Digite o telefone que receberá a chamada.");
        campotelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 209, 229)));
        jPanel2.add(campotelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, 20));

        camponome.setToolTipText("Digite o nome da pessoa que será mencionada na ligação.");
        camponome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 209, 229)));
        jPanel2.add(camponome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 410, 20));

        jLabel2.setForeground(new java.awt.Color(100, 100, 100));
        jLabel2.setText("Nome da Pessoa:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        voz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "br-Vitoria", "br-Ricardo" }));
        voz.setSelectedIndex(-1);
        voz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 209, 229)));
        jPanel2.add(voz, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 170, -1));

        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setText("Telefone:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        botaoLigacao.setBackground(new java.awt.Color(115, 202, 139));
        botaoLigacao.setForeground(new java.awt.Color(255, 255, 255));
        botaoLigacao.setText("Realizar Ligação");
        botaoLigacao.setToolTipText("");
        botaoLigacao.setContentAreaFilled(false);
        botaoLigacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoLigacao.setFocusPainted(false);
        botaoLigacao.setOpaque(true);
        botaoLigacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLigacaoActionPerformed(evt);
            }
        });
        jPanel2.add(botaoLigacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 150));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(100, 100, 100));
        jLabel1.setText("ID da Ligação:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        campoid.setEditable(false);
        campoid.setToolTipText("Este é o ID da chamada TTS! Você não pode alterar este campo.");
        campoid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 209, 229)));
        jPanel3.add(campoid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 330, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 430, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(61, 102, 140));
        jLabel4.setText("Outra tecla: Desconhecido");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(63, 140, 66));
        jLabel5.setText("Tecla 2: Entrada Autorizada");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(140, 62, 62));
        jLabel6.setText("Tecla 3: Entrada Negada");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        campoResposta.setEditable(false);
        campoResposta.setBackground(new java.awt.Color(255, 255, 255));
        campoResposta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoResposta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(campoResposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 430, 120));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("www.totalvoice.com.br");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLigacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLigacaoActionPerformed
        try {
            TotalVoiceClient client = new TotalVoiceClient("{{Seu Acess Token}}");
            Tts tts = new Tts(client);
            resultadoChamada = tts.enviar(
                    campotelefone.getText(), //Telefone
                    "Olá! O seu amigo: " + camponome.getText() + " chegou, podemos autorizar a entrada? Digite 1, para sim, ou 2, para não", //Mensagem
                    -3, //Velocidade da Mensagem
                    true, //Resposta do Usuário
                    String.valueOf(voz.getSelectedItem())); //Voz que será reproduzida
            System.out.println(resultadoChamada);
            mostrarIdTTS();
            respostaTTS();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_botaoLigacaoActionPerformed

    /*
    * Aqui nós pegamos o ID do TTS
    * e setamos no campoid.
    *
    * Nós utilizamos o Regex para
    * recuperar o ID. Pegamos a 
    * String "resultadoChamada"
    * e isolamos a parte do ID.
     */
    private void mostrarIdTTS() {
        Pattern PATTERN = Pattern.compile(".*\"id\":([a-z0-9\\-]+).*");
        Matcher matcher = PATTERN.matcher(String.valueOf(resultadoChamada));
        if (matcher.matches() && matcher.groupCount() == 1) {
            String idDoUsuario = matcher.group(1);
            System.out.println("ID: " + idDoUsuario);
            campoid.setText(idDoUsuario);
        } else {
            System.out.println("Não encontrou.");
        }
    }

    /*
    * Aqui nós cancelamos o timer
    * e desabilitamos os campos e botões.
     */
    private void finalDaLigacao() {
        botaoLigacao.setEnabled(false);
        botaoLigacao.setBackground(new java.awt.Color(82, 150, 101));
        timer.cancel();
        System.out.println("Relatório da chamada: " + relatorio);
    }

    /*
    * Aqui nós pegamos a resposta do destinatário
    * e convertemos a resposta para a informação
    * que este número representa.
    
    * Para pegar o resultado automaticamente
    * usamos o timer, com delay de 5 segundos
    * e um intervalo de procura de 1 segundo.
     */
    int delay = 5000;   // delay de 5 seg.
    int intervalo = 1000;  // intervalo de 1 seg.
    Timer timer = new Timer();

    private void respostaTTS() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                EvolineAPI evo = new EvolineAPI("{{Seu Acess Token}}");
                relatorio = String.valueOf(evo.statusTTS(Integer.parseInt(campoid.getText())));

                Pattern PATTERN = Pattern.compile(".*\"resposta\":\"([a-z0-9\\-]+).*");
                Matcher matcher = PATTERN.matcher(relatorio);

                if (matcher.matches() && matcher.groupCount() == 1) {
                    String teclaPressionada = matcher.group(1);

                    if (teclaPressionada.equals("1")) { //Se a tecla digitada for igual a 1....
                        campoResposta.setForeground(new java.awt.Color(63, 140, 66)); //Muda a cor do texto para verde
                        campoResposta.setText("Entrada autorizada! Tecla pressionada: " + teclaPressionada);
                        finalDaLigacao();
                    } else if (teclaPressionada.equals("2")) { //Se a tecla digitada for igual a 2....
                        campoResposta.setForeground(new java.awt.Color(140, 62, 62)); //Muda a cor do texto para vermelho
                        campoResposta.setText("Entrada não autorizada! Tecla pressionada: " + teclaPressionada);
                        finalDaLigacao();
                    } else if (teclaPressionada.equals("") || teclaPressionada.equals(" ")) { //Se a tecla digitada for igual a (vazio)....
                        campoResposta.setForeground(new java.awt.Color(61, 102, 140)); //Muda a cor do texto para azul
                        campoResposta.setText("Resposta desconhecida! O destinatário desligou a ligação!");
                        System.out.println(teclaPressionada);
                        finalDaLigacao();
                    } else {
                        campoResposta.setForeground(new java.awt.Color(61, 102, 140));
                        campoResposta.setText("Resposta desconhecida! Tecla pressionada: " + teclaPressionada);
                        finalDaLigacao();
                    }
                } else {
                    //System.out.println("Não encontrou.");
                }
            }
        }, delay, intervalo);
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLigacao;
    private javax.swing.JTextField campoResposta;
    private javax.swing.JTextField campoid;
    private javax.swing.JTextField camponome;
    private javax.swing.JTextField campotelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> voz;
    // End of variables declaration//GEN-END:variables
}
