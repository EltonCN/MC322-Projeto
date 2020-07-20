package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.Runnable;

public interface RunnableTurn
 implements Runnable
{
    /**
     * Operation startTurn
     * Inicia o turno da entidade
     *
     */
    public void startTurn (  );

    /**
     * Operation isInTurn
     * Verifica se o turno da entidade terminou
     *
     * @return boolean
     */
    public boolean isInTurn (  );

}

