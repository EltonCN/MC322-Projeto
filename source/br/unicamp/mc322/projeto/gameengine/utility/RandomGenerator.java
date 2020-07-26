package br.unicamp.mc322.projeto.gameengine.utility;

import java.util.Date;
import java.util.Random;

public class RandomGenerator

{
    /** Attributes */
    /**
     * Menor número a ser gerado (inclusive)
     */
    private int min;
    /**
     * Maior número a ser gerado (inclusive)
     */
    private int max;
    /**
     * Operation RandomGenerator
     * Construtor de RandomGenerator
     *
     * @param min - Menor número a ser gerado (inclusive)
     * @param max - Maior número a ser gerado (inclusive)
     * @return 
     */
    public RandomGenerator (int min, int max){
    	this.min = min;
    	this.max = max;
    }
    /**
     * Operation RandomGenerator
     * Construtor de RandomGenerator
     *
     * @param max - Maior número a ser gerado (inclusive)
     * @return 
     */
    public RandomGenerator (int max) {
    	this.min = 1;
    	this.max = max;
    }
    /**
     * Operation getResult
     * Retorna o número aleatório entre mín e max (inclusive)
     *
     * @return int
     */
    public int getResult() {
    	Random rand = new Random();
    	// Setando a semente com um número consideravelmente aleatório
    	rand.setSeed((new Date().getTime()) * new Date(new Date().toString().hashCode()).toString().hashCode() * System.nanoTime());
    	return (int) min + rand.nextInt() % (max - min + 1);
    }
}

