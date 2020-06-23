package br.unicamp.mc322.projeto.gameengine.action;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;

public interface Action

{
    /**
     * Operation run
     * Executa a ação.
    Lança ?TipoExceção?
     *
     * @param origin - Entidade que executará a ação
     */
    public void run ( Entity origin, Message message);

}

