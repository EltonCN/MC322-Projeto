package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.component.LightObstructorArea;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.service.PrototypableEntity;

public abstract class HeroQuestEntity extends Entity implements PrototypableEntity
{
    protected final float xStepSize = 1;
    protected final float yStepSize = 1;
    /** Attributes */
    /**
     * Define se a entidade deve ou não obstruir a visão
     */
    private boolean obstructor;
    /**
     * Area obstruidora de luz da entidade
     */
    private LightObstructorArea lightObstructorArea;
    /**
     * Inventário da entidade
     */
    protected LinkedList<Item> inventory;
    /**
     * Operation HeroQuestEntity
     * Construtor de HeroQuestEntity
     *
     * @param pose - Pose da entidade
     * @return 
     */
    public HeroQuestEntity ( Pose pose );

    /**
     * Operation toggleObstructor
     * Alterna a propriedade de obstruir luz da entidade
     *
     * @param visibility - 
     */
    public void toggleObstructor ( boolean visibility );

}

