package tradeBot.services.interfaces;


import java.util.List;

import tradeBot.entities.prediction.PredictionData;
import tradeBot.entities.prediction.PredictionParameter;

public interface PredictionService {

  PredictionData getPredictionData(List<PredictionParameter<?>> predictionParameters);

  List<PredictionParameter<?>> getPredictionParametersClasses(List<PredictionParameter<?>> predictionParameters);

}
