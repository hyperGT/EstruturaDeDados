package edu.gabriel.EstruturaDeDados.Fila;

public class No<T> { //adicionando generics ao código para amarrar tudo a um unico tipo

    private T object;
    private No<T> refNo=null;

    public No(T object) {

        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No<T> getRefNo() {
        return refNo;
    }

    public void setRefNo(No<T> refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
