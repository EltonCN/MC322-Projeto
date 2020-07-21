package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Iterator;

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
    public void store(Entity entity) throws DisabledServiceException
    {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
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
     */
    public Entity[] getRange(Pose origin, float radius, Metric metric) throws DisabledServiceException
     {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        
        LinkedList<Entity> result = new LinkedList<Entity>();

        Iterator<Entity> iterator = list.iterator();

        while(iterator.hasNext())
        {
            Entity e = iterator.next();

            if(e.getPose().distance(origin,metric) <= radius)
            {
                result.add(e);
            }
        }

        return (Entity[]) result.toArray();
    }

    @Override
    public void changePose ( Pose origin, Pose end ) throws DisabledServiceException, NoSuchElementException
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

        entity.moveTo(end);

        store(entity);

    }

    @Override
    public void removeEntity(Pose pose)  throws DisabledServiceException
    {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        
        Entity entity = getEntity(pose);

        removeEntity(entity);
    }

    @Override
    public void removeEntity(Entity entity)  throws DisabledServiceException
    {
        if(ended)
        {
            throw new DisabledServiceException("Serviço armazenador 'SpartialEntityStoreService' desabilitado");
        }
        
        list.remove(entity);
    }

    /**
     * Ordena a lista de entidades
     */
    private void sort()
    {
        Collections.sort(list, new EntitySpartialComparator());
    }

    /**
     * Retorna o índice da entidade em uma pose
     * @param pose
     * @return índice da lista
     */
    private int getIndex(Pose pose) throws NoSuchElementException
    {
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
    private Entity getEntity(Pose pose) throws NoSuchElementException
    {
        Iterator<Entity> iterator = list.iterator();
        
        while(iterator.hasNext())
        {
            Entity e = iterator.next();

            if(e.getPose().equal(pose))
            {
                return e;
            }

        }

        throw new NoSuchElementException("Elemento não encontrado na lista");
    }
}

