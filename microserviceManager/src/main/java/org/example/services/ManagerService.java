package org.example.services;

import org.apache.tomcat.util.bcel.Const;
import org.example.constants.Constants;
import org.example.dto.CustomizeAreaDTO;
import org.example.dto.ManagerDTO;
import org.example.dto.ProductBaseDTO;
import org.example.entities.Manager;

import org.example.exceptions.manager.ManagerNotFoundException;
import org.example.mappers.ManagerMapper;
import org.example.proxys.CustomizeAreaProxy;
import org.example.proxys.ProductBaseProxy;
import org.example.repositories.ManagerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final CustomizeAreaProxy customizeAreaProxy;
    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;
    private final ProductBaseProxy productBaseProxy;

    public ManagerService(ProductBaseProxy productBaseProxy, ManagerRepository managerRepository, CustomizeAreaProxy customizeAreaProxy,ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.customizeAreaProxy = customizeAreaProxy;
        this.managerMapper = managerMapper;
        this.productBaseProxy = productBaseProxy;
    }

    public Long addManager(ManagerDTO managerDTO) {
        Manager manager = managerMapper.convertToEntity(managerDTO);
        managerRepository.save(manager);
        return(manager.getId());
    }

    public void deleteManager(Long id) {

        if (!managerRepository.existsById(id)) {
            throw new ManagerNotFoundException(Constants.MANAGER_NOT_FOUND + id);
        }
        managerRepository.deleteById(id);
    }

    public void addCustomizeAreaByManager(CustomizeAreaDTO customizeAreaDTO, String managerId){


        ManagerDTO consultCusomizeArea =  getManager(Long.valueOf(managerId));

        if(consultCusomizeArea != null){
            //enviar datos de este controller al otro.
            customizeAreaProxy.createCustomizeArea(customizeAreaDTO);
        }
    }

    public void addProductBaseByManager(ProductBaseDTO productBaseDTO, String managerId){

        productBaseDTO.setManagerId(Long.parseLong(managerId));

        ManagerDTO consultManager =  getManager(Long.valueOf(managerId));
         CustomizeAreaDTO consultCustomizeArea = customizeAreaProxy.getCustomizeArea(productBaseDTO.getCustomizeAreaId());

        if(consultManager != null && consultCustomizeArea != null){
            //enviar datos de este controller al otro.
            productBaseProxy.createProductBase(productBaseDTO);
        }
    }

    public ManagerDTO getManager(Long id) {

        Optional<Manager> manager = managerRepository.findById(id);

        if (manager.isEmpty()) {
            throw new ManagerNotFoundException(Constants.MANAGER_NOT_FOUND + id);
        }

        return managerMapper.convertToDto(manager.get());
    }

    public List<ManagerDTO> getAllManager() {
        List<Manager> managers = managerRepository.findAll();
        return managerMapper.ListConvertToDto(managers);
    }

}
