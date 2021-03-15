package restanakin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JediController {

    private final JediOrder repository;

    public JediController(JediOrder repository) {
        this.repository = repository;
    }

    @GetMapping("/jedis")
    List<Jedi> all() {
        return repository.findAll();
    }

    @GetMapping("/jedis/{id}")
    Jedi one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new JediNotFoundException(id));
    }

    @PostMapping("/jedis")
    Jedi newJedi(@RequestBody Jedi newForceUser) {
        return repository.save(newForceUser);
    }

    @PutMapping("/jedis/{id}")
    Jedi put(@RequestBody Jedi replaceJedi, @PathVariable Long id) {
        return repository.findById(id).map(jedi -> {
            jedi = replaceJedi;
            jedi.setId(id);
            return repository.save(jedi);
        }).orElseThrow(() -> new JediNotFoundException(id));
    }

    @DeleteMapping("/jedis/{id}")
    void del(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
