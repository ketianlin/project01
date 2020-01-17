package top.ke1205.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart [totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice()
                + ", items=" + items + "]";
    }

    public Integer getTotalCount(){
        Integer totalCount = 0;
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem item : items.values()) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    /**
     * 加入购物车
     */
    public void addItem(Integer id, CartItem cartItem){
        CartItem item = items.get(id);
        if (item == null){
            items.put(id, cartItem);
        }else{
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     */
    public void updateItem(Integer id, Integer count){
        CartItem cartItem = items.get(id);
        if (cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }
}
