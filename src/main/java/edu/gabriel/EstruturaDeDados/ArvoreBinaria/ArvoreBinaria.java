package edu.gabriel.EstruturaDeDados.ArvoreBinaria;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;


    public ArvoreBinaria() {
        this.raiz = null;
    }

    /**<h1>Metodo inserir</h1>
     * para inserir um conteudo dentro de um nó
     * */
    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    /**<h1>Metodo Inserir</h1>
     * @param noAtual Refere-se ao no atual no qual sera modificado para receber ou ser o novo No
     * @param novoNo Refere-se ao Nó que queremos inserir
     * @return o nó atual
     * <b>Uso de algoritmos recursivos</b>
     * */
    private BinNo<T> inserir(BinNo<T> noAtual, BinNo<T> novoNo){
        /*
        * @if
        * verificaremos se o noAtual esta como null, assim, quer dizer que ele esta vazio
        * assim sendo retornaremos o novoNo que se refere ao no que queremos inserir
        *
        * @else if - else
        * utilizaremos o compareTo para conparar se o conteudo dentro do no inserido é maior que a raiz ou não
        * dependo se for ou não, ele será inserido à esqueda, ou a direita da Árvore binária.
        * */
        if(noAtual == null){
            return novoNo;
        } else if (novoNo.getConteudo().compareTo(noAtual.getConteudo()) < 0){
            noAtual.setNoEsq(inserir(noAtual.getNoEsq(), novoNo));
        }else {
            noAtual.setNoDir(inserir(noAtual.getNoDir(), novoNo));
        }
        return noAtual;
    }

    /** <h1>Métodos showInOrder</h1>
     *
     * <h2>Atravessamento In Order:</h2>
     * Basicamente vai mostrar os conteudos em ordem crescente
     * */
    /*
     * para isso, deve-se verificar se a raiz existe, se sim, vai mostrar primeiro aqueles que estão do lado
     * esquerdo da Árvore(os valores menores) para o direito(os valores maiores) mesmo se esses não existirem
     * */
    public void exibirInOrdem(){
        System.out.println("\n Exibindo InOrder" + ", ");
        exibirInOrdem(this.raiz);
    }
    /**@param atual vai receber a raíz da Árvore*/
    private void exibirInOrdem(BinNo<T> atual){
        if (atual != null){
            exibirInOrdem(atual.getNoEsq());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDir());
        }
    }

    /** <h1>Métodos showPosOrder</h1>
     *
     * <h2>Atravessamento Pos Order:</h2>
     * Exibe primeiro tudo de baixo pra cima, da esquerda pra direita
     * */
    public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrder" + ", ");
        exibirPosOrdem(this.raiz);
    }
    private void exibirPosOrdem(BinNo<T> atual){
        if (atual != null){
            exibirPosOrdem(atual.getNoEsq());
            exibirPosOrdem(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    /**
     * <h1>Método PreOrder</h1>
     *
     * <h2>Atravessamento PreOrder</h2>
     * vai mostrando tudo a partir da raiz, tudo que esta conectado da direita para a esquerda de cima pra baixo
     * de forma diagonal
     * */
    public void exibirPreOrdem(){
        System.out.println("\n Exibindo PreOrder" + ", ");
        exibirPreOrdem(this.raiz);
    }
    private void exibirPreOrdem(BinNo<T> atual){
        if (atual != null){
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsq());
            exibirPreOrdem(atual.getNoDir());
        }
    }

    /**<h1>Método Remove</h1>
     * <b>Metade do curso para programar esse metodo :.</b>
     * */
    public void remove(T conteudo){
        try {
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                //compare se o conteudo atual é menor que zero
                if (conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsq();
                }else {
                    atual = atual.getNoDir();
                }

                if (atual == null){
                    System.out.println("Conteudo não encontrado. Bloco try");
                }

                /*
                * Se a referencia pai da arvore do ramo escolhido para ser excluido for nulo
                * ele vai correr uma série de verificações
                * */
                if(pai == null){
                    /*
                     * primeiro se a referencia de nó a direita do No que a gente quer remover é nulo
                     * assim vamo atribuir a raiz, a referencia de No a esquerda
                     * o outro else if é a mesma coisa só que o contrário
                     * */
                    if (atual.getNoDir() == null){
                        this.raiz = atual.getNoEsq();
                    } else if (atual.getNoEsq() == null) {
                        this.raiz = atual.getNoDir();
                    }
                    /*
                    * O else desse if de cima é bem complexo, ainda mais com esse for absurdo que esta dentro dele.
                    * @oFor Começamos com o temp(No temporario ou Auxiliar :>) tendo o Nó a ser removido atribuido a si
                    * e o Nó filho por sua vez tem o nó a esquerda atribuido a si.
                    * e enquanto o No a sua direita for difente de nulo
                    * incrementamos atribuindo o Nó filho atual ao Nó auxiliar e fazemos esse mesmo nó filho receber a refencia do nó a sua esquerda
                    * */
                    else {
                        for (temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoEsq()
                        ){
                            /*
                            * esse vai permitir que as ligações perdidas sejam reconectadas
                            * Ex: se o Nó pai for excliudo, vamos permitir que o nó temporario atual set sua referencia da direita, a ref do filho a esquerda
                            * por fim conectaremos a...meu céreblo acabou de explodir....
                            * */
                            if (filho != atual.getNoEsq()){
                                temp.setNoDir(filho.getNoEsq());
                                filho.setNoEsq(raiz.getNoEsq());
                            }
                        }
                        filho.setNoDir(raiz.getNoDir());
                        raiz = filho;
                    }
                } else if (atual.getNoDir() == null) {
                    if(pai.getNoEsq() == atual){
                        pai.setNoEsq(atual.getNoEsq());
                    }else {
                        pai.setNoDir(atual.getNoEsq());
                    }
                } else if (atual.getNoEsq() == null) {
                    if(pai.getNoEsq() == atual){
                        pai.setNoEsq(atual.getNoDir());
                    }else {
                        pai.setNoDir(atual.getNoDir());
                    }

                }else {
                    for (
                            temp = atual, filho = atual.getNoEsq();
                            filho.getNoDir() != null;
                            temp = filho, filho = filho.getNoDir()
                    ){
                        if (filho != atual.getNoEsq()){
                            temp.setNoDir((filho.getNoEsq()));
                            filho.setNoEsq(atual.getNoEsq());
                        }
                        filho.setNoDir(atual.getNoDir());
                        if (pai.getNoEsq() == atual){
                            pai.setNoEsq(filho);
                        } else {
                            pai.setNoDir(filho);
                        }
                    }

                }

            }
            // se tudo der errado tem esse catch pra avisar
        }catch (NullPointerException erro){
            System.out.println("Conteudo não encontrado. Bloco catch");
        }
    }

}
