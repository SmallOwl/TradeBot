package services.interfaces;

import engines.PredictionEngine;
import entities.Active;
import entities.Prediction;
import entities.PredictionEngineStatus;

import java.util.List;

public interface PredictionService {

    /**
     * Using for predict price of active in the future
     *
     * @param active Active for prediction. Cannot be null
     * @return Prediction for Active. Cannot be null
     */
    Prediction getPrediction(Active active);

    /**
     * Using in StatisticService for analyzing PredictionEngine
     *
     * @param active Active for prediction. Cannot be null
     * @param predictionEngineStatusList List of PredictionEngineStatus needed. Cannot be null
     * @return List of enabled or test PredictionEngine for Active
     */
    List<PredictionEngine> getPredictionEngines(Active active, List<PredictionEngineStatus> predictionEngineStatusList);

}
