package com.alaya.contracts.ppos;

import com.alaya.contracts.ppos.abi.Function;
import com.alaya.contracts.ppos.dto.common.FunctionType;
import com.alaya.contracts.ppos.dto.resp.Node;
import com.alaya.contracts.ppos.dto.CallResponse;
import com.alaya.parameters.NetworkParameters;
import com.alaya.crypto.Credentials;
import com.alaya.protocol.Web3j;
import com.alaya.protocol.core.RemoteCall;

import java.util.List;

public class NodeContract extends BaseContract {

	/**
	 * 加载合约, 默认ReadonlyTransactionManager事务管理
	 *
	 * @param web3j
	 * @return
	 */
    public static NodeContract load(Web3j web3j, long chainId) {
        return new NodeContract(NetworkParameters.getPposContractAddressOfStaking(chainId), web3j);
    }

    /**
     * 加载合约, 默认RawTransactionManager事务管理
     *
     * @param web3j
     * @param credentials
     * @param chainId
     * @return
     */
    public static NodeContract load(Web3j web3j, Credentials credentials, long chainId) {
        return new NodeContract(NetworkParameters.getPposContractAddressOfStaking(chainId), chainId, web3j, credentials);
    }

    private NodeContract(String contractAddress, Web3j web3j) {
        super(contractAddress, web3j);
    }

    private NodeContract(String contractAddress, long chainId, Web3j web3j, Credentials credentials) {
        super(contractAddress, chainId, web3j, credentials);
    }

    /**
     * 查询当前结算周期的验证人队列
     *
     * @return
     */
    public RemoteCall<CallResponse<List<Node>>> getVerifierList() {
        Function function = new Function(FunctionType.GET_VERIFIERLIST_FUNC_TYPE);
        return executeRemoteCallListValueReturn(function, Node.class);
    }

    /**
     * 查询当前共识周期的验证人列表
     *
     * @return
     */
    public RemoteCall<CallResponse<List<Node>>> getValidatorList() {
        Function function = new Function(FunctionType.GET_VALIDATORLIST_FUNC_TYPE);
        return executeRemoteCallListValueReturn(function, Node.class);
    }

    /**
     * 查询所有实时的候选人列表
     *
     * @return
     */
    public RemoteCall<CallResponse<List<Node>>> getCandidateList() {
        Function function = new Function(FunctionType.GET_CANDIDATELIST_FUNC_TYPE);
        return executeRemoteCallListValueReturn(function, Node.class);
    }
}
