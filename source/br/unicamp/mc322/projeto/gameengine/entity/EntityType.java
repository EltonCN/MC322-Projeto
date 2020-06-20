package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;

public interface EntityType

{
    /**
     * Operation create
     * Instancia uma entidade de seu tipo
     *
     * @param name - Nome da entidade a ser traduzida
     * @return Entity
     */
    public Entity create ( String name );

}

