package br.unicamp.mc322.projeto.gameengine.action;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public interface Action

{
    /**
     * Operation run
     * Executa a ação.
     *
     * @param origin - Entidade que executará a ação
     */
    public void run ( Entity origin );

}

