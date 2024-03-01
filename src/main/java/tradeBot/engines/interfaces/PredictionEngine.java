package tradeBot.engines.interfaces;

import tradeBot.entities.Active;
import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameter;

import java.util.Optional;

public interface PredictionEngine {

    /**
     * Using for getting predictions
     *
     * @param active Active for search
     * @param predictionParameters PredictionParameter array for search
     * @return Optional of Prediction
     */
    Optional<Prediction> getPrediction(Active active, PredictionParameter[] predictionParameters);

}
