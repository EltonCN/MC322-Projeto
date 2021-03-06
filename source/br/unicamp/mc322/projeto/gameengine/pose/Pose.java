package br.unicamp.mc322.projeto.gameengine.pose;

import java.lang.Math;

import br.unicamp.mc322.projeto.gameengine.component.EntityRangeArea;


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
     * Ângulo/rotação do elemento em graus
     */
    private float angle;
    /**
     * Operation Pose
     * Construtor padrão, cria uma pose centrada na origem com ângulo 0
     *
     * @return
     */
    public Pose (  )
    {
        this.x = 0;
        this.y = 0;
        this.angle = 0;

        fixAngle();
    }
    /**
     * Operation Pose
     * Constroi uma pose com coordenadas x, y definidas e ângulo 0
     *
     * @param x - Coordenada x da pose
     * @param y - Coordenada y da pose
     * @return
     */
    public Pose ( float x, float y )
    {
        this.x = x;
        this.y = y;
        this.angle = 0;

        fixAngle();
    }
    /**
     * Operation Pose
     * Constrói uma pose a partir de outra pose
     *
     * @param pose - Pose que será copiada
     * @return
     */
    public Pose ( Pose pose )
    {
        this.x = pose.x;
        this.y = pose.y;
        this.angle = pose.angle;
        fixAngle();
    }
    /**
     * Operation Pose
     * Constrói uma nova pose com coordenadas determinadas
     *
     * @param x - Coordenada x da nova pose
     * @param y - Coordenada y da nova pose
     * @param angle - Ângulo da nova pose
     * @return
     */
    public Pose ( float x, float y, float angle )
    {
        this.x = x;
        this.y = y;
        this.angle = angle;
        fixAngle();
    }

    /**
     * Operation move
     * Movimenta/incrementa a pose
     *
     * @param x - Incremento no eixo x
     * @param y - Incremento no eixo y
     */
    public Pose move ( float x, float y )
    {
        Pose pose = new Pose(this.x+x, this.y+y, this.angle);

        return pose;
    }
    /**
     * Operation move
     * Movimenta/incrementa a pose
     *
     * @param x - Incremento no eixo x
     * @param y - Incremento no eixo y
     * @param angle - Incremento no ângulo
     */
    public Pose move ( float x, float y, float angle )
    {
        Pose pose = new Pose(this.x+x, this.y+y, this.angle+angle);

        return pose;
    }
    /**
     * Operation adjacent
     * Verifica se uma outra posição é adjacente a esta
     *
     * @param pose - A outra pose
     * @return boolean
     */
    public boolean adjacent(Pose pose) {
        if(x-pose.x > 1 || x-pose.x < -1)
            return false;
        if(y-pose.y > 1 || y-pose.y < -1)
            return false;
        if(x - pose.x == 0 && y - pose.y == 0)
    		return false;

        return true;
    }
    /**
     * Operation equal
     * Compara pose com outra
     * Não considera o ângulo
     * @param pose - A outra pose
     * @return boolean
     */
    public boolean equal(Pose pose) {
        if(this.x != pose.x)
        {
            return false;
        }
        if(this.y != pose.y)
        {
            return false;
        }

        return true;
    }
    /**
     * Operation distance
     * Calcula a distância entre essa e outra pose
     *
     * @param pose - A outra pose
     * @param metric - Métrica a ser utilizada
     * @return float
     *
     * /todo Gerar execção para tipo inexistente de métrica
     */
    public float distance ( Pose pose, Metric metric )
    {
        switch(metric)
        {
            case EUCLIDEAN:
                return euclideanDistance(pose);

            case MANHATTAN:
                return manhattanDistance(pose);

            default:

        }

        return 0;
    }
    /**
     * Operation euclideanDistance
     * Calcula a distância euclidiana até outra pose
     *
     * @param pose - A outra pose
     * @return float
     */
    private float euclideanDistance ( Pose pose )
    {
        float result = 0;

        result += Math.pow(pose.x-this.x, 2);

        result += Math.pow(pose.y-this.y, 2);

        return (float) Math.sqrt(result);
    }
    /**
     * Operation fixAngle
     * Corrige o ângulo (mantém sempre entre 0 e 360)
     *
     */
    private void fixAngle (  )
    {

        while(angle > 360)
        {
            angle %= 360;
        }

        while(angle < 0)
        {
            angle += 360;
        }
    }
    /**
     * Operation manhattanDistance
     * Calcula a distância de Manhattan até outra pose
     *
     * @param pose - A outra pose
     * @return float
     */
    private float manhattanDistance ( Pose pose )
    {
        float result = 0;

        result += Math.abs(this.x-pose.x);

        result += Math.abs(this.y-pose.y);

        return result;
    }
    
    //GETTERS
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	
	public float getAngle() {
		return angle;
	}
	
	/**
     * Operation isPositionOccupiable
     * Verifica se a pose está ocupada por alguma entidade
     * 
     * @return boolean
     * 
     */
	public boolean isPositionOccupiable() {
		int size = 1;
		EntityRangeArea possibleFutureArea = new EntityRangeArea(this, 0, Metric.MANHATTAN);
		size = possibleFutureArea.getEntitiesInside().length;
		return size == 0;

    }

    /**
     * Subtrai a pose de outra pose.
     * Não subtrai os ângulos
     * @param p
     * @return
     */
    public Pose minus(Pose p)
    {
        return new Pose(this.x-p.x, this.y-p.y, this.angle);
    }

    /**
     * Cálcula o ângulo em graus do vetor gerado pelo ponto onde a pose está
     */
    public float vectorAngle()
    {
        return (float) Math.toDegrees(Math.atan2(this.y, this.x));
    }
}
