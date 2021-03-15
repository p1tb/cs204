package restanakin.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JediOrder extends JpaRepository<Jedi, Long> {
}
