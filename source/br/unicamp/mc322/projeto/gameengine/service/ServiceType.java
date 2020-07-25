package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.entityrunner.NullEntityRunnerService;
import br.unicamp.mc322.projeto.gameengine.service.entitystore.NullEntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.imageoutput.NullImageOutputService;
import br.unicamp.mc322.projeto.gameengine.service.keyinput.NullKeyInputService;
import br.unicamp.mc322.projeto.gameengine.service.log.NullLogService;
import br.unicamp.mc322.projeto.gameengine.service.menu.NullMenuService;
import br.unicamp.mc322.projeto.gameengine.service.resource.NullResourceService;
import br.unicamp.mc322.projeto.gameengine.service.stagecreator.NullStageCreatorService;

public enum ServiceType

{
    /** Attributes */
    /**
     * 
     */
    LOG, ENTITYSTORE, STAGECREATION, KEYINPUT, IMAGEOUTPUT, ENTITYRUNNER, MENU, RESOURCE;

    static final public int nServiceType = 8;

    /**
     * Retorna um serviço nulo de algum tipo
     * @return
     */
    Service getNullService()
    {
        Service service = null;
        switch(this)
        {
            case LOG:
                service = new NullLogService();
            case ENTITYSTORE:
                service = new NullEntityStoreService();
            case STAGECREATION:
                service = new NullStageCreatorService();
            case KEYINPUT:
                service = new NullKeyInputService();
            case IMAGEOUTPUT:
                service = new NullImageOutputService();
            case ENTITYRUNNER:
                service = new NullEntityRunnerService();
            case MENU:
                service = new NullMenuService();
            case RESOURCE:
                service = new NullResourceService();
        }

        return service;
    } 
}

