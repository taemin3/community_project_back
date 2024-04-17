package protest.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import protest.test.domain.Post;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestRepTest {

    @Autowired TestRep testRep;

    @Test
    @Transactional
    @Rollback(false)
    public void test() throws Exception {
        //given
        Post post = new Post();
        post.setContent("asdsad");
        post.setTitle("");
        testRep.save(post);


        //when

        //then
    }

}