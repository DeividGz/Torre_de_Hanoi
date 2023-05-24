package torre_hanoi_pilha_ligada;

import java.util.Scanner;

 // @author Deivid Gomes Zanotti

public class Torre_hanoi_pilha_ligada {
    
    static Pilha A = new Pilha();
    static Pilha B = new Pilha();
    static Pilha C = new Pilha();
    static boolean pode = false;
    static boolean vitoria = false;
    static int jogadas = 0;
    
    public static void main (String[] args) throws Exception {
        enchePilha();
        
        Scanner leia = new Scanner(System.in);
        String[] movimento = new String[2];
        
        String mensagem = "";
        
        while(!vitoria) {
            exibePilhas();
            
            System.out.println("\n" + mensagem + "\n");
            
            System.out.println("De qual torre gostaria de mover um disco?");
            movimento[0] = leia.nextLine();
            System.out.println("Para qual?");
            movimento[1] = leia.nextLine();
            
            
            mensagem = validacao(movimento[0].toUpperCase(), movimento[1].toUpperCase());
            
            if(pode) {
                fazJogada(movimento[0].toUpperCase(), movimento[1].toUpperCase());
                jogadas++;
            }
            checaVitoria();
        }
        exibePilhas();
            
        System.out.println("\n" + mensagem + "\n");
        
        System.out.println("\nVOCÊ VENCEU COM "+jogadas+" JOGADAS!\n");
    }
    
    //iniciando pilha A com os seis discos
    public static void enchePilha() {
        A.insere("###########");
        A.insere(" ######### ");
        A.insere("  #######  ");
        A.insere("   #####   ");
        A.insere("    ###    ");
        A.insere("     #     ");
    }
    
    public static void exibePilhas() {
        String[] pilhaA = A.listar();
        String[] pilhaB = B.listar();
        String[] pilhaC = C.listar();
        
        int contador = 0;
        
        System.out.println("          !*TORRE DE HANOI*!         Nº Jogadas: "+jogadas+"\n");
        
        while(contador < 6) {
            auxExibe(pilhaA, contador);
            System.out.print("   ");
            auxExibe(pilhaB, contador);
            System.out.print("   ");
            auxExibe(pilhaC, contador);
            System.out.print("\n");
            contador++;
        }
        System.out.println("     A             B             C");
    }
    
    public static void auxExibe(String[] pilha, int indice) {
        if(pilha[indice] == null) {
            System.out.print("     |     ");
        } else {
            System.out.print(pilha[indice]);
        }
    }
    
    public static void checaVitoria() {
        if(C.getQuantidade() == 6 && "     #     ".equals(C.getTopo().toString())) {
            vitoria = true;
        }
    }
   
    public static String validacao(String d, String p) {     
        Pilha D = switch( p ){
            case "A" -> A;
            case "B" -> B;
            case "C" -> C;
            default -> new Pilha(new Node("Inválido"));
        };
        
        Pilha O = switch( d ){
            case "A" -> A;
            case "B" -> B;
            case "C" -> C;
            default -> new Pilha(new Node("Inválido"));
        };
        
        if(O.estaVazio()) {
            pode = false;
            return "A pilha da qual você quer mover está vazia!";
        } else if (D.estaVazio()) {
            pode = true;
            return "Movimento realizado!";
        } else {
            if("Inválido".equals(D.getTopo().toString()) || "Inválido".equals(O.getTopo().toString())) {
                pode = false;
                return "Pilha escolhida inválida!";
            }
            if(O.getTopo().toString().trim().length() > D.getTopo().toString().trim().length()) {
                pode = false;
                return "Você não pode sobrepor um disco por outro maior!";
            }
            if(O == D) {
                pode = false;
                return "Não tem sentido movimentar algo para onde ele já está!";
            }
        }
        
        pode = true;
        return "Movimento realizado!";
    }
    
    public static void fazJogada(String d, String p) throws Exception {
        if("A".equals(d) && "B".equals(p)) {
            B.insere(A.getTopo());
            A.remove();
        } else if("A".equals(d) && "C".equals(p)) {
            C.insere(A.getTopo());
            A.remove();
        } else if("B".equals(d) && "A".equals(p)) {
            A.insere(B.getTopo());
            B.remove();
        } else if("B".equals(d) && "C".equals(p)) {
            C.insere(B.getTopo());
            B.remove();
        } else if("C".equals(d) && "A".equals(p)) {
            A.insere(C.getTopo());
            C.remove();
        } else if("C".equals(d) && "B".equals(p)) {
            B.insere(C.getTopo());
            C.remove();
        }
    }
}