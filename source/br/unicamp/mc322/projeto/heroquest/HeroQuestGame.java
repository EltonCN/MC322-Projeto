package br.unicamp.mc322.projeto.heroquest;

import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.SwingScreen;
import br.unicamp.mc322.projeto.gameengine.service.entityrunner.TurnEntityRunnerService;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.SpartialEntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.StringImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.KeyboardInputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.ScannerInputService;
import br.unicamp.mc322.projeto.gameengine.service.log.TerminalLogService;
import br.unicamp.mc322.projeto.gameengine.service.resource.ImageResourceService;
import br.unicamp.mc322.projeto.gameengine.service.resource.StringImageResourceService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypeStageCreatorService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.StagePrototype;
import br.unicamp.mc322.projeto.gameengine.utility.RandomGenerator;
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
        StringImageResourceService resource = new StringImageResourceService();


        resource.setFile("SK", Skeleton.class, 0);
        resource.setFile("Br", Barbarian.class, 0);

        StringImageOutputService output = new StringImageOutputService();

        m.insertService(runner, ServiceType.ENTITYRUNNER);
        m.insertService(new SpartialEntityStoreService(), ServiceType.ENTITYSTORE);
        m.insertService(new PrototypeStageCreatorService(), ServiceType.STAGECREATION);
        m.insertService(new TerminalLogService(), ServiceType.LOG);
        //m.insertService(new ImageResourceService(), ServiceType.RESOURCE);      
        //m.insertService(new SwingScreen(),ServiceType.IMAGEOUTPUT);
        m.insertService(new ScannerInputService(), ServiceType.KEYINPUT);
        
        m.insertService(resource, ServiceType.RESOURCE);
        m.insertService(output, ServiceType.IMAGEOUTPUT);


        loadDefaultStage();
        try {
            while(true) {
                runner.run();
                output.update();
                Thread.currentThread().sleep(1000);
            }
            
        }
        catch(ServiceException e) {
            System.out.println("Não foi possível executar o serviço executor de entidades, o jogo será encerrado");
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println("Não foi dar pause");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }

    private void loadDefaultStage()
    {
        
        

        StagePrototype stage0 = new StagePrototype();


        EntityPrototype player = new EntityPrototype(Barbarian.class, new Pose(10,10));
        stage0.addPrototype(player);

        EntityPrototype monster = new EntityPrototype(Skeleton.class, new Pose(100,100));
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

