package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.magic.Magic;
import br.unicamp.mc322.projeto.heroquest.magic.SimpleHeal;


public class Elf extends Player implements Caster {

	private static final Magic[] magics = {new SimpleHeal()};
	
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
	
	@Override
	public Magic getMagic(int i) {
		return magics[i];
	}

	@Override
	public int getNMagics() {
		return magics.length;
	}

}
