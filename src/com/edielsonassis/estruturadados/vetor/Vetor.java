package com.edielsonassis.estruturadados.vetor;

import com.edielsonassis.estruturadados.base.EstruturaEstatica;

public class Vetor<T> extends EstruturaEstatica<T> {

    public Vetor(int capacidade) {
        super(capacidade);
    }

    public Vetor() {
        super();
    }

    @Override
    public boolean adiciona(T elemento) {
        return super.adiciona(elemento);
    }

    @Override
    public void adiciona(int posicao, T elemento) {
        super.adiciona(posicao, elemento);
    }

    @Override
    public void remove(int posicao) {
        super.remove(posicao);
    }

    public void remove(T elemento) {
        int posicao = this.primeiroIndice(elemento);
        if (posicao > -1) {
            this.remove(posicao);
        }
    }

    public T obtem(int posicao) {
        return this.busca(posicao);
    }

    public T busca(int posicao) {
        this.validaPosicao(posicao);
        return this.elementos[posicao];
    }
    // algoritimo de busca sequencial
    public int primeiroIndice(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1; // significa que a posicao nao existe
    }

    public int ultimoIndice(T elemento) {
        for (int i = this.tamanho -1; i >= 0; i--) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contem(T elemento) {
        return this.primeiroIndice(elemento) > -1;
    }

    public void limpa() {
        this.tamanho = 0;
    }   
}