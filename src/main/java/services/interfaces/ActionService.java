package services.interfaces;

import java.util.List;

import entities.Action;
import entities.ActionStatus;

public interface ActionService {

  /**
   * Using for execution actions
   *
   * @param actionList list of actions to execute. Cannot be null
   * @return status of execution. Cannot be null
   */
  List<ActionStatus> useActions(List<Action> actionList);

}
