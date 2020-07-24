package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;

public interface Attackable

{
    /**
     * Operation getDefenseScore
     * Retorna a pontuação de defesa da entidade
     *
     * @return int
     */
    public int getDefenseScore (  );

    /**
     * Operation takeDamage
     * Faz a entidade receber uma quantidade de dano
     *
     * @param damage - Dano a ser recebido
     */
    public void takeDamage ( float damage );

    /**
     * Verifica se é amigável
     * @return
     */
    public boolean getIsFriendly();

	public Pose getPose();

}

