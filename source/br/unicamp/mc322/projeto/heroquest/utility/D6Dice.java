package br.unicamp.mc322.projeto.heroquest.utility;

import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;

public class D6Dice

{
    /** Associations */
    private static RandomGenerator rand6 = new RandomGenerator(6);
    /**
     * Operation getResult
     * Retorna um número aleatório entre 1 e 6 (inclusive)
     *
     * @return int
     * @todo garantir que o resultado está entre 1 (inclusive) e 6 (inclusive) (foi lançada uma exceção por resultado 0)
     */
    public static int getResult() {
    	return rand6.getResult();
    }
}

