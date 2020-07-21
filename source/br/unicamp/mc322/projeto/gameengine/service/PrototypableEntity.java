package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.EntityPrototype;

public interface PrototypableEntity

{
    /**
     * Operation createPrototype
     * Cria um protótipo da entidade
     *
     * @return EntityPrototype
     */
    public EntityPrototype createPrototype (  );

}
