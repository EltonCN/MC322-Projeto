package br.unicamp.mc322.projeto.gameengine.service.menu;

import br.unicamp.mc322.projeto.gameengine.service.menu.Menu;

public interface Menu

{
    /**
     * Operation show
     *
     * @return 
     */
    public show (  );

    /**
     * Operation hide
     *
     * @return 
     */
    public hide (  );

    /**
     * Operation add
     *
     * @param button - 
     * @return 
     */
    public add ( Button button );

    /**
     * Operation add
     *
     * @param menu - 
     * @return 
     */
    public add ( Menu menu );

}

