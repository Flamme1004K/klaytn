package com.test.kas

import com.test.kas.klaytnConsole.Caver
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KlaytnWalletTest {

    @Test
    fun `address로 walletAccount을 조회한다`() {
        // given
        val address = "0x13ffA0049b684AFD4bA3E029219153C19D8e0970"
        val caver = Caver.instance
        // when
        val account = caver.kas.wallet.getAccount(address)

        // then
        assertThat(address).isEqualTo(account.address)
    }

    @Test
    fun `publickey로 walletAccount를 조회한다`() {
        // given
        val publicKey = "0x048955a975645c8cc1b215e622fb437ffee7ec8d7b5ad51c704f73eb3adc690038f7c46065ff8d653ab0c0c7f073fe5419a0878da4c7274db4b49ae50f0a9072e6"
        val address = "0x13ffA0049b684AFD4bA3E029219153C19D8e0970"
        val caver = Caver.instance

        // when
        val account = caver.kas.wallet.getAccountListByPublicKey(publicKey)

        // then
        assertThat(account.items.map { it.address }.contains(address))
    }
}