package br.unicamp.mc322.projeto.gameengine.action;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.gamesystem.message.Message;

public class RandomMovement implements Movement {
    /** Attributes */
    /**
     * Distância que a ação irá movimentar
     */
    private float distance;

    /**
     * Operation RandomMovement Contrutor de RandomMovement
     *
     * @param distance - Distância que a entidade será movimentada
     * @return
     */
    public RandomMovement(float distance) {
        this.distance = distance;
    }

    /**
     * Executa a ação
     * @param origin - entidade que executará a ação
     * @param message - mensagem sobre a qual a ação será executada
     */
    public void run(Entity origin) {
        

    }

    
}

