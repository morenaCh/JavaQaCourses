package qaqources.first;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    /*@Test
    public void test1(){
        Point point=new Point(2,5,5,9);
        assert point.distance()==5;
     }*/

    @Test
    public void test1(){
        Point point=new Point(2,5,5,9);
        Assert.assertEquals(point.distance(),5.0);

    }

    @Test
    public void test2(){
        Point point=new Point(2,5,5,9);
        Assert.assertEquals(point.distance(),4.0);

    }

    @Test
    public void test3(){
        Point point=new Point(3,7,6,11);
        Assert.assertEquals(point.distance(),6.4031242374328485);

    }

    @Test
    public void test4(){
        Point point=new Point(3,7,6,11);
        Assert.assertEquals(point.distance(),6.40312);

    }


}
