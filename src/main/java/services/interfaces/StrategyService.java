package services.interfaces;

import java.util.List;
import java.util.Map;

import entities.actions.Action;
import entities.actives.Active;
import entities.predictions.Prediction;

public interface StrategyService {

  /**
   * Using for getting actions based on prediction
   *
   * @param activePredictionMap Map.Entry of Active and Prediction for it. Cannot be null
   * @return List of Action for executing in ActionService. Cannot be null
   */
  List<Action> getActions(Map<Active, Prediction> activePredictionMap);

}
