package Rede_Social;
//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.util.ArrayList;
import java.util.List;

public class CalculadorIntersecaoIngenuo implements CalculadorIntersecao {

    @Override
    public List<Usuario> obterIntersecao(List<Usuario> lista1, List<Usuario> lista2) {
        List<Usuario> list = new ArrayList();
        for(int i=0; i<lista1.size(); i++){
            if(lista2.contains(lista1.get(i))){
                list.add(lista1.get(i));
            }
        }
        // para cada elemento da primeira lista, percorra a segunda lista até encontrá-lo (ou não)

        return list;
    }
}
