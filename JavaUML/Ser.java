package HeroQuest.Entidade;

import HeroQuest.Entidade.Item;
import HeroQuest.Entidade.Armadura;
import HeroQuest.Entidade.Entidade;

public abstract class Ser extends Entidade
{
    /** Attributes */
    /**
     * 
     */
    protected int vida;
    /**
     * 
     */
    protected boolean caster;
    /**
     * 
     */
    protected Item itensEquipados;
    /**
     * 
     */
    protected Armadura armadura;
    /**
     * 
     */
    protected int dinheiro;
    /**
     * Operation run
     *
     * @return 
     */
    public run (  );

    /**
     * Operation sofrerAtaque
     *
     * @return 
     */
    protected sofrerAtaque (  );

    /**
     * Operation curar
     *
     * @return 
     */
    protected curar (  );

    /**
     * Operation realizarAtaque
     *
     * @return 
     */
    protected realizarAtaque (  );

    /**
     * Operation movimentar
     *
     * @return 
     */
    protected movimentar (  );

    /**
     * Operation drop
     *
     * @return 
     */
    protected drop (  );

}

