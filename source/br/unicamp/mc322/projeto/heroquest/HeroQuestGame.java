package br.unicamp.mc322.projeto.heroquest;

import java.net.URL;

import br.unicamp.mc322.projeto.gameengine.entity.DisabledEntityException;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.SpartialEntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.exception.DisabledServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.EntityRecipeException;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;
import br.unicamp.mc322.projeto.gameengine.service.gamerunner.TurnGameRunnerService;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.StringImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.KeyInputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.ScannerInputService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.log.LogService;
import br.unicamp.mc322.projeto.gameengine.service.log.LogType;
import br.unicamp.mc322.projeto.gameengine.service.log.TerminalLogService;
import br.unicamp.mc322.projeto.gameengine.service.resource.StringImageResourceService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.EntityPrototype;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.PrototypeLoader;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.StageIdentifier;
import br.unicamp.mc322.projeto.heroquest.entity.*;
import br.unicamp.mc322.projeto.heroquest.item.Treasure;
import br.unicamp.mc322.projeto.heroquest.service.HeroQuestStageCreatorService;

/**
 *
 * Método que inicia o jogo
 * É altamente recomendável que a wiki/documentação seja lida antes de ler/executar o código
 *
 */
public class HeroQuestGame
{
    public static void main(String[] args)
    {
        new HeroQuestGame();
    }
    
    private void setAllFiles(StringImageResourceService resource) {
    	resource.setFile("SpriteSheet/EntitiesSprites/enemies/skeleton/south/idle.png", Skeleton.class, 0);
        resource.setFile("SpriteSheet/EntitiesSprites/enemies/magic_skeleton/south/atack.png", MagicSkeleton.class, 0);
        resource.setFile("SpriteSheet/EntitiesSprites/enemies/goblin/south/idle.png", Goblin.class, 0);
        resource.setFile("SpriteSheet/EntitiesSprites/heroes/barbarian/south/idle.png", Barbarian.class, 0);
        resource.setFile("SpriteSheet/EntitiesSprites/heroes/wizard/south/idle.png", Wizard.class, 0);
        resource.setFile("SpriteSheet/EntitiesSprites/heroes/elf/south/idle.png", Elf.class, 0);
        resource.setFile("SpriteSheet/EntitiesSprites/heroes/dwarf/south/idle.png", Dwarf.class, 0);
        resource.setFile("SpriteSheet/ScenarioSprites/obstacles/water_font.png", Statue.class, 0);
        resource.setFile("SpriteSheet/ScenarioSprites/ground/rocks.png", Wall.class, 0);
        resource.setFile("SpriteSheet/ScenarioSprites/ground/gravel.png", Door.class, 0);
        resource.setFile("SpriteSheet/ScenarioSprites/loot/closed_chest.png", Treasure.class, 0);
        resource.setFile("SpriteSheet/ScenarioSprites/loot/opened_bag.png", Trap.class, 0);
        resource.setFile("SpriteSheet/ItensSprites/consumable/potion.png", SearchHotspot.class, 0);
        resource.setFile("SpriteSheet/notVisible.png", Player.class, 0);
    	
    }
    
    /**
     * @todo Descobrir uma forma melhor para conseguir o path da pasta de estágios
     */
    @SuppressWarnings("static-access") //É um jogo de Thread única, então isso não é um grande problema
	public HeroQuestGame()
    {
        ServiceManager m = ServiceManager.getInstance();

        m.setAllNullService();

        TurnGameRunnerService runner = new TurnGameRunnerService();
        StringImageResourceService resource = new StringImageResourceService();

        //--------------------
        setAllFiles(resource);
        //--------------------
        
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


        URL url=null;
        try
        {
            url = this.getClass().getResource("dummy.txt");
        }
        catch(Exception e)
        {

        }

        String path = url.getPath();

        path = path.substring(0, path.length() - 48);

        String stagePath = path + "stages";

        @SuppressWarnings("unused")
		PrototypeLoader loader = new PrototypeLoader(stagePath);



        try
        {
        	choosePlayer(stageCreator); // Players na ordem alfabética de 1 a 4
        	//chooseStage(stageCreator); // 1 default 2 random
            stageCreator.loadDefaultStage();
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

    private void chooseStage(HeroQuestStageCreatorService h) {
    	try {
			KeyInputService k = (KeyInputService) ServiceManager.getInstance().getService(ServiceType.KEYINPUT);

			boolean loadedStage = false;
			do {
				char order = k.getUserInput();

				if (order == '1') {
					h.loadDefaultStage();
					loadedStage = true;
				}

				else if (order == '2') {
					h.loadRandomStage();
					loadedStage = true;
				}
			} while(!loadedStage);



		} catch (NotAvaibleServiceException | DisabledServiceException e) {
			try {
				LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
				l.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "HeroQuestGameCreatorService in HeroQuestGame", "Há um problema: " + e);
			} catch (NotAvaibleServiceException | DisabledServiceException e2) {
				e2.printStackTrace();
			}
		}

    }

    private void choosePlayer(HeroQuestStageCreatorService h) {

			KeyInputService k;

			try {
				k = (KeyInputService) ServiceManager.getInstance().getService(ServiceType.KEYINPUT);

				boolean loadedPlayer = false;
				do {
					char order = k.getUserInput();
					if (order == '1') {
						getPlayer(Barbarian.class);
						loadedPlayer = true;
					}

					else if (order == '2') {
						getPlayer(Dwarf.class);
						loadedPlayer = true;
					}

					else if (order == '3') {
						getPlayer(Elf.class);
						loadedPlayer = true;
					}

					else if (order == '4') {
						getPlayer(Wizard.class);
						loadedPlayer = true;
					}

					} while(!loadedPlayer);
			} catch (NotAvaibleServiceException | DisabledServiceException | DisabledEntityException | EntityRecipeException e) {
				try {
					LogService l = (LogService) ServiceManager.getInstance().getService(ServiceType.LOG);
					l.sendLog(LogType.STAGECREATOR, LogPriority.ERROR, "Instanciação de Player", "Há um problema: " + e);
				} catch (NotAvaibleServiceException | DisabledServiceException e2) {
					e2.printStackTrace();
				}
			}




    }

    private void getPlayer(Class<?> c) throws NotAvaibleServiceException, DisabledServiceException, DisabledEntityException, EntityRecipeException {
    	EntityStoreService e;
		e = (EntityStoreService) ServiceManager.getInstance().getService(ServiceType.ENTITYSTORE);



    	Object[] args = {};
    	e.store(new EntityPrototype(c, 1, 1, 0, args).instantiateEntity());
    }


}
