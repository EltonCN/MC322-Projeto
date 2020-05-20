package HeroQuest.GameSystem;

import HeroQuest.GameSystem.Sala;
import HeroQuest.GameSystem.Loader;
import HeroQuest.Imagem.Tela;

public class Jogo

{
    /** Attributes */
    /**
     * 
     */
    private LinkedList<Sala> salas;
    /**
     * 
     */
    private Sala salaAtual;
    /**
     * 
     */
    private Loader loader;
    /**
     * 
     */
    private Tela tela;
    /** Associations */
    private Tela unnamed_10;
    private Loader unnamed_9;
    private Sala unnamed_8;
    /**
     * Operation iniciar
     *
     * @return 
     */
    public iniciar (  ){}
    /**
     * Operation Jogo
     *
     * @param arquivo - 
     * @return 
     */
    public Jogo ( String arquivo ){}
    /**
     * Operation Jogo
     *
     * @param sala - 
     * @return 
     */
    public Jogo ( Sala sala ){}
    /**
     * Operation Jogo
     *
     * @param salas - 
     * @param idPrimeira - 
     * @return 
     */
    public Jogo ( LinkedList<Sala> salas, int idPrimeira ){}
}

