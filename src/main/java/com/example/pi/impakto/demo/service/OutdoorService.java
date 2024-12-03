package com.example.pi.impakto.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.pi.impakto.demo.dto.outdoor.GetOutdoorDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorInsertDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorListDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorUpdateDTO;
import com.example.pi.impakto.demo.exception.OutdoorNotFoundException;
import com.example.pi.impakto.demo.model.Outdoor;
import com.example.pi.impakto.demo.repository.OutdoorRepository;
import com.example.pi.impakto.demo.service.converters.OutdoorDTOConverters;

@Service
public class OutdoorService {
    
    @Autowired
    private OutdoorRepository outdoorRepository;


    public Outdoor insertOutdoor(OutdoorInsertDTO outdoor){
        Outdoor outdoorModel = OutdoorDTOConverters.OutdoorInsertDTOModel(outdoor);
        return outdoorRepository.save(outdoorModel);
    }

    public void deleteById (Long id)throws OutdoorNotFoundException {
        Optional<Outdoor> opOutdoor = outdoorRepository.findById(id);
        
        if(opOutdoor.isEmpty()){
            throw new OutdoorNotFoundException("Outdoor não encontrado!");
        }

        Outdoor outdoor = opOutdoor.get();
        outdoorRepository.delete(outdoor);
    }


    public List<OutdoorListDTO> listOutdoors(){
        List<OutdoorListDTO> outdoorsDTO = new ArrayList<>();
        List<Outdoor> outdoorsModel = outdoorRepository.findAll();

        for(int i =0; i< outdoorsModel.size(); i++){
            Outdoor outdoorModel = outdoorsModel.get(i);
            OutdoorListDTO outdoorDTO = OutdoorDTOConverters.outdoorListDTOToModel(outdoorModel);
            outdoorsDTO.add(outdoorDTO);
        }
        return outdoorsDTO;
    }
    
    public GetOutdoorDTO getById(Long id) throws OutdoorNotFoundException{
        Optional<Outdoor> opOutdoor = outdoorRepository.findById(id);
        
        if(opOutdoor.isEmpty()){
            throw new OutdoorNotFoundException("Outdoor não encontrado!");
        }

        return OutdoorDTOConverters.getOutdoorDTOToModel(opOutdoor.get());
    }


    public void updateById(Long idOutdoor, OutdoorUpdateDTO novoOutdoor) throws OutdoorNotFoundException{
        Optional<Outdoor> opOutdoor = outdoorRepository.findById(idOutdoor);
        
        if(opOutdoor.isEmpty()){
            throw new OutdoorNotFoundException("Outdoor não encontrado!");
        }

        Outdoor outdoor = opOutdoor.get();
        OutdoorDTOConverters.OutdoorUpdateDTOToModel(novoOutdoor, outdoor);
        outdoor.setFiguraOutdoor(novoOutdoor.getFiguraOutdoor());
        outdoor.setFotoOutdoor(novoOutdoor.getFotoOutdoor());
        outdoor.setGeolocalizacao(novoOutdoor.getGeoLocalizacao());
        outdoor.setDescricao(novoOutdoor.getDescricao());
        outdoor.setStatusUso(novoOutdoor.isStatusUso());
        outdoor.setTipoOutdoor(novoOutdoor.getTipoOutdoor());

        outdoorRepository.save(outdoor);
    }




    public void updateFiguraOutdoor(String figuraOutdoor, OutdoorUpdateDTO novoOutdoor) throws OutdoorNotFoundException{

        Optional<Outdoor> opOutdoor = outdoorRepository.findByFiguraOutdoor(figuraOutdoor);
        
        if(opOutdoor.isEmpty()){
            throw new OutdoorNotFoundException("Outdoor não encontrado!");
        }

        Outdoor outdoor = opOutdoor.get();
        OutdoorDTOConverters.OutdoorUpdateDTOToModel(novoOutdoor, outdoor);
        outdoor.setFiguraOutdoor(novoOutdoor.getFiguraOutdoor());
        outdoor.setFotoOutdoor(novoOutdoor.getFotoOutdoor());
        outdoor.setGeolocalizacao(novoOutdoor.getGeoLocalizacao());
        outdoor.setDescricao(novoOutdoor.getDescricao());
        outdoor.setStatusUso(novoOutdoor.isStatusUso());
        outdoor.setTipoOutdoor(novoOutdoor.getTipoOutdoor());

        outdoorRepository.save(outdoor);
    }



    public void updateStatusUso(Boolean statusUso, OutdoorUpdateDTO novoOutdoor) throws OutdoorNotFoundException{

        Optional<Outdoor> opOutdoor = outdoorRepository.findByStatusUso(statusUso);
        
        if(opOutdoor.isEmpty()){
            throw new OutdoorNotFoundException("Outdoor não encontrado!");
        }

        Outdoor outdoor = opOutdoor.get();
        OutdoorDTOConverters.OutdoorUpdateDTOToModel(novoOutdoor, outdoor);
        outdoor.setFiguraOutdoor(novoOutdoor.getFiguraOutdoor());
        outdoor.setFotoOutdoor(novoOutdoor.getFotoOutdoor());
        outdoor.setGeolocalizacao(novoOutdoor.getGeoLocalizacao());
        outdoor.setDescricao(novoOutdoor.getDescricao());
        outdoor.setStatusUso(novoOutdoor.isStatusUso());
        outdoor.setTipoOutdoor(novoOutdoor.getTipoOutdoor());

        outdoorRepository.save(outdoor);
    }
    
}

