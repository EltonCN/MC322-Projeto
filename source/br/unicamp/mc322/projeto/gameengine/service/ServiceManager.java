package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.Service;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;

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
    /** Associations */
    private Service unnamed_3;
    /**
     * Operation insertService
     * Define uma implementação de serviço
     *
     * @param service - Serviço a ser utlizado
     * @param serviceType - Tipo de serviço que ele implementa
     * @return 
     */
    public insertService ( Service service, ServiceType serviceType ){}
    /**
     * Operation getService
     * Retorna um serviço
     *
     * @param serviceType - Tipo do serviço que irá retornar
     * @return <S extends Service>
     */
    public <S extends Service> getService ( ServiceType serviceType ){}
    /**
     * Operation defineServiceManager
     * Define uma outra implementação de ServiceManager para ser utilizado
     *
     * @param serviceManager - 
     */
    public void defineServiceManager ( ServiceManager serviceManager ){}
    /**
     * Operation getInstance
     * Retorna a instância atual de ServiceManager.
    Cria a padrão se ainda não defi
     *
     * @return ServiceManager
     */
    public ServiceManager getInstance (  ){}
    /**
     * Operation setNullService
     * Define que um serviço utilizará uma definição nula
     *
     * @param serviceType - Serviço que utilizará uma definição nula
     */
    public void setNullService ( ServiceType serviceType ){}
    /**
     * Operation setAllNullService
     * Define todos os serviços como nulos
     *
     */
    public void setAllNullService (  ){}
    /**
     * Operation ServiceManager
     * Construtor de ServiceManager
     *
     * @return 
     */
    private ServiceManager (  ){}
}

