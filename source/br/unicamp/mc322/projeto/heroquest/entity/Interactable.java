package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public interface Interactable

{
    /**
     * Operation interact
     * Interage com a entidade
     *
     * @param activator - Entidade que irá interagir com ela
     */
    public void interact (Entity activator);

}

