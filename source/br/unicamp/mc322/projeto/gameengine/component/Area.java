package br.unicamp.mc322.projeto.gameengine.component;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;

/**
 * Uma área no plano
 */
public class Area

{
    /** Attributes */
    /**
     * Pose de origem da área
     */
    protected Pose origin;
    /**
     * Alcance da área
     */
    protected float range; //float foi utilizado para possibilitar a extensão do código para versões não baseadas em grids com posições quantizadas
    /**
     * Métrica que a área utiliza para verificar o alcance
     */
    protected Metric metric;
    /**
     * Operation Area
     * Construtor de área
     *
     * @param origin - Pose de origem da área
     * @param range - Alcance da área
     * @param metric - Métrica a ser utilizada para verificar o alcance
     * @return 
     */
    public Area (Pose origin, float range, Metric metric) {
        this.origin = origin;
        this.range = range;
        this.metric = metric;
    }
    
    //Implementação de área infinita
    public Area (Pose origin, Metric metric) {
        this.origin = origin;
        this.range = Integer.MAX_VALUE;
        this.metric = metric;
    }
    
    /**
     * Operation isInside
     * Verifica se uma pose está contida na área
     *
     * @param pose - Pose a ser verificada
     * @return boolean
     */
    public boolean isInside (Pose pose) { // Checks if a Pose is inside a round OR square circle
        if (origin.distance(pose, metric) <= range) {
            return true;
        }
        return false;
    }
    
    protected boolean isAngleClose(float angle) {
		return (origin.getAngle() - angle <= Math.PI/40); 
	}
}

