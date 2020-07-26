package br.unicamp.mc322.projeto.gameengine.service.entitystore;

import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Iterator;

/**
 * Armazena as entidades considerando as poses
 * 
 * @todo homogenizar lançamento de exceções "DisableEntity" e "DisableService"
 */
public class SpartialEntityStoreService implements EntityStoreService 
{
    /**
     * Armazena se o serviço foi encerrado
     */
    private boolean ended;

    /**
     * Lista de entidades armazenadas
     */
    private LinkedList<Entity> list;

    /**
     * Construtor de SpartialEntityStoreService
     */
    public SpartialEntityStoreService()
    {
        this.list = new LinkedList<Entity>();
    }

    @Override
    public void end()
    {
        ended = true;
    }

    @Override
    public void store(Entity entity) throws DisabledServiceException, DisabledEntityException
    {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        if(entity.isEnabled() == false)
        {
            throw new DisabledEntityException();
        }

        
        Iterator<Entity> iterator = list.iterator();
        EntitySpartialComparator comp = new EntitySpartialComparator();

        int index = 0;
        
        while(iterator.hasNext())
        {
            Entity e = iterator.next();
            if(comp.compare(entity,e) >0)
            {
                break;
            }
            index += 1;
        }

        list.add(index, entity);

    }

    @Override
    /**
     * @todo Otimizar para considerar a ordenação da lista
     * @todo Implementar melhor remoção dos elementos desabilitados
     */
    public Entity[] getRange(Pose origin, float radius, Metric metric) throws DisabledServiceException
     {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        
        LinkedList<Entity> result = new LinkedList<Entity>();
        LinkedList<Entity> toRemove = new LinkedList<Entity>();

        Iterator<Entity> iterator = list.iterator();

        while(iterator.hasNext())
        {
            Entity e = iterator.next();
            
            if(e.isEnabled() == false)
            {  
                toRemove.add(e);
                continue;
            }


            if(e.getPose().distance(origin,metric) <= radius)
            {
                result.add(e);
            }
        }


        for(Entity e : toRemove)
        {
            list.remove(e);
        }

        return result.toArray(new Entity[result.size()]);
    }

    @Override
    public void changePose ( Pose origin, Pose end ) throws DisabledServiceException, NoSuchElementException, DisabledEntityException
     {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        
        Entity entity;

        try
        {
            entity = getEntity(origin);
        }
        catch(NoSuchElementException e)
        {
            throw e;
        }

        if(entity.getPose().equal(end))
        {
            return;
        }

        removeEntity(origin);
        store(entity);

        try {
			entity.moveTo(end);
		} catch (InvalidMovementException e) {
			// Da forma que foi implementado, não precisamos nos preocupar muito com isso
			e.printStackTrace();
		}

        store(entity);

    }

    @Override
    public void removeEntity(Pose pose)  throws DisabledServiceException
    {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }

        Entity entity = null;

        try
        {
            entity = getEntity(pose);
        }
        catch(DisabledEntityException e)
        {

        }
        

        entity.disable();

        removeEntity(entity);
    }

    @Override
    public void removeEntity(Entity entity)  throws DisabledServiceException
    {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        
        entity.disable();

        list.remove(entity);
    }

    /**
     * Ordena a lista de entidades
     */
    private void sort() {
        Collections.sort(list, new EntitySpartialComparator());
    }

    /**
     * Retorna o índice da entidade em uma pose
     * @param pose
     * @return índice da lista
     */
    private int getIndex(Pose pose) throws NoSuchElementException {
        Iterator<Entity> iterator = list.iterator();
        
        int index = 0;
        while(iterator.hasNext())
        {
            Entity e = iterator.next();


            if(e.getPose().equal(pose))
            {
                return index;
            }

        }

        throw new NoSuchElementException("Elemento não encontrado na lista");
    }

    /**
     * Retorna a entidade em uma posa
     * @param pose
     * @return
     */
    private Entity getEntity(Pose pose) throws NoSuchElementException, DisabledEntityException
    {
        Iterator<Entity> iterator = list.iterator();
        
        while(iterator.hasNext())
        {
            Entity e = iterator.next();

            if(e.getPose().equal(pose))
            {
                if(e.isEnabled() == false)
                {
                    list.remove(e);

                    throw new DisabledEntityException();
                }
                return e;
            }

        }

        throw new NoSuchElementException("Elemento não encontrado na lista");
    }

    @Override
    public int countEntity() throws DisabledServiceException {
        return list.size();
    }

    @Override
    /**
     * @todo lançar exceção caso a entidade não exista
     */
    public Entity getEntity(int index) 
    {
        Entity e = list.get(index);
        if(e.isEnabled() == false)
        {
            list.remove(e);
            return null;
        }

        return list.get(index);
    }
}

