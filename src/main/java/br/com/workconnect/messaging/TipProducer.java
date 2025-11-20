package br.com.workconnect.messaging;

import br.com.workconnect.config.RabbitMQConfig;
import br.com.workconnect.model.Tip;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendTipCreatedMessage(Tip tip) {
        String message = "Nova dica criada: " + tip.getTitle() +
                " | Autor: " + tip.getAuthor().getName();

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                message
        );

        System.out.println(" [Producer] Mensagem enviada para fila: " + message);
    }
}
