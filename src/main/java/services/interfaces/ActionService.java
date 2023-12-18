package services.interfaces;

import java.util.List;

import entities.actions.Action;
import entities.actions.ActionStatus;
import entities.platforms.Platform;

public interface ActionService<P extends Platform> {

  /**
   * Using for execution actions
   *
   * @param actionList list of actions to execute. Cannot be null
   * @return status of execution. Cannot be null
   */
  List<ActionStatus> useActions(List<Action> actionList);

}
