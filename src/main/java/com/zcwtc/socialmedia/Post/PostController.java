package com.zcwtc.socialmedia.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class PostController {
    private PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> index() {
        return new ResponseEntity<>(this.postRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
    public ResponseEntity<Post> showPost(@PathVariable Long postId) {
        return new ResponseEntity<>(this.postRepository.findOne(postId), HttpStatus.OK);
    }

    @RequestMapping(value = "users/{userId}/posts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> showPostsByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(this.postRepository.getPostsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "posts", method = RequestMethod.POST)
    public ResponseEntity<Post> store(@RequestBody Post post) {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.PUT)
    public ResponseEntity<Post> update(@PathVariable Long userId, @RequestBody Post post) {
        Post foundPost = postRepository.findOne(userId);

        foundPost.update(post);

        Post savedPost = postRepository.save(foundPost);

        return new ResponseEntity<>(savedPost, HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(@PathVariable Long postId) {
        postRepository.delete(postId);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}

