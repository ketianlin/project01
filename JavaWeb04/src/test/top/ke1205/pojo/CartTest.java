package top.ke1205.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(1, new CartItem(1, "母猪产后护理I", 1, new BigDecimal(52),new BigDecimal(52)));
        cart.addItem(1, new CartItem(2, "母猪产后护理II", 1, new BigDecimal(52),new BigDecimal(52)));
        cart.addItem(1, new CartItem(2, "母猪产后护理II", 1, new BigDecimal(52),new BigDecimal(52)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void updateItem() {
    }
}