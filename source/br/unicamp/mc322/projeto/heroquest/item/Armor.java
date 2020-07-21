package br.unicamp.mc322.projeto.heroquest.item;

import br.unicamp.mc322.projeto.heroquest.Item;

public abstract class Armor extends Item
{
    /**
     * Operation transformDamage
     * Reduz o dano
     *
     * @param damage - Dano original do ataque
     * @return float
     */
    public float transformDamage ( float damage );

}

