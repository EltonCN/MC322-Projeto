package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.heroquest.Item;

public abstract class Weapon extends Item
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
    public Weapon ( int hand, int uses );

}

