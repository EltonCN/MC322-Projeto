package br.unicamp.mc322.projeto.gameengine.service;

public interface StageCreatorService
 extends Service
{
    /**
     * Operation loadStage
     * Carrega um estágio (e descarrega o anterior)
     *
     * @param identifier - Identificador do estágio que será carregado
     */
    public void loadStage ( StageIdentifier identifier );

    /**
     * Operation unload
     * Descarrega o estágio atual
     *
     */
    public void unload (  );

}

