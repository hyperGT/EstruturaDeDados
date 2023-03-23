package edu.gabriel.EstruturaDeDados.ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;

    private int tamanhoLista = 0;


    //metodo genérico get (pode retornar qualquer tipo)
    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

        /**
         * <h1>Método Add</h1>
     * Este metodo é para adicionar um novo No a frente na lista que será referido como ultimo No e tera null como proxima referencia
     * @param elemento Elemento se refere ao conteudo dentro do No que esta sendo criado. O T significa que ele é genérico e pode adotar qualquer tipo
    */
    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoPosterior(null);
        novoNo.setNoAnterior(ultimoNo);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo != null){
            ultimoNo.setNoPosterior(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    /** <h1>Método Add</h1>
     * Este método diferentemente do primeiro, possibilita inserir um novo conteudo diretamente em qualquer indice da lista
     * @param elemento Se refere ao conteudo a ser adicionado em determinado índice
     * @param index Se refere ao indice
     * */
    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoPosterior(noAuxiliar);

        //verificações
        /*se o No posterior NÃO estiver vazio
        * seta o No anterior como anterior mesmo pois queremos inserir esse novo No no meio ali de dois indices que serão anteriores ou posteriores a esse
        * pegue o No posterior e set o seu NO anterior como o novo No inserido.
        * se o No posterior ao novo No for null, set o anterior a esse(null) como ultimo No(novo No inserido)
        * */
        if(novoNo.getNoPosterior() != null){ //para adicionar no meio
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getNoPosterior().setNoAnterior(novoNo);
        }else { //para adicionar como ultimo
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }
        /*
        * se o indice para inserir for 0, o primeiro No passara a ser o novo No recem-adicionado
        * senão, o No anterior terá como No posterior o novo No adicionado(Ex: novoNo=1 - get index=0 set No posterior(1) como novo No)
        * */
        if (index == 0){
            primeiroNo = novoNo;
        }else {
            novoNo.getNoAnterior().setNoPosterior(novoNo);
        }
        tamanhoLista++;
    }

    /**
     * <h1>Método remove</h1>
     * Este método remove o conteudo do índice escolhido da memória
     * @param index Referente ao índice
     * */
    public void remove(int index){
            /*
        * Se o indice escolhido for 0: o primeiro nó agora é o No posterior a ele
        * dentro há a condição de que se o valor do primeiro no não for null
        * primeiroNo indica seu anterior como vazio
        * */
        if(index == 0){
            primeiroNo = primeiroNo.getNoPosterior();
            if(primeiroNo != null){
                primeiroNo.setNoAnterior(null);
            }
            /*
            * Se o index escolhido para ser removido for diferente de 0, como 1 ou 2, precisaremos identificar aqueles que estao antes ou depois desse
            * a variavel no auxiliar vai receber o index inserido caso ele não for 0
            * pegaremos o No anterior ao auxiliar e a referencia de no posterior ao indice escolhido sera posterior ao anterior do mesmo
            * Ex: index escolhido 1 ; get No index 0 e set posterior a esse o indice 2, o 2 se tornara o novo indice 1 e o conteudo do antigo index 1 será excluido da memoria
            * */
        }else {
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoAnterior().setNoAnterior(noAuxiliar.getNoPosterior());
            /*
            * iremos detectar se o indice escolhido não está sendo referido como o ultimo No
            * assim iremos referenciar o No posterior ao do indice o valor de seu anterior, desmembrando a lista e rearanjando ela,
            * e excluindo tambem seu conteudo da memoria
            * se a condição de cima não for verdadeira, o ultimo nó é igual ao indice escolhido para ser removido; e será removido
            * */
            if (noAuxiliar != ultimoNo){
                noAuxiliar.getNoPosterior().setNoAnterior(noAuxiliar.getNoAnterior());
            }else {
                ultimoNo = noAuxiliar;
            }
        }
        this.tamanhoLista--;
    }

    //metodo para obter o indice escolhido
    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0 ; (i < index) && (noAuxiliar != null) ; i++){
            noAuxiliar = noAuxiliar.getNoPosterior();
        }
        return noAuxiliar;
    }

    public int size(){
        return tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size() ; i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoPosterior();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
