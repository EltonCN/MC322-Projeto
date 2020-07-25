package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;

public class Wizard extends Player implements Caster
{

	public Wizard(Pose pose) {
		super(pose, 1, 2, 4);
		PI = 6;
		// TODO ADD WEAPONS AND MAGIC
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
