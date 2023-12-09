package service.interfaces;

import java.util.List;

import entity.Active;

public interface ActiveService {

  /**
   * Using for getting all enabled(or test) actives
   *
   * @return list of enabled actives. Cannot be null
   */
  List<Active> getEnabledActives();

}
