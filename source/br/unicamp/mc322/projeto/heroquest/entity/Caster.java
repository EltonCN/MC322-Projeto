package br.unicamp.mc322.projeto.heroquest.entity;

import br.unicamp.mc322.projeto.heroquest.magic.Magic;

public interface Caster 
{
    public int getInteligence();
    public Magic getMagic(int i);
    public int getNMagics();
}