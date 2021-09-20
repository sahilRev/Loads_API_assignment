package com.liveeasy.load.payload;


import com.liveeasy.load.Controller.LoadController;
import com.liveeasy.load.Model.Load;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class loadWithShipperIdResponse {
    //Response type for LoadController::getLoadsByShipperId

    private String message;
    private List<Load> loads;
}
