package br.unicamp.mc322.projeto.gameengine.menu;

import br.unicamp.mc322.projeto.gameengine.service.Menu;
import br.unicamp.mc322.projeto.gameengine.menu.SwingMenu;

public class SwingMenu
 implements Menu
{
    /** Attributes */
    /**
     * Submenus do menu
     */
    private Menu submenu = LinkedList<Menu>;
    /**
     * Mensagens selecionáveis do menu
     */
    private LinkedList<SelectableMessage> item;
    /** Associations */
    private SwingMenu unnamed_2;
    /**
     * Operation add
     * Adiciona um item ao menu
     *
     * @param item - Mensagem selecionável a ser adicionada
     * @param index - Posição em que será adicionada
     * @return 
     */
    public add ( SelectableMessage item, int index ){}
    /**
     * Operation show
     * Exibe o menu na tela
     *
     * @return 
     */
    public show (  ){}
    /**
     * Operation hide
     * Esconde o menu
     *
     * @return 
     */
    public hide (  ){}
    /**
     * Operation add
     * Adiciona um submenu
     *
     * @param menu - Submenu
     * @param index - Posição do submenu
     * @return 
     */
    public add ( Menu menu, int index ){}
}

