package br.unicamp.mc322.projeto.gameengine.service.resource;

public class NullResourceService
 implements ResourceService
{

    @Override
    public void setFile(String file) 
    {

    }

    @Override
    public void setRoot(String rootFolder) 
    {

    }

    @Override
    public void end() 
    {

    }

    @Override
    public ResourceExtrinsic getResource(ResourceType resourceType, Class c, int index) 
    {
        return null;
    }
}

