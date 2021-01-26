package minidec;

import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author github.com/dev7060
 */
public class Minidec extends javax.swing.JFrame {
    public Minidec() {
        initComponents();
        ImageIcon img = new ImageIcon("duck.png");
        setIconImage(img.getImage());
        Color bg = new Color(28, 27, 27);
        jTextArea1.setBackground(bg);
        jTextArea1.setForeground(Color.white);
        this.setTitle("Minidec");
        jTextArea2.setEditable(false);
        Color bg2 = new Color(45, 45, 45);
        Container container = getContentPane();
        container.setBackground(bg2);
        jTextArea2.setBackground(bg);
        jTextArea2.setForeground(Color.CYAN);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextField1.setText("Insert command line arguments");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Run");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Run");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        System.out.println("run event");
        String program = jTextArea1.getText();
        try {
            PrintWriter out = new PrintWriter("main.c");
            out.println(program);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Minidec.class.getName()).log(Level.SEVERE, null, ex);
        }
        Runtime rt = Runtime.getRuntime();
        try {
            ProcessBuilder builder = new ProcessBuilder("gcc", "main.c", "-o", "main.exe");
            builder.redirectOutput(new File("err.txt"));
            builder.redirectError(new File("err.txt"));
            Process p = builder.start();
            try {
                p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Minidec.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.destroyForcibly();
            File file = new File("err.txt");
            System.out.println("err file should have created");
            System.out.println(file.length());
            if (file.length() == 0) {
                System.out.println("no errors");
                ProcessBuilder builder2 = new ProcessBuilder("G:\\Minidec\\" + "main.exe");
                File op1 = new File("op1.txt");
                File op2 = new File("op2.txt");
                builder2.redirectOutput(op1);
                builder2.redirectError(op2);
                Process p2 = builder2.start();
                try {
                    p2.waitFor();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Minidec.class.getName()).log(Level.SEVERE, null, ex);
                }
                p2.destroyForcibly();
                File file2 = new File("G:\\Minidec\\op1.txt");
                FileInputStream fis = new FileInputStream(file2);
                byte[] data = new byte[(int) file2.length()];
                System.out.println((int) file2.length());
                fis.read(data);
                fis.close();
                op1.delete();
                op2.delete();
                System.out.println("hello");
                String content = new String(data, "UTF-8");
                System.out.println(content);
                String content4 = "$ gcc main.c -o main.exe";
                String content2 = content4 + "\n$ G:\\Minidec\\main.exe" + "\n" + content;
                jTextArea2.setText(content2);
            }

        } catch (IOException ex) {
            Logger.getLogger(Minidec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        jMenu3MouseClicked(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Minidec.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Minidec.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Minidec.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Minidec.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Minidec();
            }
        });
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
}
