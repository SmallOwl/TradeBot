package tradeBot.services.interfaces;

import tradeBot.entities.Active;
import tradeBot.entities.Currency;
import tradeBot.entities.Platform;

import java.util.Collection;
import java.util.Optional;

public interface ActiveService {

    /**
     *
     * Using for getting all known Actives
     *
     * @return List of Actives
     */
    Collection<Active> getAllActives();

    /**
     * Using for getting Active by Currency
     *
     * @param currency Currency for search
     * @param platform Platform for search
     * @return Optional of Active
     */
    Optional<Active> getActiveByCurrency(Currency currency, Platform platform);

}
