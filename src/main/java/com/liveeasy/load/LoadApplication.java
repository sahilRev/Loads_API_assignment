package com.liveeasy.load;

import com.liveeasy.load.Model.Shipper;
import com.liveeasy.load.Repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoadApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(LoadApplication.class, args);

	}

	@Autowired
	ShipperRepository shipperRepository;

	@Override
	public void run(String... args) throws Exception {
		Shipper shipper1 = Shipper.builder()
				.name("shipper1")
				.build();
		Shipper shipper2 = Shipper.builder()
				.name("shipper2")
				.build();
		Shipper shipper3 = Shipper.builder()
				.name("shipper3")
				.build();

		shipperRepository.save(shipper1);
		shipperRepository.save(shipper2);
		shipperRepository.save(shipper3);

	}
}
