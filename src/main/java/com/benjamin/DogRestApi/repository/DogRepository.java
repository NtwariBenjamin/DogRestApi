package com.benjamin.DogRestApi.repository;

import com.benjamin.DogRestApi.Entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.lang.ref.SoftReference;
import java.util.List;


public interface DogRepository extends CrudRepository<Dog,Integer> {
    @Query("select d from Dog d where d.name=?1")
    Dog findByName(String dogName);


    @Query("select d.breed from Dog d")
    List<String> findBreed();

    @Query("select d from Dog d where d.breed=?1")
    Dog findByBreed(String breed);
}
