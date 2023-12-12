package services.implementations;

import engines.PredictionEngine;
import entities.Active;
import entities.Prediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import services.interfaces.PredictionService;
import services.interfaces.StatisticService;

import java.util.Map;

@Slf4j
@Service
public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private StatisticService statisticService;

    private Map<Active, Class<? extends PredictionEngine>> activeClassMap;

    private Map<Class<? extends PredictionEngine>, PredictionEngine> predictionEngineMap;

    //TODO Доделать refresh
    @Async
    @Scheduled(fixedRate = 3600000)
    private void refreshPredictionEngines() {
    }

    @Override
    public Prediction getPrediction(Active active) {
        return predictionEngineMap.get(activeClassMap.get(active)).getPrediction(active);
    }

}
