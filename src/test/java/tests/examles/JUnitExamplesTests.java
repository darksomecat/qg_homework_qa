package tests.examles;

import org.junit.jupiter.api.*;

public class JUnitExamplesTests {

    @BeforeAll
     static void startup() {
        System.out.println("test startup");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("test ended");
    }

    @BeforeEach
    void startBrouser() {
        System.out.println("-browser has started");
    }

    @BeforeEach
    void openGuru() {
        System.out.println("-open https://school.qa.guru/");
    }

    @AfterEach
    void stopBrouser() {
        System.out.println("browser has stopped");
    }

    @Test
    void firstTest(){
        System.out.println("-firstTest");
    }
    @Test
    void secondTest(){
         System.out.println("-secondTest");
    }
}
