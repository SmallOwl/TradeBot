package entities.actives;

import entities.Currency;
import entities.platforms.Platform;
import lombok.Data;

@Data
public class Active {

  private Currency currency;

  private ActiveStatus activeStatus;

  private Platform platform;

}
