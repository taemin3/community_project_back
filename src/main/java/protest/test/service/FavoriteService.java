package protest.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import protest.test.entity.Board;
import protest.test.entity.FavoriteBoard;
import protest.test.entity.Member;
import protest.test.repository.FavoriteBoardRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteBoardRepository favoriteBoardRepository;

    @Transactional
    public void add(Member member, Board board) {
        Optional<FavoriteBoard> favoriteBoardOpt = favoriteBoardRepository.findByMemberAndBoard(member, board);

        if(favoriteBoardOpt.isPresent()){
            FavoriteBoard favoriteBoard = favoriteBoardOpt.get();
            favoriteBoardRepository.delete(favoriteBoard);
        } else {
            FavoriteBoard favoriteBoard = new FavoriteBoard();
            favoriteBoard.setBoard(board);
            favoriteBoard.setMember(member);
            favoriteBoardRepository.save(favoriteBoard);
        }

    }

}
