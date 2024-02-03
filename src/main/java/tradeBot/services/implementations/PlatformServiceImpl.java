package tradeBot.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tradeBot.engines.interfaces.PlatformEngine;
import tradeBot.entities.Active;
import tradeBot.entities.Platform;
import tradeBot.services.interfaces.PlatformService;

import java.util.Collection;
import java.util.Map;

//TODO Добавить фильтрацию платформ
@Service
@RequiredArgsConstructor
public class PlatformServiceImpl implements PlatformService {

    private final Map<Platform, PlatformEngine> platformEngineMap;

    @Override
    public Collection<Active> getAllActives(Platform platform) {
        return platform != null && platformEngineMap.containsKey(platform) ?
                platformEngineMap.get(platform).getAllActives() :
                platformEngineMap.values().stream().map(PlatformEngine::getAllActives).flatMap(Collection::stream).toList();
    }

}
