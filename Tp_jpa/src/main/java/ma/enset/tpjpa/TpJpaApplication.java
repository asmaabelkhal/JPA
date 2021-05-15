package ma.enset.tpjpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.enset.tpjpa.entities.Patient;
import ma.enset.tpjpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		patientRepository.save(new Patient(null, "Hassan",new Date(),2300,false));
		patientRepository.save(new Patient(null, "Asmaa",new Date(),2000,false));
		patientRepository.save(new Patient(null, "Amina",new Date(),230,false));
		patientRepository.save(new Patient(null, "Hakim",new Date(),2200,false));
		patientRepository.save(new Patient(null, "Mona",new Date(),1500,true));
		System.out.println("************************************");
		patientRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("************************************");
		Patient patient=patientRepository.findById(4L).get();
		System.out.println(patient.getNom());
		
		/*System.out.println("************************************");
		List<Patient> patients=patientRepository.findByNomContains("A");
		patients.forEach(p->{
			System.out.println(p.toString());
		});*/	
		
		System.out.println("************************************");
		List<Patient> patients2=patientRepository.findByMalade(true);
		patients2.forEach(p->{
			System.out.println(p.toString());
		});	
		
		System.out.println("************************************");
		List<Patient> patients3=patientRepository.findByNomContainsAndMalade("M",true);
		patients3.forEach(p->{
			System.out.println(p.toString());
		});
		patientRepository.deleteById(5L);
		 
		System.out.println("************************************");
		Page<Patient> pagePatients=patientRepository.findAll(PageRequest.of(0, 2));
		System.out.println("Nombre de pages :"+pagePatients.getTotalPages());
		List<Patient> listPatients=pagePatients.getContent();
		listPatients.forEach(p->{
			System.out.println(p.toString());
		});	
		System.out.println("************************************");
		Page<Patient> patientsp=patientRepository.findByNomContains("A", PageRequest.of(0, 2));
		patientsp.forEach(p->{
			System.out.println(p.toString());
		});	 
		
		
	}

}
