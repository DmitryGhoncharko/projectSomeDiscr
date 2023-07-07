package by.webproj.carshowroom.command;

import by.webproj.carshowroom.controller.RequestFactory;
import by.webproj.carshowroom.controller.SimpleRequestFactory;
import by.webproj.carshowroom.model.connection.ConnectionPool;
import by.webproj.carshowroom.model.connection.HikariCPConnectionPool;
import by.webproj.carshowroom.model.dao.ScoreDao;

public class InitialContext {

    private final RequestFactory simpleRequestFactory = new SimpleRequestFactory();
    private final ConnectionPool connectionPool = new HikariCPConnectionPool();
    private final ScoreDao scoreDao = new ScoreDao(connectionPool);
    public Command lookup(String commandName) {

        switch (commandName) {
            case "scoreboard":
                return new ShowScoreboardPageCommand(scoreDao,simpleRequestFactory);
                default:{
                return new ShowMainPageCommand(simpleRequestFactory);
            }

        }
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
