/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.ed.estructuras;

/**
 *
 * @author desandlope0
 */
public class NodoTermino {

    Termino termino;
    NodoTermino sgte;


    public NodoTermino getSgte() {
        return sgte;
    }

    public void setSgte(NodoTermino sgte) {
        this.sgte = sgte;
    }


    
    
    //Hola Jimmy!!!!
    //Holi manuel :v

    
    
    public NodoTermino(Termino termino){
        this.termino = termino;
        sgte = null;
    }
    public NodoTermino(Termino termino, NodoTermino sgte) {
        this.termino = termino;
        this.sgte = sgte;
    }
}
