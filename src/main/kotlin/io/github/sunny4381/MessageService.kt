package io.github.sunny4381

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.transaction.annotation.Transactional

@Service
open class MessageService(
        @Autowired
        private val repository: MessageRepository
) {
    open fun getRecentMessages(n: Int): List<Message> {
        return repository.findByOrderByIdDesc(PageRequest(0, n))
    }

    @Transactional
    open fun save(message: Message) {
        repository.save(message)
    }
}
