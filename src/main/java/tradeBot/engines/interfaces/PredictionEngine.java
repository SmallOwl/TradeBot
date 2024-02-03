package tradeBot.engines.interfaces;

import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameters;

import java.util.Optional;

public interface PredictionEngine {

    /**
     * Using for getting predictions
     *
     * @param predictionParameters PredictionParameters for search
     * @return Optional of Prediction
     */
    Optional<Prediction> getPrediction(PredictionParameters predictionParameters);

}
