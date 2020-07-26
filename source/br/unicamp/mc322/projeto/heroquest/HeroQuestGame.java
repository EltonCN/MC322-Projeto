package br.unicamp.mc322.projeto.heroquest;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.SpartialEntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.gamerunner.TurnGameRunnerService;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.StringImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.ScannerInputService;
import br.unicamp.mc322.projeto.gameengine.service.log.TerminalLogService;
import br.unicamp.mc322.projeto.gameengine.service.resource.StringImageResourceService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypeLoader;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.StageIdentifier;
import br.unicamp.mc322.projeto.heroquest.entity.Barbarian;
import br.unicamp.mc322.projeto.heroquest.entity.Door;
import br.unicamp.mc322.projeto.heroquest.entity.Skeleton;
import br.unicamp.mc322.projeto.heroquest.entity.Wall;
import br.unicamp.mc322.projeto.heroquest.service.HeroQuestStageCreatorService;

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

        TurnGameRunnerService runner = new TurnGameRunnerService();
        StringImageResourceService resource = new StringImageResourceService();


        resource.setFile("SK", Skeleton.class, 0);
        resource.setFile("BR", Barbarian.class, 0);
        resource.setFile("WW", Wall.class, 0);
        resource.setFile("DR", Door.class, 0);

        HeroQuestStageCreatorService stageCreator = new HeroQuestStageCreatorService();

        m.insertService(runner, ServiceType.GAMERUNNER);
        m.insertService(new SpartialEntityStoreService(), ServiceType.ENTITYSTORE);
        m.insertService(new HeroQuestStageCreatorService(), ServiceType.STAGECREATION);
        m.insertService(new TerminalLogService(), ServiceType.LOG);
        //m.insertService(new ImageResourceService(), ServiceType.RESOURCE);
        //m.insertService(new SwingScreen(),ServiceType.IMAGEOUTPUT);
        m.insertService(new ScannerInputService(), ServiceType.KEYINPUT);

        m.insertService(resource, ServiceType.RESOURCE);
        m.insertService(new StringImageOutputService(), ServiceType.IMAGEOUTPUT);

        PrototypeLoader loader = new PrototypeLoader();

        StageIdentifier stage = loader.load("stage0.xml");

        stageCreator.insertStage(stage.getStage());

        

        //stageCreator.loadDefaultStage();
        try 
        {
            stageCreator.loadStage(stage);
            while(true) {
                runner.run();
                Thread.currentThread().sleep(1500);
            }

        }
        catch(ServiceException e) {
            System.out.println("Não foi possível executar o serviço executor de entidades, o jogo será encerrado");
            e.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            System.out.println("Não foi, dar pause");
			e.printStackTrace();
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }


    }
}
