import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntArrayListTest {

    private IntList<Car> intList;

    @Before
    public void setUP() throws Exception {
        intList = new IntArrayList<>();
        for (int i = 0; i < 100; i++) {
            intList.add(i, new Car("BMW", i));

        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100,intList.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased() {
        assertTrue(intList.remove(5));
        assertEquals(99,intList.size());
    }

    @Test
    public void whenElementRemoveThenSizeMustBeDecreased() {
        Car car = new Car("Toyota",12);
        intList.add(car);
        assertEquals(101,intList.size());
        assertTrue(intList.removeByElement(car));
        assertEquals(100,intList.size());

    }

    @Test
    public void whenNonExistenElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota",15);
        assertFalse(intList.removeByElement(car));
        assertEquals(100,intList.size());
    }

    @Test
    public void whenListCleanedThenSizeMustBe0() {
        intList.clear();
        assertEquals(0,intList.size());
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = intList.get(0);
        assertEquals("BMW",car.getBrand());
    }
    @Test
    public void insertIntoMiddle () {
        Car car = new Car("BMW", 1);
        intList.add(50,car);
        Car carFromList = intList.get(50);
        Assert.assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoFirstPosition () {
        Car car = new Car("BMW", 1);
        intList.add(0, car);
        Car carFromList = intList.get(0);
        Assert.assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoLastPosition () {
        Car car = new Car("BMW", 1);
        intList.add(100, car);
        Car carFromList = intList.get(100);
        Assert.assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void whenCleanedListMethodIsEmptyMustReturnTrue() {
        intList.clear();
        assertEquals(0,intList.size());
        assertTrue(intList.isEmpty());
    }

    @Test
    public void whenChangeElementOnIndexReturnDstElement() {
        Car car = new Car ("Mercedes", 300);
        Car carFromList = intList.get(0);
        Assert.assertEquals("BMW", carFromList.getBrand());
        intList.set(0,car);
        Car carFromListNew = intList.get(0);
        Assert.assertEquals("Mercedes",carFromListNew.getBrand());

    }
    
}