package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.service.StagePrototype;
import br.unicamp.mc322.projeto.heroquest.entity.HeroQuestEntity;
import br.unicamp.mc322.projeto.heroquest.entity.Interactable;

public class Door extends HeroQuestEntity implements Interactable
{
    /**
     * Operation Door
     * Criador de Door
     *
     * @param stage - Estágio para o qual a porta deve levar
     * @return 
     */
    public Door ( StagePrototype stage ){}
}

