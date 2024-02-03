package tradeBot.services.interfaces;

import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameters;

import java.util.Collection;
import java.util.Optional;

public interface PredictionService {

    /**
     * Using for getting predictions
     *
     * @param predictionParameters PredictionParameters for search
     * @return Optional of Prediction
     */
    Optional<Prediction> getPrediction(PredictionParameters predictionParameters);

    /**
     * Using for getting predictions
     *
     * @param predictionParameters PredictionParameters for search
     * @return Optional of Prediction
     */
    Collection<Prediction> getAllPredictions(PredictionParameters predictionParameters);

}
