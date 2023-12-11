package services.implementations;

import engines.PredictionEngine;
import entities.Active;
import entities.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import services.interfaces.PredictionService;
import services.interfaces.StatisticService;

import java.util.List;

public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private StatisticService statisticService;

    @Override
    public Prediction getPrediction(Active active) {
        return null;
    }

    @Override
    public List<PredictionEngine> getEnabledPredictionEngines(Active active) {
        return null;
    }

}
