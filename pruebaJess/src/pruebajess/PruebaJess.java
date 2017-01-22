/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajess;

/**
 *
 * @author Kattya Desiderio
 */


import jess.*;
public class PruebaJess {

    /**
     * @param args the command line arguments
     */
    public static String ruta="C:\\Users\\Kattya Desiderio\\Documents\\NetBeansProjects\\SistemaExperto-CreditoBancario\\pruebaJess\\src\\codigo\\prueba.clp";
    
    public static void main(String[] args) throws JessException {
        Rete r = new Rete();
        r.batch(ruta);
//        r.assertString(hecho);
        r.reset();
        r.run();
    }
    
}
