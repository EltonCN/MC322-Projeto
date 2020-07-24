package br.unicamp.mc322.projeto.gameengine.component;

import br.unicamp.mc322.projeto.gameengine.component.Area;
import br.unicamp.mc322.projeto.gameengine.entity.Entity;
import br.unicamp.mc322.projeto.gameengine.pose.Metric;
import br.unicamp.mc322.projeto.gameengine.pose.Pose;
import br.unicamp.mc322.projeto.gameengine.service.EntityStoreService;
import br.unicamp.mc322.projeto.gameengine.service.LogPriority;
import br.unicamp.mc322.projeto.gameengine.service.LogService;
import br.unicamp.mc322.projeto.gameengine.service.LogType;
import br.unicamp.mc322.projeto.gameengine.service.ServiceManager;
import br.unicamp.mc322.projeto.gameengine.service.ServiceType;
import br.unicamp.mc322.projeto.gameengine.service.exception.ServiceException;

public class EntityRangeArea extends Area {
    
    /**
     * Construtor de EntityRangeAre
     * 
     * @param origin - Pose de origem da área
     * @param range - Alcance da área
     * @param metric - Métrica a ser utilizada para verificar o alcance
     */
    public EntityRangeArea(Pose origin, float range, Metric metric)
    {
        super(origin, range, metric);
    }

    /**
     * Operation getEntitiesInside
     * Retorna as entidades dentro da área
     *
     * @return Entity[]
     */
    public Entity[] getEntitiesInside ()
    {
        ServiceManager m = ServiceManager.getInstance();
        
        try
        {
            EntityStoreService s = (EntityStoreService) m.getService(ServiceType.ENTITYSTORE);

            return s.getRange(origin, range, metric);
        }
        catch(ServiceException e)
        {
            try
            {
                LogService s = (LogService) m.getService(ServiceType.LOG);

                s.sendLog(LogType.OTHER, LogPriority.ERROR, "Serviço não disponível", "Não foi possível acessar o serviço de armazenagem em EntityRangeArea");
            }
            catch(ServiceException e2)
            {

            }

            return new Entity[0];
        }
    }
}

