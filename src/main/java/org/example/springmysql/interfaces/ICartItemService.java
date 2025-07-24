package org.example.springmysql.interfaces;

import org.example.springmysql.model.entity.CartItem;

import java.util.List;
import java.util.UUID;

public interface ICartItemService {

    List<CartItem> getAllCartItems();

    CartItem addCartItem(CartItem cartItem);

    void removeCartItem(UUID cartItemId) throws Exception;

    void clearCart();
}
