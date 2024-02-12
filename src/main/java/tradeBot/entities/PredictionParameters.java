package tradeBot.entities;

import lombok.Data;
import tradeBot.engines.interfaces.PredictionEngine;

@Data
public class PredictionParameters {

    private final Class<? extends PredictionEngine> predictionEngine;

    private final Active active;

    private final Long currentTimestamp;

    private final Long preferStartTimestamp;

    private final Long preferEndTimestamp;

}
