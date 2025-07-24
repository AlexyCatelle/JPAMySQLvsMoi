package org.example.springmysql.service;

import org.example.springmysql.interfaces.ICartItemService;
import org.example.springmysql.model.entity.CartItem;
import org.example.springmysql.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartItemService implements ICartItemService {
private final CartItemRepository cartItemRepository;

public CartItemService(CartItemRepository cartItemRepository) {
    this.cartItemRepository = cartItemRepository;
}


    @Override
    public List<CartItem> getAllCartItems() {
    List<CartItem> cartItems = cartItemRepository.findAll();

    return cartItems.stream().map(cartItem -> cartItem).collect(Collectors.toList());
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public void removeCartItem(UUID cartItemId) throws Exception {

    }

    @Override
    public void clearCart() {

    }
}
