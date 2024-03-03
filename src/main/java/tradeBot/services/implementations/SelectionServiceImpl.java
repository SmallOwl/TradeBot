package tradeBot.services.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tradeBot.entities.prediction.PredictionEngineClassPredictionParameter;
import tradeBot.entities.prediction.PredictionParameter;
import tradeBot.entities.prediction.PredictionStatistic;
import tradeBot.services.interfaces.DataService;
import lombok.RequiredArgsConstructor;
import tradeBot.services.interfaces.PredictionService;
import tradeBot.services.interfaces.SelectionService;

@Service
@RequiredArgsConstructor
public class SelectionServiceImpl implements SelectionService {

  private final DataService dataService;

  private final PredictionService predictionService;

  private final Collection<PredictionStatistic> predictionStatistics = new ArrayList<>();

  @Override
  public Collection<PredictionParameter<?>> selectPrediction(Collection<PredictionParameter<?>> predictionParameters) {
    Optional<PredictionStatistic> predictionStatisticOptional = getPredictionStatistics(predictionParameters)
      .stream()
      .max(Comparator.comparingDouble(PredictionStatistic::getResultScore));
    if(predictionStatisticOptional.isEmpty()) return Collections.emptyList();
    return predictionStatisticOptional.get().getPredictionParameters();
  }

  @Override
  public Collection<PredictionStatistic> getPredictionStatistics(Collection<PredictionParameter<?>> predictionParameters) {
    return predictionStatistics
      .stream()
      .filter(predictionStatistic -> new HashSet<>(predictionStatistic.getPredictionParameters()).containsAll(predictionParameters))
      .toList();
  }

  @Override
  public void refreshPredictionStatistic() {
    predictionService.getPredictionEnginesClasses()
      .stream()
      .forEach(predictionEngineClass -> {
        PredictionEngineClassPredictionParameter predictionEngineClassPredictionParameter =
          new PredictionEngineClassPredictionParameter(Collections.emptyList());
        predictionEngineClassPredictionParameter.setPredictionEngineClass(predictionEngineClass);
        List<Class<PredictionParameter<?>>> predictionParametersClasses = predictionService.getPredictionParametersClasses(predictionEngineClass);
        predictionParametersClasses
          .stream()
          .forEach(predictionParameterClass -> );
      });
  }

}
