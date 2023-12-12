package services.implementations;

import entities.Active;
import entities.ActiveStatus;
import entities.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import services.interfaces.ActiveService;
import utils.interfaces.FileUtil;
import utils.interfaces.PlatformUtil;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.BiFunction;

@Slf4j
@Service
public class ActiveServiceImpl implements ActiveService {

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private PlatformUtil platformUtil;

    @Autowired
    private Path activesFilePath;

    //TODO Добавить связку с пропертей
    @Autowired
    private ActiveStatus defaultActiveStatus;

    private List<Active> useActives;

    @Async
    @Scheduled(fixedRate = 3600000)
    private void refreshActives() {
        List<Active> fileActives = fileUtil.readListValueFromFile(activesFilePath, Active.class, StandardOpenOption.READ);
        List<Active> platformActives = Arrays.stream(Platform.values())
                .flatMap(platform -> platformUtil.getActives(platform).stream())
                .toList();
        useActives = mergeActiveCollections(fileActives, platformActives, mergeActiveBiFunction());
        if(!fileUtil.writeValueToFile(activesFilePath, useActives.stream(), StandardOpenOption.CREATE,
          StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {
            log.error("Exception in List<Active> saving {}", useActives);
            throw new RuntimeException();
        }
    }

    @Override
    public List<Active> getActives(List<ActiveStatus> activeStatusList) {
        return useActives
                .stream()
                .filter(active -> activeStatusList.contains(active.getActiveStatus()))
                .toList();
    }

    //TODO Доделать в конце
    private BiFunction<Active, Active, Active> mergeActiveBiFunction() {
        return (first, second) -> first;
    }

    private List<Active> mergeActiveCollections(Collection<Active> first, Collection<Active> second, BiFunction<Active, Active, Active> mergeRule) {
        List<Active> result = new ArrayList<>();
        first.forEach(firstElement -> {
            Optional<Active> secondElementOptional = second
                    .stream()
                    .filter(secondElement -> activeEquals(firstElement, secondElement))
                    .findFirst();
            if (secondElementOptional.isEmpty()) result.add(firstElement);
            else result.add(mergeRule.apply(firstElement, secondElementOptional.get()));
        });
        return result;
    }

    //TODO Доделать в конце
    private boolean activeEquals(Active first, Active second) {
        return true;
    }

}