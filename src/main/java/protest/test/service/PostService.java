package protest.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import protest.test.dto.PostDto;
import protest.test.entity.Board;
import protest.test.entity.Member;
import protest.test.entity.Post;
import protest.test.repository.BoardRepository;
import protest.test.repository.MemberRepository;
import protest.test.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long create(PostDto postDto) {
        Post post = new Post();
        Optional<Board> optionalBoard = boardRepository.findById(postDto.getBoardId());
        Board board = optionalBoard.orElse(new Board());
        Member member = memberRepository.findById(postDto.getMemberId()).orElse(null);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setPostDate(LocalDateTime.now());
        post.setBoard(board);
        post.setMember(member);
        postRepository.save(post);
        return post.getId();
    }



}
