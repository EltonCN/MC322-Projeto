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
import br.unicamp.mc322.projeto.heroquest.action.RandomMovement;

public class Skeleton extends Enemy
{
    /**
     * Operation Skeleton
     * Construtor de esqueleto (DEVE: definir o movimento básico como Random, e o ataque básico como uma arma aleatória)
     *
     * @return 
     */
    public Skeleton (Pose pose)
    {
        super(pose, 3, 2, 4); // Balanceamento escolhido: focado em defesa
        basicMovement = new RandomMovement();
        basicAttack = null; //TODO
    }

    @Override
    /**
     * 
     * @TODO tratar exceções
     */
    public void draw() {
        try {
            ServiceManager m = ServiceManager.getInstance();

            ResourceService s = (ResourceService) m.getService(ServiceType.RESOURCE);

            SpriteExtrinsic sprite = (SpriteExtrinsic) s.getResource(ResourceType.IMAGE, this.getClass(), 0);

            sprite.setPose(this.getPose());

            sprite.setPriority(SpritePriority.LOW);

            ImageOutputService imageService = (ImageOutputService) m.getService(ServiceType.IMAGEOUTPUT);

            imageService.addSprite(sprite);
        } catch(ServiceException e) 
        {
        	
        }

    }
}

