package br.unicamp.mc322.projeto.heroquest.entity;

import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.heroquest.utility.D6Dice;
import br.unicamp.mc322.projeto.heroquest.utility.EnemyDice;
import br.unicamp.mc322.projeto.heroquest.utility.RandomPose;
import br.unicamp.mc322.projeto.heroquest.service.StageType;
import br.unicamp.mc322.projeto.heroquest.utility.D100Dice; 

/**
 * @todo Implementar restrições do tamanho da sala
 */
public class RandomStageSpawner extends Entity 
{
    private static final int enemyDice = 2;
    private static final int enemyDiceAisle = 1;
    private static final int pStatue = 40;
    private static final int pStatueAisle = 30;
    private static final int pSpawner = 20;
    private static final int pSpawnerAisle = 5;
    private static final int pTrap = 20;

    private StageType type;

    private LinkedList<Entity> generatedEntity;

    public RandomStageSpawner(Pose pose, StageType type)
    {
        super(pose);
        this.type = type;

        generatedEntity = new LinkedList<Entity>();

        createRandomElements();

        addElements();

        this.enabled = false;
    }

    public RandomStageSpawner(Pose pose, Integer type)
    {
        this(pose, StageType.values()[type] ) ;
    }

    private void addElements()
    {
        ServiceManager m = ServiceManager.getInstance();

        try
        {
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            for(Entity e : generatedEntity)
            {
                s.store(e);
            }
        }
        catch(DisabledEntityException e)
        {
            //Não deve acontecer, já que a entidade acabou de ser gerada
        }
        catch(ServiceException e)
        {
            ///@todo Lidar com a exceção - talvez fechar o jogo?
        }
        

    }

    private void createRandomElements()
    {
        createRandomEnemy();

        createRandomStatue();
            
        createRandomsSpawner();

        createRandomTrap();
    }


    /**
     * Cria uma armadilha aleatória de acordo com as probabilidades
     */
    private void createRandomTrap()
    {
        if(D100Dice.getResult()<pTrap)
        {
            Entity trap = new Trap(RandomPose.getResult());

            generatedEntity.add(trap);

            createRandomStatue();
        }
    }

    /**
     * Cria uma estátua aleatória de acordo com as probabilidades
     */
    private void createRandomStatue()
    {

        boolean add = false;

        if(type==StageType.ROOM)
        {
            if(D100Dice.getResult()<pStatue)
            {
                add = true;
            }
        }
        else if(D100Dice.getResult()<pStatueAisle)
        {
            add = true;
            
        }

        if(add)
        {
            Entity statue = new Statue(RandomPose.getResult());
            generatedEntity.add(statue);
            createRandomStatue();
        }
    }

    /**
     * Cria um spawner aleatório de acordo com as probabilidades
     */
    private void createRandomsSpawner()
    {
        boolean add = false;

        if(type==StageType.ROOM)
        {
            if(D100Dice.getResult()<pSpawner)
            {
                add = true;

                
            }
        }
        else if(D100Dice.getResult()<pSpawnerAisle)
        {
                add = true;
        }

        if(add)
        {
            Entity statue = new SearchHotspot(RandomPose.getResult());
            generatedEntity.add(statue);

            createRandomsSpawner();
        }
    }

    private void createRandomEnemy()
    {
        int nEnemy = 0;

        if(type == StageType.ROOM)
        {
            for(int i = 0; i<enemyDice; i++)
            {
                nEnemy += D6Dice.getResult();
            }
            
        }
        else
        {
            for(int i = 0; i<enemyDiceAisle; i++)
            {
                nEnemy += D6Dice.getResult();
            }
        }  

        for(int i = 0; i<nEnemy; i++)
        {
            Entity e = EnemyDice.getEnemy(RandomPose.getResult());
            generatedEntity.add(e);
        }

    }

}
    