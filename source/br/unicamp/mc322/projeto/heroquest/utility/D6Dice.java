package br.unicamp.mc322.projeto.heroquest.utility;

import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;

public class D6Dice

{
    /** Associations */
    private static RandomGenerator rand6 = new RandomGenerator(1,6);
    /**
     * Operation getResult
     * Retorna um número aleatório entre 1 e 6 (inclusive)
     *
     * @return int
     */
    public static int getResult() {
    	return rand6.getResult();
    }
}

