package br.com.workconnect.service;

import br.com.workconnect.messaging.TipProducer;
import br.com.workconnect.model.Tip;
import br.com.workconnect.model.User;
import br.com.workconnect.repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipService {

    private final TipRepository tipRepository;
    private final TipProducer tipProducer;

    @CacheEvict(value = "tipsList", allEntries = true)
    public Tip createTip(Tip tip, User author) {
        tip.setAuthor(author);
        Tip saved = tipRepository.save(tip);
        tipProducer.sendTipCreatedMessage(saved);
        return saved;
    }

    @Cacheable("tipsList")
    public Page<Tip> getTipsPaginated(int page, int size) {
        System.out.println("Consultando dicas no banco...");
        return tipRepository.findAll(PageRequest.of(page, size));
    }

    public Tip findById(Long id) {
        return tipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dica não encontrada."));
    }
}
