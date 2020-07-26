package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;


/**
 * 
 * Apenas uma classe intrasponível
 *
 */
public class Obstacle extends HeroQuestEntity {

	public Obstacle(Pose pose) {
		super(pose);
		///@todo Auto-generated constructor stub
	}

	@Override
	public void draw() {
		///@todo Auto-generated method stub
		
	}
	
	@Override
	public boolean isPermanent() {
		return true;
	}

}
