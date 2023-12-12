package engines;

import entities.Active;
import entities.Prediction;

public interface PredictionEngine {

    /**
     * Using for predict price of active in the future
     *
     * @param active Active for prediction. Cannot be null
     * @return Prediction for Active. Cannot be null
     */
    Prediction getPrediction(Active active);

}
