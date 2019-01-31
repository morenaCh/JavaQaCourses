package qaqources.first;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void test1() {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(2, 5);
        Assert.assertEquals(p1.distance(p2), 1.0);

    }

    @Test
    public void test2() {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(2, 10);
        Assert.assertEquals(p1.distance(p2), 5);

    }

    @Test
    public void test3() {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(2, 10);
        Assert.assertEquals(p1.distance(p2), 5.0);

    }

    @Test
    public void test4() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 10);
        Assert.assertEquals(p1.distance(p2), 8.0);
    }
}
