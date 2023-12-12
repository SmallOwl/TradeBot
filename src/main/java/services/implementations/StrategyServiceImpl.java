package services.implementations;

import engines.StrategyEngine;
import entities.Action;
import entities.Active;
import entities.Prediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import services.interfaces.StrategyService;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StrategyServiceImpl implements StrategyService {

    private StrategyEngine strategyEngine;

    //TODO Доделать refresh
    @Async
    @Scheduled(fixedRate = 3600000)
    private void refreshStrategyEngine() {
    }

    @Override
    public List<Action> getActions(Map<Active, Prediction> activePredictionMap) {
        return strategyEngine.getActions(activePredictionMap);
    }

}
