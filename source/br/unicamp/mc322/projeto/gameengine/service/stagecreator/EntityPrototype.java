package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

import java.lang.reflect.Constructor;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.exception.EntityRecipeException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NoEntityException;

public class EntityPrototype
{
    /** Attributes */
    /**
     * Classe da entidade (deve ser subclasse de Entity)
     */
    private Class entityClass;
    /**
     * Pose da entidade
     */
    private Pose pose;
    /**
     * Argumentos para construir a entidade (na ordem de declaração)
     */
    private Object[] arg;

    public EntityPrototype(Class entityClass, Pose pose, Object... arg )
    {
        this.entityClass = entityClass;
        this.pose = pose;
        this.arg = arg;
    }

    public Entity instantiateEntity() throws EntityRecipeException
    {
        Class[] argClassList = new Class[1+arg.length];

        Object[] argList = new Object[1+arg.length];

        argList[0] = pose;
        argClassList[0] = Pose.class;

        for(int i = 0; i< arg.length; i++)
        {
            argList[i+1] = arg[1];
            argClassList[i+1] = arg[1].getClass();
        }

        Entity entity;
        try
        {
            Constructor constructor = entityClass.getConstructor(argClassList);        

            entity = (Entity) constructor.newInstance(argList);
        }
        catch(NoSuchMethodException e)
        {
            throw new EntityRecipeException("Não foi possível instanciar a entidade, construtor não encontrado" , e);
        }
        catch(ClassCastException e)
        {
            throw new EntityRecipeException("Não foi possível instanciar a entidade, a classe não foi encontrada",new NoEntityException(e));
        }
        catch(Exception e)
        {
            throw new EntityRecipeException("Não foi possível instanciar a entidade, "+e.toString(), e);
        }

        
        return entity;
    }
}

