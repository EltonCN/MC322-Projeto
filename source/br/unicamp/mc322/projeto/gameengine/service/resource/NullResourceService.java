package br.unicamp.mc322.projeto.gameengine.service.resource;

public class NullResourceService
 implements ResourceService
{


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

    @Override
    public void setFile(String file, Class c, int index) {

    }
}

