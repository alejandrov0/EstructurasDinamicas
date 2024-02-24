/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadoblementeenlazada;

/**
 *
 * @author José Alejandro
 */
public class LISTADOBLEMENTEENLAZADA {

    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        // Insertar elementos en la lista
        lista.insertarAlInicio(1);
        lista.insertarAlFinal(2);
        lista.insertarAlInicio(3);

        // Mostrar la lista hacia adelante
        System.out.println("Lista hacia adelante:");
        lista.recorrerHaciaAdelante();

        // Mostrar la lista hacia atrás
        System.out.println("Lista hacia atrás:");
        lista.recorrerHaciaAtras();

        // Mostrar tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.mostrarTamaño());

        // Mostrar si la lista está vacía
        System.out.println("¿La lista está vacía? " + lista.estaVacia());

        // Buscar elemento por valor
        nodo nodoBuscado = lista.buscarPorValor(2);
        if (nodoBuscado != null) {
            System.out.println("Elemento encontrado por valor: " + nodoBuscado.valor);
        } else {
            System.out.println("Elemento no encontrado por valor.");
        }

        // Buscar elemento por índice
        nodo nodoPorIndice = lista.buscarPorIndice(1);
        if (nodoPorIndice != null) {
            System.out.println("Elemento encontrado por índice: " + nodoPorIndice.valor);
        } else {
            System.out.println("Elemento no encontrado por índice.");
        }

        // Borrar un elemento
        lista.borrarElemento(2);

        // Mostrar la lista después de borrar
        System.out.println("Lista después de borrar:");
        lista.recorrerHaciaAdelante();
    }
}

class Nodo {
    public nodo anterior;
    int valor;
    nodo previo;
    nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.previo = null;
        this.siguiente = null;
    }
}

class ListaDobleEnlazada {
    private nodo primerNodo;
    private nodo ultimoNodo;
    private int tamaño;

    public ListaDobleEnlazada() {
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.tamaño = 0;
    }

    public void insertarAlInicio(int valor) {
        nodo nuevoNodo = new nodo(valor);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.siguiente = primerNodo;
            primerNodo.anterior = nuevoNodo;
            primerNodo = nuevoNodo;
        }

        tamaño++;
    }

    public void insertarAlFinal(int valor) {
        nodo nuevoNodo = new nodo(valor);

        if (ultimoNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.anterior = ultimoNodo;
            ultimoNodo.siguiente = nuevoNodo;
            ultimoNodo = nuevoNodo;
        }

        tamaño++;
    }

    public void recorrerHaciaAdelante() {
        nodo nodoActual = primerNodo;

        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " ");
            nodoActual = nodoActual.siguiente;
        }

        System.out.println();
    }

    public void recorrerHaciaAtras() {
        nodo nodoActual = ultimoNodo;

        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " ");
            nodoActual = nodoActual.anterior;
        }

        System.out.println();
    }

    public int mostrarTamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return primerNodo == null;
    }

    public nodo buscarPorValor(int valor) {
        nodo nodoActual = primerNodo;

        while (nodoActual != null && nodoActual.valor != valor) {
            nodoActual = nodoActual.siguiente;
        }

        return nodoActual;
    }

    public nodo buscarPorIndice(int indice) {
        if (indice < 0 || indice >= tamaño) {
            return null;
        }

        nodo nodoActual = primerNodo;
        int indiceActual = 0;

        while (nodoActual != null && indiceActual < indice) {
            nodoActual = nodoActual.siguiente;
            indiceActual++;
        }

        return nodoActual;
    }

    public void borrarElemento(int valor) {
    }
}
