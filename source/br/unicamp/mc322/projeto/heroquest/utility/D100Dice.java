package br.unicamp.mc322.projeto.heroquest.utility;

import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;

public class D100Dice

{
    /** Associations */
    private static RandomGenerator rand100 = new RandomGenerator(100);
    /**
     * Operation getResult
     * Retorna um número aleatório entre 1 e 6 (inclusive)
     *
     * @return int
     * @todo garantir que o resultado está entre 1 (inclusive) e 6 (inclusive) (foi lançada uma exceção por resultado 0)
     */
    public static int getResult() 
    {
    	return rand100.getResult();
    }
}