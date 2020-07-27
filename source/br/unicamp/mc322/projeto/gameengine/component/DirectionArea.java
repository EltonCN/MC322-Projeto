package br.unicamp.mc322.projeto.gameengine.component;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;

/**
 * Área setor circular
 */
public class DirectionArea extends EntityRangeArea 
{
    float opening;
    float maxAngle;
    float minAngle;

    public DirectionArea(Pose origin, float range, Metric metric, float opening)
     {
        super(origin, range, metric);
        this.opening = opening;
        maxAngle = origin.getAngle() + (opening/2);
        minAngle = origin.getAngle() - (opening/2);
    }
    

    /**
     * Operation getEntitiesInside
     * Retorna as entidades dentro da área
     *
     * @return Entity[]
     */
    public Entity[] getEntitiesInside ()
    {
        Entity[] all = super.getEntitiesInside();
        LinkedList<Entity> result = new LinkedList<Entity>();

        for(Entity e : all)
        {
            float angle = e.getPose().minus(this.origin).getAngle();

            if(angle<maxAngle && angle>minAngle)
            {
                result.add(e);
            }

        }

        return result.toArray(new Entity[result.size()]);
    }

    /**
     * Verifica se uma pose está dentro da área
     */
    public boolean isInside (Pose pose)
    {
        if(super.isInside(pose) == false)
        {
            return false;
        }


         float angle = pose.minus(this.origin).getAngle();

        if(angle<maxAngle && angle>minAngle)
        {
            return true;
        }

        return false;
    }
}