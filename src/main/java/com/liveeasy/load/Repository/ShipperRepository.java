package com.liveeasy.load.Repository;

import com.liveeasy.load.Model.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipperRepository extends JpaRepository<Shipper, UUID> {
}
