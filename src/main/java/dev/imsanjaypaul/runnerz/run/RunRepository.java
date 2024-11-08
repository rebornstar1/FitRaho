package dev.imsanjaypaul.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void AddOne(Run run){
        runs.add(run);
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