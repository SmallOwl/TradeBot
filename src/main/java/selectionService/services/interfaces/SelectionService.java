package selectionService.services.interfaces;

import java.util.Collection;
import java.util.List;

import core.entities.PredictionParameter;
import core.entities.PredictionStatistic;

public interface SelectionService {

  /**
   * This function used to get best predictionParameters for prediction.
   *
   * @param predictionParameters Predefined parameters.
   * @return List of best PredictionParameter.
   */
  Collection<PredictionParameter<?>> selectPrediction(Collection<PredictionParameter<?>> predictionParameters);

  /**
   * This function used to get PredictionStatistic.
   *
   * @param predictionParameters Predefined parameters.
   * @return List of PredictionStatistic. Each of it include list of PredictionParameter, resultScore etc.
   */
  Collection<PredictionStatistic> getPredictionStatistics(Collection<PredictionParameter<?>> predictionParameters);

  /**
   * This function used to refresh service manually.
   */
  void refreshPredictionStatistic();

}
