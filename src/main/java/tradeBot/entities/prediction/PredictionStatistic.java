package tradeBot.entities.prediction;

import java.util.Collection;
import java.util.List;

import lombok.Data;

@Data
public class PredictionStatistic {

  private final Collection<PredictionParameter<?>> predictionParameters;

  private final PredictionData predictionData;

  private final double resultScore;

}
