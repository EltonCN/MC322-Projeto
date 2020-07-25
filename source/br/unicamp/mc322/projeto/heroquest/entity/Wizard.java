package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.item.Dagger;

public class Wizard extends Player implements Caster
{

	public Wizard(Pose pose) {
		super(pose, 1, 2, 4, "Wizard");
		PI = 6;
		setDagger();
		// TODO ADD WEAPONS AND MAGIC
	}
	
	private void setDagger() {
		for(int i = 0; i < 3; i++)
			this.equipWeapon(new Dagger());
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
}
