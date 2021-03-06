package com.example.capstone2.service;

import com.example.capstone2.controller.MainController;
import com.example.capstone2.model.Post;
import com.example.capstone2.model.Type;
import com.example.capstone2.repository.PostRepository;
import com.example.capstone2.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<Type> getTypes() {
        return typeRepository.findAll();
    }

    public List<Post> getTypePosts(Long typeId) {
        return postRepository.getByTypeId(typeId);
    }

    public Post createTypePost(Long typeId, Post postObject) {
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()){
            postObject.setType(type.get());
            return postRepository.save(postObject);
        }
        return postObject;
    }


    public Type getOneType(Long typeId) {
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()){
         return type.get();
        }
        return null;
    }

    public Post deleteTypePost(Long typeId, Long postId) {
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()){
            Optional<Post> post= postRepository.getByIdAndTypeId(postId, typeId);
            if (post.isPresent()){
                postRepository.deleteById(postId);
                return post.get();
            }
            return null;
        }
        return null;
    }

    public Post editTypePost(Long typeId, Long postId, Post postObject) {
        Optional<Type> type = typeRepository.findById(typeId);
        if (type.isPresent()){
            Optional<Post> post= postRepository.getByIdAndTypeId(postId, typeId);
            if (post.isPresent()){
                post.get().setName(postObject.getName());
                post.get().setTitle(postObject.getTitle());
                post.get().setDescription(postObject.getDescription());
                return postRepository.save(post.get());
            }
            return null;
        }
        return null;
    }
}
