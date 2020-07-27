package br.unicamp.mc322.projeto.heroquest.item;


public abstract class Item

{
    /** Attributes */
    /**
     * Valor monetário do item
     */
    private float value;
    /**
     * Nome do item
     */
	private String name;
    /**
     * Operation Item
     * Construtor de item
     *
     * @param name - Nome do item
     * @param value - Valor monetário do item
     * @return 
     */
    public Item ( String name, float value )
    {
        this.name = name;
        this.value = value;
    }
    
    
    public float getValue() {
    	return value;
    }
    
    public String getName() {
    	return name;
    }

}

