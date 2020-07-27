package br.unicamp.mc322.projeto.heroquest.utility;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;

public class RandomPose {
    public static Pose getResult()
    {
        ///@todo Adaptar Essa classe
    	
    	int passo = 48;
    	int randomX = new RandomGenerator(15).getResult() * passo;
    	int randomY = new RandomGenerator(8).getResult() * passo;
    	
    	
    	
        return new Pose(randomX, randomY);
    }
    
}