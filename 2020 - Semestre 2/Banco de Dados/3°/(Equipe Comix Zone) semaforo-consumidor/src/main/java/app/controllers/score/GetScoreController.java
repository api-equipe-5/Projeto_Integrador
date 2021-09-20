package app.controllers.score;

import spark.Request;
import spark.Response;
import spark.Route;

public class GetScoreController {
    public final Route getScore = (Request request, Response response) -> {
        int score = (int)(Math.random()*3);

        response.status(200);
        return score;
    };
}
