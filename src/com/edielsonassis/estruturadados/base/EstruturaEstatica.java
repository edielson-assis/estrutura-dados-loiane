package com.edielsonassis.estruturadados.base;

import java.util.Arrays;

public class EstruturaEstatica<T> {
    
    protected T[] elementos;
    protected int tamanho;

    @SuppressWarnings("unchecked")
    public EstruturaEstatica(int capacidade) {
        if (capacidade < 0) {
            throw new IllegalArgumentException("Capacidade inválida: " + capacidade);
        }
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public EstruturaEstatica() {
       this(10);
    }

    protected boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        } 
        return false;
    }

    protected void adiciona(int posicao, T elemento) {
        this.validaPosicao(posicao);
        this.aumentaCapacidade();
        // move todos os elementos
        for (int i = this.tamanho -1; i >= posicao; i--) {
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    protected void remove(int posicao) {
        this.validaPosicao(posicao);
        for (int i = posicao; i < this.tamanho -1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
         return this.tamanho == 0;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[");

        for (int i = 0; i < this.tamanho -1; i++) {
            sBuilder.append(this.elementos[i]);
            sBuilder.append(", ");
        }

        if (this.tamanho > 0) {
            sBuilder.append(this.elementos[this.tamanho -1]);
        }
        sBuilder.append("]");

        return sBuilder.toString();
    } 

    @SuppressWarnings("unchecked")
    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos =  Arrays.copyOf(elementos, elementosNovos.length);
            }
            this.elementos = elementosNovos;
        }
    }
    
    protected void validaPosicao(int posicao) {
        if (!(posicao >= 0 || posicao < this.tamanho)) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
    }
}