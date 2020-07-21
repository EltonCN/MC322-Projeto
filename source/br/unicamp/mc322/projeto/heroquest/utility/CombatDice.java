package br.unicamp.mc322.projeto.heroquest.utility;

import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;

public class CombatDice {
    /** Associations */
    private static RandomGenerator rand6 = new RandomGenerator(0, 5);
    private static CombatDiceFace[] faces = {CombatDiceFace.SKULL, CombatDiceFace.SKULL, CombatDiceFace.SKULL, CombatDiceFace.HEROSHIELD, CombatDiceFace.HEROSHIELD, CombatDiceFace.MONSTERSHIELD};
    /**
     * Operation getResult
     * Gera um resultado do dado
     *
     * @return CombatDiceFace
     */
    public static CombatDiceFace getResult() {
    	return faces[rand6.getResult()];
    }
}

