package br.unicamp.mc322.projeto.heroquest.item;


public abstract class Item

{
    /** Attributes */
    /**
     * Valor monetário do item
     */
    protected float value;
    /**
     * Nome do item
     */
    protected String name;
    /**
     * Operation Item
     * Construtor de item
     *
     * @param name - Nome do item
     * @param value - Valor monetário do item
     * @return 
     */
    public Item ( String name, float value );

}

