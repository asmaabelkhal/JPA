package ma.enset.tpjpa.repositories;

import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.tpjpa.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	//public List<Patient> findByNomContains(String name);
	public List<Patient> findByMalade(boolean b);
	public List<Patient> findByNomContainsAndMalade(String name,boolean b);
	public Page<Patient> findByNomContains(String name,PageRequest pageRequest);

}
