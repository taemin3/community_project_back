package protest.test.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import protest.test.domain.Board;
import protest.test.domain.Post;
import protest.test.dto.PostDto;
import protest.test.repository.BoardRepository;
import protest.test.repository.PostRepository;
import protest.test.service.PostService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = "application/json;charset=UTF-8")
public class ApiController {

    private final PostService postService;
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    @ResponseBody
    @PostMapping("/api")
    public String asdasd(@RequestBody PostDto postDto) throws IOException {
        postService.create(postDto);
        return "ok";
    }


    @GetMapping("/posts")
    public List<Post> posts() {
        return postRepository.findAll();
    }

    @GetMapping("/board")
    public List<Board> boards() {
        return boardRepository.findAll();
    }





}
