package protest.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import protest.test.dto.PostDto;
import protest.test.domain.Board;
import protest.test.domain.Member;
import protest.test.domain.Post;
import protest.test.repository.BoardRepository;
import protest.test.repository.MemberRepository;
import protest.test.repository.PostRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long create(PostDto postDto) {
        Post post = new Post();
        Board board = boardRepository.findByBoardName(postDto.getBoardName());
        Member member = memberRepository.findByLoginId(postDto.getMemberId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setPostDate(LocalDateTime.now());
        post.setBoard(board);
        post.setMember(member);
        postRepository.save(post);
        return post.getId();
    }



}
