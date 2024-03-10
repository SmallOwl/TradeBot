package tradeBot.services.implementations;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tradeBot.engines.PredictionEngine;
import tradeBot.entities.prediction.PredictionData;
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
    if (predictionStatisticOptional.isEmpty()) return Collections.emptyList();
    return predictionStatisticOptional.get().getPredictionParameters();
  }

  @Override
  public Collection<PredictionStatistic> getPredictionStatistics(Collection<PredictionParameter<?>> predictionParameters) {
    return predictionStatistics
      .stream()
      .filter(
        predictionStatistic -> new HashSet<>(predictionStatistic.getPredictionParameters()).containsAll(predictionParameters))
      .toList();
  }

  //TODO Добавить логирование
  @Override
  public void refreshPredictionStatistic() {
    PredictionEngineClassPredictionParameter predictionEngineClassParameter = new PredictionEngineClassPredictionParameter();
    predictionEngineClassParameter.setPredictionEngineClasses(predictionService.getPredictionEnginesClasses());
    predictionEngineClassParameter.setPredictionEngineClassesIterator(
      predictionEngineClassParameter.getPredictionEngineClasses().iterator());
    while (predictionEngineClassParameter.hasNext()) {
      Class<PredictionEngine> predictionEngineClass = predictionEngineClassParameter.getParameter();
      Collection<Collection<PredictionParameter<?>>> predictionParametersCollections =
        getPredictionParametersCollections(predictionEngineClass);
      for(Collection<PredictionParameter<?>> predictionParameters: predictionParametersCollections) {
        PredictionData predictionData = dataService.getPredictionData(predictionParameters);
        PredictionStatistic predictionStatistic = new PredictionStatistic(predictionParameters, predictionData, 0);
        predictionStatistics.add(predictionStatistic);
      }
    }
  }

  private Collection<Collection<PredictionParameter<?>>> getPredictionParametersCollections(
    Class<PredictionEngine> predictionEngineClass) {
    Collection<? extends PredictionParameter<?>> predictionParameters = predictionService
      .getPredictionParametersClasses(predictionEngineClass)
      .stream()
      .map(predictionParameterClass -> {
        try {
          return predictionParameterClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      })
      .toList();
    if (predictionParameters.isEmpty()) return Collections.emptyList();
    Collection<Collection<PredictionParameter<?>>> predictionParametersForRequest = new ArrayList<>();
    for(PredictionParameter<?> predictionParameterForAdding: predictionParameters) {
      predictionParametersForRequest = joinPredictionParameterToCollections(predictionParametersForRequest,
        predictionParameterForAdding);
    }
    return predictionParametersForRequest;
  }

  private Collection<Collection<PredictionParameter<?>>> joinPredictionParameterToCollections(
    Collection<Collection<PredictionParameter<?>>> baseCollection, PredictionParameter<?> predictionParameter) {
    Collection<Collection<PredictionParameter<?>>> returnCollection = new ArrayList<>();
    Collection<PredictionParameter<?>> predictionParameterForAddingCollection = new ArrayList<>();
    while(predictionParameter.hasNext()) {
      PredictionParameter<?> predictionParameterForClone = predictionParameter.nextClone();
      predictionParameterForAddingCollection.add(predictionParameterForClone);
    }
    if(baseCollection.isEmpty()) {
      for(PredictionParameter<?> predictionParameterForAdding: predictionParameterForAddingCollection) {
        Collection<PredictionParameter<?>> collectionForAdding = new ArrayList<>();
        collectionForAdding.add(predictionParameterForAdding);
        returnCollection.add(collectionForAdding);
      }
    } else {
      for(PredictionParameter<?> predictionParameterForAdding: predictionParameterForAddingCollection) {
        for(Collection<PredictionParameter<?>> baseCollectionForAdding: baseCollection) {
          Collection<PredictionParameter<?>> collectionForAdding = new ArrayList<>(baseCollectionForAdding);
          collectionForAdding.add(predictionParameterForAdding);
          returnCollection.add(collectionForAdding);
        }
      }
    }
    return returnCollection;
  }

}
