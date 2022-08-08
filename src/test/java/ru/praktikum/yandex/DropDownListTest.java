package ru.praktikum.yandex;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DropDownListTest extends BaseTest {

    DropDownList list;
    private String scooterCostexpected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String someScootersExpected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String timeRentExpected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String todayScooterExpected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String prolongOrBackEarlyExpected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private String chargerWithScooterExpected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String cancellingOrderExpected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private String mkadRegionExpected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";



    @Test
    public void test_cost() {
        list = new DropDownList(driverChrome);
        assertEquals(scooterCostexpected, list.getScooterCostAnswer());
    }

    @Test
    public void test_someScooters(){
        list = new DropDownList(driverChrome);
        assertEquals(someScootersExpected, list.getSomeScootersAnswer());
    }

    @Test
    public void test_rentTime(){
        list = new DropDownList(driverChrome);
        assertEquals(timeRentExpected, list.getTimeRentAnswer());
    }

    @Test
    public void test_scooterToday(){
        list = new DropDownList(driverChrome);
        assertEquals(todayScooterExpected, list.getTodayScooterAnswer());
    }

    @Test
    public void test_prolongScooter(){
        list = new DropDownList(driverChrome);
        assertEquals(prolongOrBackEarlyExpected, list.getProlongOrBackEarlyAnswer());
    }

    @Test
    public void test_charger(){
        list = new DropDownList(driverChrome);
        assertEquals(chargerWithScooterExpected, list.getChargerWithScooterAnswer());
    }

    @Test
    public void test_orderCancel(){
        list = new DropDownList(driverChrome);
        assertEquals(cancellingOrderExpected, list.getCancellingOrderAnswer());
    }

    @Test
    public void test_mkadRegion(){
        list = new DropDownList(driverChrome);
        assertEquals(mkadRegionExpected, list.getMkadRegionAnswer());
    }

}