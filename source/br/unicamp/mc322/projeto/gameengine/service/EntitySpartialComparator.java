package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.entity.Entity;

import java.util.Comparator;

public class EntitySpartialComparator implements Comparator<Entity>
{
    public int compare(Entity a, Entity b)
    {
        if(a.getPose().getX() < b.getPose().getX())
        {
            return 1; 
        }
        else if(a.getPose().getX() > b.getPose().getX())
        {
            return -1;
        }
        else
        {
            if(a.getPose().getY()< b.getPose().getY())
            {
                return -1;
            }
            else if (a.getPose().getY()> b.getPose().getY())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}