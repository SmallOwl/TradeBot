package services.interfaces;

import java.util.List;

import entities.actives.Active;
import entities.actives.ActiveStatus;

public interface ActiveService {

  /**
   *
   * Using for getting all enabled(or test) actives
   *
   * @param activeStatusList for filtering Active
   * @return list of enabled actives. Cannot be null
   */
  List<Active> getActives(List<ActiveStatus> activeStatusList);

}
