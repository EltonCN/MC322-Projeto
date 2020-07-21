package br.unicamp.mc322.projeto.gameengine.sprite;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteIntrinsic;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ResourceExtrinsic;

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
    private int priority;
    /** Associations */
    private SpriteIntrinsic unnamed_1;
    /**
     * Operation SpriteIntrinsic
     * Construtor de SpriteExtrinsic
     *
     * @param spriteIntrinsic - Sprite intrínseca correspondente
     * @return 
     */
    public SpriteIntrinsic ( SpriteIntrinsic spriteIntrinsic ){}
    /**
     * Operation setPose
     * Define a pose
     *
     * @param pose - Pose da sprite
     */
    public void setPose ( Pose pose ){}
    /**
     * Operation setPriority
     * Define a prioridade da sprite
     *
     * @param priority - Prioridade da Sprite
     */
    public void setPriority ( int priority ){}
}

