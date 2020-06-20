package br.unicamp.mc322.projeto.gameengine.gamesystem;

import br.unicamp.mc322.projeto.gameengine.gamesystem.Room;
import br.unicamp.mc322.projeto.gameengine.output.image.Screen;

public class Game

{
    /** Attributes */
    /**
     * Lista das salas contidas no jogo	
     */
    private LinkedList<Room> room;
    /**
     * A sala sendo executada atualmente
     */
    private Room activeRoom;
    /**
     * Tela onde serão exibidos os elementos do jogo
     */
    private Screen screen;
    /** Associations */
    private Screen unnamed_7;
    private Room unnamed_6;
    /**
     * Operation run
     * Inicia o jogo
     *
     */
    public void run (  ){}
    /**
     * Operation Game
     * Construtor a partir de uma sala
     *
     * @param firstRoom - Primeira sala do jogo
     * @return 
     */
    public Game ( Room firstRoom ){}
    /**
     * Operation Game
     * Construtor a partir de uma lista de salas
     *
     * @param room - Lista de salas do jogo
     * @param index - Índice da primeira sala do jogo
     * @return 
     */
    public Game ( LinkedList<Room> room, int index ){}
    /**
     * Operation insertRoom
     * Insere uma sala no jogo
     *
     * @param room - Sala a ser inserida
     */
    public void insertRoom ( Room room ){}
    /**
     * Operation insertRoom
     * Insere uma lista de salas no jogo
     *
     * @param room - Lista de salas
     */
    public void insertRoom ( LinkedList<Room> room ){}
    /**
     * Operation setScreen
     * Define a tela que será usada pelo jogo
     *
     * @param screen - Tela
     */
    public void setScreen ( Screen screen ){}
}

