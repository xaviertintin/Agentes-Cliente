/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import agentesc.Contenedor;
import contenidoSerializado.Pagos;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author Surface
 */
public class Agente3 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    } 

    @Override
    protected void takeDown() {
        Contenedor c = (Contenedor)getArguments()[0];
        int i = Integer.parseInt(getArguments()[1].toString());
        i++;
        c.crearHijos("AgenteHijo"+i, new Object[]{c,i});
        System.out.println("Morir");
    }
    
    class Comportamiento extends Behaviour{
        boolean terminado = false;
        @Override
        public void action() {
            System.out.println(getName());
            Object[] pagosVentas = new Object[]{new Pagos(1, 1, 100, "2022-10-10")};
                new Ventas(1,1,20221,100,true,"2022-10-10","Producto 1 Descripcion");
            Pagos pagos = new Pagos(D_MIN,D_MIN,D_MIN,STATE_READY);
            Mensajes.enviarS(ACLMessage.INFORM, "Unirinformacion", pagosVentas, "COD0302", getAgent());
            //terminado = true;//depende lo q necesites
            //doDelete();
            //sensor de temperatura ...........
            //Alto Baja
            //Mensajes.enviar(ACLMessage.INFORM,"BuscarDatos", "baja","COD0302",getAgent());
            //ACLMessage acl = blockingReceive();
            //System.out.println(acl.getContent());
        }

        @Override
        public boolean done() {
            return terminado;
        }
        
    }
}
