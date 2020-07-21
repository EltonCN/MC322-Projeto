package br.unicamp.mc322.projeto.heroquest.entity;


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
    public void takeDamage ( int damage );

}

