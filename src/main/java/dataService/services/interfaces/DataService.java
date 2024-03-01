package dataService.services.interfaces;

import java.util.List;

import core.entities.Active;
import core.entities.ActiveData;
import core.entities.PredictionData;
import core.entities.PredictionParameter;

public interface DataService {

  PredictionData getPredictionData(List<PredictionParameter<?>> predictionParameters);

  ActiveData getActiveData(Active active);

  void refreshPredictionData();

}
