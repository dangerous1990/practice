package org.learn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dangerous on 2017/3/1.
 */
public class BinarySearchTest {
    private BinarySearch bs ;
    @Before
    public void before(){
        bs = new BinarySearch();
    }

    @Test
    public void rankTest(){
        int[] array = {1,2,3,6,7,12,13,16,17,18,20};
        int result = bs.rank(array,1,0,array.length-1,0);
        Assert.assertEquals(result,0);
        result = bs.normal(array,1);
        Assert.assertEquals(result,0);
    }
}
