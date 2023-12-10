package services.interfaces;

import java.util.List;

import entities.Active;

public interface ActiveService {

  /**
   * Using for getting all enabled(or test) actives
   *
   * @return list of enabled actives. Cannot be null
   */
  List<Active> getEnabledActives();

}
