package com.murad.online1.db.repository;

import com.murad.online1.db.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {


    Address findByIdEmployee(int idEmployee);


}
