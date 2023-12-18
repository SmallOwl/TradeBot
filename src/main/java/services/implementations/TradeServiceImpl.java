//package services.implementations;
//
//import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//import entities.actions.Action;
//import entities.actions.ActionStatus;
//import entities.actives.Active;
//import entities.actives.ActiveStatus;
//import entities.predictions.Prediction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import lombok.extern.slf4j.Slf4j;
//import services.interfaces.*;
//
//@Slf4j
//@Service
//public class TradeServiceImpl implements TradeService {
//
//  @Autowired
//  private ActiveService activeService;
//
//  @Autowired
//  private PredictionService predictionService;
//
//  @Autowired
//  private StrategyService strategyService;
//
//  @Autowired
//  private ActionService actionService;
//
//  @Autowired
//  private StatisticService statisticService;
//
//  @Autowired
//  private LogService logService;
//
//  //TODO Доделать тревогу, если action пошел по пизде
//  @Scheduled(fixedRate = 1000)
//  public void trade() {
//    List<Active> activeList = activeService.getActives(List.of(ActiveStatus.TRADE));
//    Map<Active, Prediction> activePredictionMap = activeList
//      .stream()
//      .collect(Collectors.toMap(Function.identity(), active -> predictionService.getPrediction(active)));
//    List<Action> actionList = strategyService.getActions(activePredictionMap);
//    List<ActionStatus> actionStatusList = actionService.useActions(actionList);
//    if(!logService.saveActionStatus(actionStatusList)) {
//      log.error("Exception in List<ActionStatus> saving {}", actionStatusList);
//      throw new RuntimeException();
//    }
//  }
//
//}
