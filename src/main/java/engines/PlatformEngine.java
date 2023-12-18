package engines;

import entities.actions.Action;
import entities.actives.Active;
import entities.platforms.Platform;

import java.util.List;

public interface PlatformEngine {

    /**
     * Using to get all actives from platform
     *
     * @return list of actives in current platform
     */
    List<Active> getActives(Platform platform);

    /**
     * Using to execute active from platform
     *
     * @return result of action
     */
    boolean useAction(Action action);

}
