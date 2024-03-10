package tradeBot.services.interfaces;


import java.util.Collection;
import java.util.List;

import tradeBot.engines.PredictionEngine;
import tradeBot.entities.prediction.PredictionData;
import tradeBot.entities.prediction.PredictionParameter;

public interface PredictionService {

  PredictionData getPredictionData(Collection<PredictionParameter<?>> predictionParameters);

  List<Class<PredictionParameter<?>>> getPredictionParametersClasses(Class<PredictionEngine> predictionEngineClass);

  List<Class<PredictionEngine>> getPredictionEnginesClasses();

}
