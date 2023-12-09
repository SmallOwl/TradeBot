package service.implementations;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import entity.Action;
import entity.ActionStatus;
import entity.Active;
import entity.Prediction;
import lombok.extern.slf4j.Slf4j;
import service.interfaces.ActionService;
import service.interfaces.ActiveService;
import service.interfaces.PredictionService;
import service.interfaces.StatisticService;
import service.interfaces.StrategyService;
import service.interfaces.TradeService;

@Slf4j
@Service
public class TradeServiceImpl implements TradeService {

  @Autowired
  private ActiveService activeService;

  @Autowired
  private PredictionService predictionService;

  @Autowired
  private StrategyService strategyService;

  @Autowired
  private ActionService actionService;

  @Autowired
  private StatisticService statisticService;

  @Scheduled(fixedRate = 1000)
  public void trade() {
    List<Active> activeList = activeService.getEnabledActives();
    Map<Active, Prediction> activePredictionMap = activeList
      .stream()
      .map(active -> predictionService.getPrediction(active))
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    List<Action> actionList = strategyService.getActions(activePredictionMap);
    List<ActionStatus> actionStatusList = actionService.useActions(actionList);
    if(!statisticService.saveActionStatus(actionStatusList)) {
      log.error("Exception in List<ActionStatus> saving {}", actionStatusList);
      throw new RuntimeException();
    }
  }

}
