package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.item.ShortSword;

public class Dwarf extends Player
{

	public Dwarf(Pose pose) {
		super(pose, 2, 2, 7, "Dwarf");
		PI = 3;
		equipWeapon(new ShortSword());
		///@todo Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		///@todo Auto-generated method stub
		
	}
}

