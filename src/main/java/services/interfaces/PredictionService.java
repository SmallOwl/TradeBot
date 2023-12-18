package services.interfaces;

import entities.actives.Active;
import entities.predictions.Prediction;

public interface PredictionService {

    /**
     * Using for predict price of active in the future
     *
     * @param active Active for prediction. Cannot be null
     * @return Prediction for Active. Cannot be null
     */
    Prediction getPrediction(Active active);

}
