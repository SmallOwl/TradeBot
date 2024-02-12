package tradeBot.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tradeBot.engines.interfaces.PredictionEngine;
import tradeBot.entities.Active;
import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameters;
import tradeBot.services.interfaces.PredictionService;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

//TODO Добавить управление
@Slf4j
@Service
@RequiredArgsConstructor
public class PredictionServiceImpl implements PredictionService {

    private final Map<Class<? extends PredictionEngine>, PredictionEngine> predictionEngineMap;

    private final Map<Active, PredictionEngine> predictionBestEngineMap;

    @Override
    public Optional<Prediction> getPrediction(PredictionParameters predictionParameters) {
        if(predictionParameters.getActive() == null) {
            log.warn("Active {} is not valid", predictionParameters.getActive());
            return Optional.empty();
        }
        return predictionParameters.getPredictionEngine() != null ?
                predictionEngineMap.get(predictionParameters.getPredictionEngine()).getPrediction(predictionParameters) :
                predictionBestEngineMap.get(predictionParameters.getActive()).getPrediction(predictionParameters);
    }

    @Override
    public Collection<Prediction> getAllPredictions(PredictionParameters predictionParameters) {
        if(predictionParameters.getActive() == null) {
            log.warn("Active {} is not valid", predictionParameters.getActive());
            return Collections.emptyList();
        }
        return predictionEngineMap
                .values()
                .stream()
                .map(predictionEngine -> predictionEngine.getPrediction(predictionParameters))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public Collection<PredictionEngine> getAllPredictionEngines() {
        return predictionEngineMap.values();
    }
}
