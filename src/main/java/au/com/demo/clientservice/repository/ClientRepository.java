package au.com.demo.clientservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.demo.clientservice.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    Optional<ClientEntity> findByEmail(String email);
}
