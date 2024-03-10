package tradeBot.entities.prediction;

import java.util.Iterator;
import java.util.List;

import lombok.Data;
import tradeBot.engines.PredictionEngine;

@Data
public class PredictionEngineClassPredictionParameter implements PredictionParameter<Class<PredictionEngine>> {

  private Class<PredictionEngine> predictionEngineClass;

  private List<Class<PredictionEngine>> predictionEngineClasses;

  private Iterator<Class<PredictionEngine>> predictionEngineClassesIterator;

  @Override
  public void setParameter(Class<PredictionEngine> parameter) {
    this.predictionEngineClass = parameter;
  }

  @Override
  public Class<PredictionEngine> getParameter() {
    return predictionEngineClass;
  }

  @Override
  public Class<Class<PredictionEngine>> getParameterClass() {
    return null;
  }

  @Override
  public PredictionParameter<Class<PredictionEngine>> nextClone() {
    PredictionEngineClassPredictionParameter predictionEngineClassPredictionParameter =
      new PredictionEngineClassPredictionParameter();
    predictionEngineClassPredictionParameter.setPredictionEngineClass(this.predictionEngineClass);
    predictionEngineClassPredictionParameter.setPredictionEngineClasses(this.predictionEngineClasses);
    predictionEngineClassPredictionParameter.setPredictionEngineClassesIterator(this.predictionEngineClassesIterator);
    return predictionEngineClassPredictionParameter;
  }

  @Override
  public boolean hasNext() {
    return predictionEngineClassesIterator.hasNext();
  }

  @Override
  public Class<PredictionEngine> next() {
    this.predictionEngineClass = predictionEngineClassesIterator.next();
    return predictionEngineClass;
  }

}
