package services;

import entities.actives.ActiveStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import services.implementations.ActiveServiceImpl;
import services.interfaces.ActionService;
import services.interfaces.ActiveService;
import services.interfaces.PlatformService;
import utils.interfaces.FileUtil;

import java.nio.file.Path;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ActiveServiceTest {

    private ActiveService activeService;

    @Mock
    private FileUtil fileUtil;

    @Mock
    private PlatformService platformService;

    @Mock
    private Path activesFilePath;

    @Mock
    private ActiveStatus defaultActiveStatus;

    @BeforeAll
    public void beforeAll() {
        this.activeService = new ActiveServiceImpl(fileUtil, platformService, any(), defaultActiveStatus);
    }

    @Test
    public void refreshActivesTradeByUserToTradeBySystemTest() {
        when(fileUtil.readListValueFromFile(any(),)).thenReturn()
    }

}
