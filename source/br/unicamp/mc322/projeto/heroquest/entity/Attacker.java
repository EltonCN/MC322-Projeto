package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;

public interface Attacker {
    int getAttackScore();

    public boolean getIsFriendly();
    
    public Pose getPose();
}