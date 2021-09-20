package com.liveeasy.load.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class addLoadRequest {
    // Payload to add Load

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private Integer numberOfTrucks;
    private Float weight;
    private String comment;
    private LocalDate date;
    private UUID shipperId;
}
