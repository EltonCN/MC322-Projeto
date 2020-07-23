package br.unicamp.mc322.projeto.gameengine.service;

import java.util.NoSuchElementException;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;

public class NullEntityStoreService implements EntityStoreService {

    @Override
    public void end() {

    }

    @Override
    public void store(Entity entity) {

    }

    @Override
    public Entity[] getRange(Pose origin, float radius, Metric metric) {

        return null;
    }



    @Override
    public void removeEntity(Pose pose) {

    }

    @Override
    public void removeEntity(Entity entity) {

    }

    @Override
    public void changePose(Pose origin, Pose end) throws DisabledServiceException, NoSuchElementException 
    {

    }

    @Override
    public int countEntity() throws DisabledServiceException 
    {
        return 0;
    }

    @Override
    public Entity getEntity(int index) {
        return null;
    }
}

