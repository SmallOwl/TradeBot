package utils.interfaces;

import entities.Active;
import entities.Platform;

import java.util.List;

public interface PlatformUtil {

    /**
     * Using to get all actives from platform
     *
     * @return list of actives in current platform
     */
    List<Active> getActives(Platform platform);

}
