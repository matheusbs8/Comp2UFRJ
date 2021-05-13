package Questao5_6;
//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Questao_5 {

    public static void encontrarPar(List<Integer> lista, int k){
        HashSet<Integer> conjunto = new HashSet<>();
        for (Integer number : lista) {
            conjunto.add(number);
        }
        for(int i=0; i< lista.size(); i++){
            if(conjunto.contains(k-lista.get(i))){
                System.out.printf("%d, %d", lista.get(i), k-lista.get(i));
                break;
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(-10);
        a.add(56);
        a.add(44);
        a.add(12);
        a.add(18);
        int k= 34;
        encontrarPar(a, k);
    }
}
