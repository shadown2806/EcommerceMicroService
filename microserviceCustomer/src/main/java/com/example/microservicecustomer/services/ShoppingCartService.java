
/*
package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.ShoppingCart;
import com.credicoop.utn.exceptions.shop.ShoppingCartNotFoundException;
import com.credicoop.utn.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    public void deleteShoppingCart(Long id) {

        if (!shoppingCartRepository.existsById(id)) {

            throw new ShoppingCartNotFoundException(Constants.SHOPPINGCART_NOT_FOUND + id);
        }
        shoppingCartRepository.deleteById(id);
    }

    public ShoppingCart getShoppingCart(Long id) {

        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(id);
        if (!shoppingCart.isPresent()) {

            throw new ShoppingCartNotFoundException(Constants.SHOPPINGCART_NOT_FOUND + id);
        }
        return shoppingCart.get();
    }

    public List<ShoppingCart> getAllShoppingCart() {
        return shoppingCartRepository.findAll();
    }

}
*/