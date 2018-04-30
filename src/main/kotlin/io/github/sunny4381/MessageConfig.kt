package io.github.sunny4381

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.Validator


@Configuration
open class MessageConfig : WebMvcConfigurerAdapter() {
    @Bean
    open fun messageSource(): ReloadableResourceBundleMessageSource {
        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasenames("classpath:i18n/messages") //（※２）
        messageSource.setCacheSeconds(0)
        messageSource.setDefaultEncoding("UTF-8")
        return messageSource
    }

    @Bean
    open fun validator(): LocalValidatorFactoryBean {
        val localValidatorFactoryBean = LocalValidatorFactoryBean()
        localValidatorFactoryBean.setValidationMessageSource(messageSource())
        return localValidatorFactoryBean
    }

    override fun getValidator(): Validator {  //（※３）
        return validator()
    }
}
