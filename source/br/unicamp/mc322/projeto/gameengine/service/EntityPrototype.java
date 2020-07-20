package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;

public class EntityPrototype

{
    /** Attributes */
    /**
     * Classe da entidade (deve ser subclasse de Entity)
     */
    private Class class;
    /**
     * Pose da entidade
     */
    private Pose pose;
    /**
     * Argumentos para construir a entidade (na ordem de declaração)
     */
    private Object[] arg;
}

