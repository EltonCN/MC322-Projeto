package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.item.LongSword;

public class Barbarian extends Player
{

	public Barbarian(Pose pose) {
		super(pose, 3, 2, 8, "Barbarian");
		PI = 2;
		equipWeapon(new LongSword());
		///@todo ADD WEAPONS
	}

	@Override
	public void draw() {
		///@todo Auto-generated method stub
		
	}
}

