package com.edielsonassis.estruturadados.lista;

public class ListaEncadeada<T> {
    
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    private static final int NAO_ENCONTRADO = -1;
    private static final String POSICAO_INVALIDA = "Posição inválida: ";
    private static final String LISTA_VAZIA = "Lista está vazia";

    public void adicionaInicio(T elemento) {
        if (this.tamanho == 0) {
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }
        tamanho++;
    }

    public void adiciona(T elemento) {
        No<T> celula = new No<>(elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        
        this.ultimo = celula;
        this.tamanho++;
    }

    public void adiciona(int posicao, T elemento) {
        if (posicao < 0 || posicao > this.tamanho)  {
            throw new IllegalArgumentException(POSICAO_INVALIDA + posicao);
        }

        if (posicao == 0) {
            this.adicionaInicio(elemento);
        } else if (posicao == this.tamanho) {
            this.adiciona(elemento);
        } else {
            No<T> noAnterior = this.buscaNo(posicao);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    public T removeInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }

        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if (this.tamanho == 0) {
            this.ultimo = null;
        }

        return removido;
    }

    public T removeFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        if (this.tamanho == 1) {
            return this.removeInicio();
        }

        No<T> penultimoNo = this.buscaNo(this.tamanho -2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    public T remove(int posicao) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(POSICAO_INVALIDA + posicao);
        }
        if (posicao == 0) {
            return this.removeInicio();
        }
        if (posicao == this.tamanho -1) {
             return this.removeFinal();
        }

        No<T> noAnterior = this.buscaNo(posicao -1);
        No<T> noAtual = noAnterior.getProximo();
        No<T> proximoNo = noAtual.getProximo();
        noAnterior.setProximo(proximoNo);
        noAtual.setProximo(null);
        this.tamanho--;

        return noAtual.getElemento();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void limpa() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    private No<T> buscaNo(int posicao) {
        if (this.posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(POSICAO_INVALIDA + posicao);
        }

        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    public T buscaPorPosicao(int posicao) {
        return this.buscaNo(posicao).getElemento();
    }

    public int busca(T elemento) {
        No<T> noAtual = this.inicio;

        int posicao = 0;
        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento)) {
                return posicao;
            }
            posicao++;
            noAtual = noAtual.getProximo();
        }

        return NAO_ENCONTRADO;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho -1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }

    private boolean posicaoNaoExiste(int posicao) {
        return !(posicao >= 0 && posicao <= this.tamanho);
    }
}