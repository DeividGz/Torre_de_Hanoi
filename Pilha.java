/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torre_hanoi_pilha_ligada;

/**
 *
 * @author aluno
 */
public class Pilha<T> {
    private Node<T> topo;
    private int qtd;

    public Pilha() {
        this.topo = null;
        this.qtd = 0;
    }
    
    public Pilha(Node<T> topo) {
        this.topo = topo;
        this.qtd = 0;
    }

    public int getQuantidade() {
        return qtd;
    }
    
    public T getTopo() {
        return topo.getInfo();
    }
    
    public void insere(T valor) {
        this.qtd++;
        
        Node<T> novo = new Node<T>(valor);
        
        novo.setAnterior(this.topo);
        
        this.topo = novo;
    }

    public boolean estaVazio() {
        return this.topo == null;
    }

    public T remove() throws Exception { 
        if(!estaVazio()) {
            qtd--;

            Node<T> aux = null;
            
            aux = this.topo;
            this.topo = this.topo.getAnterior();
            aux.setAnterior(null);
            return (aux.getInfo());
        } 
        throw new Exception("A pilha já está vazia!");
    }

    public String[] listar() {
        Node<T> atual = this.topo;
        String[] resposta = new String[6];
        int voltasVazio = 6 - qtd;
        for(int i = 0; i < voltasVazio; i++) {
            resposta[i] = "     |     ";
        }
        int posicaoDisco = voltasVazio;
        while(atual != null){
            resposta[posicaoDisco] = atual.getInfo().toString();
            atual = atual.getAnterior();
            posicaoDisco++;
        }
        return resposta;
    }
}
