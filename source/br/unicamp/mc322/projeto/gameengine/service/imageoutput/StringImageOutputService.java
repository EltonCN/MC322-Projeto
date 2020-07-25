package br.unicamp.mc322.projeto.gameengine.service.imageoutput;


import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.StringSprite;

/**
 * @TODO verificacação de serviço desabilitado
 */
public class StringImageOutputService implements ImageOutputService 
{
    private SpriteExtrinsic[][] frame;
    private int xSize, ySize;
    private int xSpriteSize, ySpriteSize;
    private boolean ended;

    private static final int nLineBreak = 10;

    public StringImageOutputService()
    {
        xSize = 672;
        ySize = 336;
        xSpriteSize = 14;
        ySpriteSize = 7;
        ended = false;


    }

    @Override
    public void end() 
    {
        this.ended = true;
    }

    @Override
    /**
     * @Tratar exceções
     */
    public void update() 
    {
        frame = new SpriteExtrinsic[xSpriteSize][ySpriteSize];
        


        ServiceManager m = ServiceManager.getInstance();

        try
        {
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            for(int i = 0; i< s.countEntity(); i++)
            {
                s.getEntity(i).draw();
            }
        }
        catch(ServiceException e)
        {

        }
        
        for(int i = 0; i<xSpriteSize; i++)
        {
            for(int j = 0; j<ySpriteSize; j++)
            {
                if(frame[i][j] == null)
                {
                    System.out.print("  ");
                }
                else
                {
                    StringSprite s = (StringSprite) frame[i][j].getSprite();
                    System.out.print(s.getSprite());
                }
            }
            System.out.println();
        }

        for(int i = 0; i<nLineBreak; i++)
        {
            System.out.println("-----------------------------------------");
        }

    }

    @Override
    /**
     * @TODO lançar exceção para Sprite fora da tela
     * @TODO lançar exceção para Sprite que não seja string
     */
    public void addSprite(SpriteExtrinsic extrinsic) 
    {
        int xPosition = (int) (xSpriteSize*(extrinsic.getPose().getX()/xSize));
        int yPosition = (int) (ySpriteSize*(extrinsic.getPose().getY()/ySize));

        if( extrinsic.getPose().getX() < 0 ||xPosition> xSpriteSize)
        {
            return;
        }
        if(extrinsic.getPose().getY()<0 || yPosition> ySpriteSize)
        {
            return;
        }

        try
        {
            StringSprite sprite = (StringSprite) extrinsic.getSprite();
        }
        catch(ClassCastException e)
        {

        }
        

        if(frame[xPosition][yPosition] != null )
        {
            if(frame[xPosition][yPosition].getSpritePriority().ordinal() > extrinsic.getSpritePriority().ordinal())
            {
                return;
            }
        }

        frame[xPosition][yPosition] = extrinsic;

    }

    @Override
    public int getXSize() 
    {
        return xSize;
    }

    @Override
    public int getYSize() {
        return ySize;
    }
    
}