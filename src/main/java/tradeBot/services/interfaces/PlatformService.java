package tradeBot.services.interfaces;

import tradeBot.entities.Active;
import tradeBot.entities.Platform;

import java.util.Collection;
import java.util.Optional;

public interface PlatformService {

    /**
     * Using for getting all actives
     *
     * @param platform Platform for getting actives
     * @return Collection of Actives
     */
    Collection<Active> getAllActives(Platform platform);

}
