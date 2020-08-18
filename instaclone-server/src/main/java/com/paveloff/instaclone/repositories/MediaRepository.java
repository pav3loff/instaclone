package com.paveloff.instaclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paveloff.instaclone.model.Media;

public interface MediaRepository extends JpaRepository<Media, Integer> {

}
