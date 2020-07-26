package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.item.Dagger;
import br.unicamp.mc322.projeto.heroquest.magic.Fireball;
import br.unicamp.mc322.projeto.heroquest.magic.Magic;
import br.unicamp.mc322.projeto.heroquest.magic.MagicMissile;
import br.unicamp.mc322.projeto.heroquest.magic.Teleport;

public class Wizard extends Player implements Caster
{
	
	private static final Magic[] magics = {new Fireball(), new MagicMissile(), new Teleport()};

	public Wizard(Pose pose) {
		super(pose, 1, 2, 4, "Wizard");
		PI = 6;
		setDagger();
		///@todo ADD WEAPONS AND MAGIC
	}
	
	private void setDagger() {
		for(int i = 0; i < 3; i++)
			this.equipWeapon(new Dagger());
	}

	@Override
	public Magic getMagic(int i) {
		return magics[i];
	}

	@Override
	public int getNMagics() {
		return magics.length;
	}
}
