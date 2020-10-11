package pl.sda.spring.security.model;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
