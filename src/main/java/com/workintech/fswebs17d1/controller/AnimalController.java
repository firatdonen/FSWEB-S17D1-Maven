package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@RestController
@RequestMapping("/workintech")
public class AnimalController {
    @Value("${course.name}")
    private String courseName;
    @Value("${project.developer.fullname}")

    private Map<Integer, Animal> animals= new HashMap<>();
    //CRUD işlemleri burada olacak
    @GetMapping
    public Collection<Animal>getAllAnimals(){
        return animals.values();
    }
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id){
        return animals.get(id);

    }
    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
    }
    @PutMapping("/{id}")
    public void updateAnimal(@PathVariable int id,@RequestBody Animal animal){
        animals.put(id, animal);
    }
    @DeleteMapping("{id}")
    public void deleteAnimal(@PathVariable int id) {
    animals.remove(id);
    }

}




