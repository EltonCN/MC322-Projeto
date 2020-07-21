package br.unicamp.mc322.projeto.heroquest.entity;


public interface Curable

{
    /**
     * Operation cureLife
     * Cura uma certa quantidade de vida da entidade
     *
     * @param lifePoints - Pontos de vida que serão restaurados
     */
    public void cureLife ( int lifePoints );

}

