package standard_calc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class ControllerTest {

    @org.junit.jupiter.api.Test
    void onMouseClicked() {
    }

    @org.junit.jupiter.api.Test
    void numHandler() {
    }

    @org.junit.jupiter.api.Test
    void oprHandler() {
    }

    @org.junit.jupiter.api.Test
    void compute() {
    }

    @org.junit.jupiter.api.Test
    void expressionHandler() {
    }

    @org.junit.jupiter.api.Test
    void dotHandler() {
    }

    @org.junit.jupiter.api.Test
    void checkDecimal() {
    }

    @org.junit.jupiter.api.Test
    void changeSign() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void clearAll() {
    }

    @org.junit.jupiter.api.Test
    void displayResult() {
    }

    @org.junit.jupiter.api.Test
    void percentHandler() {
    }

    @org.junit.jupiter.api.Test
    void removeZero() {
    }

    @org.junit.jupiter.api.Test
    void checkTrue() {
        assumeTrue("DEV".contentEquals(System.getenv("ENV")), () ->
                "Aborting test: not on developer workstation");
    }

    @ParameterizedTest
    @ValueSource(strings = {"23", "34.5", "45.00", "67"})
    void testDecimal(String text) {
        Controller controller = new Controller();
        assertTrue(controller.checkDecimal(text));
    }
}