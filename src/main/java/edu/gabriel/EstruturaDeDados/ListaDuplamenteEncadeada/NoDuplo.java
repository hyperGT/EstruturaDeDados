package edu.gabriel.EstruturaDeDados.ListaDuplamenteEncadeada;

public class NoDuplo<T> {

    private T conteudo;
    private NoDuplo<T> noPosterior;
    private NoDuplo<T> noAnterior;

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoPosterior() {
        return noPosterior;
    }

    public void setNoPosterior(NoDuplo<T> noPosterior) {
        this.noPosterior = noPosterior;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}

