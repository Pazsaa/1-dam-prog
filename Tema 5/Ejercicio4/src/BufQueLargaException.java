/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apazgarcia
 */
public class BufQueLargaException extends Exception {
    public BufQueLargaException(){
        super("Cadena demasiado larga");
    }
}
