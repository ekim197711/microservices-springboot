package com.example.springbootmicroservice.space;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/space")
public class SpaceShipRestController {
    private static List<SpaceShip> ships = new ArrayList(List.of(new SpaceShip("Mike", 50)));

    @GetMapping("/ship")
    public List<SpaceShip> ships(){
        return ships;
    }

    @PostMapping("/ship")
    public List<SpaceShip> ships(@RequestBody SpaceShip ship){
        ships.add(ship);
        return ships;
    }

    @DeleteMapping("/ship/{captain}")
    public List<SpaceShip> deleteships(@PathVariable("captain") String captain){
        List<SpaceShip> collect = ships.stream().filter((s) -> s.getCaptain().equalsIgnoreCase(captain))
                .collect(Collectors.toList());
        ships.removeAll(collect);
        return ships;
    }


}
