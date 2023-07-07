package by.webproj.carshowroom.rest;

import by.webproj.carshowroom.command.InitialContext;
import by.webproj.carshowroom.entity.Score;
import by.webproj.carshowroom.model.dao.ScoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/scope")
public class ScopeAddEndpoint extends HttpServlet {
    private InitialContext initialContext = new InitialContext();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long scopes = Long.parseLong(req.getParameter("scopes"));
        String userName = req.getParameter("userName");
        System.out.println(userName);
        System.out.println(scopes);
        Score score = new Score(1L,userName,scopes);
        ScoreDao scoreDao = new ScoreDao(initialContext.getConnectionPool());
        Optional<Score> scoreOptional = scoreDao.getByName(userName);
        String secret = req.getParameter("secret");
        if(secret!=null && secret.equals("gSUIHEFDjlkashvbUIADHS283751804713nfmlsdfnoad")){
            if(scoreOptional.isPresent()){
                if(scopes>scoreOptional.get().getScope()){
                    scoreDao.update(score);
                }
            }else {
                scoreDao.add(score);
            }
        }
        super.doPost(req, resp);
    }
}
