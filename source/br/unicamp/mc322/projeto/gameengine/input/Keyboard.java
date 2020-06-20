package br.unicamp.mc322.projeto.gameengine.input;

import br.unicamp.mc322.projeto.gameengine.input.Keyboard;
import br.unicamp.mc322.projeto.gameengine.input.Key;

public class Keyboard

{
    /** Attributes */
    /**
     * Instância única
     */
    private static  instance;
    /**
     * Operation getInstance
     * Retorna uma instância de Keyboard
     *
     * @return Keyboard
     */
    public static Keyboard getInstance (  ){}
    /**
     * Operation isPressed
     * Verifica se uma tecla está pressionada
     *
     * @param key - Tecla que será verificada
     * @return boolean
     */
    public boolean isPressed ( Key key ){}
}

