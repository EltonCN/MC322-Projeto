package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.Button;
import br.unicamp.mc322.projeto.gameengine.service.Menu;

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

