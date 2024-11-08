package dev.imsanjaypaul.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst();
    }

    // post
    public ResponseEntity<Run> createRun(Run run){
        runs.add(run);
        return ResponseEntity.status(HttpStatus.CREATED).body(run);
    }

    // put for the update itself
    void putRun(Run run){
        Integer id = run.id();
        Optional<Run> test = runs.stream()
                .filter(flip -> Objects.equals(flip.id(), id))
                .findFirst();

        if(test.isEmpty())
        {
            runs.add(run);
        }
        else
        {
            runs.remove(test.get());
            runs.add(run);
        }
    }

    // delete Method
    void deleteRun(Run run){
        runs.remove(run);
    }

    @PostConstruct
    public void init(){
        runs.add(new Run(
                1,
                "Trump",
                LocalDateTime.now(),
                LocalDateTime.now(),
                3,
                Location.OUTDOOR
        ));

        runs.add(new Run(
                2,
                "Ivanka",
                LocalDateTime.now(),
                LocalDateTime.now(),
                5,
                Location.INDOOR
        ));
    }
}

// Now I want to add new Runs in this list