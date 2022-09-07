package case_management.data.service;

import case_management.data.entities.IncidentsEntity;
import case_management.data.repositories.IncidentRepository;
import case_management.data.dao.IncidentDao;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    private final IncidentDao incidentDao;

    public IncidentService(IncidentRepository incidentRepository, IncidentDao incidentDao) {
        this.incidentRepository = incidentRepository;
        this.incidentDao = incidentDao;
    }


    public List<IncidentsEntity> getIncidents() {

        return incidentRepository.findAll();

    }

    public IncidentsEntity getIncident(int id) {
        return incidentRepository.findById(id);
    }

    public void saveOrUpdate(IncidentsEntity incidentsEntity) {

        incidentRepository.save(incidentsEntity);
    }

    public void deleteIncident(int id) {

        boolean exists = incidentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("incident with id " + id + " does not exist");
        }
        IncidentsEntity incidentsEntity = incidentRepository.findById(id);
        incidentsEntity.setDeleted(true);
        incidentRepository.save(incidentsEntity);
    }

//    public void filterIncidents(Map<String, String> params) {
//        incidentRepository.filterIncidents(params);
//    }

        public List<IncidentsEntity> filterIncidents(Optional<Integer> id, Optional<Date> date) {
        List<IncidentsEntity> incidents = incidentRepository.filterIncidents(id, date);
        return incidents;

//    public List<IncidentsEntity> filterIncidents(Optional<Integer> id, Optional<Date> date) {
//
//        String query = "select * from inc_db.incidents where 1=1";
//        Map<String, Object> params = new HashMap<>();
//        if (id != null) {
//            query += " and id = :id";
//            params.put("id", id);
//        }
//        if (date != null) {
//            query += " and date(rec_time) = :date";
//            params.put("date", date);
//        }
//
//        incidentDao.execute(query,params);



        }
}
