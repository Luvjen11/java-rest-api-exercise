package com.cbfacademy.restapiexercise.ious;

import java.util.UUID;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;


public interface IOURepository extends ListCrudRepository<IOU, UUID> {

    public List<IOU> findByBorrower(String borrower);

}
