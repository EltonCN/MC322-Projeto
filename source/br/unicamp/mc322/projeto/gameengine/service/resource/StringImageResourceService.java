package br.unicamp.mc322.projeto.gameengine.service.resource;

import java.util.Hashtable;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.StringSprite;

public class StringImageResourceService implements ResourceService 
{
    private boolean ended;

    private Hashtable<Class, String> spriteList;

    public StringImageResourceService()
    {
        this.ended = false;
        spriteList = new Hashtable<Class, String>(100);
    }

    @Override
    public void end() 
    {
        ended = false;
    }

    @Override
    public void setFile(String sprite, Class c, int index) 
    {
        spriteList.put(c, sprite);

    }

    @Override
    public ResourceExtrinsic getResource(ResourceType resourceType, Class c, int index) {
        if(resourceType == ResourceType.AUDIO)
        {
            return null;
        }

        String string = spriteList.get(c);

        StringSprite sprite = new StringSprite(string);

        SpriteExtrinsic extrinsic = new SpriteExtrinsic(sprite);

        return extrinsic;
    }

    @Override
    public void setRoot(String rootFolder) 
    {
        return;
    }
    
}