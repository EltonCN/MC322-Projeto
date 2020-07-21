package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.Service;

public interface KeyInputService
 implements Service
{
    /**
     * Operation isPressed
     * Verifica se uma tecla está pressionada
     *
     * @param key - Tecla
     * @return boolean
     */
    public boolean isPressed ( Key key );

    /**
     * Operation isReleased
     * Verifca se uma tecla está solta
     *
     * @param key - Tecla
     * @return boolean
     */
    public boolean isReleased ( Key key );

}

