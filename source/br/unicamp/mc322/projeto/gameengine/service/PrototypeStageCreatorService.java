package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.StagePrototype;
import br.unicamp.mc322.projeto.gameengine.service.StageCreatorService;

public class PrototypeStageCreatorService
 implements StageCreatorService
{
    /** Attributes */
    /**
     * Conjunto de protótipos de estágio existentes
     */
    public StagePrototype[] stagePrototype;
    /** Associations */
    private StagePrototype unnamed_6;
    /**
     * Operation insertStagePrototype
     * Insere um novo protótipo de estágio
     *
     * @param stagePrototype - Protótipo de estágio a ser inserido
     */
    public void insertStagePrototype ( StagePrototype stagePrototype ){}
}

