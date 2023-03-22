package edu.gabriel.EstruturaDeDados.Pilha;

public class Pilha {


    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public void push(No novoNo){
        No refAuxiliar = refNoEntradaPilha; //guardo minha referencia de topo na ref auxiliar
        refNoEntradaPilha = novoNo; //pego minha referencia do topo e seto ela como um novo Nó
        refNoEntradaPilha.setRefNo(refAuxiliar); // seta a referencia de baixo como o Nó antigo que estava no topo
    }

    public No pop(){ //exclui o No que esta no topo da Pilha
        if(!this.isEmpty()){ //se a referencia de no de entrada da pilha nao estiver vazia
            No noPoped = refNoEntradaPilha;  // pega a atual ref de entrada(topo) e exclui
            refNoEntradaPilha = refNoEntradaPilha.getRefNo(); //estando vazio, pegamos o que estava em baixo e tornamos como a ref entrada atual
            return noPoped; //retorna a exclusão
        }
        return null;
    }

    public No top(){
        return refNoEntradaPilha;
    } //metodo para mostrar o No que esta no topo da pilha

    public boolean isEmpty(){
        return refNoEntradaPilha == null ? true : false;
    } //verifica se o No referido esta vazio ou n

    @Override
    public String toString() {

        String strRetorno = "-----------\n";
        strRetorno += "edu/gabriel/EstruturaDeDados/Pilha \n";
        strRetorno += "-----------\n";

        No noAuxiliar = refNoEntradaPilha;

        while (true) { //while loop infinito até que pegue todos os dados e percorra todos eles até acabarem(null será sinalizado)
            if (noAuxiliar != null) {
                strRetorno += "[No{dado=" + noAuxiliar.getDado()+"}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            } else

                break;

        }
        strRetorno += "===========\n";
        return strRetorno;
    }
}
