package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.exception.*;

import java.util.NoSuchElementException;

public interface EntityStoreService
 extends Service
{
    /**
     * Operation store
     * Armazena uma entidade
     *
     * @param entity - Entidade a ser armazenada
     */
    public void store ( Entity entity ) throws DisabledServiceException;

    /**
     * Operation getRange
     * Retorna a lista de entidades dentro de um range específico
     *
     * @param origin - Pose de origem
     * @param radius - Range de alcance
     * @param metric - Métrica que será utilizada para calcular o range
     * @return Entity[]
     */
    public Entity[] getRange ( Pose origin, float radius, Metric metric ) throws DisabledServiceException;

    /**
     * Operation changePose
     * Altera a pose de alguma entidade
     *
     * @param origin - Pose de origem da entidade
     * @param final - Pose final da entidade
     * @param entity - Entidade que será movida
     */
    public void changePose ( Pose origin, Pose end ) throws DisabledServiceException, NoSuchElementException;

    /**
     * Operation removeEntity
     * Remove uma entidade
     *
     * @param pose - Pose da entidade que será removida
     */
    public void removeEntity ( Pose pose ) throws DisabledServiceException;

    /**
     * Operation removeEntity
     * Remove uma entidade
     *
     * @param entity - Entidade que será removida
     */
    public void removeEntity ( Entity entity ) throws DisabledServiceException;

}

