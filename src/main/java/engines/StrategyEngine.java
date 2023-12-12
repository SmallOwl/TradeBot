package engines;

import entities.Action;
import entities.Active;
import entities.Prediction;

import java.util.List;
import java.util.Map;

public interface StrategyEngine {

    /**
     * Using for getting actions based on prediction
     *
     * @param activePredictionMap Map.Entry of Active and Prediction for it. Cannot be null
     * @return List of Action for executing in ActionService. Cannot be null
     */
    List<Action> getActions(Map<Active, Prediction> activePredictionMap);

}
