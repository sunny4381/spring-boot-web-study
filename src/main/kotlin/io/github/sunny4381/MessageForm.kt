package io.github.sunny4381

import javax.validation.constraints.Size

class MessageForm {
    @Size(max = 10)
    var name: String = ""

    @Size(min = 5, max = 140)
    var text: String = ""
}
