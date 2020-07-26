package br.unicamp.mc322.projeto.heroquest.utility;

public class CombatDice {
    /** Associations */
    private static CombatDiceFace[] faces = {CombatDiceFace.SKULL, CombatDiceFace.SKULL, CombatDiceFace.SKULL, CombatDiceFace.HEROSHIELD, CombatDiceFace.HEROSHIELD, CombatDiceFace.MONSTERSHIELD};
    /**
     * Operation getResult
     * Gera um resultado do dado
     *
     * @return CombatDiceFace
     * @todo alterar método após corrigir o dado
     */
    public static CombatDiceFace getResult()
    {
        int result = D6Dice.getResult();


        if(result<0)
        {
            result =0;
        }
        if(result>5)
        {
            result = 5;
        }

    	return faces[result];
    }
}

