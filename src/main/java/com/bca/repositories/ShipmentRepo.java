package com.bca.repositories;

import com.bca.entities.Shipment;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShipmentRepo extends PagingAndSortingRepository<Shipment, Integer> {

}
