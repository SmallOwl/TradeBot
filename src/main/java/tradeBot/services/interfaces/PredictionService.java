package tradeBot.services.interfaces;

import tradeBot.engines.interfaces.PredictionEngine;
import tradeBot.entities.Active;
import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameter;

import java.util.Collection;
import java.util.Optional;

public interface PredictionService {

    /**
     * Using for getting predictions
     *
     * @param predictionEngine PredictionEngine for prediction
     * @param predictionParameters PredictionParameter array for prediction
     * @return Optional of Prediction
     */
    Optional<Prediction> getPrediction(Active active, Class<PredictionEngine> predictionEngine,
                                       PredictionParameter[] predictionParameters);

    /**
     * Using for getting all existing PredictionEngines Classes
     *
     * @return Collection of PredictionEngines Classes
     */
    Collection<Class<PredictionEngine>> getAllPredictionEngineClasses();
}
