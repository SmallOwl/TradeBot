package tradeBot.entities.prediction;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import tradeBot.engines.PredictionEngine;

@Data
@RequiredArgsConstructor
public class PredictionEngineClassPredictionParameter implements PredictionParameter<Class<PredictionEngine>> {

  @Autowired
  private final List<Class<PredictionEngine>> predictionEngineClasses;

  private Class<PredictionEngine> predictionEngineClass;

  private final Iterator<Class<PredictionEngine>> predictionEngineClassesIterator = predictionEngineClasses.iterator();

  @Override
  public Class<PredictionEngine> getParameter() {
    return predictionEngineClass;
  }

  @Override
  public Class<Class<PredictionEngine>> getParameterClass() {
    return null;
  }

  @Override
  public boolean hasNext() {
    return predictionEngineClassesIterator.hasNext();
  }

  @Override
  public Class<PredictionEngine> next() {
    return predictionEngineClassesIterator.next();
  }

}
