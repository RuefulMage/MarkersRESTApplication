package Server.Services;

import Server.Models.DTOs.MarkerDTO;
import Server.Models.Entities.Marker;
import Server.Models.Entities.User;
import Server.Repos.HibernateMarkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private HibernateMarkersRepo markersRepo;

    @Override
    public ArrayList<MarkerDTO> getAllMarkers() {
        ArrayList<MarkerDTO> markerDTOS = new ArrayList<MarkerDTO>();
        ArrayList<Marker> arrayList = (ArrayList<Marker>) markersRepo.findAll();
        MarkerDTO markerDTO;
        for (Marker marker:arrayList) {
            markerDTO = new MarkerDTO(marker.getId(), marker.getComment(),
                    marker.getCountry(), marker.getReasonOfTurism(), marker.getLongitude()
                    , marker.getLatitude());
            markerDTOS.add(markerDTO);
        }
        System.out.println(markerDTOS);
        return markerDTOS;
    }

    @Override
    public List<Marker> getUsersMarkers(User user) {
        return markersRepo.findByUser(user);
    }
}
