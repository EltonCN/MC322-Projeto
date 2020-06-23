package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.Pose;

public interface EntityType

{
    /**
     * Operation create
     * Instancia uma entidade de seu tipo
     *
     * @param name - Nome da entidade a ser traduzida
     * @param pose - Pose inicial da entidade
     * @return Entity
     */
    public Entity create ( String name, Pose pose);

}

