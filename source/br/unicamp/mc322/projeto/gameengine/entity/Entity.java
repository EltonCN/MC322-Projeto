package br.unicamp.mc322.projeto.gameengine.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;

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
    public boolean isPermanent (  ) {
    	return false;
    }

    /**
     * Operation stageChanged
     * Executa operações em trocas de estágio
     *
     */
    public void stageChanged ();

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
    public void draw (  );

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
    protected void moveTo (Pose pose) {
    	this.pose.set(pose);
    }

    /**
     * Operation moveBy
     * Move a entidade por um deslocamento específico
     *
     * @param deltaX - 
     * @param deltaY - 
     * @param deltaAngle - 
     */
    protected void moveBy ( float deltaX, float deltaY, float deltaAngle ) {
    	this.pose.move(deltaX, deltaY, deltaAngle);
    }

}

