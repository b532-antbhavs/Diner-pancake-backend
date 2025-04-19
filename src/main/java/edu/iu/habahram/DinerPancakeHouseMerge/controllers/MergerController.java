package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    private final MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> getAll() {
        return mergerRepository.getTheMenuItems();
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarian() {
        return mergerRepository.getVegetarianItems();
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast() {
        return mergerRepository.getBreakfastItems();
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch() {
        return mergerRepository.getLunchItems();
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getDinner() {
        return mergerRepository.getDinnerItems();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequest request) {
        try {
            mergerRepository.signUp(request.username(), request.password(), request.email());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public record SignupRequest(String username, String password, String email) {}
}