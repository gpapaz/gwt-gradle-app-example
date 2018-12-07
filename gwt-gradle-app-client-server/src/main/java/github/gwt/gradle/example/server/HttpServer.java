package github.gwt.gradle.example.server;

import com.google.gson.Gson;
import github.gwt.gradle.example.shared.ServerHealth;
import spark.Spark;

public class HttpServer {
    public static void main(String[] args) {
        Spark.port(8080);
        Spark.staticFileLocation("/");
        Spark.initExceptionHandler(Throwable::printStackTrace);
        Spark.get(
                "/health",
                (request, response) -> new Gson().toJson(new ServerHealth("~_~"))
        );
    }
}
