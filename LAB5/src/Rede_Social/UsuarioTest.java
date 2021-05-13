
package Rede_Social;
//Nome: Matheus Barroso de Santana
//DRE: 120041661
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UsuarioTest {
    Usuario u1;
    Usuario u2;
    Usuario u3;
    ArrayList<Usuario> amigos=new ArrayList<Usuario>();

    @Before
    public void setUp() {

        for (int i =1; i<=100000; i++){
            amigos.add(new Usuario(i,new CalculadorIntersecaoEsperto()));
        }




    }

    @Test
    public void testarTamanhoIntersecao(){
        u1=new Usuario(12345678, new CalculadorIntersecaoIngenuo());
        u2=new Usuario(12345679, new CalculadorIntersecaoEsperto());
        u3=new Usuario(12345672, new CalculadorIntersecaoViaBuscaBinaria());
        u1.getAmigos().add(amigos.get(0));
        u1.getAmigos().add(amigos.get(1));
        u1.getAmigos().add(amigos.get(2));
        u2.getAmigos().add(amigos.get(0));
        u2.getAmigos().add(amigos.get(1));
        u2.getAmigos().add(amigos.get(3));
        u3.getAmigos().add(amigos.get(0));
        u3.getAmigos().add(amigos.get(1));
        assertEquals(2, u1.obterQuantidadeDeAmigosEmComum(u2));
        assertEquals(2, u1.obterQuantidadeDeAmigosEmComum(u3));
    }

    @Test
    public void compararPerformace(){
        u1=new Usuario(12345678, new CalculadorIntersecaoIngenuo());
        u2=new Usuario(12345679, new CalculadorIntersecaoEsperto());
        u3=new Usuario(12345672, new CalculadorIntersecaoViaBuscaBinaria());
        Random n = new Random();
        for(int i=1; i< amigos.size(); i++){

                u1.getAmigos().add(amigos.get(i));

            if(true){
                u2.getAmigos().add(amigos.get(i));
                u3.getAmigos().add(amigos.get(i));
            }
        }
        Collections.shuffle(u1.getAmigos());
        System.out.println(u1.getAmigos().get(0).getId());
        double t1 = System.currentTimeMillis();
        u1.obterQuantidadeDeAmigosEmComum(u2);
        double t2 = System.currentTimeMillis();
        double tf = (t2-t1)/1000;
        System.out.printf("A execução da calculadora de interseção ingenua demorou %.5f segundos.\n",tf);
        t1 = System.currentTimeMillis();
        u2.obterQuantidadeDeAmigosEmComum(u1);
        t2 = System.currentTimeMillis();
        tf = (t2-t1)/1000;
        System.out.printf("A execução da calculadora de interseção esperta demorou %.5f segundos.\n",tf);
        t1 = System.currentTimeMillis();
        u3.obterQuantidadeDeAmigosEmComum(u1);
        t2 = System.currentTimeMillis();
        tf = (t2-t1)/1000;
        System.out.printf("A execução da calculadora de interseção via busca binaria demorou %.5f segundos.\n",tf);

    }

}