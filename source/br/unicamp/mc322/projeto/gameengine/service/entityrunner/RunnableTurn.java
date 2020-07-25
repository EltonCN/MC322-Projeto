package br.unicamp.mc322.projeto.gameengine.service.entityrunner;

public interface RunnableTurn
 extends Runnable
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

