package dleedev365.runnerz.run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InMemoryRunRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryRunRepository.class);
    private final List<Run> runs = new ArrayList<>();

    public List<Run> findAll(){ return runs; }

    public Optional<Run> findById(Integer id){
        return Optional.ofNullable(runs.stream()
                .filter(run -> Objects.equals(run.id(), id))
                .findFirst()
                .orElseThrow(RunNotFoundException::new)
        );
    }

    public void create(Run run){
        Run newRun = new Run(run.id(), run.title(), run.startedOn(), run.completedOn(), run.miles(), run.location());
        runs.add(newRun);
    }

    public void update(Run newRun, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            var r = existingRun.get();
            log.info("Updating Existing Run: " + existingRun.get());
            runs.set(runs.indexOf(r),newRun);
        }
    }

    public void delete(Integer id){
        log.info("Deleting Run: " + id);
        runs.removeIf(run -> run.id().equals(id));
    }

    public int count(){ return runs.size(); }

    public void saveAll(List<Run> runs){
        runs.forEach(this::create);
    }

    public List<Run> findByLocation(String location){
        return runs.stream().filter(run -> Objects.equals(run.location(), location)).toList();
    }


}