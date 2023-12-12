package services.implementations;

import entities.Active;
import entities.ActiveStatus;
import entities.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import services.interfaces.ActiveService;
import utils.interfaces.FileUtil;
import utils.interfaces.PlatformUtil;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.BiFunction;

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
        List<Active> fileActives = fileUtil.readValueFromFile(activesFilePath, Active.class, StandardOpenOption.READ);
        List<Active> platformActives = Arrays.stream(Platform.values())
                .flatMap(platform -> platformUtil.getActives(platform).stream())
                .toList();
        useActives = mergeActiveCollections(fileActives, platformActives, mergeActiveBiFunction());
        fileUtil.writeValueToFile(activesFilePath, useActives.stream(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
    }

    @Override
    public List<Active> getEnabledActives() {
        return useActives
                .stream()
                .filter(active -> active.getActiveStatus().equals(ActiveStatus.TRADE) || active.getActiveStatus().equals(ActiveStatus.TEST))
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