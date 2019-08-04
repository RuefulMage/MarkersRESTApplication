package Server.Controllers;


import Server.Models.DTOs.MarkerDTO;
import Server.Models.Entities.Marker;
import Server.Models.Entities.User;
import Server.Services.MarkerService;
import Server.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/markers")
public class MarkersController {
    @Autowired
    private UserService userService;

    @Autowired
    private MarkerService markerService;

//    @GetMapping
//    public

    @GetMapping
    public ArrayList<MarkerDTO> getUsersList(){
        return markerService.getAllMarkers();
    }


}
