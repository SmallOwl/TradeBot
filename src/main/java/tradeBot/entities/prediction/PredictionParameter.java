package tradeBot.entities.prediction;

import java.util.Iterator;

public interface PredictionParameter<R> extends Iterator<R> {

  void setParameter(R parameter);

  R getParameter();

  Class<R> getParameterClass();

  PredictionParameter<R> nextClone();

}