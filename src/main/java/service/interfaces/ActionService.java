package service.interfaces;

import java.util.List;

import entity.Action;
import entity.ActionStatus;

public interface ActionService {

  /**
   * Using for execution actions
   *
   * @param actionList list of actions to execute. Cannot be null
   * @return status of execution. Cannot be null
   */
  List<ActionStatus> useActions(List<Action> actionList);

}
