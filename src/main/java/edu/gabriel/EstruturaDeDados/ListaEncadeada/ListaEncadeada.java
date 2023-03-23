package edu.gabriel.EstruturaDeDados.ListaEncadeada;

public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    //METODO ADD
    public void add(T conteudo) { //metodo add, que serve para adicionar um novo conteudo a um indice indicado

        No<T> novoNo = new No<>(conteudo);

        if (this.isEmpty()) {
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAux = referenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++) {
            noAux = noAux.getProximoNo();
        }

        noAux.setProximoNo(novoNo);
    }

    //metodo para retornar o conteudo
    public T get(int index) {
        return getNo(index).getConteudo();
    }


    //metodo para retornar o No
    private No<T> getNo(int index) {
        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    //metodo remove
    public T remove(int index){

        No<T> noPivor = this.getNo(index); //guarda o index que queremos remover

        if(index==0){
            referenciaEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }
        /*
        * No pivor esta com um valor
        * no Anterior vai receber o valor anterior
        * no Anterior vai setar o prox no como o posterior ao que sera excluido
        * retorno o conteudo excluido
        * */
        No<T> noAnterior = getNo(index-1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }



    public int size() {
        int tamanhoLista = 0;

        No<T> referenciaAux = referenciaEntrada;

        //loop infinito no intuito de aumentar automaticamente o tamanho da lista
        while (true) {
            if (referenciaAux != null) {
                tamanhoLista++;

                if (referenciaAux.getProximoNo() != null) {
                    referenciaAux = referenciaAux.getProximoNo();
                } else {
                    break;
                }

            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    //metodo usado para validar o indice
    private void validaIndice(int index) {

        if (index >= size()) {
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index + " desta lista. O ultimo indice da lista é: " + ultimoIndice + '.');
        }
    }

    public boolean isEmpty() {
        return referenciaEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for (int i = 0 ; i < this.size() ; i++){
            strRetorno += "[No{conteudo= " + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}


