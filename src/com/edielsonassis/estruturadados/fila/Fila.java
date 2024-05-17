package com.edielsonassis.estruturadados.fila;

import com.edielsonassis.estruturadados.base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {
    
    public Fila(int capacidade) {
        super(capacidade);
    }

    public Fila() {
        super();
    }

    public void enfileira(T elemento) {
        super.adiciona(elemento);
    }

    public T espia() {
        if (this.estaVazia()) {
            return null;
        }

        return this.elementos[0];
    }

    public T desenfileira() {
        final int POSICAO = 0;

        if (!this.estaVazia()) {
            T elementoRemovido = this.elementos[POSICAO];
            super.remove(POSICAO);
            return elementoRemovido;
        }

        return null;
    }
}