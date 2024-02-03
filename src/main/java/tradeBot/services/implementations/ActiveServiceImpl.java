package tradeBot.services.implementations;

import lombok.extern.slf4j.Slf4j;
import tradeBot.entities.Active;
import tradeBot.entities.Currency;
import tradeBot.entities.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tradeBot.services.interfaces.ActiveService;
import tradeBot.services.interfaces.PlatformService;

import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActiveServiceImpl implements ActiveService {

    private final PlatformService platformService;

    @Override
    public Collection<Active> getAllActives() {
        return platformService.getAllActives(Optional.empty());
    }

    @Override
    public Optional<Active> getActiveByCurrency(Currency currency, Platform platform) {
        if(currency == null || !validateCurrency(currency) || platform == null) {
            log.warn("Currency {} or Platform {} is not valid", currency, platform);
            return Optional.empty();
        }
        return parseActiveByCurrency(platformService.getAllActives(Optional.of(platform)), currency);
    }

    //TODO Доделать валидацию
    private boolean validateCurrency(Currency currency) {
        return true;
    }

    //TODO Доделать
     private Optional<Active> parseActiveByCurrency(Collection<Active> activeList, Currency currency) {
        return Optional.empty();
     }

}
