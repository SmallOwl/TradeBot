package tradeBot.services.interfaces;

import java.util.Collection;
import java.util.List;

import tradeBot.entities.Active;
import tradeBot.entities.ActiveData;
import tradeBot.entities.prediction.PredictionData;
import tradeBot.entities.prediction.PredictionParameter;

public interface DataService {

  PredictionData getPredictionData(Collection<PredictionParameter<?>> predictionParameters);

  ActiveData getActiveData(Active active);

  void refreshPredictionData();

}
