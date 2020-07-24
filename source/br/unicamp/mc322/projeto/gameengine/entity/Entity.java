package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

public abstract class Entity

{
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
    
    public Entity (Pose pose) {
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
    public void stageChanged ()
    {
        if(isPermanent() == false)
        {
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
    	enabled = false; //TODO FINISH IMPLEMENTING! @Elton
    }

    /**
     * Operation draw
     * Desenha a entidade na tela
     *
     */
    public abstract void draw();

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
     * @todo Lidar com exceções
     */
    public final boolean moveTo(Pose pose) {
    	if (!pose.isPositionOccupiable())
    		return false;
    	
        ServiceManager m = ServiceManager.getInstance();

        try {
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            s.changePose(this.pose, pose);
        } catch(DisabledServiceException e) {
        	//TODO IMPLEMENT
        } catch(NotAvaibleServiceException e) {
        	//TODO IMPLEMENT
        }
        
        this.pose = new Pose(pose);
        return true;
    }

    /**
     * Operation moveBy
     * Move a entidade por um deslocamento específico
     *
     * @param deltaX
     * @param deltaY
     * @param deltaAngle
     * @return boolean - Did the move succeed?
     */
    protected final boolean moveBy(float deltaX, float deltaY, float deltaAngle) {
        
    	Pose end = new Pose(this.pose).move(deltaX, deltaY, deltaAngle);
    	return moveTo(end);        
    }
    
}
