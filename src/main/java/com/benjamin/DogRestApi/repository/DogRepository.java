package com.benjamin.DogRestApi.repository;

import com.benjamin.DogRestApi.Entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DogRepository extends JpaRepository<Dog,Integer> {
//    @Query("select d from Dog d where d.name=?1")
//    Dog findByName(String dogName);
//
//
//    @Query("select d.breed from Dog d")
//    List<String> findBreed();
//
//    @Query("select d from Dog d where d.breed=?1")
//    Dog findByBreed(String breed);
}
