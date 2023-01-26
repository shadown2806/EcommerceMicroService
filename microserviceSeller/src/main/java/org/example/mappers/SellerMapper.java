package org.example.mappers;

import org.example.dto.SellerDTO;
import org.example.entities.Seller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper {

    private final ModelMapper sellerMapper;

    public SellerMapper() {
        this.sellerMapper = new ModelMapper();
    }


    public List<SellerDTO> ListConvertToDto(List<Seller> listSeller) {

        List<SellerDTO> listSellerDTO = new ArrayList<>();

        for (Seller seller : listSeller) {
            listSellerDTO.add(sellerMapper.map(seller, SellerDTO.class));
        }

        return listSellerDTO;
    }

    public SellerDTO convertToDto(Seller seller) {
        return sellerMapper.map(seller, SellerDTO.class);
    }

    public Seller convertToEntity(SellerDTO sellerDTO) {
        return sellerMapper.map(sellerDTO, Seller.class);
    }

}
