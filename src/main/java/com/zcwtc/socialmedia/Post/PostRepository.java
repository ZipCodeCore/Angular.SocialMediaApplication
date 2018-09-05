package com.zcwtc.socialmedia.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Query(value = "SELECT * FROM post p WHERE p.user_id=?1", nativeQuery = true)
    Iterable<Post> getPostsByUserId(Long userId);
}
