// package com.example.pi.impakto.demo.controller;

// import com.example.pi.impakto.demo.controller.openAPI.MapaControllerOpenAPI;
// import com.example.pi.impakto.demo.dto.mapa.MapaDetailDTO;
// import com.example.pi.impakto.demo.dto.mapa.MapaInsertDTO;
// import com.example.pi.impakto.demo.dto.mapa.MapaListDTO;
// import com.example.pi.impakto.demo.dto.mapa.MapaUpdateDTO;
// import com.example.pi.impakto.demo.exception.ResourceNotFoundException;
// // import com.example.pi.impakto.demo.model.Outdoor;
// import com.example.pi.impakto.demo.service.MapaService;
// import java.util.List;
// import lombok.AllArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/mapa")
// @AllArgsConstructor
// public class MapaController implements MapaControllerOpenAPI{

//   @Autowired
//   private final MapaService mapaService;

//   // Criar um novo Mapa
//   @PostMapping("/add")
//   public MapaDetailDTO createMapa(@RequestBody MapaInsertDTO mapaDTO) {
//     return mapaService.createMapa(mapaDTO);
//   }

//   // Obter um Mapa por ID com detalhes
//   @GetMapping("/{id}")
//   public MapaDetailDTO getMapaById(@PathVariable("id") Long id)
//     throws ResourceNotFoundException {
//     try {
//       return mapaService.getMapaById(id);
//     } catch (ResourceNotFoundException e) {
//       throw new RuntimeException(e.getMessage());
//     }
//   }

//   // Obter todos os Mapas (listagem simples)
//   @GetMapping("/all")
//   public List<MapaListDTO> getAllMapas() {
//     return mapaService.getAllMapas();
//   }

//   // Atualizar um Mapa por ID
//   @PutMapping("/update/{id}")
//   public MapaDetailDTO updateMapa(
//     @PathVariable("id") Long id,
//     @RequestBody MapaUpdateDTO mapaDTO
//   ) throws ResourceNotFoundException {
//     try {
//       return mapaService.updateMapa(id, mapaDTO);
//     } catch (ResourceNotFoundException e) {
//       throw new RuntimeException(e.getMessage());
//     }
//   }

//   // Deletar um Mapa por ID
//   @DeleteMapping("/delete/{id}")
//   public void deleteMapa(@PathVariable("id") Long id) {
//     try {
//       mapaService.deleteMapa(id);
//     } catch (ResourceNotFoundException e) {
//       throw new RuntimeException(e.getMessage());
//     }
//   }

//   // @PostMapping("/insert/geolocalizacao/")
//   // public void insertGeolocalizacao(@RequestBody String geolocalizacao){
//   //     mapaService.insertGeolocalizacao(geolocalizacao);
//   // }

//   // @DeleteMapping("/delete/{outdoor}")
//   // public void deleteByOutdoor(@RequestBody Outdoor outdoor)
//   //   throws ResourceNotFoundException {
//   //   try {
//   //     mapaService.deleteByOutdoor(outdoor);
//   //   } catch (ResourceNotFoundException e) {
//   //     throw new RuntimeException(e.getMessage());
//   //   }
//   // }

//   // Obter Mapa por Geolocalização
//   @GetMapping("/geolocalizacao/{geolocalizacao}")
//   public MapaDetailDTO findByGeolocalizacao(
//     @PathVariable String geolocalizacao
//   ) throws ResourceNotFoundException {
//     try {
//       return mapaService.getByGeolocalizacao(geolocalizacao);
//     } catch (ResourceNotFoundException e) {
//       throw new RuntimeException(e.getMessage());
//     }
//   }

//   @PutMapping("/update/{geolocalizacao}")
//   public void updateOutdoorByCliente(@RequestBody String geolocalizacao) {
//     try {
//       mapaService.getByGeolocalizacao(geolocalizacao);
//     } catch (ResourceNotFoundException e) {
//       throw new RuntimeException(e.getMessage());
//     }
//   }

//   // @GetMapping("/{outdoor}")
//   // public MapaDetailDTO findByOutdoor(@RequestBody Outdoor outdoor)
//   //   throws ResourceNotFoundException {
//   //   try {
//   //     return mapaService.findByOutdoor(outdoor);
//   //   } catch (ResourceNotFoundException e) {
//   //     return null;
//   //   }
//   // }
// }
