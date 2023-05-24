/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torre_hanoi_pilha_ligada;

/**
 *
 * @author aluno
 */
public class Node<T> {
    private T info;
    private Node<T> anterior;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Node<T> anterior) {
        this.anterior = anterior;
    }

    public Node(T conteudo) {
        info = conteudo;
        anterior = null;
    }
}
