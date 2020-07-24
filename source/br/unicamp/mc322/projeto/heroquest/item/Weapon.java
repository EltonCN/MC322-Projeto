package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.heroquest.action.Attack;

public abstract class Weapon extends Item implements Attack
{
    /** Attributes */
    /**
     * Mãos que a arma consome
     */
    private int hand;
    /**
     * Usos que a arma possui
     */
    private int uses;
    /**
     * Operation Weapon
     * Construtor de Weapon
     *
     * @param hand - Mãos que a arma usa
     * @param uses - Usos que a arma possui
     * @return 
     */
    public Weapon (String name, float value, int hand, int uses )
    {
        super(name, value);
        this.hand = hand;
        this.uses = uses;
    }

}

