package br.unicamp.mc322.projeto.heroquest.service;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypeStageCreatorService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.StagePrototype;
import br.unicamp.mc322.projeto.heroquest.entity.Barbarian;
import br.unicamp.mc322.projeto.heroquest.entity.Skeleton;
import br.unicamp.mc322.projeto.heroquest.entity.Wall;

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
    public void loadDefaultStage()
    {
        
        

        StagePrototype stage0 = new StagePrototype();
        buildTheWall(stage0);

        EntityPrototype player = new EntityPrototype(Barbarian.class, 6, 3);
        stage0.addPrototype(player);

        EntityPrototype monster = new EntityPrototype(Skeleton.class, 6, 4);
        stage0.addPrototype(monster);

        ServiceManager m = ServiceManager.getInstance();

        try
        {
            PrototypeStageCreatorService s = (PrototypeStageCreatorService) m.getService(ServiceType.STAGECREATION);

            s.insertStagePrototype(stage0);

            s.loadStage(stage0);
        }
        catch(Exception e)
        {
            System.out.println("Não foi possível carregar os estágios. O jogo será encerrado");
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void addRandomEnemy(StagePrototype stage)
    {
    	Object[] args = {};
        EntityPrototype monster = new EntityPrototype(null, null, args);

    }


    /**
     * Constroi as paredes ao redor da sala
     * @param stage - o estágio que possuirá as paredes
     * @todo utilizar constantes para representar o tamanho das salas
     */
    private void buildTheWall(StagePrototype stage) {
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


