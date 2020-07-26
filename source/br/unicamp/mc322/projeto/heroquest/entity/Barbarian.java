package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.ImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceService;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceType;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.SpritePriority;
import br.unicamp.mc322.projeto.heroquest.action.SimpleAttack;
import br.unicamp.mc322.projeto.heroquest.item.LongSword;

public class Barbarian extends Player
{

	public Barbarian(Pose pose) {
		super(pose, 3, 2, 8, "Barbarian");
		PI = 2;
		equipWeapon(new LongSword());
		///@todo ADD WEAPONS
	}
}

