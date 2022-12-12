package com.arconsis.recommendationcoreservice.common

import java.util.logging.Logger
import javax.enterprise.context.Dependent
import javax.enterprise.inject.spi.InjectionPoint

class LoggerProducer {

    @Dependent
    fun createLogger(injectionPoint: InjectionPoint): Logger {
        return Logger.getLogger(injectionPoint.member.declaringClass.name)
    }

}