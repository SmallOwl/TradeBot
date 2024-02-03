package tradeBot.services.interfaces;

import tradeBot.entities.Active;
import tradeBot.entities.Platform;

import java.util.Collection;
import java.util.Optional;

public interface PlatformService {

    Collection<Active> getAllActives(Optional<Platform> platform);

}
