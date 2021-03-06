package com.platon.protocol.core.methods.response;

import com.platon.protocol.core.Response;
import com.platon.utils.Numeric;

import java.math.BigInteger;

/**
 * eth_getBlockTransactionCountByNumber.
 */
public class PlatonGetBlockTransactionCountByNumber extends Response<String> {
    public BigInteger getTransactionCount() {
        return Numeric.decodeQuantity(getResult());
    }
}
