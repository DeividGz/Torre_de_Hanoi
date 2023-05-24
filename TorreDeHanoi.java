/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package torredehanoi;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class TorreDeHanoi {

    /**
     * @param args the command line arguments
     */
    static String[][] pinos =
    {
        {"    (=)    ", "  ", "     |     ", "  ", "     |     "},
        {"   (===)   ", "  ", "     |     ", "  ", "     |     "},
        {"  (=====)  ", "  ", "     |     ", "  ", "     |     "},
        {" (=======) ", "  ", "     |     ", "  ", "     |     "},
        {"(=========)", "  ", "     |     ", "  ", "     |     "}
    };
    
    static int linha = 5, coluna = 5, colA = 0, colB = 4, colC = 4, jogadas = 0;
    static int DeGeral = 0, ColunaDG = 0, ParaGeral = 0, ColunaPG = 0;
    
    static Scanner leia = new Scanner(System.in);
    static boolean erro = false, ganhou = false;
    
    static String DeQual = "", ParaQual = "";
    static String DeAnt = "", ParaAnt = "";
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*!JOGO DA TORRE DE HANOI!*\n\n");
        ExibePinos();
     
        do{
            do{
                PedeJogada();
                ValidaJogada();
                if(erro == false){
                    FazJogada();
                } else {
                    ExibePinos();
                    System.out.println("Não foi possivel realizar essa jogada");
                }
            }while(erro);
            ExibePinos();
        }while(!ganhou);
        
    }
    
    public static void ExibePinos(){
        System.out.println("     |            |            |     ");
        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                System.out.print(pinos[i][j]);
            }
            System.out.println("");
        }
        System.out.println("-----------  -----------  -----------");
        System.out.println("     A            B            C     ");
        System.out.println("\n");
    }
    
    public static void PedeJogada(){
        
        System.out.println("De qual das torres você quer mover uma peca?");
        DeQual = leia.nextLine();
        System.out.println("Para qual coluna essa peca ira?");
        ParaQual = leia.nextLine();
        
    }
    
    public static void ValidaJogada(){
        if(jogadas == 0 && !"A".equals(DeQual)){
            erro = true;
            return;
        } else {
            erro = false;
        }
        if(ParaQual.equals(DeQual)){
            erro = true;
            return;
        } else {
            erro = false;
        }
    }
    
    public static void FazJogada(){
        if(jogadas != 0){
            ControlaColunas(DeAnt, ParaAnt);
        }
        if("A".equals(DeQual) && "B".equals(ParaQual)){
            DeGeral = colA;
            ParaGeral = colB;
            ColunaDG = 0;
            ColunaPG = 2;
        }
        if("A".equals(DeQual) && "C".equals(ParaQual)){
            DeGeral = colA;
            ParaGeral = colC;
            ColunaDG = 0;
            ColunaPG = 4;
        }
        if("B".equals(DeQual) && "A".equals(ParaQual)){
            DeGeral = colB;
            ParaGeral = colA;
            ColunaDG = 2;
            ColunaPG = 0;
        }
        if("B".equals(DeQual) && "C".equals(ParaQual)){
            DeGeral = colB;
            ParaGeral = colC;
            ColunaDG = 2;
            ColunaPG = 4;
        }
        if("C".equals(DeQual) && "A".equals(ParaQual)){
            DeGeral = colC;
            ParaGeral = colA;
            ColunaDG = 4;
            ColunaPG = 0;
        }
        if("C".equals(DeQual) && "B".equals(ParaQual)){
            DeGeral = colC;
            ParaGeral = colB;
            ColunaDG = 4;
            ColunaPG = 2;
        }

        pinos[ParaGeral][ColunaPG] = pinos[DeGeral][ColunaDG];
        pinos[DeGeral][ColunaDG] = "     |     ";

        System.out.println("DeGeral: "+DeGeral+" ColunaDG: "+ColunaDG);
        System.out.println("ParaGeral: "+ParaGeral+" ColunaPG: "+ColunaPG);
        System.out.println("DeQual: "+DeQual+" ParaQual: "+ParaQual);
        System.out.println("DeAnt: "+DeAnt+" ParaAnt: "+ParaAnt);

        DeAnt = DeQual;
        ParaAnt = ParaQual;

        jogadas++;
    }

    public static void ControlaColunas(String De, String Para){
        if(De.equals(DeQual)){
            if("A".equals(DeQual)){
                colA++;
            }
            if("B".equals(DeQual)){
                colB++;
            }
            if("C".equals(DeQual)){
                colC++;
            }
        }
        if(Para.equals(ParaQual)){
            if("A".equals(ParaQual)){
                colA--;
            }
            if("B".equals(ParaQual)){
                colB--;
            }
            if("C".equals(ParaQual)){
                colC--;
            }
        }
    }
    
}

/*
      01234567890123456789012
0         |          |          |
1         #          |          |
2        ###         |          |
3       #####        |          |
4      #######       |          |
5     #########      |          |
6     ---------  ---------  ---------

             ﴾≡﴿
            ﴾≡≡≡﴿
           ﴾≡≡≡≡≡﴿
          ﴾≡≡≡≡≡≡≡﴿
         ﴾≡≡≡≡≡≡≡≡≡﴿
*/