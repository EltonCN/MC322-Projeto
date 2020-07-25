package br.unicamp.mc322.projeto.gameengine.sprite;

public class StringSprite extends SpriteIntrinsic
{
    String sprite;

    public StringSprite(String sprite) 
    {
        super("");

        this.sprite = sprite;
    }
    
    public String getSprite()
    {
        return this.sprite;
    }
}