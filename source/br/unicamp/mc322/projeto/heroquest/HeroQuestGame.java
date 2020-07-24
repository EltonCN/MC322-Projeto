package br.unicamp.mc322.projeto.heroquest;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.service.ImageResourceService;
import br.unicamp.mc322.projeto.gameengine.service.KeyboardInputService;
import br.unicamp.mc322.projeto.gameengine.service.PrototypeStageCreatorService;
import br.unicamp.mc322.projeto.gameengine.service.ScannerInputService;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.SpartialEntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.StagePrototype;
import br.unicamp.mc322.projeto.gameengine.service.SwingScreen;
import br.unicamp.mc322.projeto.gameengine.service.TerminalLogService;
import br.unicamp.mc322.projeto.gameengine.service.TurnEntityRunnerService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.heroquest.entity.Barbarian;
import br.unicamp.mc322.projeto.heroquest.entity.Goblin;
import br.unicamp.mc322.projeto.heroquest.entity.Skeleton;

public class HeroQuestGame
{
    public static void main(String[] args)
    {
        new HeroQuestGame();
    }

    public HeroQuestGame()
    {
        ServiceManager m = ServiceManager.getInstance();

        m.setAllNullService();

        TurnEntityRunnerService runner = new TurnEntityRunnerService();

        m.insertService(runner, ServiceType.ENTITYRUNNER);
        m.insertService(new SpartialEntityStoreService(), ServiceType.ENTITYSTORE);
        m.insertService(new PrototypeStageCreatorService(), ServiceType.STAGECREATION);
        m.insertService(new TerminalLogService(), ServiceType.LOG);
        //m.insertService(new ImageResourceService(), ServiceType.RESOURCE);      
        //m.insertService(new SwingScreen(),ServiceType.IMAGEOUTPUT);
        m.insertService(new ScannerInputService(), ServiceType.KEYINPUT);
        
        

        loadDefaultStage();
        try
        {
            while(true)
            {
                runner.run();
            }
            
        }
        catch(ServiceException e)
        {
            System.out.println("Não foi possível executar o serviço executor de entidades, o jogo será encerrado");
            e.printStackTrace();
            System.exit(1);
        }
        

    }

    private void loadDefaultStage()
    {
        
        

        StagePrototype stage0 = new StagePrototype();


        //EntityPrototype player = new EntityPrototype(Barbarian.class, new Pose(0,0));
        //stage0.addPrototype(player);

        EntityPrototype monster = new EntityPrototype(Skeleton.class, new Pose(10,0));
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
}

