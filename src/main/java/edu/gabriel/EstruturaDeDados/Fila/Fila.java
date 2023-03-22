package edu.gabriel.EstruturaDeDados.Fila;

public class Fila<T> {  //adicionando generics ao código para amarrar tudo a um unico tipo

    private No<T> refNoEntradaFila;

    public Fila() {
        this.refNoEntradaFila = null;
    }

//metodo emfileirar
    public void enqueue(T object){   //sera feita a refatoração desses Nós
        No<T> novoNo = new No<>(object); //embutindo um nó dentro de um outro nó
        novoNo.setRefNo(refNoEntradaFila); //novoNo entra na fila, e a referencia é o antigo ultimo No
        refNoEntradaFila = novoNo; //o ultimo no agora é esse(recebendo o valor do ultimo No)
    }

    public T first(){
        if(!this.isEmpty()){ //se o ultimo na fila NÃO estiver vazio
            No<T> primeiroNo = refNoEntradaFila; // A variavel primeiroNo recebe o atual refNo
            while (true){ //enquanto verdadeiro execute
                if(primeiroNo.getRefNo() != null){ //se primeiroNo verificar que o proximo valor não for vazio, continue
                    primeiroNo = primeiroNo.getRefNo(); // primeiroNo a receber ele mesmo obtendo o valor da prox referencia
                }else {
                    break; //termine o loop caso o prox valor esteja apontando para null
                }
            }
            return (T) primeiroNo.getObject(); //para sanar o erro, foi feito um casting do [primeiroNo.getObject()] para T
        }
        return null;
    }

    // metodo desemfileirar(nao e um void method)
    public T dequeue(){
        if(!this.isEmpty()){
            No<T> primeiroNo = refNoEntradaFila;
            No<T> noAuxiliar = refNoEntradaFila; // a var auxiliar recebe tambem a refNo...

            while (true){
                if(primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo; // a var auxiliar dessa vez guarda o valor do [primeiroNo] para mante-lo
                    primeiroNo=primeiroNo.getRefNo();
                }else {
                    noAuxiliar.setRefNo(null); //seta o valor do ultimo como vazio, excluindo-o da fila
                    break;
                }
            }
            return (T) primeiroNo.getObject(); //tbm foi necessário um casting aqui
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = ""; //add uma string que guarda strings(textos) dentro dela
        No<T> noAuxiliar = refNoEntradaFila; //variavel auxiliar que vai receber a ref do ultimo item da fila

        if (refNoEntradaFila != null){ //se esta ref NÃO estiver vazia(o ultimo item nao existe)
            while (true){ //enquanto verdade execute:
                strRetorno += "[No{objeto: " + noAuxiliar.getObject() + "}]--->"; //a var string mostra os obj criados
                if (noAuxiliar.getRefNo() != null){ //se existir mais de um ref na fila faça
                    noAuxiliar = noAuxiliar.getRefNo(); //noAux percorre as ref enquanto o loop durar, ate que haja uma que aponte para null
                }
                else{
                    strRetorno += "null";
                    break; //
                }
            }
        }
        else {
            strRetorno = "null";
        }

        return strRetorno;
    }
}
