package pl.sda.spring.security.model;

import org.springframework.data.jpa.repository.JpaRepository;

interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
