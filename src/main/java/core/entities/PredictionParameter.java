package core.entities;

import java.util.Iterator;

public interface PredictionParameter<R> extends Iterator<R> {

  R getParameter();

  Class<R> getParameterClass();

}