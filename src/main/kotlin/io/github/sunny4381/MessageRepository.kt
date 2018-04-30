package io.github.sunny4381

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : CrudRepository<Message, Long> {
    fun findByOrderByIdDesc(pageable: Pageable): List<Message>
}
