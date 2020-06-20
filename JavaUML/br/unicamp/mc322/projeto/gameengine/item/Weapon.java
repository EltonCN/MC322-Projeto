package br.unicamp.mc322.projeto.gameengine.item;

import br.unicamp.mc322.projeto.gameengine.action.Attack;
import br.unicamp.mc322.projeto.gameengine.item.Item;

public abstract class Weapon extends Item implements Attack
{
    /** Attributes */
    /**
     * Ataque que a arma pode realizar
     */
    private Attack attack;
}

