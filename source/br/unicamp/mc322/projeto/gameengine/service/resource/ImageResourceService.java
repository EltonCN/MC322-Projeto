package br.unicamp.mc322.projeto.gameengine.service.resource;

import br.unicamp.mc322.projeto.gameengine.sprite.SpriteExtrinsic;

public class ImageResourceService
 implements ResourceService
{
    /** Attributes */
    /**
     * Hash map das sprites já carregadas
     */
    private SpriteExtrinsic[] sprite;
    /**
     * Tabela de Hash dos arquivos, chaveados a partir do tipo de entidade. Pode conte
     */
    private Map hashTable;
	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setFile(String file, Class c, int index) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ResourceExtrinsic getResource(ResourceType resourceType, Class c, int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setRoot(String rootFolder) {
		// TODO Auto-generated method stub
		
	}
}

