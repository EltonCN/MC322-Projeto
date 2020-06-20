package br.unicamp.mc322.projeto.gameengine.output.image;

import br.unicamp.mc322.projeto.gameengine.output.image.SpriteBuffer;
import br.unicamp.mc322.projeto.gameengine.output.image.SpriteFactory;
import br.unicamp.mc322.projeto.gameengine.entity.EntityType;
import br.unicamp.mc322.projeto.gameengine.output.image.Sprite;

public class SpriteFactory

{
    /** Attributes */
    /**
     * Hash map das sprites já carregadas
     */
    private Sprite[] sprite;
    /**
     * Instância atual de SpriteFactory
     */
    private  instance = SpriteFactory;
    /**
     * Tabela de Hash dos arquivos, chaveados a partir do tipo de entidade. Pode conte
     */
    private Map hashTable;
    /** Associations */
    private Sprite unnamed_8;
    /**
     * Operation getSpriteBuffer
     * Provê um SpriteBuffer
     *
     * @param entityType - Arquivo que contém a Sprite
     * @param index - 
     * @return SpriteBuffer
     */
    public SpriteBuffer getSpriteBuffer ( entityType entityType, int index ){}
    /**
     * Operation setRoot
     * Pasta raiz onde as sprites serão procurada
     *
     * @param rootFolde - Endereço da pasta raiz
     */
    public void setRoot ( String rootFolde ){}
    /**
     * Operation getInstance
     * Retorna uma instância de SpriteFactory
     *
     * @return SpriteFactory
     */
    public SpriteFactory getInstance (  ){}
    /**
     * Operation getSpriteBuffer
     * Provê um SpriteBuffer
     *
     * @param entityType - 
     * @return SpriteBuffer
     */
    public SpriteBuffer getSpriteBuffer ( EntityType entityType ){}
    /**
     * Operation setFile
     * Define o spriteBuffer de alguma entidade
     *
     * @param file - 
     * @param index - Índice do SpriteBuffer
     */
    public void setFile ( String file, int index ){}
    /**
     * Operation SpriteFactory
     * Construtor de SpriteFactory
     *
     * @param pastaRaiz - Pasta raiz que contém as sprites
     * @return 
     */
    private SpriteFactory ( String pastaRaiz ){}
}

