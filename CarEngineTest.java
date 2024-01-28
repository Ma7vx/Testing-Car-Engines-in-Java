import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarEngineTest {
    private CarEngine engine;
    private static int count = 0;

    @AfterEach
    private void summary() {
        count += 1;
        System.out.println(count + " Tests ran.");
    }

    @AfterAll
    private static void tearDown() {
        System.out.println("All tests are done");
    }

    @BeforeEach
    private void setUp() {
        engine = new CarEngine();
    }

    @Test
    public void testSetCompanyName() {
        engine.setCompanyName(null); // test if company name is not passed
        assertEquals("Unknown", engine.getCompanyName());

        engine.setCompanyName("BMW"); // test if company name is passed
        assertEquals("BMW", engine.getCompanyName());
    }

    @Test
    public void testSetNumCylinders() {
        engine.setNumCylinders(10); // test if more than 8 cylinders
        assertEquals(8, engine.getNumCylinders());

        engine.setNumCylinders(4); // test if car has 6 cylinders
        assertEquals(4, engine.getNumCylinders());
    }

    @Test
    public void testSetBoreSize() {
        engine.setBoreSize(140); // test if greater than 100
        assertEquals(100, engine.getBoreSize());

        engine.setBoreSize(-1);
        assertEquals(0, engine.getBoreSize());
    }

    @Test
    public void testSetEngineDisplacement() {
        engine.setBoreSize(80);
        engine.setStroke(90);
        engine.setNumCylinders(1);
        engine.setEngineDisplacement();
        float expectedEngineDisplacement = (float) Math.round(452.16 * 100) / 100;

        assertEquals(expectedEngineDisplacement, engine.getEngineDisplacement());
    }
    @Test
    public void testSetHorsePower() {
        engine.setTorque(100);
        engine.setSpeed(500);
        engine.setHorsePower(false);
        assertEquals(9.520182609558105, engine.getHorsePower());
    }
}