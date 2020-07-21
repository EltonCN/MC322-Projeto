package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.Service;

public interface ImageOutputService
 extends Service
{
    /**
     * Operation update
     * Atualiza a saída
     *
     */
    public void update (  );

    /**
     * Operation addSprite
     * Adiciona uma imagem a saída
     *
     * @param sprite - Sprite a ser adicionado
     */
    public void addSprite ( SpriteExtrinc sprite );

}

