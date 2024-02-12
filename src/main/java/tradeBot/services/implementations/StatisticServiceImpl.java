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
import java.util.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    //Services
    private final PredictionService predictionService;

    private final ActiveService activeService;

    private final FileUtil fileUtil;

    //Params
    private final String predictionDataPath = "";

    private final Long predictionMinRange;

    private final Long predictionMaxRange;

    private final Long predictionStep;

    //Used objects
    private List<Prediction> predictionsList;

    //TODO
    @Override
    public void refreshPredictionEngine() {
    }

    @PostConstruct
    private void initPredictionStatistic() {
        log.info("Start initialization prediction statistic");
        List<Prediction> predictionsList = fileUtil.readListValueFromFile(Paths.get(predictionDataPath), Prediction.class,
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE_NEW);
        List<Prediction> missingPredictionsList = getMissingPredictionsList(predictionsList);
        predictionsList.addAll(missingPredictionsList);
        this.predictionsList = predictionsList;
        log.info("End initialization prediction statistic");
    }

    private List<Prediction> getMissingPredictionsList(List<Prediction> existingPredictionsList) {
        List<Prediction> resultPredictions = new ArrayList<>();
        Collection<Active> actives = activeService.getAllActives();
        Collection<Class<? extends PredictionEngine>> predictionEngines = predictionService.getAllPredictionEngines();
        for(Active active : actives) {
            for(Class<? extends PredictionEngine> predictionEngine : predictionEngines) {
                Optional<Long> start = existingPredictionsList
                        .stream()
                        .filter(prediction -> prediction.getActive() == active)
                        .filter(prediction -> prediction.getPredictionEngine() == predictionEngine)
                        .min(Comparator.comparing(Prediction::getTimestamp))

                        .map(Prediction::getTimestamp);
                if(start.isEmpty()) {
                    log.warn("No data for Active {} PredictionEngine {}", active, predictionEngine);

                }
            }
        }
    }

    private double getPredictionCoefficient(Prediction prediction, ActiveStatistic activeStatistic) {
        return 0.0;
    }

}
