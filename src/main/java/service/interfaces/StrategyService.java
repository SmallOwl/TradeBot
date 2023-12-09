package service.interfaces;

import java.util.List;
import java.util.Map;

import entity.Action;
import entity.Active;
import entity.Prediction;

public interface StrategyService {

  /**
   * Using for getting actions based on prediction
   *
   * @param activePredictionMap Map.Entry of Active and Prediction for it. Cannot be null
   * @return List of Action for executing in ActionService. Cannot be null
   */
  List<Action> getActions(Map<Active, Prediction> activePredictionMap);

}
