package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.StageMemento;
import br.unicamp.mc322.projeto.gameengine.service.StageIdentifier;

public class StagePrototype extends StageMemento implements StageIdentifier
{
    /** Attributes */
    /**
     * Protótipos das entidades que irão existir no estágio
     */
    private LinkedList<EntityPrototype> entityPrototype;
    /**
     * Cópia do estágio modificado após descarregá-lo (contém apenas protótipos 
     */
    private StageMemento memento;
    /**
     * Operation createMemento
     * Cria uma cópia do estágio como está agora na memória
     *
     */
    public void createMemento (  ){}
}

