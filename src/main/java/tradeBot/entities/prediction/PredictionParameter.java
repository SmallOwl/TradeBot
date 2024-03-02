package tradeBot.entities.prediction;

import java.util.Iterator;

public interface PredictionParameter<R> extends Iterator<R> {

  R getParameter();

  Class<R> getParameterClass();

}