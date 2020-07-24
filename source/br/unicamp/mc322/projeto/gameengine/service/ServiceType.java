package br.unicamp.mc322.projeto.gameengine.service;


public enum ServiceType

{
    /** Attributes */
    /**
     * 
     */
    LOG, ENTITYSTORE, STAGECREATION, KEYINPUT, IMAGEOUTPUT, ENTITYRUNNER, MENU, RESOURCE;

    static final public int nServiceType = 7;

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

