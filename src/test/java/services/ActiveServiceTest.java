//package services;
//
//import engines.PlatformEngine;
//import entities.actives.Active;
//import entities.actives.ActiveStatus;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.mockito.Mock;
//import services.implementations.ActiveServiceImpl;
//import services.interfaces.ActionService;
//import services.interfaces.ActiveService;
//import services.interfaces.PlatformService;
//import utils.interfaces.FileUtil;
//
//import java.nio.file.Path;
//import java.util.List;
//
//import static entities.actives.ActiveStatus.TRADE_BY_SYSTEM;
//import static entities.actives.ActiveStatus.TRADE_BY_USER;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class ActiveServiceTest {
//
//    private ActiveService activeService;
//
//    @Mock
//    private FileUtil fileUtil;
//
//    @Mock
//    private PlatformService platformService;
//
//    @Mock
//    private PlatformEngine platformEngine;
//
//    @Mock
//    private Active active;
//
//    @Mock
//    private ActiveStatus defaultActiveStatus;
//
//    @BeforeAll
//    public void beforeAll() {
//        this.fileUtil = mock(FileUtil.class);
//        this.platformService = mock(PlatformService.class);
//        this.platformEngine = mock(PlatformEngine.class);
//        this.active = mock(Active.class);
//        this.defaultActiveStatus = mock(ActiveStatus.class);
//        this.activeService = new ActiveServiceImpl(fileUtil, platformService, any(), defaultActiveStatus);
//    }
//
//    @Test
//    public void getActivesEmptyTest() {
//        when(fileUtil.readListValueFromFile(any(), any(), any())).thenReturn(List.of());
//        when(platformService.getPlatformsEngines()).thenReturn(List.of(platformEngine));
//        when(platformEngine.getActives()).thenReturn(List.of());
//        List<Active> expectedActiveList = List.of();
//        List<Active> actualActiveList = activeService.getActives();
//        assertEquals(expectedActiveList, actualActiveList);
//    }
//
//    @Test
//    public void refreshActivesTradeByUserToTradeBySystemTest() {
//        when(fileUtil.readListValueFromFile(any(), ActiveStatus.class, any())).thenReturn(List.of(TRADE_BY_USER));
//        when(platformService.getPlatformsEngines()).thenReturn(List.of(platformEngine));
//        when(platformEngine.getActives()).thenReturn(List.of(active));
//        when(active.getActiveStatus()).thenReturn(TRADE_BY_SYSTEM);
//        List<ActiveStatus> expectedActiveStatusList = List.of(TRADE_BY_USER);
//        List<Active> actualActiveList = activeService.getActives();
//        assertNotNull(actualActiveList);
//        List<ActiveStatus> actualActiveStatusList = actualActiveList.stream().map(Active::getActiveStatus).toList();
//        assertEquals(expectedActiveStatusList, actualActiveStatusList);
//    }
//
//    @Test
//    public void refreshActivesTradeByUserToTestByUserTest() {
//        when(fileUtil.readListValueFromFile(any(), ActiveStatus.class, any())).thenReturn(List.of(TRADE_BY_USER));
//        when(platformService.getPlatformsEngines()).thenReturn(List.of(platformEngine));
//        when(platformEngine.getActives()).thenReturn(List.of(active));
//        when(active.getActiveStatus()).thenReturn(TRADE_BY_SYSTEM);
//        List<ActiveStatus> expectedActiveStatusList = List.of(TRADE_BY_USER);
//        List<Active> actualActiveList = activeService.getActives();
//        assertNotNull(actualActiveList);
//        List<ActiveStatus> actualActiveStatusList = actualActiveList.stream().map(Active::getActiveStatus).toList();
//        assertEquals(expectedActiveStatusList, actualActiveStatusList);
//    }
//
//}
