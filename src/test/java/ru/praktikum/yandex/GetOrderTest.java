package ru.praktikum.yandex;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetOrderTest extends BaseTest {

    @Test
    public void test_upperButton(){
        GetOrder order = new GetOrder(driverChrome);
        boolean actual = order.isOrderGotten(1);
        assertEquals(true, actual);
    }

    @Test
    public void test_bottomButton(){
        GetOrder order = new GetOrder(driverChrome);
        boolean actual = order.isOrderGotten(2);
        assertEquals(true, actual);
    }

}