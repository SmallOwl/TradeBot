package service.interfaces;

import java.util.Map;

import entity.Active;
import entity.Prediction;

public interface PredictionService {

  /**
   * Using for predict price of active in the future
   *
   * @param active Active for prediction. Cannot be null
   * @return Map.Entry of Active and Prediction for it. Cannot be null
   */
  Map.Entry<Active, Prediction> getPrediction(Active active);

}
