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

    public void sumaListas(NodoTermino cabecera2) {
        NodoTermino aux = cabecera;
        while (aux != null) {
            aux = aux.sgte;
        }
        aux.sgte = cabecera2;
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

    public ListaTermino multiplicarMonomio(Termino t) {
        ListaTermino d = new ListaTermino();
        NodoTermino aux = cabecera;
        int exp;
        double coef;
        while (aux != null) {
            exp = aux.termino.exponente + t.exponente;
            coef = aux.termino.coeficiente * t.coeficiente;
            Termino nuevoT = new Termino(exp, coef);
            d.agregarTermino(nuevoT);
            aux = aux.sgte;
        }
        return d;
    }

    public ListaTermino multiplicarPolinomio(NodoTermino cabecera2) {
        ListaTermino d = new ListaTermino();
        NodoTermino aux = cabecera;
        NodoTermino aux2 = cabecera2;
        int exp;
        double coef;
        while (aux != null) {
            aux2 = cabecera2;
            while (aux2 != null) {
                exp = aux.termino.exponente + aux2.termino.exponente;
                coef = aux.termino.coeficiente * aux2.termino.coeficiente;
                Termino nuevoT = new Termino(exp, coef);
                d.agregarTermino(nuevoT);
                aux2 = aux2.sgte;
            }
            aux = aux.sgte;
        }
        return d.simplificar();
    }

    public ListaTermino simplificar() {
        ListaTermino d = new ListaTermino();
        NodoTermino aux = cabecera;
        NodoTermino aux2;
        int exp;
        double coef;
        while (aux != null) {
            aux2 = aux.sgte;
            while (aux2 != null) {
                if (aux.termino.exponente == aux2.termino.exponente) {
                    aux.termino.coeficiente += aux2.termino.coeficiente;
                    eliminar(aux2);
                }
                    aux2 = aux2.sgte;
            }

            exp = aux.termino.exponente;
            coef = aux.termino.coeficiente;
            Termino nuevoT = new Termino(exp, coef);
            d.agregarTermino(nuevoT);

            aux = aux.sgte;
        }

        return d;
    }

    public void eliminar(NodoTermino entrada) {
        //NodoTermino nodo;
        NodoTermino actual, anterior;
        boolean encontrado;
        //inicializa los apuntadores
        actual = cabecera;
        anterior = null;
        encontrado = false;
        // búsqueda del nodo y del anterior
        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.equals(entrada));
            //con objetos: actual.dato.equals(entrada)
            if (!encontrado) {
                anterior = actual;
                actual = actual.sgte;
            }
        }
// Enlace del nodo anterior con el siguiente
        if (actual != null) {
// Distingue entre que el nodo sea el cabecera,
// o del resto de la lista
            if (actual.equals(cabecera)) {
                cabecera = actual.sgte;
            } else {
                anterior.sgte = actual.sgte;
            }
        }
        // nodo = actual.sgte;
        //return nodo;
    }
}
