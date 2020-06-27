package br.unicamp.mc322.projeto.gameengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.unicamp.mc322.projeto.gameengine.input.Keyboard;
import br.unicamp.mc322.projeto.gameengine.input.Key;

public class Keyboard implements KeyListener

{
    /** Attributes */
    /**
     * Instância única
     */
    private static Keyboard instance;

    private boolean[] pressed;


    /**
     * Construtor de Keyboard
     */
    private Keyboard() {
        pressed = new boolean[8];

        for(int i = 0; i<8; i++)
        {
            pressed[i] = false;
        }
    }

    /**
     * Operation getInstance Retorna uma instância de Keyboard
     *
     * @return Keyboard
     */
    public static Keyboard getInstance() {
        if (instance == null) {
            instance = new Keyboard();
        }

        return instance;
    }

    /**
     * Operation isPressed Verifica se uma tecla está pressionada
     *
     * @param key - Tecla que será verificada
     * @return boolean
     */
    public boolean isPressed(Key key) 
    {
        return pressed[key.ordinal()];
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        // TODO Auto-generated method stub

    }


    private int keyEventToIndex(KeyEvent e)
    {
        int retorno = -1;

        switch(e.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
                retorno = Key.DOWNARROW.ordinal();
            break;

            case KeyEvent.VK_UP:
                retorno = Key.UPARROW.ordinal();
            break;

            case KeyEvent.VK_LEFT:
                retorno = Key.LEFTARROW.ordinal();
            break;

            case KeyEvent.VK_RIGHT:
                retorno = Key.RIGHTARROW.ordinal();
            break;

            case KeyEvent.VK_W:
                retorno = Key.W.ordinal();
            break;

            case KeyEvent.VK_A:
                retorno = Key.A.ordinal();
            break;

            case KeyEvent.VK_S:
                retorno = Key.S.ordinal();
            break;

            case KeyEvent.VK_D:
                retorno = Key.D.ordinal();
            break;
        }

        return retorno;
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int index = keyEventToIndex(e);

        pressed[index] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        int index = keyEventToIndex(e);

        pressed[index] = false;

    }
}

