package cn.xiaoshuiping.springbootwebflux.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/15 下午6:21
 */
@Component
public class EchoHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(final WebSocketSession session) {
        return session.send(session.receive().map(msg -> session.textMessage(msg.getPayloadAsText())));
    }
}
