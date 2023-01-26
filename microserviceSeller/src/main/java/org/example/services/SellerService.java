package org.example.services;

import org.example.constants.Constants;
import org.example.dto.CustomizedProductDTO;
import org.example.dto.SellerDTO;
import org.example.dto.ShopDTO;
import org.example.entities.Seller;
import org.example.exceptions.seller.SellerNotFoundException;
import org.example.mappers.SellerMapper;
import org.example.proxys.SellerProxy;
import org.example.repositories.SellerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.proxys.ShopProxy;

import java.util.List;
import java.util.Optional;


@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;
    private final ShopService shopService;

    public SellerService(SellerRepository sellerRepository, SellerMapper sellerMapper,ShopService shopService) {
        this.sellerRepository = sellerRepository;
        this.sellerMapper = sellerMapper;
        this.shopService = shopService;
    }


    public Long addSeller(SellerDTO sellerDTO) {
        Seller seller = sellerMapper.convertToEntity(sellerDTO);
        sellerRepository.save(seller);
        return (seller.getId());
    }

    public void deleteSeller(Long id) {

        if (!sellerRepository.existsById(id)) {
            throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND + id);
        }

        sellerRepository.deleteById(id);
    }

    public void addCustomizedProductBySeller(CustomizedProductDTO customizedProductDTO, String sellerId, String shopId){

        SellerDTO consultSeller = getSeller(Long.valueOf(sellerId));
        if(consultSeller != null) {

            shopService.addCustomizedProductByShop(customizedProductDTO, shopId);
        }
    }

    public void addShopBySeller(ShopDTO shopDTO, String sellerId){

        SellerDTO consultSeller = getSeller(Long.valueOf(sellerId));


        shopDTO.setSellerId(Long.parseLong(sellerId));

        if(consultSeller != null){

            shopService.addShop(shopDTO);
        }
    }

    public SellerDTO getSeller(Long id) {

        Optional<Seller> seller = sellerRepository.findById(id);

        if (seller.isEmpty()) {
            throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND + id);
        }

        return sellerMapper.convertToDto(seller.get());
    }


    public List<SellerDTO> getAllSeller() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellerMapper.ListConvertToDto(sellers);
    }
}
