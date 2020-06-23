package br.unicamp.mc322.projeto.gameengine.gamesystem;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.gamesystem.Room;
import br.unicamp.mc322.projeto.gameengine.output.image.Screen;
import br.unicamp.mc322.projeto.gameengine.output.image.SpriteBuffer;;

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
    
    /**
     * Operation run
     * Inicia o jogo
     * 
     * @todo Definir o critério de parada do jogo
     * @todo Exceção para inexistência de próxima sala
     */
    public void run (  )
    {
        while(true)
        {
            if(activeRoom.hasPlayer())
            {
                activeRoom.run();
                
                LinkedList<SpriteBuffer> sprite = activeRoom.show();
                screen.receiveBuffer(sprite);
            }
            else
            {
               
                try
                {
                    activeRoom = activeRoom.nextRoom();
                }
                catch(Exception e)
                {
                    System.exit(1);
                }
                
            }
        }

    }
    /**
     * Operation Game
     * Construtor a partir de uma sala
     *
     * @param firstRoom - Primeira sala do jogo
     * @return 
     */
    public Game ( Room firstRoom )
    {
        room = new LinkedList<Room>();

        room.addFirst(firstRoom);
        activeRoom = firstRoom;


    }
    /**
     * Operation Game
     * Construtor a partir de uma lista de salas
     *
     * @param room - Lista de salas do jogo
     * @param index - Índice da primeira sala do jogo
     * @return 
     */
    public Game ( LinkedList<Room> room, int index )
    {
        this.room = new LinkedList<Room>();

        activeRoom = room.remove(index);

        this.room.addAll(room);

        this.room.addFirst(activeRoom);
    }
    /**
     * Operation insertRoom
     * Insere uma sala no jogo
     *
     * @param room - Sala a ser inserida
     */
    public void insertRoom ( Room room )
    {
        this.room.add(room);
    }
    /**
     * Operation insertRoom
     * Insere uma lista de salas no jogo
     *
     * @param room - Lista de salas
     */
    public void insertRoom ( LinkedList<Room> room )
    {
        this.room.addAll(room);
    }
    /**
     * Operation setScreen
     * Define a tela que será usada pelo jogo
     *
     * @param screen - Tela
     */
    public void setScreen ( Screen screen )
    {
        this.screen = screen;
    }
}

