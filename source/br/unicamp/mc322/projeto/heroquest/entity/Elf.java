package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;


public class Elf extends Player implements Caster {

	public Elf(Pose pose) {
		super(pose, 2, 2, 6, "Elf");
		caster = true;
		PI = 4;
		///@todo ADD WEAPONS AND MAGIC
	}

	@Override
	public void draw() {
		///@todo Auto-generated method stub

	}

}
