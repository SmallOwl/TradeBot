package tradeBot.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tradeBot.engines.interfaces.PredictionEngine;
import tradeBot.entities.Active;
import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameters;
import tradeBot.services.interfaces.ActiveService;
import tradeBot.services.interfaces.PredictionService;
import tradeBot.services.interfaces.StatisticService;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final PredictionService predictionService;

    private final ActiveService activeService;

    @Override
    public void refreshPredictionEngine() {
        Map<Active, Class<PredictionEngine>> bestActivePredictionMap = activeService.getAllActives()
                .stream()
                .map(active -> new PredictionParameters(null, active))
                .map(predictionService::getAllPredictions)
                .map(predictions -> predictions.stream().collect(Collectors.toMap(Function.identity(), this::getPredictionCoefficient)))
                .map(predictionPerActiveMap ->  predictionPerActiveMap.entrySet().stream().max(Map.Entry.comparingByValue()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Map.Entry::getKey)
                .collect(Collectors.toMap(Prediction::getActive, Prediction::getPredictionEngine));

    }

    private double getPredictionCoefficient(Prediction prediction) {
        return 0.0;
    }

}
