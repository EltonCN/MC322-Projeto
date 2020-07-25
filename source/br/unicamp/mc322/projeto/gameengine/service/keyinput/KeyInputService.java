package br.unicamp.mc322.projeto.gameengine.service.keyinput;

import br.unicamp.mc322.projeto.gameengine.service.Service;

public interface KeyInputService extends Service
{
    /**
     * Operation isPressed
     * Verifica se uma tecla está pressionada
     *
     * @param key - Tecla
     * @return boolean
     */
    /*public boolean isPressed (KeyEvent key);/*

    /**
     * Operation isReleased
     * Verifca se uma tecla está solta
     *
     * @param key - Tecla
     * @return boolean
     */
    /*public boolean isReleased (KeyEvent key);*/
	/**
     * Operation getUserInput
     * Retorna o input do usuário
     *
     * @return char
     */
	public char getUserInput();

}

