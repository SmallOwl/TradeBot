package tradeBot.engines.interfaces;

import tradeBot.entities.Active;
import tradeBot.entities.Platform;

import java.util.Collection;

public interface PlatformEngine {

    /**
     * Using for getting all actives
     *
     * @return Collection of Actives
     */
    Collection<Active> getAllActives();

    /**
     * Using for getting platform of Engine
     * (Not used generics because you cant make enum as generic parameter of class)
     *
     * @return Platform of Engine
     */
    Platform getPlatform();

}
