package com.example.capstone2.service;

import com.example.capstone2.controller.MainController;
import com.example.capstone2.repository.PostRepository;
import com.example.capstone2.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MainService {
    private static final Logger LOGGER = Logger.getLogger(MainController.class.getName());
    private PostRepository postRepository;
    private TypeRepository typeRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    public void setTypeRepository(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }
}
