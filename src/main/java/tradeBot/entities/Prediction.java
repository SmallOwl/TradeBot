package tradeBot.entities;

import lombok.Data;
import tradeBot.engines.interfaces.PredictionEngine;

@Data
public class Prediction {

    private final Active active;

    private final Class<PredictionEngine> predictionEngine;

    private final Long timestamp;

}
