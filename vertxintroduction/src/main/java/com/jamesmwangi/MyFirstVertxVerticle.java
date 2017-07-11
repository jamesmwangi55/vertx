package com.jamesmwangi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyFirstVertxVerticle extends AbstractVerticle {
  @Override
  public void start(Future<Void> future) throws Exception {
    vertx
        .createHttpServer()
        .requestHandler(r -> {
          r.response().end("<h1>Hello from my first " +
              "Vert.x 3 application</h1>");
        }).listen(8080, result ->{
          if(result.succeeded()){
            future.complete();
          } else {
            future.fail(result.cause());
          }
    });
  }
}
