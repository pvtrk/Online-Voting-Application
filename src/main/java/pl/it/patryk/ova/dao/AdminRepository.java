package pl.it.patryk.ova.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.it.patryk.ova.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
