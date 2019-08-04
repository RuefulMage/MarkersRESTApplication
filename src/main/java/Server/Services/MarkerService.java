package Server.Services;

import Server.Models.DTOs.MarkerDTO;
import Server.Models.Entities.Marker;
import Server.Models.Entities.User;

import java.util.ArrayList;
import java.util.List;

public interface MarkerService {
    ArrayList<MarkerDTO> getAllMarkers();
    List<Marker> getUsersMarkers(User user);
}
