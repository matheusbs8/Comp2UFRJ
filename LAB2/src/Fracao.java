import java.util.Objects;

//Nome : Matheus Barroso de Santana
//DRE: 120041661

/**
 * Representa uma fração de forma explícita, guardando numerador e denominador inteiros.
 * Frações equivalentes (matematicamente) devem ser consideradas equals().
 */
public class Fracao {

    /**
     * Cria uma fração, baseada em seu numerador e denominador.
     * O sinal da fração será inferido a partir do sinal
     * do numerador e do denominador.
     *
     * @param numerador o numerador
     * @param denominador o denominador
     */
    private int numerador;
    private int denominador;
    private boolean positivo;
    public Fracao(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("Denominador não pode ser zero!!");
        }
        if((numerador>0 && denominador<0)|| (numerador<0 && denominador>0)){
            positivo=false;
        }
        else{
            positivo=true;
        }
        this.denominador=Math.abs(denominador);
        this.numerador=Math.abs(numerador);

    }

    /**
     * Retorna o sinal da fração.
     *
     * @return true, se for positiva ou nula (zero);
     *         false, se for negativa.
     */
    public boolean getSinal() {
        return positivo;
    }

    /**
     * Retorna o (valor absoluto do) numerador desta fração, ou seja, sempre não-negativo
     * @return o numerador
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * Retorna o (valor absoluto do) denominador desta fração, ou seja, sempre positivo
     * @return o numerador
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * Retorna o valor numérico da fração (com o sinal correto).
     *
     * @return um float, com o valor na melhor precisão possível
     *         Ex.: -1/3 vai retornar 0.33333333
     */
    public float getValorNumerico() {
        return  (positivo)? (float) ((numerador * 1.0) / denominador) : (float) ((numerador * 1.0)/denominador)*(-1);

    }

    /**
     * Retorna uma fração equivalente à esta fração,
     * e que não pode mais ser simplificada (irredutível).
     *
     * @return um outro objeto Fracao, se esta fração for redutível;
     *         esta própria fração (this), se ela já for irredutível
     */
    public Fracao getFracaoGeratriz() {
        int mdc =AritmeticaUtils.mdc(numerador, denominador);
        if(mdc==1){
            return  this;
        }
        else{
            int nume = (positivo)?((int)numerador/mdc): (int)((numerador *(-1))/mdc);
            return  new Fracao(nume, (int)denominador/mdc);
        }


          // ToDo: IMPLEMENT ME!!!!
    }

    @Override
    public String toString() {
        String s;
        if(numerador==0){
            return "0";
        }
        if (denominador==1){
            s=(positivo)?""+numerador:"-"+numerador;
            return s;
        }
        s=(positivo)?""+numerador+"/"+denominador:"-"+numerador+"/"+denominador;
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fracao f = (Fracao) o;

        return this.getFracaoGeratriz().numerador==getFracaoGeratriz().numerador &&
                this.getFracaoGeratriz().denominador==getFracaoGeratriz().denominador &&
                this.getSinal()==f.getSinal();
    }


}
