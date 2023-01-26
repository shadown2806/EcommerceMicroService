package org.example.proxys;

import org.example.dto.CustomizeAreaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servicieCustomizeArea", url = "http://localhost:8765/SERVICIEPRODUCTS/api/v1/customizeArea/")
public interface CustomizeAreaProxy {

    @PostMapping(value = "add")
    public void createCustomizeArea(@RequestBody CustomizeAreaDTO customizeAreaDTO);

    @GetMapping(value = "{id}")
    public CustomizeAreaDTO getCustomizeArea(@PathVariable("id") Long id);


}
