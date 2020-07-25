package br.unicamp.mc322.projeto.heroquest.utility;

public class CombatDice {
    /** Associations */
    private static CombatDiceFace[] faces = {CombatDiceFace.SKULL, CombatDiceFace.SKULL, CombatDiceFace.SKULL, CombatDiceFace.HEROSHIELD, CombatDiceFace.HEROSHIELD, CombatDiceFace.MONSTERSHIELD};
    /**
     * Operation getResult
     * Gera um resultado do dado
     *
     * @return CombatDiceFace
     */
    public static CombatDiceFace getResult() {
    	return faces[D6Dice.getResult() - 1];
    }
}

