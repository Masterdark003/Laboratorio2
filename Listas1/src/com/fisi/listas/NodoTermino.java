/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.listas;

/**
 *
 * @author desandlope0
 */
public class NodoTermino {

    Termino termino;
    NodoTermino sgte;

    public NodoTermino(Termino termino, NodoTermino sgte) {
        this.termino = termino;
        this.sgte = sgte;
    }
}