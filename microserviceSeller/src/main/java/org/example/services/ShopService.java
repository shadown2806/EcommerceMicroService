package org.example.services;

import org.example.constants.Constants;
import org.example.dto.ShopDTO;
import org.example.entities.Shop;
import org.example.exceptions.shop.ShopNotFoundException;
import org.example.mappers.ShopMapper;
import org.example.proxys.CustomizedProductProxy;
import org.example.proxys.ShopProxy;
import org.example.repositories.ShopRepository;
import org.springframework.stereotype.Service;
import org.example.dto.CustomizedProductDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final CustomizedProductProxy customizedProductProxy;
    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;
    private final ShopProxy shopProxy;

    public ShopService (ShopProxy shopProxy, ShopRepository shopRepository, CustomizedProductProxy customizedProductProxy,ShopMapper shopMapper){
        this.shopRepository = shopRepository;
        this.customizedProductProxy = customizedProductProxy;
        this.shopMapper = shopMapper;
        this.shopProxy = shopProxy;
    }

    public Long addShop(ShopDTO shopDTO) {
        Shop shop = shopMapper.convertToEntity(shopDTO);
        shopRepository.save(shop);
        return(shop.getId());
    }

    public void addCustomizedProductByShop(CustomizedProductDTO customizedProductDTO, String shopId){


        ShopDTO consultShop = shopProxy.getShop(Long.valueOf(shopId));

        if(consultShop != null){
            customizedProductProxy.createCustomizedProduct(customizedProductDTO);
        }

    }

    public void deleteShop(Long id) {

        if (!shopRepository.existsById(id)) {
            throw new ShopNotFoundException(Constants.SHOP_NOT_FOUND + id);
        }
        shopRepository.deleteById(id);
    }

    public ShopDTO getShop(Long id) {

        Optional<Shop> shop = shopRepository.findById(id);

        if (shop.isEmpty()) {

            throw new ShopNotFoundException(Constants.SHOP_NOT_FOUND + id);
        }

        return shopMapper.convertToDto(shop.get());
    }

    public List<ShopDTO> getAllShop() {
        List<Shop> shops = shopRepository.findAll();
        return shopMapper.ListConvertToDto(shops);
    }
}
