package com.example.microservicecustomer.mappers;

import com.example.microservicecustomer.dto.CustomerDTO;
import com.example.microservicecustomer.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    private final ModelMapper customerMapper;

    public CustomerMapper() {
        this.customerMapper = new ModelMapper();
    }


    public List<CustomerDTO> ListConvertToDto(List<Customer> customerList) {

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customerList) {
            customerDTOList.add(customerMapper.map(customer, CustomerDTO.class));
        }

        return customerDTOList;
    }

    public CustomerDTO convertToDto(Customer customer) {
        return customerMapper.map(customer, CustomerDTO.class);
    }

    public Customer convertToEntity(CustomerDTO customerDTO) {
        return customerMapper.map(customerDTO, Customer.class);
    }

}
