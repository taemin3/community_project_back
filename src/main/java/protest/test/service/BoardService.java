package protest.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import protest.test.entity.Board;
import protest.test.entity.FavoriteBoard;
import protest.test.entity.Member;
import protest.test.dto.BoardDto;
import protest.test.repository.BoardRepository;
import protest.test.repository.FavoriteBoardRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final FavoriteBoardRepository favoriteBoardRepository;
    @Transactional
    public List<BoardDto> create(Member member) {
        List<Board> boards = boardRepository.findAll();
        List<FavoriteBoard> favoriteBoards = favoriteBoardRepository.findByMemberId(member.getId());
        Set<Long> favoriteBoardIds = new HashSet<>();
        for (FavoriteBoard favoriteBoard : favoriteBoards) {
            Board board = favoriteBoard.getBoard();
            favoriteBoardIds.add(board.getId());
        }

        List<BoardDto> boardDtos = new ArrayList<>();

        for (FavoriteBoard favoriteBoard : favoriteBoards) {
            Board board = favoriteBoard.getBoard();
            boolean isFavorite = true; // 즐겨찾기 목록에 있는 경우는 항상 즐겨찾기 상태로 설정
            BoardDto boardDto = new BoardDto(board.getId(), board.getBoardName(), isFavorite);
            boardDtos.add(boardDto);
        }


        for (Board board : boards) {
            Long boardId = board.getId();
            if (!favoriteBoardIds.contains(boardId)) { // 즐겨찾기 목록에 없는 경우
                BoardDto boardDto = new BoardDto(boardId, board.getBoardName(), false); // 즐겨찾기 상태는 false로 설정
                boardDtos.add(boardDto);
            }
        }
        return boardDtos;

    }

}
