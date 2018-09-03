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
public class ListaTermino {

    private NodoTermino cabecera;

    public NodoTermino getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoTermino cabecera) {
        this.cabecera = cabecera;
    }

    public void agregarTermino(Termino nuevoTermino) {
        //Lógica 
        if (cabecera == null) {
            cabecera = new NodoTermino(nuevoTermino);
        } else {
            cabecera = new NodoTermino(nuevoTermino, cabecera);
        }
    }

    public double evaluar(double numero) {
        //Lógica 
        NodoTermino aux = cabecera;
        double resultado = 0;
        int i = 0;
        while (aux != null) {
            resultado += aux.termino.coeficiente * Math.pow(numero, aux.termino.exponente);
            aux = aux.sgte;
        }
        return resultado;
    }

    @Override
    public String toString() {
        //Lógica 
        NodoTermino aux = cabecera;
        String pop = "";
        int i = 0;
        while (aux != null) {
            if (i == 0) {
                if (aux.termino.coeficiente == 0) {
                    pop += "";

                } else if (aux.termino.exponente == 0) {
                    pop += aux.termino.coeficiente;
                    i++;
                } else {
                    pop += aux.termino.coeficiente + "*x^" + aux.termino.exponente;
                    i++;
                }
            } else {
                if (aux.termino.coeficiente == 0) {
                    pop += "";

                } else if (aux.termino.exponente == 0) {
                    pop += " + " + aux.termino.coeficiente;

                } else {
                    pop += " + " + aux.termino.coeficiente + "*x^" + aux.termino.exponente;

                }
            }

            aux = aux.sgte;
        }
        return pop;
    }

    public String toStringIntegrado() {
        //Lógica 
        NodoTermino aux = cabecera;
        String pop = "";
        int i = 0;
        while (aux != null) {
            if (i == 0) {
                if (aux.termino.coeficiente == 0) {
                    pop += "";

                } else if (aux.termino.exponente == 0) {
                    pop += aux.termino.coeficiente + "*In(x)";
                    i++;
                } else {
                    pop += aux.termino.coeficiente + "*x^" + aux.termino.exponente;
                    i++;
                }
            } else {
                if (aux.termino.coeficiente == 0) {
                    pop += "";

                } else if (aux.termino.exponente == 0) {
                    pop += " + " + aux.termino.coeficiente + "In(x)";

                } else {
                    pop += " + " + aux.termino.coeficiente + "*x^" + aux.termino.exponente;

                }
            }

            aux = aux.sgte;
        }
        return pop;
    }

    public ListaTermino derivar(ListaTermino polinomio, int numeroDerivaciones) {
        //Lógica 
        ListaTermino d = new ListaTermino();
        for (int x = 1; x <= numeroDerivaciones; x++) {
            NodoTermino aux = cabecera;

            int exp;
            double coef;
            while (aux != null) {

                if (aux.termino.exponente == 1) {
                    exp = aux.termino.exponente - 1;
                    coef = aux.termino.coeficiente;
                } else if (aux.termino.exponente == 0) {
                    exp = 0;
                    coef = 0;
                } else {
                    exp = aux.termino.exponente - 1;
                    coef = aux.termino.exponente * aux.termino.coeficiente;
                }

                Termino nuevoT = new Termino(exp, coef);
                d.agregarTermino(nuevoT);
                aux = aux.sgte;
            }
        }

        return d;
    }

    /*public double evaluarDerivada(double valorEvaluar, int numeroDerivaciones){
    
        return 0;
    }*/
    public ListaTermino integrar(int numeroIntegraciones) {
        //Lógica 
        ListaTermino d = new ListaTermino();
        for (int x = 1; x <= numeroIntegraciones; x++) {
            NodoTermino aux = cabecera;

            int exp;
            double coef;
            while (aux != null) {

                if (aux.termino.exponente == -1) {
                    //para integrar x a la -1 we :'v
                    exp = aux.termino.exponente + 1;
                    coef = aux.termino.coeficiente;
                } else {
                    exp = aux.termino.exponente + 1;
                    coef = aux.termino.coeficiente / exp;
                }

                Termino nuevoT = new Termino(exp, coef);
                d.agregarTermino(nuevoT);
                aux = aux.sgte;
            }
        }

        return d;

    }
    public ListaTermino multiplicarNumero(int numero) {
        ListaTermino d = new ListaTermino();
        NodoTermino aux = cabecera;
        int exp;
        double coef;
        while (aux != null) {
            exp = aux.termino.exponente;
            coef = aux.termino.coeficiente * numero;
            Termino nuevoT = new Termino(exp, coef);
            d.agregarTermino(nuevoT);
            aux = aux.sgte;
        }
        return d;
    }
    public ListaTermino multiplicarMonomio (Termino t) {
        ListaTermino d = new ListaTermino();
        NodoTermino aux = cabecera;
        int exp;
        double coef;
        while (aux != null) {
            exp = aux.termino.exponente * t.exponente;
            coef = aux.termino.coeficiente * t.coeficiente;
            Termino nuevoT = new Termino(exp, coef);
            d.agregarTermino(nuevoT);
            aux = aux.sgte;
        }
        return d;
    }
}
