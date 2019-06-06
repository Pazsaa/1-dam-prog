package ejercicio1apuntes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;

/**
 *
 * @author Alberto Paz
 */
public class Formulario extends JFrame implements ActionListener {
    private JButton amarillo;
    private JButton azul;
    private JButton aleatorio;
    
    public Formulario(){
        super("Ejercicio apuntes 1");
        this.setLayout(null);
        
        amarillo = new JButton("Yellow mellow!");
        amarillo.setSize(amarillo.getPreferredSize());
        amarillo.setLocation(0,1);
        amarillo.setForeground(Color.YELLOW);
        amarillo.addActionListener(this);
        this.add(amarillo);
        
        azul = new JButton("Blue like you!");
        azul.setSize(azul.getPreferredSize());
        azul.setLocation(0,100);
        azul.setForeground(Color.BLUE);
        azul.addActionListener(this);
        this.add(azul);
        
        aleatorio = new JButton("Random");
        aleatorio.setSize(aleatorio.getPreferredSize());
        aleatorio.setLocation(1,200);
        aleatorio.addActionListener(this);
        this.add(aleatorio);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        Random r = new Random();
        
        if((event.getSource() == amarillo)){
            this.getContentPane().setBackground(Color.yellow);
        }
        if((event.getSource() == azul)){
            this.getContentPane().setBackground(Color.blue);
        }
        if(event.getSource() == aleatorio){
            this.setLocation(r.nextInt(600 + 1), r.nextInt(400 +1));
        }
    }
}
