import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void times() {
    }

    @org.junit.jupiter.api.Test
    void division() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("the dummy test")
    void dummyTest() {
        assertEquals(20, 20);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("the failing test")
    void failingTest() {
        assertEquals(20, 22);
    }


}