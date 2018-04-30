package io.github.sunny4381

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import javax.servlet.http.HttpServletRequest

@Controller
class MessageController(
        @Autowired
        private val service: MessageService
) {
    @GetMapping("/messages")
    fun messages(model: Model) : String {
        model.addAttribute("messageForm", MessageForm())

        val messages = service.getRecentMessages(100)
        model.addAttribute("messages", messages)

        return "messages"
    }

    @PostMapping("/messages")
    fun postMessages(@Validated form: MessageForm, result: BindingResult, model: Model, request: HttpServletRequest) : String {
        if (result.hasErrors()) {
//            model.addAttribute("messageForm", form)
//
            val messages = service.getRecentMessages(100)
            model.addAttribute("messages", messages)

            return "messages"
        }

        service.save(Message(form.name, form.text, request.remoteAddr))
        return "redirect:/messages"
    }
}
