/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditobancario.controllers;

import creditobancario.util.Helper;
import creditobancario.views.AplicationForm;
import jess.*;


public class EventHandler implements JessListener{

    AplicationForm vista;
    public EventHandler( AplicationForm vista) {
        this.vista = vista;
    }

    @Override
    public void eventHappened(JessEvent je){
        int type = je.getType();
        Rete rete = (Rete)je.getSource();
        Context context = je.getContext();
        Helper helper = new Helper(rete);

        if(type == JessEvent.DEFRULE_FIRED){
           Fact nodoActual = helper.findFactByTempleteName("MAIN::nodo-actual");
            if (nodoActual != null){
                String slotV;
                Fact nodo = null;
                try {
                    slotV = nodoActual.get(0).toString();
                    nodo = helper.findFactByTemplateName("MAIN::Nodo", "nombre", slotV);
                    if (nodo != null){
                        String tipo = nodo.getSlotValue("tipo").stringValue(context);
                        System.out.println(tipo);
                        if (tipo.equals("pregunta")){
                            String pregunta = nodo.getSlotValue("pregunta").stringValue(context);
                            System.out.println(pregunta);
                            vista.cambiarPregunta(pregunta);
                        }else if(tipo.equals("respuesta")){
                            String respuesta = nodo.getSlotValue("respuesta").stringValue(context);
                            System.out.println(respuesta);
                            vista.darRespuesta("El animal es: "+respuesta);
                        }
                    }
                } catch (JessException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
