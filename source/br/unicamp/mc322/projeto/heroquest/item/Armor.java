package br.unicamp.mc322.projeto.heroquest.item;

public abstract class Armor extends Item
{
    private float durability;
    public Armor(String name, float value, float durability) 
    {
        super(name, value);
        this.durability = durability;    
    }

    /**
     * Operation transformDamage Reduz o dano
     *
     * @param damage - Dano original do ataque
     * @return float
     */
    public abstract float transformDamage ( float damage );

}

