package tradeBot.entities.prediction;

import java.util.List;

import lombok.Data;

@Data
public class PredictionStatistic {

  private final List<PredictionParameter<?>> predictionParameters;

  private final double resultScore;

}