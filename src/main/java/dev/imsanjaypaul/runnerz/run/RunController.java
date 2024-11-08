package dev.imsanjaypaul.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
       return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty())
        {
            throw new RunNotFound();
        }
        else return run.get();
    }

    // post Method
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create (@Valid @RequestBody Run run) {
        runRepository.createRun(run);
    }

    // put Method
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    void put (@Valid @RequestBody Run run) {
        runRepository.putRun(run);
    }

    // Delete Method
    @DeleteMapping("")
    void delete (@RequestBody Run run) {
        runRepository.deleteRun(run);
    }
}

// Instead of creating a new instance
