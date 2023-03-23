package edu.gabriel.EstruturaDeDados.ListaCircular;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista = 0;

    /**
     * <h1>Metodo Add</h1>
     * @param conteudo Refere-se ao que está dentro do No, seu conteudo no caso
     */
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(this.tamanhoLista == 0){ //caso a lista esteja vazia
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setProximoNo(cauda);
        }else {
            novoNo.setProximoNo(this.cauda); //novoNo vai ficar antes da cauda
            /*
            * novoNO será a nova cauda da lista e será referenciado pela cabeca da lista
            * */
            this.cabeca.setProximoNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    /**
     * <h1>Metodo Remove</h1>
     * */
    public void remove(int index){
        /* funcionamento do metodo:
        * se o indice for maior que o tamanho da liste, dispara um "erro" para o usuario
        *
        * */
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O indice é maior que o tamanho da lista");

        /*
         * exclui o index 0 e conecta o indice 1 como novo indice 0
         * a cabeca da lista ainda esta se referindo a antiga cauda, entao foi necessario "atualiza-la"
         * se o indice for 1, exclui ele e inclui o indice 2 como o novo indice 1
         * se for um valor que nao seja esses, teremos um loop (for) que percorrerá toda a lista
         * sempre se referindo ao indice anterior ao indice escolhido para exclusão
         * chegando no indice anterior ao escolhido, ele vai aponta-lo para o No que é o proximo No do indice escolhido para a exclusão
         * */
        No<T> noAuxiliar = this.cauda;
        if (index == 0){

            this.cauda = this.cauda.getProximoNo();
            this.cabeca.setProximoNo(this.cauda);
        }else if(index == 1){
            this.cauda.setProximoNo(this.cauda.getProximoNo());
        }else {
            for(int i = 0 ; i < index-1 ; i++){
                noAuxiliar = noAuxiliar.getProximoNo();
            }
            noAuxiliar.setProximoNo(noAuxiliar.getProximoNo().getProximoNo());
        }
        this.tamanhoLista--;
    }

    /**
     * <h1>Metodo Get</h1>
     * */
    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private No<T> getNo(int index){
        if(this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia");

        if(index == 0)
            return this.cauda;
        No<T> noAuxiliar = this.cauda;
        for (int i = 0 ; i < index ; i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noAuxiliar;
    }

    /**
     * <h1>Metodo Size</h1>
     * */
    public int size(){
        return this.tamanhoLista;
    }

    /**
     * <h1>Metodo isEmpty</h1>
     * */
    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        No<T> noAuxiliar = this.cauda;
        for (int i = 0 ; i < this.size() ; i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]---->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += this.size() != 0 ? "(Aponta para a cauda)" : "[vazio]";
        return strRetorno;
    }
}
