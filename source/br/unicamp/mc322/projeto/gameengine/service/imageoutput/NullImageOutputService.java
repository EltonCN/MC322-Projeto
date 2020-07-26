package br.unicamp.mc322.projeto.gameengine.service.imageoutput;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public class NullImageOutputService implements ImageOutputService {

    @Override
    public void end() {
    	//void
    }

    @Override
    public void update() {
    	//void
    }

    @Override
    public void addSprite(SpriteExtrinsic sprite) {
    	//void
    }

    @Override
    public int getXSize() {
        return 0;
    }

    @Override
    public int getYSize() {
        return 0;
    }
}

