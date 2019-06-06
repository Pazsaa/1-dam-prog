/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame {

    JButton btn_1;
    JButton btn_2;

    JLabel lbl;

    String coords;
    String title = "Control de Ratón: ";

    Component[] comps;

    Color c = Color.GREEN;

    public Menu() {
        this.setLayout(null);
        this.setFocusable(true);

        comps = this.getContentPane().getComponents();

        btn_1 = new JButton("Izquierdo");
        btn_1.setBounds(80, 80, 120, 80);
        btn_1.addMouseMotionListener(new MouseHandler());
        btn_1.addMouseListener(new MouseHandler());
        btn_1.setEnabled(false);
        this.add(btn_1);

        btn_2 = new JButton("Derecho");
        btn_2.setBounds(210, 80, 120, 80);
        btn_2.addMouseListener(new MouseHandler());
        btn_2.addMouseMotionListener(new MouseHandler());
        btn_2.setEnabled(false);
        this.add(btn_2);

        lbl = new JLabel("Teclas: ");
        lbl.setBounds(140, 140, 200, 140);
        add(lbl);

        this.getContentPane().addMouseListener(new MouseHandler());
        this.getContentPane().addMouseMotionListener(new MouseHandler());

        this.addKeyListener(new KeyHandler());
        this.addWindowListener(new Cerrar());

        MenuSecundario m_sec = (MenuSecundario) this.getOwner();
    }

    public void displaySecondary() {
        MenuSecundario m_sec = new MenuSecundario(this);
        m_sec.pack();
        m_sec.setLocationRelativeTo(this);
        m_sec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        m_sec.setVisible(true);
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            lbl.setVisible(true);
            lbl.setText("Codigo: " + e.getKeyCode() + "-- Caracter: " + e.getKeyChar());

            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
                displaySecondary();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            lbl.setText("Teclas");
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btn_1.setBackground(c);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                btn_2.setBackground(c);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btn_1.setBackground(null);
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                btn_2.setBackground(null);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            coords = (String.format(
                    title + "X: %d || Y: %d",
                    e.getX() + e.getX(),
                    e.getY() + e.getY()));
            setTitle(coords);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            coords = title;
            setTitle(coords);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            coords = (String.format(
                    title + "X:%d || Y:%d)",
                    e.getX(),
                    e.getY()));
            if (e.getSource() != this) {
                coords = (String.format(title + "X:%d || Y:%d", (e.getX() + e.getComponent().getX()), (e.getY() + e.getComponent().getY())));
            }

            setTitle(coords);
        }
    }

    private class Cerrar extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            int res = JOptionPane.showConfirmDialog(null,
                    "¿Seguro que quieres salir?", null,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (res == JOptionPane.OK_OPTION) {
                e.getWindow().dispose();
            }
        }
    }
}
