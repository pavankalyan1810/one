package org.TableBookingSystem.Repository;

import java.util.List;
import java.util.Optional;

import org.TableBookingSystem.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TableRepository extends JpaRepository<Table, Long> {

	List<Table> findByBookedFalse();

	Optional<Table> findBytableId(Long tableId);

}
