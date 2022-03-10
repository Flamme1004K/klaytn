package com.test.kas

import com.test.kas.klaytnConsole.Caver
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import xyz.groundx.caver_ext_kas.rest_client.io.swagger.client.api.kip17.model.Kip17FeePayerOptions

class KIP17Test {

    val CAVER = Caver.instance

    @Test
    fun `KIP17 컨트랙트를 만든다`() {
        // given
        val name = "MFK12"
        val symbol = "MFK"
        val alias = "my-first-kip18"
        val option = Kip17FeePayerOptions().enableGlobalFeePayer(true)
        // when
        val deploy = CAVER.kas.kip17.deploy(name, symbol, alias, option)

        // then
        assertThat(deploy.status).isEqualToIgnoringCase("submitted")
    }

    @Test
    fun `KIP17를 조회한다`() {
        // given
        val contractList = CAVER.kas.kip17.contractList

        // when
        val aliasList = contractList.items.map { it.alias }

        // then
        assertThat(aliasList.contains("my-first-kip18"))
    }

    @Test
    fun `KIP17 토큰 발행`() {
        // given
        val contractAlias = "my-first-kip18"
        val to = "0x13ffA0049b684AFD4bA3E029219153C19D8e0970"
        val id = "0x1"
        val uri = "ipfs://QmRjtPYN5W1hNJEuuLz3CZNNDyETjU2jzGRnnmBMcBPQf5"

        // when
        val response = CAVER.kas.kip17.mint(contractAlias, to, id, uri)

        // then
        assertThat(response.status).isEqualToIgnoringCase("submitted")
    }


}