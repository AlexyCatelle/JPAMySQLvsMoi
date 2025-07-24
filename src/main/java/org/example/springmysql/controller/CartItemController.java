package org.example.springmysql.controller;

import org.example.springmysql.interfaces.ICartItemService;
import org.example.springmysql.model.entity.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
    private final ICartItemService cartItemService;

    public CartItemController(ICartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItems() {
        return new ResponseEntity<>(cartItemService.getAllCartItems(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CartItem> addCartItem(@Validated @RequestBody CartItem cartItem) {
     return new ResponseEntity<>(cartItemService.addCartItem(cartItem), HttpStatus.OK);
    }
}
