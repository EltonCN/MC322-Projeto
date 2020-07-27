package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.InvalidStageIdentifierException;

public interface StageCreatorService
 extends Service
{
    /**
     * Operation loadStage
     * Carrega um estágio (e descarrega o anterior)
     *
     * @param identifier - Identificador do estágio que será carregado
     */
    public void loadStage ( StageIdentifier identifier ) throws DisabledServiceException, InvalidStageIdentifierException;

    /**
     * Insere um estágio no criador
     * @param stage - estágio a ser inserido
     */
    public void insertStage(Stage stage);

    /**
     * Operation unload
     * Descarrega o estágio atual
     *
     */
    public void unload (  ) throws DisabledServiceException;

}

