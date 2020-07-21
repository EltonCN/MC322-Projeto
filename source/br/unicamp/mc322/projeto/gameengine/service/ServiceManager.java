package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.NotAvaibleServiceException;

/**
 * Gerencia e permite acesso aos serviços do jogo
 */
public class ServiceManager

{
    /** Attributes */
    /**
     * Instância do gerenciador de serviços definida
     */
    private static ServiceManager instance;
    /**
     * Serviços existentes
     */
    private Service[] service;
    /**
     * Operation insertService
     * Define uma implementação de serviço
     *
     * @param service - Serviço a ser utlizado
     * @param serviceType - Tipo de serviço que ele implementa 
     */
    /**
     * @todo Verificação do tipo de serviço, para se certificar que o serviço fornecido pertence ao tipo fornecido
     */
    public void insertService ( Service service, ServiceType serviceType )
    {
        if(this.service[serviceType.ordinal()] != null)
        {
            this.service[serviceType.ordinal()].end();
        }

        this.service[serviceType.ordinal()] = service;
    }
    /**
     * Operation getService
     * Retorna um serviço
     *
     * @param serviceType - Tipo do serviço que irá retornar
     * @return Service
     */
    public Service getService ( ServiceType serviceType ) throws NotAvaibleServiceException
    {
        if(this.service[serviceType.ordinal()] == null)
        {
            LogService log = (LogService) service[ServiceType.LOG.ordinal()];

            log.sendLog(LogType.MANAGER, LogPriority.ERROR, "Serviço Inexistente", "Foi solicitado um serviço inexistente do tipo "+serviceType.toString());

            throw new NotAvaibleServiceException("Foi solicitado um serviço inexitente");
        }
        return this.service[serviceType.ordinal()];
    }
    /**
     * Operation defineServiceManager
     * Define uma outra implementação de ServiceManager para ser utilizado
     *
     * @param serviceManager - 
     */
    public void defineServiceManager ( ServiceManager serviceManager )
    {
        if(instance != null)
        {
            LogService log = (LogService) service[ServiceType.LOG.ordinal()];

            log.sendLog(LogType.MANAGER, LogPriority.WARNING, "Redefinição de Manager", "Está sendo definido um novo service manager, porém já há um existente");
        }

        instance = serviceManager;
    }
    /**
     * Operation getInstance
     * Retorna a instância atual de ServiceManager.
     * Cria a padrão se ainda não defida
     *
     * @return ServiceManager
     */
    public ServiceManager getInstance (  )
    {
        if(instance == null)
        {
            instance = new ServiceManager();
        }

        return instance;
    }
    /**
     * Operation setNullService
     * Define que um serviço utilizará uma definição nula
     *
     * @param serviceType - Serviço que utilizará uma definição nula
     */
    public void setNullService ( ServiceType serviceType )
    {
        Service service = serviceType.getNullService();

        this.service[serviceType.ordinal()] = service;
    }
    /**
     * Operation setAllNullService
     * Define todos os serviços como nulos
     *
     */
    public void setAllNullService (  )
    {
        for(ServiceType type : ServiceType.values())
        {
            Service service = type.getNullService();
            
            this.service[type.ordinal()] = service;
        }
    }
    /**
     * Operation ServiceManager
     * Construtor de ServiceManager
     *
     * @return 
     */
    private ServiceManager (  )
    {
        this.service = new Service[ServiceType.nServiceType];

        this.service[ServiceType.LOG.ordinal()] = ServiceType.LOG.getNullService();
    }
}

