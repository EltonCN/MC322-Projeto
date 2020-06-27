package br.unicamp.mc322.projeto.gameengine.output.image;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.output.image.SpriteBuffer;

public class Screen

{
    /** Attributes */
    /**
     * Conjunto de spriteBuffers a serem impressos
     */
    private LinkedList<SpriteBuffer> spriteBuffer;
    /**
     * Operation receiveBuffer
     * Recebe um sprite
     *
     * @param buffer - Sprite a ser adicionado
     * @return 
     */
    public void receiveBuffer ( SpriteBuffer buffer ){}
    /**
     * Operation show
     * Imprimir os elementos na tela
     *
     */
    public void show (  ){}
    /**
     * Operation receiveBuffer
     * Recebe um conjunto de sprites buffer
     *
     * @param buffer - Conjunto de sprites
     */
    public void receiveBuffer ( LinkedList<SpriteBuffer> buffer ){}
    /**
     * Operation print
     * Imprime uma imagem em uma posição da tela
     *
     * @param x - Posição x do monitor
     * @param y - Posição y do monitor
     * @param image - Imagem
     */
    private void print ( int x, int y, Image image ){}
}

