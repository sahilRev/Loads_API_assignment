package com.liveeasy.load.Service;

import com.liveeasy.load.Model.Load;
import com.liveeasy.load.payload.addLoadRequest;
import com.liveeasy.load.payload.loadWithShipperIdResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface LoadService {

    ResponseEntity<String> addLoad(addLoadRequest addLoadRequest);
    ResponseEntity<loadWithShipperIdResponse> getLoadsByShipperId(UUID id);
    ResponseEntity<Load> getLoadById(Long id);
    ResponseEntity<Load> updateLoad(Long LoadId, addLoadRequest load);
    ResponseEntity<String> deleteLoad(Long id);
}
