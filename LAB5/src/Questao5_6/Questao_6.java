package Questao5_6;
//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.util.HashMap;

public class Questao_6 {


    public static void caracterMaisOcorrente(String s){
        HashMap<Character, Integer> conjunto = new HashMap<>();
        int j=1;
        int number=0;
        char c='n';
        for (int i = 0; i < s.length(); i++) {
            j=1;
            char caracter = s.charAt(i);
            if(conjunto.get(caracter)==null){
                conjunto.put(caracter, j);
            }
            else{
                j=conjunto.get(caracter)+1;
                conjunto.put(caracter, j);
            }
            if(j>number){
                c=caracter;
                number=j;
            }
        }
        System.out.printf("%c, %d", c, number);
    }

    public static void main(String[] args){
        double t1 = System.currentTimeMillis();
        caracterMaisOcorrente("arara");
        double t2 = System.currentTimeMillis();
        double tf = (t2-t1)/1000;
        System.out.printf("\nA execução da calculadora de interseção ingenua demorou %.5f segundos.\n",tf);

    }
}
