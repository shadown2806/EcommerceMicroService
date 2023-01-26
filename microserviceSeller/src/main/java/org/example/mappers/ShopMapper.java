package org.example.mappers;

import org.example.dto.ShopDTO;
import org.example.entities.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShopMapper {

    private final ModelMapper shopMapper;

    public ShopMapper(ModelMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public List<ShopDTO> ListConvertToDto(List<Shop> listShop) {

        List<ShopDTO> listShopDTO = new ArrayList<>();

        for (Shop shop : listShop) {
            listShopDTO.add(shopMapper.map(shop, ShopDTO.class));
        }

        return listShopDTO;
    }

    public ShopDTO convertToDto(Shop shop) {
        return shopMapper.map(shop, ShopDTO.class);
    }

    public Shop convertToEntity(ShopDTO shopDTO) {
        return shopMapper.map(shopDTO, Shop.class);
    }

}
