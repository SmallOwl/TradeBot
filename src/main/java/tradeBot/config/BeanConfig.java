package tradeBot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tradeBot.engines.interfaces.PlatformEngine;
import tradeBot.engines.interfaces.PredictionEngine;
import tradeBot.entities.Platform;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class BeanConfig {

    @Bean
    public Map<Platform, PlatformEngine> platformEngineMap(Collection<PlatformEngine> platformEngines) {
        return platformEngines
                .stream()
                .collect(Collectors.toMap(PlatformEngine::getPlatform, Function.identity()));
    }

    @Bean
    public Map<Class<? extends PredictionEngine>, PredictionEngine> predictionEngineMap(Collection<PredictionEngine> predictionEngines) {
        return predictionEngines
                .stream()
                .collect(Collectors.toMap(PredictionEngine::getClass, Function.identity()));
    }

}
