package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public interface ImageOutputService extends Service {
    /**
     * Operation update Atualiza a saida
     *
     */
    public void update() throws DisabledServiceException;

    /**
     * Operation addSprite Adiciona uma imagem a saida
     *
     * @param sprite - Sprite a ser adicionado
     */
    public void addSprite(SpriteExtrinsic sprite) throws DisabledServiceException;

    /**
     * Retorna a dimensão x da tela
     * @return
     */
    public int getXSize() throws DisabledServiceException;

    /**
     * Retorna a dimensão y da tela
     * @return
     */
    public int getYSize() throws DisabledServiceException;

}

