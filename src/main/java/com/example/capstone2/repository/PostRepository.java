package com.example.capstone2.repository;

import com.example.capstone2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Long>{
    List<Post> getByTypeId(Long typeId);
}
