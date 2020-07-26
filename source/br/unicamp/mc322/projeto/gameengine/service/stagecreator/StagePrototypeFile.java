package br.unicamp.mc322.projeto.gameengine.service.stagecreator;

public class StagePrototypeFile implements StageIdentifier
{
    String file;

    public StagePrototypeFile(String file)
    {
        this.file = file;
    }

    @Override
    public Stage getStage() 
    {
        return new PrototypeLoader().load(file);
    }
    
}