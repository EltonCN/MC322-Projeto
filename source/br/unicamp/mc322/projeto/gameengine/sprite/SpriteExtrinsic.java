package br.unicamp.mc322.projeto.gameengine.sprite;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.resource.ResourceExtrinsic;

public class SpriteExtrinsic
 implements ResourceExtrinsic
{
    /** Attributes */
    /**
     * Sprite intrínseca correspondente
     */
    private SpriteIntrinsic spriteIntrinsic;
    /**
     * Pose em que a Sprite está
     */
    private Pose pose;
    /**
     * Prioridade na tela
     */
    private SpritePriority priority;
    /**
     * Operation SpriteIntrinsic
     * Construtor de SpriteExtrinsic
     *
     * @param spriteIntrinsic - Sprite intrínseca correspondente
     * @return 
     */
    public SpriteExtrinsic( SpriteIntrinsic spriteIntrinsic )
    {
        this.spriteIntrinsic = spriteIntrinsic;
    }
    /**
     * Operation setPose
     * Define a pose
     *
     * @param pose - Pose da sprite
     */
    public void setPose ( Pose pose )
    {
        this.pose = pose;
    }
    /**
     * Operation setPriority
     * Define a prioridade da sprite
     *
     * @param low - Prioridade da Sprite
     */
    public void setPriority ( SpritePriority priority )
    {
        this.priority = priority;
    }

    /**
     * Retorna a sprite
     * @return
     */
    public SpriteIntrinsic getSprite()
    {
        return this.spriteIntrinsic;
    }

    /**
     * Retorna a prioridade da Sprite
     * @return
     */
    public SpritePriority getSpritePriority()
    {
        return this.priority;
    }

    /**
     * Retorna a pose da Sprite
     */
    public Pose getPose()
    {
        return pose;
    }
}

