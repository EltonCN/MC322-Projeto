package br.unicamp.mc322.projeto.gameengine.entity;

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
    public abstract void stageChanged ();

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
     * Operation draw
     * Desenha a entidade na tela
     *
     */
    public abstract void draw (  );

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
     * @param pose -
     */
    /**
     * @todo Lidar com exceções
     */
    public final void moveTo (Pose pose)
    {
        this.pose = pose;

        ServiceManager m = ServiceManager.getInstance();

        try
        {
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            s.changePose(this.pose, pose);
        }
        catch(DisabledServiceException e)
        {

        }
        catch(NotAvaibleServiceException e)
        {

        }

    }

    /**
     * Operation moveBy
     * Move a entidade por um deslocamento específico
     *
     * @param deltaX -
     * @param deltaY -
     * @param deltaAngle -
     */
    protected final void moveBy ( float deltaX, float deltaY, float deltaAngle ) {
        Pose end = this.pose.move(deltaX, deltaY, deltaAngle);

        moveTo(end);

    }

}
