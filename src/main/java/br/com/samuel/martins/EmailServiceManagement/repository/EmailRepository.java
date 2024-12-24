package br.com.samuel.martins.EmailServiceManagement.repository;

import br.com.samuel.martins.EmailServiceManagement.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {
}
