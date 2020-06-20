package br.unicamp.mc322.projeto.gameengine;

import br.unicamp.mc322.projeto.gameengine.Pose;
import br.unicamp.mc322.projeto.gameengine.Metric;

public class Pose

{
    /** Attributes */
    /**
     * Posição no eixo x
     */
    private float x;
    /**
     * Posição no eixo y
     */
    private float y;
    /**
     * Ângulo/rotação do elemento
     */
    private float angle;
    /**
     * Operation Pose
     * Construtor padrão, cria uma pose centrada na origem com ângulo 0
     *
     * @return 
     */
    public Pose (  ){}
    /**
     * Operation Pose
     * Constroi uma pose com coordenadas x, y definidas e ângulo 0
     *
     * @param x - Coordenada x da pose
     * @param y - Coordenada y da pose
     * @return 
     */
    public Pose ( float x, float y ){}
    /**
     * Operation Pose
     * Constrói uma pose a partir de outra pose
     *
     * @param pose - Pose que será copiada
     * @return 
     */
    public Pose ( Pose pose ){}
    /**
     * Operation Pose
     * Constrói uma nova pose com coordenadas determinadas
     *
     * @param x - Coordenada x da nova pose
     * @param y - Coordenada y da nova pose
     * @param angle - Ângulo da nova pose
     * @return 
     */
    public Pose ( float x, float y, float angle ){}
    /**
     * Operation set
     * Define as coordenadas da pose
     *
     * @param x - Posição x da pose
     * @param y - Posição y da pose
     */
    public void set ( float x, float y ){}
    /**
     * Operation set
     * Define as coordenadas da pose
     *
     * @param x - Posição x da pose
     * @param y - Posição y da pose
     * @param angle - Ângulo da pose
     */
    public void set ( float x, float y, float angle ){}
    /**
     * Operation move
     * Movimenta/incrementa a pose
     *
     * @param x - Incremento no eixo x
     * @param y - Incremento no eixo y
     */
    public void move ( float x, float y ){}
    /**
     * Operation move
     * Movimenta/incrementa a pose
     *
     * @param x - Incremento no eixo x
     * @param y - Incremento no eixo y
     * @param angle - Incremento no ângulo
     */
    public void move ( float x, float y, float angle ){}
    /**
     * Operation adjacent
     * Verifica se uma outra posição é adjacente a esta
     *
     * @param pose - A outra pose
     * @return boolean
     */
    public boolean adjacent ( Pose pose ){}
    /**
     * Operation equal
     * Compara pose com outra
     *
     * @param pose - A outra pose
     * @return boolean
     */
    public boolean equal ( Pose pose ){}
    /**
     * Operation distance
     * Calcula a distância entre essa e outra pose
     *
     * @param pose - A outra pose
     * @param metric - Métrica a ser utilizada
     * @return float
     */
    public float distance ( Pose pose, Metric metric ){}
    /**
     * Operation euclidianDistance
     * Calcula a distância euclidiana até outra pose
     *
     * @param pose - A outra pose
     * @return float
     */
    private float euclidianDistance ( Pose pose ){}
    /**
     * Operation fixAngle
     * Corrige o ângulo (mantém sempre entre 0 e 360)
     *
     */
    private void fixAngle (  ){}
    /**
     * Operation manhattanDistance
     * Calcula a distância de Manhattan até outra pose
     *
     * @param pose - A outra pose
     * @return float
     */
    private float manhattanDistance ( Pose pose ){}
}

