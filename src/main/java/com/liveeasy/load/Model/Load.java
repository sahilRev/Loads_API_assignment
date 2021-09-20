package com.liveeasy.load.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "loads_tbl")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "loading_point", nullable = false)
    private String loadingPoint;
    @Column(name = "unloading_point", nullable = false)
    private String unloadingPoint;
    @Column(name = "product_type", nullable = false)
    private String productType;
    @Column(name = "truck_type", nullable = false, length = 50)
    private String truckType;
    @Column(name = "num_trucks", nullable = false)
    private Integer numberOfTrucks;
    @Column(name = "weight", nullable = false)
    private Float weight;
    @Column(name = "comment", nullable = true, length = 500)
    private String comment;
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

}
