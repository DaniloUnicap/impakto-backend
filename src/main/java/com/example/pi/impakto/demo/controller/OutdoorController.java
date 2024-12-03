package com.example.pi.impakto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pi.impakto.demo.controller.openAPI.OutdoorControllerOpenAPI;
import com.example.pi.impakto.demo.dto.outdoor.GetOutdoorDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorInsertDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorListDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorUpdateDTO;
import com.example.pi.impakto.demo.exception.OutdoorNotFoundException;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.service.OutdoorService;

@RestController
@RequestMapping("/api/outdoor")
public class OutdoorController implements OutdoorControllerOpenAPI{

    @Autowired
    public OutdoorService outdoorService;

    @PostMapping("/add")
    public Outdoor insertOutdoor(@RequestBody OutdoorInsertDTO outdoorDTO){
        return outdoorService.insertOutdoor(outdoorDTO);
    }

    @GetMapping("/all")
    public List<OutdoorListDTO> getOutdoors(){
        return outdoorService.listOutdoors();
    }
    
    @GetMapping("/{id}")
    public GetOutdoorDTO getOutdoorById(@PathVariable ("id") Long id){
            return outdoorService.getById(id);  
    }

    @PutMapping("/{id}")
    public void updateOutdoor(@PathVariable ("id") Long id, @RequestBody OutdoorUpdateDTO outdoor){
        try{
            outdoorService.updateById(id, outdoor);
        } catch(OutdoorNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public void deleteOutdoorById(@PathVariable Long id) throws OutdoorNotFoundException {
        outdoorService.deleteById(id);
    }
}
