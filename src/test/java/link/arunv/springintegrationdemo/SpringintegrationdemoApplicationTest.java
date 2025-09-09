package link.arunv.springintegrationdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class SpringintegrationdemoApplicationTest {
    @Test
    void mainMethodRuns() {
        assertDoesNotThrow(() -> SpringintegrationdemoApplication.main(new String[]{}));
    }
}
