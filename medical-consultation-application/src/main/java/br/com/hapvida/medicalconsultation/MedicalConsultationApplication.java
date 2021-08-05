package br.com.hapvida.medicalconsultation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.hapvida.medicalconsultation")
public class MedicalConsultationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalConsultationApplication.class, args);
    }
}
