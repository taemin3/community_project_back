package protest.test.apicontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import protest.test.dto.PostListDto;
import protest.test.entity.Board;
import protest.test.entity.Member;
import protest.test.entity.Post;
import protest.test.dto.BoardDto;
import protest.test.dto.FavoriteDto;
import protest.test.dto.PostDto;
import protest.test.repository.BoardRepository;
import protest.test.repository.MemberRepository;
import protest.test.repository.PostRepository;
import protest.test.service.BoardService;
import protest.test.service.FavoriteService;
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
    private final BoardService boardService;
    private final FavoriteService favoriteService;
    private final MemberRepository memberRepository;

    @ResponseBody
    @PostMapping("/api")
    public String asdasd(@RequestBody PostDto postDto) throws IOException {
        postService.create(postDto);
        return "ok";
    }


    @GetMapping("/posts")
    public List<PostListDto> posts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "0") int pageSize,
            @RequestParam(value = "boardId", defaultValue = "0") Long boardId
    ) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC,
                "postDate"));

        Page<Post> pagePost = postRepository.findAllWithPost(boardId,pageRequest);
        List<PostListDto> postListDtos = pagePost.map(p -> new PostListDto(p)).toList();

        return postListDtos;
    }

    @GetMapping("/board")
    public List<BoardDto> boards(@RequestParam("memberId") String memberId) {
        Member member = memberRepository.findByLoginId(memberId);
        return boardService.create(member);
    }

    @PostMapping("/favorite")
    public String favorite(@RequestBody FavoriteDto favoriteDto) {
        Board board = boardRepository.findByBoardName(favoriteDto.getBoardName());
        Member member = memberRepository.findByLoginId(favoriteDto.getMemberId());
        favoriteService.add(member,board);
        return "ok";
    }







}
