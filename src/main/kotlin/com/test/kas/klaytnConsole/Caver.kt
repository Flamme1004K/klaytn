package com.test.kas.klaytnConsole

import xyz.groundx.caver_ext_kas.CaverExtKAS

object Caver {
    private const val CHAIN_ID = 1001
    private const val ACCESS_KEY_ID = "KASKOPO9IO8FLYY4XD0E525F"
    private const val SECRET_ACCESS_KEY = "SVT9U_Yx1yYimmz8Ws4tAgjGFXEuQGRJw8_xEO-c"

    val instance: CaverExtKAS = CaverExtKAS().apply {
        this.initKASAPI(CHAIN_ID, ACCESS_KEY_ID, SECRET_ACCESS_KEY)
    }
}