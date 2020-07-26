package br.unicamp.mc322.projeto.gameengine.service.resource;

import java.util.Hashtable;
import java.util.LinkedList;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.SpriteIntrinsic;
import br.unicamp.mc322.projeto.gameengine.sprite.SwingImage;

public class ImageResourceService
 implements ResourceService
{
    /** Attributes */
    /**
     * Hash map das sprites já carregadas
     */
    private String root;
    /**
     * Tabela de Hash dos arquivos, chaveados a partir do tipo de entidade. Pode conte
     */
    private Hashtable<Class, LinkedList<String>> files;

    @Override
    public void end() {
        // TODO Auto-generated method stub

    }

    @Override
    public void setFile(String file, Class c, int index) 
    {
        if(files.get(c) == null)
        {
            files.put(c, new LinkedList<String>());
        }

        String totalFolder;

        if(root != null)
        {
            totalFolder = root+"/"+file;
        }
        else
        {
            totalFolder = file;
        }

        files.get(c).add(index, totalFolder);

    }

    @Override
    public ResourceExtrinsic getResource(ResourceType resourceType, Class c, int index) 
    {
        String file = files.get(c).get(index);

        SpriteIntrinsic intrinsic = new SwingImage(file);

        SpriteExtrinsic extrinsic = new SpriteExtrinsic(intrinsic);

        return extrinsic;
    }

    @Override
    public void setRoot(String rootFolder) 
    {
        root = rootFolder;

    }

    


}

