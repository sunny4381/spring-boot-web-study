package io.github.sunny4381

import java.util.*
import javax.persistence.*


@Entity
class Message() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = false)
    var text: String? = null

    @Column(nullable = false)
    var remoteAddr: String? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    var createdAt: Date? = null

    constructor(name: String, text: String, remoteAddr: String) : this() {
        this.name = name
        this.text = text
        this.remoteAddr = remoteAddr
    }

    @PrePersist
    fun prePersist() {
        this.createdAt = Date()
    }
}
