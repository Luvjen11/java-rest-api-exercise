package com.cbfacademy.restapiexercise.ious;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;


//  Define a native @Query annotation that will return all IOUs with an above average value. Hint: create a subquery using the AVG function
public interface IOURepository extends ListCrudRepository<IOU, UUID> {

    public List<IOU> findByBorrower(String borrower);

    @Query(value = "SELECT * FROM ious WHERE amount > (SELECT AVG(amount) FROM ious)", nativeQuery = true)
    public List<IOU> findHighValueIOUs();

    @Query("SELECT i from IOU i WHERE i.amount <= (SELECT AVG(i2.amount) FROM IOU i2)")
    public List<IOU> findLowValueIous();
}
