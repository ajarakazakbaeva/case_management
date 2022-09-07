package case_management.controllers;

import case_management.data.entities.IncidentsEntity;
import case_management.data.repositories.IncidentRepository;
import case_management.data.service.IncidentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
@RestController
@RequestMapping("/incident")
@Tag(name = "Incident service", description = "Работа с инцидентами и содержимым онных")
public class IncidentController {

    final
    IncidentRepository incidentRepository;

    final IncidentService incidentService;


    public IncidentController(IncidentRepository incidentRepository, IncidentService incidentService) {
        this.incidentRepository = incidentRepository;
        this.incidentService = incidentService;
    }

    @GetMapping("/{id}")
    public IncidentsEntity getIncident(@PathVariable int id) {

        return incidentService.getIncident(id);

    }

    @GetMapping()
    public List<IncidentsEntity> getIncidents() {

        return incidentService.getIncidents();

    }

    @PostMapping()
    public void addNewIncident(@RequestBody IncidentsEntity incidentsEntity) {

        incidentService.saveOrUpdate(incidentsEntity);
    }

    @PutMapping()
    public void saveIncident(@RequestBody IncidentsEntity incidentsEntity) {
        

        incidentService.saveOrUpdate(incidentsEntity);
    }

    @GetMapping("/delete/{id}")
    public void deleteIncident(@PathVariable("id") int id) {

        incidentService.deleteIncident(id);
    }


    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public List<IncidentsEntity> getIncidents(@RequestParam(defaultValue = "0") Integer id,
                                              @RequestParam(required = false) String date,
                                              @RequestParam(required = false) Boolean is_deleted) throws ParseException {
        List<IncidentsEntity> incidents = new ArrayList<>();
        List<IncidentsEntity> result = new ArrayList<>();
        IncidentsEntity incident;


        if (id!=0) {

             incident = IncidentsEntity
                    .builder()
                    .id(id)
                    .isDeleted(is_deleted)
                    .build();
//             System.out.println("id!=0 incident: " + incident);
             incidents = incidentRepository.findAll(Example.of(incident, ExampleMatcher.matching().withIgnoreNullValues()));

        }
        else {
            incident = IncidentsEntity
                    .builder()
                    .isDeleted(is_deleted)
                    .build();

//            System.out.println("id=0 incident: " + incident);
            incidents = incidentRepository.findAll(Example.of(incident, ExampleMatcher.matching().withIgnorePaths("id")));


        }

        if (id==null && is_deleted==null && date!=null) {
            incidents = incidentRepository.findAll();

        }


//        System.out.println("found incidents " + incidents);


        // Filter by date
//        System.out.println("date input in string format " + date);
        if (date!=null && !date.equals("")) {
            Date date_filter = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            //        System.out.println("date input in date format " + date_filter);
            for (IncidentsEntity inc:incidents) {
                if (inc.getRecTime()!=null){
                    SimpleDateFormat formatter = new SimpleDateFormat(
                            "dd-MM-yyyy");
                    Date inc_date =  formatter.parse(formatter.format(inc.getRecTime()));
//                System.out.println("inc date " + inc_date);
                    if (inc_date.compareTo(date_filter)==0) {
                        System.out.println("EQUAL!");
                        result.add(inc);
                    }
                }
            }
        }
        else {
            result = incidents;
        }
        return result;
    }
}
