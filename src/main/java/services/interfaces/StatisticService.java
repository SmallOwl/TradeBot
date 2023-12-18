package services.interfaces;

import engines.PredictionEngine;
import engines.StrategyEngine;
import entities.actives.Active;

public interface StatisticService {

  /**
   * Using for getting best PredictionEngine for active
   *
   * @param active foreach PredictorEngine returned
   * @return best PredictorEngine for active
   */
  PredictionEngine getPredictionEngine(Active active);

  /**
   * Using for getting best StrategyEngine
   *
   * @return best StrategyEngine for active
   */
  StrategyEngine getStrategyEngine();

}
