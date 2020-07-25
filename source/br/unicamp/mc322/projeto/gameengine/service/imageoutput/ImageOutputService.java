package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public interface ImageOutputService extends Service {
    /**
     * Operation update Atualiza a saída
     *
     */
    public void update();

    /**
     * Operation addSprite Adiciona uma imagem a saída
     *
     * @param sprite - Sprite a ser adicionado
     */
    public void addSprite(SpriteExtrinsic sprite);

    /**
     * Retorna a dimensão x da tela
     * @return
     */
    public int getXSize();

    /**
     * Retorna a dimensão y da tela
     * @return
     */
    public int getYSize();

}

