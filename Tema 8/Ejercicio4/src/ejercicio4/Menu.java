package ejercicio4;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame implements ActionListener {
    ArrayList<Contacto> agenda = new ArrayList<Contacto>();
    File saved = new File("C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 8\\saved.data");
    
    JTextArea txt_area;
    JButton btn_add;
    JButton btn_rem;
    JButton btn_save;
    JButton btn_load;
    
    public Menu() throws IOException, FileNotFoundException, ClassNotFoundException{
        super("Agenda");
        this.setLayout(new FlowLayout());
        
        txt_area = new JTextArea(30, 30);
        txt_area.setEditable(false);
        txt_area.setVisible(true);
        this.add(new JScrollPane(txt_area));
        
        btn_add = new JButton("Añadir");
        btn_add.addActionListener(this);
        this.add(btn_add);
        
        btn_rem = new JButton("Quitar");
        btn_rem.addActionListener(this);
        this.add(btn_rem);
        
        btn_save = new JButton("Guardar");
        btn_save.addActionListener(this);
        this.add(btn_save);
        
        
        btn_load = new JButton("Cargar");
        btn_load.addActionListener(this);
        this.add(btn_load);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_add){
            String nombre = JOptionPane.showInputDialog(null, "Nombre del contacto:");
            String tlf = JOptionPane.showInputDialog(null, "Numero de telefono:");
            String email = JOptionPane.showInputDialog(null, "Correo electronico:");
            
            agenda.add(new Contacto(nombre, Integer.parseInt(tlf), email));
            UpdateTextArea();
        }
        
        if(e.getSource() == btn_rem){
            String index = JOptionPane.showInputDialog(null, "Numero de la entrada a elminar: ");
            agenda.remove(Integer.parseInt(index) - 1);
            UpdateTextArea();
        }
        
        if(e.getSource() == btn_save){
            if(saved.exists())
            saved.delete();
            
            try{
                saved.createNewFile();
                FileOutputStream f_out = new FileOutputStream(saved);
                ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
                obj_out.writeObject(agenda);
                f_out.close();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        if(e.getSource() == btn_load){
            ArrayList<Object> loaded;
            try(FileInputStream f_in = new FileInputStream(saved)){
               ObjectInputStream obj_in = new ObjectInputStream(f_in);
               loaded = (ArrayList<Object>) obj_in.readObject();
               f_in.close();
               for(Object o : loaded){
                   if(o instanceof Contacto)
                       agenda.add((Contacto) o);
               }
               UpdateTextArea();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void UpdateTextArea(){
        String texto = "";
        int i = 1;
        for(Contacto c : agenda){
            texto += i + ".-" + c.nombre + " -- " + c.telefono + " -- " + c.email + "\n"; 
            i++;
        }
        txt_area.setText(texto);
    }
}
