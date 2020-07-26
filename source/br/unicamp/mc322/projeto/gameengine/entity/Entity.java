package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.action.InvalidMovementException;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.ImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceService;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceType;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.SpritePriority;

/**
 * Representações de objetos que compõem o jogo. Pode representar um personagem jogável, NPCs, plataformas, gatilhos de eventos.
 */
public abstract class Entity {
    /** Attributes */
    /**
     * Pose da entidade
     */
    private Pose pose;
    /**
     *
     */
    protected boolean enabled;
    /**
     * Operation Entity
     * Construtor de entidade
     *
     * @param pose -
     * @return
     */
    
    public Entity (Pose pose)
    {
        enabled = true;
    	this.pose = pose;
    }

    /**
     * Operation isPermanent
     * Verifica se a entidade é permanente
     *
     * @return boolean
     */
    public boolean isPermanent() {
    	return false;
    }

    /**
     * Operation stageChanged
     * Executa operações em trocas de estágio
     *
     */
    public void stageChanged () {
        if(!isPermanent()) {
            this.disable();
        }
    }

    /**
     * Operation isEnabled
     * Verifica se a entidade está ativa
     *
     * @return boolean
     */
    public boolean isEnabled() {
    	return enabled;
    }

    /**
     * Operation disable
     * Desativa a entidade
     *
     */
    public void disable (  ) {
    	enabled = false;
    }

    /**
     * Operation getPose
     * Retorna a pose da entidade
     *
     * @return Pose
     */
    public Pose getPose() {
    	return pose;
    }

    /**
     * Operation moveTo
     * Move a entidade para uma pose específica
     *
     * @param pose
     * @return boolean - Did the move succeed?
     */
    /**
     * @throws InvalidMovementException 
     * @todo Lidar com exceções
     */
    public final void moveTo(Pose pose) throws InvalidMovementException, DisabledEntityException
    {
        if (enabled == false)
        {
            throw new DisabledEntityException();
        }
        
    	if (!pose.isPositionOccupiable())
    		throw new InvalidMovementException();
    	
        ServiceManager m = ServiceManager.getInstance();

        this.pose = new Pose(pose);

        try {
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            s.changePose(this.pose, pose);
        } catch(DisabledServiceException | NotAvaibleServiceException e) {
        	try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.ENTITYSTORE, LogPriority.ERROR, "EntityStore", "Há um problema: " + e);
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
        }
    }

    /**
     * Operation moveBy
     * Move a entidade por um deslocamento específico
     *
     * @param deltaX
     * @param deltaY
     * @param deltaAngle
     * @return boolean - Did the move succeed?
     * @throws InvalidMovementException 
     */
    protected final void moveBy(float deltaX, float deltaY, float deltaAngle) throws InvalidMovementException, DisabledEntityException
    {
        if(enabled == false)
        {
            throw new DisabledEntityException();
        }

    	Pose end = new Pose(this.pose).move(deltaX, deltaY, deltaAngle);
    	moveTo(end);        
    }
    
    /**
     * 
     * @TODO tratar exceções
     */
    /**
     * Operation draw
     * Desenha a entidade na tela
     *
     */
    public void draw() 
    {
        if(enabled == false)
        {
            return;
        }
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
