package tradeBot.services.implementations;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tradeBot.engines.interfaces.PredictionEngine;
import tradeBot.entities.Active;
import tradeBot.entities.ActiveStatistic;
import tradeBot.entities.Prediction;
import tradeBot.entities.PredictionParameters;
import tradeBot.services.interfaces.ActiveService;
import tradeBot.services.interfaces.PredictionService;
import tradeBot.services.interfaces.StatisticService;
import tradeBot.utils.interfaces.FileUtil;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final PredictionService predictionService;

    private final ActiveService activeService;

    private final FileUtil fileUtil;

    private final String predictionDataPath = "";

    private final Map<Active,Map<PredictionEngine,Map<Long, Long>>> predictionDiffByTimestamp;

    //TODO
    @Override
    public void refreshPredictionEngine() {
        if(predictionDiffByTimestamp == null)
            fileUtil.readListValueFromFile(Paths.get(predictionDataPath), Prediction.class,
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE_NEW);
    }

    @PostConstruct

    private void initPredictionStatistic() {
        log.info("Start initialization prediction statistic");
        log.info("End initialization prediction statistic");
    }

    private double getPredictionCoefficient(Prediction prediction, ActiveStatistic activeStatistic) {
        return 0.0;
    }

}
