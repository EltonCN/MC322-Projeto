package br.unicamp.mc322.projeto.gameengine.item;

import br.unicamp.mc322.projeto.gameengine.item.Item;
import br.unicamp.mc322.projeto.gameengine.action.Reaction;

public abstract class Armor extends Item implements Reaction
{
    /**
     * Operation transformDamage
     * Reduz o dano
     *
     * @param dammage - Dano original do ataque
     * @return float
     */
    public float transformDamage ( float dammage );

}

