package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.*;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.ImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceService;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceType;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.SpritePriority;

public class Door extends HeroQuestEntity implements Interactable 
{
    private StageIdentifier identifier;

    /**
     * Operation Door Criador de Door
     *
     * @param stage - Estágio para o qual a porta deve levar
     * @return
     */
    public Door(Pose pose, StageIdentifier identifier) 
    {
        super(pose);

        this.identifier = identifier;
    }

    public Door(Pose pose, StagePrototypeFile identifier)
    {
        super(pose);

        this.identifier = (StageIdentifier) identifier;
    }

    @Override
    public EntityPrototype createPrototype()
    {
        return new EntityPrototype(this.getClass(), this.getPose(), this.identifier );
    }

    @Override
    /**
     * Altera o estágio
     * 
     * @todo Lidar com exceções
     */
    public void interact(Entity activator) 
    {
        try
        {
            ServiceManager m = ServiceManager.getInstance();

            StageCreatorService s = (StageCreatorService) m.getService(ServiceType.STAGECREATION);
    
            s.loadStage(identifier);
        }
        catch(Exception e)
        {

        }
        
    }

    @Override
    public void stageChanged() 
    {
        this.disable();

    }

    @Override
    /**
     * Envia seu sprite para a tela
     * 
     * @todo Lidar com exceções
     */
    public void draw() 
    {
        try
        {
            ServiceManager m = ServiceManager.getInstance();

            ResourceService s = (ResourceService) m.getService(ServiceType.RESOURCE);

            SpriteExtrinsic sprite = (SpriteExtrinsic) s.getResource(ResourceType.IMAGE, this.getClass(), 0);

            sprite.setPose(this.getPose());

            sprite.setPriority(SpritePriority.LOW);

            ImageOutputService imageService = (ImageOutputService) m.getService(ServiceType.IMAGEOUTPUT);

            imageService.addSprite(sprite);
        }
        catch(ServiceException e)
        {

        }
        
        
    }


}

