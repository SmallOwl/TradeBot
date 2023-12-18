package services.interfaces;

import entities.actions.ActionStatus;

import java.util.List;

public interface LogService {

    /**
     * Using for saving List<ActionStatus>. This data can be used for debugging or improvement predictions and strategies
     *
     * @param actionStatusList List of statuses from ActionService. Cannot be null
     * @return status of saving. If save is ok return true, else false
     */
    boolean saveActionStatus(List<ActionStatus> actionStatusList);

}
