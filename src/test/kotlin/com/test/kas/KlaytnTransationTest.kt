package com.test.kas

import com.test.kas.klaytnConsole.Caver
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import xyz.groundx.caver_ext_kas.rest_client.io.swagger.client.api.wallet.model.ContractDeployTransactionRequest
import xyz.groundx.caver_ext_kas.rest_client.io.swagger.client.api.wallet.model.ValueTransferTransactionRequest

class KlaytnTransationTest {

    val CAVER = Caver.instance

    @Test
    fun `클레이튼코인을 보낸다`() {
        // given
        val request = ValueTransferTransactionRequest()
        request.from("0x13ffA0049b684AFD4bA3E029219153C19D8e0970")
        request.to("0xFB8Eb3e8301D2D543130f53707a850DC27145791")
        request.value("0x1")
        request.submit(true)


        // when
        val transactionResult = CAVER.kas.wallet.requestValueTransfer(request)

        // then
        assertThat(transactionResult.status).isEqualToIgnoringCase("Submitted")
    }


}