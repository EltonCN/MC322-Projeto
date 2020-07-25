package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.imageoutput.ImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.menu.Menu;
import br.unicamp.mc322.projeto.gameengine.service.menu.MenuService;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public class SwingScreen implements MenuService, ImageOutputService {
    /** Attributes */
    /**
     * 
     */
    private Container mainPainel;

    @Override
    public void end() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addMenu(Menu menu) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addSprite(SpriteExtrinsic sprite) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getXSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getYSize() {
        // TODO Auto-generated method stub
        return 0;
    }
}

