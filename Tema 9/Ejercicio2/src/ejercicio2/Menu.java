/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame implements ActionListener {

    File f = new File("C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 9\\prueba.txt");

    JButton[] botones = new JButton[12];

    JButton btn_reset;

    JTextField txf_numbers;
    String txf_text = "";

    JMenuBar mb_principal;
    JMenu m_movil, m_archivo, m_otros;
    JMenuItem mi_grabar, mi_leer, mi_reset, mi_salir, mi_acerca;

    public Menu() {
        super("Telefono");
        this.setLayout(null);

        // File
        mi_grabar = new JMenuItem("Guardar número");
        mi_grabar.setMnemonic('G');
        mi_grabar.addActionListener(this);

        mi_leer = new JMenuItem("Leer número");
        mi_leer.setMnemonic('L');
        mi_leer.addActionListener(this);

        m_archivo = new JMenu("Archivo");
        m_archivo.setMnemonic('A');
        m_archivo.add(mi_grabar);
        m_archivo.add(mi_leer);

        // Edit
        mi_reset = new JMenuItem("Reset");
        mi_reset.setMnemonic('R');
        mi_reset.addActionListener(this);

        mi_salir = new JMenuItem("Salir");
        mi_salir.setMnemonic('S');
        mi_salir.addActionListener(this);

        m_movil = new JMenu("Movil");
        m_movil.setMnemonic('M');
        m_movil.add(mi_reset);
        m_movil.addSeparator();
        m_movil.add(mi_salir);

        // About
        mi_acerca = new JMenuItem("About");
        mi_acerca.addActionListener(this);

        m_otros = new JMenu("Otros");
        m_otros.setMnemonic('O');
        m_otros.add(mi_acerca);

        // Main
        mb_principal = new JMenuBar();
        mb_principal.add(m_archivo);
        mb_principal.add(m_movil);
        mb_principal.add(m_otros);
        this.setJMenuBar(mb_principal);

        // Components
        txf_numbers = new JTextField(10);
        txf_numbers.setSize(230, 30);
        txf_numbers.setLocation(10, 170);
        txf_numbers.setEditable(false);
        txf_numbers.addActionListener(this);
        this.add(txf_numbers);

        btn_reset = new JButton("RESET");
        btn_reset.setSize(200, 30);
        btn_reset.setLocation(10, 220);
        btn_reset.addActionListener(this);
        this.add(btn_reset);

        int x = 10;
        int y = 10;
        for (int i = 0; i < botones.length; i++) {
            String btn_text = "" + (i + 1);
            if (i == 9) {
                btn_text = "#";
            }
            if (i == 10) {
                btn_text = "0";
            }
            if (i == 11) {
                btn_text = "*";
            }

            botones[i] = new JButton(btn_text);
            botones[i].setSize(70, 30);
            botones[i].setLocation(x, y);
            botones[i].addActionListener(this);
            botones[i].addKeyListener(new KeyHandler());
            botones[i].addMouseListener(new MouseHandler());
            botones[i].addMouseMotionListener(new MouseHandler());
            this.add(botones[i]);

            if ((i + 1) % 3 == 0) {
                x = 10;
                y += 40;
            } else {
                x += 80;
            }
        }
        this.addKeyListener(new KeyHandler());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_reset || e.getSource() == mi_reset) {
            txf_text = "";
            txf_numbers.setText(txf_text);
            for (JButton btn : botones) {
                btn.setBackground(null);
            }
        }

        if (e.getSource() == mi_salir) {
            Window win = FocusManager.getCurrentManager().getActiveWindow();
            win.dispose();
        }

        if (e.getSource() == mi_acerca) {
            JOptionPane.showMessageDialog(null, "<html><b>Telefono cutre</b><br>Creador: <b>Alberto Paz</b> </html>");
        }

        if (e.getSource() == mi_grabar) {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            
            try (PrintWriter pw = new PrintWriter(new FileWriter(f.getPath(), false))) {
                pw.println(txf_numbers.getText());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        if(e.getSource() == mi_leer){
            String texto = "";
            
            try(Scanner sc = new Scanner(f)){
                while(sc.hasNext()){
                    texto += sc.nextLine();
                }
                JOptionPane.showMessageDialog(null, "Información recibida: \n" + texto);
            }catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Archivo no econtrado");
            }
        }
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() >= 48 && e.getKeyCode() <= 57) {
                txf_text += e.getKeyChar();
                txf_numbers.setText(txf_text);
            } else if (e.getKeyChar() == '*' || e.getKeyChar() == '#') {
                txf_text += e.getKeyChar();
                txf_numbers.setText(txf_text);
            }
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton btn_clicked = ((JButton) e.getComponent());
            txf_text += btn_clicked.getText();
            txf_numbers.setText(txf_text);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            e.getComponent().setBackground(Color.GREEN);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getComponent().getBackground() != Color.GREEN) {
                e.getComponent().setBackground(Color.YELLOW);
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e){
            if(e.getComponent().getBackground() != Color.GREEN){
                e.getComponent().setBackground(null);
            }
        }
    }
}
