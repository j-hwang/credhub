package org.cloudfoundry.credhub.handler

import org.cloudfoundry.credhub.views.BulkRegenerateResults
import org.cloudfoundry.credhub.views.CredentialView

interface RegenerateHandler {
    fun handleRegenerate(credentialName: String): CredentialView
    fun handleBulkRegenerate(signerName: String): BulkRegenerateResults
}
