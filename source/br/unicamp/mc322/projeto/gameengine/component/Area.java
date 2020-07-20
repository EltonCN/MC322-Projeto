package br.unicamp.mc322.projeto.gameengine.component;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;

public class Area

{
    /** Attributes */
    /**
     * Pose de origem da área
     */
    private Pose origin;
    /**
     * Alcance da área
     */
    private float range;
    /**
     * Métrica que a área utiliza para verificar o alcance
     */
    private Metric metric;
    /**
     * Operation Area
     * Construtor de área
     *
     * @param origin - Pose de origem da área
     * @param range - Alcance da área
     * @param metric - Métrica a ser utilizada para verificar o alcance
     * @return 
     */
    public Area ( Pose origin, float range, Metric metric ){}
    /**
     * Operation isInside
     * Verifica se uma pose está contida na área
     *
     * @param pose - Pose a ser verificada
     * @return boolean
     */
    public boolean isInside ( Pose pose ){}
}

