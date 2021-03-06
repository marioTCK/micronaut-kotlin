package io.micronaut.ktor.server

import io.ktor.server.engine.ApplicationEngineEnvironment
import io.ktor.server.tomcat.Tomcat
import io.ktor.server.tomcat.TomcatApplicationEngine
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Requires
import io.micronaut.http.server.HttpServerConfiguration
import io.micronaut.ktor.KotrApplication
import javax.inject.Singleton

@Singleton
@Requires(classes = arrayOf(Tomcat::class))
class KotrTomcatEmbeddedServer(
        override val ctx: ApplicationContext,
        override val serverConfiguration: HttpServerConfiguration,
        override val engineEnvironment: ApplicationEngineEnvironment,
        val kotrApplication: KotrApplication<TomcatApplicationEngine.Configuration>) : AbstractKotrEmbeddedServer(
        ctx,
        serverConfiguration,
        engineEnvironment,
        Tomcat.create(engineEnvironment, kotrApplication.configuration)
)