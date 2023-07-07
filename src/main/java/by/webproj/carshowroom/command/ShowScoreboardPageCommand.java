package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.entity.Score;
import by.webproj.carshowroom.exception.DaoException;
import by.webproj.carshowroom.exception.ServiceError;
import by.webproj.carshowroom.model.dao.ScoreDao;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShowScoreboardPageCommand implements Command{
    private final ScoreDao scoreDao;

    private final RequestFactory requestFactory;
    @Override
    public CommandResponse execute(CommandRequest request) throws ServiceError, DaoException {
        List<Score> scores = scoreDao.showTop50();
        request.addAttributeToJsp("scores",scores);
        return requestFactory.createForwardResponse(PagePath.SCOPRES.getPath());

    }

}
