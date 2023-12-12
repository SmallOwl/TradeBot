package services.implementations;

import entities.Action;
import entities.ActionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import services.interfaces.ActionService;
import services.interfaces.PlatformService;

import java.util.List;
import java.util.Map;

public class ActionServiceImpl implements ActionService {

    @Autowired
    private PlatformService platformService;

    //TODO Доделать. Должна быть херова туча проверок на целостность
    @Override
    public List<ActionStatus> useActions(List<Action> actionList) {
        return actionList
                .stream()
                .map(action -> Map.entry(action, platformService.getPlatforms(action.getPlatform()).useAction(action)))
                .map(entry -> getActionStatus(entry.getKey(), entry.getValue()))
                .toList();
    }

    //TODO Доделать
    private ActionStatus getActionStatus(Action action, boolean success) {
        return null;
    }
}
