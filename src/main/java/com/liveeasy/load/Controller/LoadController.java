package com.liveeasy.load.Controller;


import com.liveeasy.load.Model.Load;
import com.liveeasy.load.Service.LoadService;
import com.liveeasy.load.payload.addLoadRequest;
import com.liveeasy.load.payload.loadWithShipperIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class LoadController {

    private final LoadService service;

    @PostMapping(value = "/load")
    public ResponseEntity<String> addLoad(@RequestBody addLoadRequest addLoadRequest){
        return service.addLoad(addLoadRequest);
    }

    @GetMapping(value = "/load/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable("loadId") Long id){
        return service.getLoadById(id);
    }

    @GetMapping(value = "/load")
    public ResponseEntity<loadWithShipperIdResponse> getLoadsByShipperId(@RequestParam(value = "shipperId", required = true) UUID id){
        return service.getLoadsByShipperId(id);
    }

    @PutMapping(value = "/load/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable("loadId") Long id, @RequestBody addLoadRequest addLoadRequest){
        return service.updateLoad(id, addLoadRequest);
    }

    @DeleteMapping(value = "/load/{loadId}")
    public ResponseEntity<String> deleteLoadById(@PathVariable("loadId") Long id){
        return service.deleteLoad(id);
    }



}// end class
