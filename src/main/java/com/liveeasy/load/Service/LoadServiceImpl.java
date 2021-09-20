package com.liveeasy.load.Service;

import com.liveeasy.load.Model.Load;
import com.liveeasy.load.Model.Shipper;
import com.liveeasy.load.Repository.LoadRepository;
import com.liveeasy.load.Repository.ShipperRepository;
import com.liveeasy.load.payload.addLoadRequest;
import com.liveeasy.load.payload.loadWithShipperIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadServiceImpl implements LoadService{

    // Repositories
    private final LoadRepository loadRepository;
    private final ShipperRepository shipperRepository;


    /****************************************** ADD LOAD ********************************************/
    @Override
    public ResponseEntity<String> addLoad(addLoadRequest addLoadRequest) {
        Shipper shipper = shipperRepository.findById(addLoadRequest.getShipperId()).orElse(null);
        Load load = Load.builder()
                .loadingPoint(addLoadRequest.getLoadingPoint())
                .unloadingPoint(addLoadRequest.getUnloadingPoint())
                .productType(addLoadRequest.getProductType())
                .truckType(addLoadRequest.getTruckType())
                .numberOfTrucks(addLoadRequest.getNumberOfTrucks())
                .weight(addLoadRequest.getWeight())
                .comment(addLoadRequest.getComment())
                .shipper(shipper)
                .date(addLoadRequest.getDate())
                .build();
        loadRepository.save(load);

        return new ResponseEntity<>("loads details added successfully", HttpStatus.CREATED);
    }


    /****************************************** GET LOADS BY SHIPPER-ID ******************************************************/
    @Override
    public ResponseEntity<loadWithShipperIdResponse> getLoadsByShipperId(UUID id) {
        List<Load> loads = loadRepository.findAll().parallelStream()
                .filter(t -> t.getShipper().getId() == id)
                .collect(Collectors.toList());

        return new ResponseEntity<>( new loadWithShipperIdResponse("List of loads with shipperId : " + id, loads), HttpStatus.OK);
    }



    /****************************************** GET LOAD BY ID ********************************************/
    @Override
    public ResponseEntity<Load> getLoadById(Long id) {
        Optional<Load> load = Optional.of(loadRepository.findById(id)).orElseGet(null);
        return new ResponseEntity<>(load.orElse(null),HttpStatus.OK);
    }



    /****************************************** UPDATE LOAD ********************************************/
    @Override
    public ResponseEntity<Load> updateLoad(Long LoadId, addLoadRequest load) {

        if (loadRepository.existsById(LoadId) && shipperRepository.existsById(load.getShipperId())){
            Shipper shipper = shipperRepository.getById(load.getShipperId());
            Load updatedLoad = Load.builder()
                    .id(LoadId)
                    .loadingPoint(load.getLoadingPoint())
                    .unloadingPoint(load.getUnloadingPoint())
                    .productType(load.getProductType())
                    .truckType(load.getTruckType())
                    .numberOfTrucks(load.getNumberOfTrucks())
                    .weight(load.getWeight())
                    .comment(load.getComment())
                    .date(load.getDate())
                    .shipper(shipper)
                    .build();
            loadRepository.save(updatedLoad);
            return new ResponseEntity<>(updatedLoad, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    /****************************************** DELETE LOAD ********************************************/
    @Override
    public ResponseEntity<String> deleteLoad(Long id) {
        if (loadRepository.existsById(id)){
            loadRepository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}// end LoadService Class
