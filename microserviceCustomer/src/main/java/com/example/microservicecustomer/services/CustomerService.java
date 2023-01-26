package com.example.microservicecustomer.services;

import com.example.microservicecustomer.constants.Constants;
import com.example.microservicecustomer.dto.CustomerDTO;
import com.example.microservicecustomer.dto.OrderDTO;
import com.example.microservicecustomer.entities.Customer;
import com.example.microservicecustomer.exceptions.customer.CustomerNotFoundException;
import com.example.microservicecustomer.mappers.CustomerMapper;
import com.example.microservicecustomer.proxys.ProxyCustomer;
import com.example.microservicecustomer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final OrderService orderService;
    private final ProxyCustomer proxyCustomer;

    public CustomerService(ProxyCustomer proxyCustomer, OrderService orderService, CustomerRepository customerRepository,CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.orderService = orderService;
        this.proxyCustomer = proxyCustomer;
    }

    public void addCustomizedProductOnOrderByRegisterCustomer(OrderDTO orderDTO, String idCustomer){


        System.out.println(idCustomer);

        CustomerDTO customerDTO = proxyCustomer.getCustomer(Long.valueOf(idCustomer));

        System.out.println(customerDTO);

        if(customerDTO != null){

            orderDTO.setCustomerDTO(customerDTO);
            orderService.addOrder(orderDTO);


        }

    }

    public Long addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.convertToEntity(customerDTO);
        customerRepository.save(customer);
        return(customer.getId());
    }

    public void deleteCustomer(Long id) {

        if (!customerRepository.existsById(id)) {

            throw new CustomerNotFoundException(Constants.CUSTOMER_NOT_FOUND + id);

        }

        customerRepository.deleteById(id);
    }

    public CustomerDTO getCustomer(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {

            throw new CustomerNotFoundException(Constants.CUSTOMER_NOT_FOUND + id);

        }

        System.out.println("ESOPOOOO" + customer);

        return customerMapper.convertToDto(customer.get());

    }

    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.ListConvertToDto(customers);
    }

}
