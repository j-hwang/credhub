package org.cloudfoundry.credhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "currentTimeProvider")
class CredhubTestApp
