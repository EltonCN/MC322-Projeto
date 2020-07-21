package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;

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
    public void changePose(Pose origin) {
        

    }

    @Override
    public void removeEntity(Pose pose) {
       

    }

    @Override
    public void removeEntity(Entity entity) {
        

    }
}

