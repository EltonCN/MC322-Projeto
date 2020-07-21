package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.heroquest.entity.Player;

public class Wizard extends Player
{

	public Wizard(Pose pose) {
		super(pose, 1, 2, 4);
		PI = 6;
		caster = true;
		// TODO ADD WEAPONS AND MAGIC
	}
}

