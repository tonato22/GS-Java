package br.com.workconnect.messaging;

import br.com.workconnect.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TipConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveTipMessage(String message) {
        System.out.println("📥 Mensagem recebida na fila '"
                + RabbitMQConfig.QUEUE_NAME + "': " + message);

        // Aqui você poderá futuramente:
        // - enviar e-mail
        // - salvar log
        // - atualizar dashboard em tempo real
        // - qualquer processador assíncrono
    }
}
