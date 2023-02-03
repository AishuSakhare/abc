package com.capgemini.medicalboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MedicalConfig {
	@Bean
	public LocalEntityManagerFactoryBean getMedical() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("MedicalPersistanceUnit");
		return factoryBean;

	}// end of getMedical()

}// End of class
