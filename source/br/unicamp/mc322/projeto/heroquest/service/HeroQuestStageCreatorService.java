package br.unicamp.mc322.projeto.heroquest.service;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.InvalidStageIdentifierException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypeLoader;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypeStageCreatorService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.Stage;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.StageIdentifier;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.StagePrototype;
import br.unicamp.mc322.projeto.heroquest.entity.Barbarian;
import br.unicamp.mc322.projeto.heroquest.entity.Skeleton;
import br.unicamp.mc322.projeto.heroquest.entity.Wall;

/**
 * @todo implementar ended
 */
public class HeroQuestStageCreatorService extends PrototypeStageCreatorService
{
    /** Attributes */
    /**
     * Tipo de cada estágio
     */
    private StageType[] stageType;
    private int enemyCounter;


    /**
     * Cria os estágios padrões do jogo
     */
    public void loadDefaultStage() throws DisabledServiceException
    {
        PrototypeLoader loader = new PrototypeLoader();
        StageIdentifier identifier = loader.load("stage0.xml");
        
        this.loadStage(identifier);


    }

    public void loadRandomStage() throws DisabledServiceException
    {
        PrototypeLoader loader = new PrototypeLoader();
        StageIdentifier identifier = loader.load("stage0R.xml");

        loadStage(identifier);

    }

    public void loadStage(StageIdentifier identifier) throws DisabledServiceException
    {
        addWall((StagePrototype) identifier.getStage());

        Stage stage = identifier.getStage();

        this.insertStage(stage);

        try
        {
            super.loadStage(identifier);
        }
        catch(InvalidStageIdentifierException e)
        {
            try
            {
                ServiceManager m = ServiceManager.getInstance();

                LogService s = (LogService) m.getService(ServiceType.LOG);

                s.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "HeroQuestStageCreatorService", "Não foi possível carregar os estágios");
            }
            catch(ServiceException e2)
            {

            }
            

            System.exit(1);
        }
        
    }


    /**
     * Constroi as paredes ao redor da sala
     * @param stage - o estágio que possuirá as paredes
     * @todo utilizar constantes para representar o tamanho das salas
     */
    private void addWall(StagePrototype stage) {
    	for(int i = 0; i < 16; i++) {
    		stage.addPrototype(new EntityPrototype(Wall.class, i, 0));
    		stage.addPrototype(new EntityPrototype(Wall.class, i, 8));
    	}
    	
    	for(int j = 1; j < 8; j++) {
    		stage.addPrototype(new EntityPrototype(Wall.class, 0, j));
    		stage.addPrototype(new EntityPrototype(Wall.class, 15, j));
    	}
    }

}


