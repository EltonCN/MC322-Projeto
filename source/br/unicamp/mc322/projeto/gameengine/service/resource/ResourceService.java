package br.unicamp.mc322.projeto.gameengine.service.resource;

import br.unicamp.mc322.projeto.gameengine.service.Service;

public interface ResourceService
 extends Service
{
    /**
     * Operation setFile
     * Define um arquivo de recurso para alguma classe
     *
     * @param file - Arquivo
     * @param class - Classe
     * @param index - Índice do arquivo
     */
    public void setFile (String file, Class c, int index);

    /**
     * Operation getResource
     * Retorna o recurso para uma entidade
     *
     * @param resourceType - Tipo do recurso que será carregado
     * @param class - Classe ao qual o recurso pertence
     * @param index - Índice do recurso
     * @return ResourceExtrinsic
     */
    public ResourceExtrinsic getResource ( ResourceType resourceType, Class c, int index );

    /**
     * Operation setRoot
     * Define a pasta raiz para procurar os recursos
     *
     * @param rootFolder - Pasta raiz
     */
    public void setRoot ( String rootFolder );

}
