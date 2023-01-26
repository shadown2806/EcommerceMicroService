package org.example.mappers;

import org.example.dto.ManagerDTO;
import org.example.entities.Manager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManagerMapper {

    private final ModelMapper managerMapper;

    public ManagerMapper(ModelMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    public List<ManagerDTO> ListConvertToDto(List<Manager> listManager) {

        List<ManagerDTO> listManagerDTO = new ArrayList<>();

        for (Manager manager : listManager) {
            listManagerDTO.add(managerMapper.map(manager, ManagerDTO.class));
        }

        return listManagerDTO;
    }

    public ManagerDTO convertToDto(Manager manager) {
        return managerMapper.map(manager, ManagerDTO.class);
    }

    public Manager convertToEntity(ManagerDTO managerDTO) {
        return managerMapper.map(managerDTO, Manager.class);
    }

}
