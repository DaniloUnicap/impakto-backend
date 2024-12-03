package com.example.pi.impakto.demo.service.converters;

import com.example.pi.impakto.demo.dto.outdoor.GetOutdoorDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorInsertDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorListDTO;
import com.example.pi.impakto.demo.dto.outdoor.OutdoorUpdateDTO;
import com.example.pi.impakto.demo.model.Outdoor;

public class OutdoorDTOConverters {

     public static Outdoor OutdoorInsertDTOModel (OutdoorInsertDTO outdoorDTO){
        Outdoor outdoorModel = new Outdoor();
        outdoorModel.setFiguraOutdoor(outdoorDTO.getFiguraOutdoor());
        outdoorModel.setFotoOutdoor(outdoorDTO.getFotoOutdoor());
        outdoorModel.setGeolocalizacao(outdoorDTO.getGeolocalizacao());
        outdoorModel.setDescricao(outdoorDTO.getDescricao());
        outdoorModel.setStatusUso(outdoorDTO.isStatusUso());
        outdoorModel.setTipoOutdoor(outdoorDTO.getTipoOutdoor());
        outdoorModel.setGeolocalizacao(outdoorDTO.getGeolocalizacao());
        return outdoorModel;
     }

     public static OutdoorListDTO outdoorListDTOToModel (Outdoor outdoorModel){
        OutdoorListDTO outdoorDTO = new OutdoorListDTO();
        outdoorDTO.setFotoOutdoor(outdoorModel.getFotoOutdoor());
        outdoorDTO.setGeolocalizacao(outdoorModel.getGeolocalizacao());
        outdoorDTO.setDescricao(outdoorModel.getDescricao());
        outdoorDTO.setStatusUso(outdoorModel.isStatusUso());
        outdoorDTO.setTipoOutdoor(outdoorModel.getTipoOutdoor());
        outdoorDTO.setAgendamento(outdoorModel.getAgendamento());
        outdoorDTO.setId(outdoorModel.getId());
        return outdoorDTO;
     }

      public static void OutdoorUpdateDTOToModel(OutdoorUpdateDTO outdoorUpdateDTO, Outdoor outdoor){
        outdoor.setFiguraOutdoor(outdoorUpdateDTO.getFiguraOutdoor());
        outdoor.setFotoOutdoor(outdoorUpdateDTO.getFotoOutdoor());
        outdoor.setGeolocalizacao(outdoorUpdateDTO.getGeoLocalizacao());
        outdoor.setDescricao(outdoorUpdateDTO.getDescricao());
        outdoor.setStatusUso(outdoorUpdateDTO.isStatusUso());
        outdoor.setTipoOutdoor(outdoorUpdateDTO.getTipoOutdoor());
      }

      public static GetOutdoorDTO getOutdoorDTOToModel (Outdoor outdoor){
      GetOutdoorDTO outdoorDTO = new GetOutdoorDTO();
      outdoorDTO.setId(outdoor.getId());
      outdoorDTO.setFiguraOutdoor(outdoor.getFiguraOutdoor());
      outdoorDTO.setFotoOutdoor(outdoor.getFotoOutdoor());
      outdoorDTO.setGeolocalizacao(outdoor.getGeolocalizacao());
      outdoorDTO.setDescricao(outdoor.getDescricao());
      outdoorDTO.setStatusUso(outdoor.isStatusUso());
      outdoorDTO.setTipoOutdoor(outdoor.getTipoOutdoor());
      outdoorDTO.setAgendamento(outdoor.getAgendamento());
      outdoorDTO.setContrato(outdoor.getContrato());
      return outdoorDTO;
      }

    
}


