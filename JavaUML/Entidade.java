package HeroQuest.Entidade;

import HeroQuest.Imagem.Sprite;
import HeroQuest.Pose;
import HeroQuest.Entidade.Inventário;
import HeroQuest.GUI;
import HeroQuest.Imagem.SpriteBuffer;
import HeroQuest.Entidade.Entidade;

public abstract class Entidade

{
    /** Attributes */
    /**
     * 
     */
    protected LinkedList<Entidade> grupo;
    /**
     * 
     */
    protected Sprite sprite;
    /**
     * 
     */
    protected Pose pose;
    /**
     * 
     */
    protected Inventário inventário;
    /**
     * 
     */
    protected int estado;
    /**
     * 
     */
    protected String nome;
    /**
     * 
     */
    protected GUI gui;
    /** Associations */
    private GUI unnamed_11;
    private Entidade unnamed_7;
    private Inventário unnamed_6;
    private Sprite unnamed_2;
    private Pose unnamed_1;
    /**
     * Operation Entidade
     *
     * @param grupo - 
     * @return 
     */
    public Entidade ( LinkedList<Entidade> grupo );

    /**
     * Operation show
     *
     * @return SpriteBuffer
     */
    public SpriteBuffer show (  );

    /**
     * Operation existe
     *
     * @return boolean
     */
    abstract public boolean existe (  );

    /**
     * Operation morrer
     * retorna a lista de entidades contidas ou remove a sim mesma da lista e insere s
     *
     * @return Entidade?
     */
    abstract public Entidade? morrer (  );

    /**
     * Operation run
     *
     * @return 
     */
    abstract public run (  );

    /**
     * Operation showGUI
     *
     * @return LinkedList<SpriteBuffer>
     */
    public LinkedList<SpriteBuffer> showGUI (  );

    /**
     * Operation maisProximo
     *
     * @param entidades - 
     * @param tipo - 
     * @param origem - 
     * @return Entidade
     */
    protected static Entidade maisProximo ( LinkedList<Entidade> entidades, TipoEntidade tipo, Pose origem );

    /**
     * Operation transponível
     *
     * @param pose - 
     * @return boolean
     */
    protected static boolean transponível ( Pose pose );

    /**
     * Operation adjacente
     *
     * @param entidade - 
     * @return boolean
     */
    protected boolean adjacente ( Entidade entidade );

    /**
     * Operation getGUI
     *
     * @return GUI
     */
    protected GUI getGUI (  );

}

