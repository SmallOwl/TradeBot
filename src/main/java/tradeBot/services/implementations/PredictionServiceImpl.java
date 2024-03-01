package tradeBot.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tradeBot.engines.interfaces.PredictionEngine;
import tradeBot.entities.Active;
import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameter;
import tradeBot.services.interfaces.PredictionService;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

//TODO Добавить управление
@Slf4j
@Service
@RequiredArgsConstructor
public class PredictionServiceImpl implements PredictionService {

    private final Map<Class<PredictionEngine>, PredictionEngine> predictionEngineMap;

    private final Map<Active, PredictionEngine> predictionBestEngineMap;

    @Override
    public Optional<Prediction> getPrediction(Active active, Class<PredictionEngine> predictionEngine,
                                              PredictionParameter[] predictionParameters) {
        if(active == null) {
            log.warn("Active is null");
            return Optional.empty();
        }
        return predictionEngine != null ?
                predictionEngineMap.get(predictionEngine).getPrediction(active, predictionParameters) :
                predictionBestEngineMap.get(active).getPrediction(active, predictionParameters);
    }

    @Override
    public Collection<Class<PredictionEngine>> getAllPredictionEngineClasses() {
        return predictionEngineMap.keySet();
    }
}
