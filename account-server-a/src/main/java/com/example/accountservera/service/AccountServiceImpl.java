package com.example.accountservera.service;

import com.example.accountservera.mapper.AccountMapper;
import com.example.accountservera.pojo.FreezeAccount;
import com.example.demo.api.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author junyangwei
 * @date 2021-11-28
 */
@Service("accountServiceA")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    /**
     * 账户操作：将用户ID为1的美元账后扣减1元，并且人命币账号增加7.0
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean accountExchange() {
        // 构造 demo 数据：userId为1的用户，美元要扣减1.0，人民币要增加7.0，本次事务模拟ID为112233
        int userId = 1;
        double addDollar = -1.0;
        double addYuan = +7.0;
        long transactionId = 112233;

        // 构造冻结金额
        FreezeAccount freezeAccount = new FreezeAccount();
        freezeAccount.setTransactionId(transactionId);
        freezeAccount.setUserId(userId);
        freezeAccount.setFreezeDollar(-addDollar);
        freezeAccount.setFreezeYuan(-addYuan);

        // 进行预处理：扣减美元，并添加冻结金额数据
        accountMapper.updateAccountDollar(-1.0, 1);
        accountMapper.insertFreezeAccount(freezeAccount);

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean confirm() {
        accountMapper.updateAccountYuan(7.0, 1);
        accountMapper.updateFreezeAccountStatus(2, 112233L);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancel() {
        accountMapper.updateAccountDollar(1.0, 1);
        accountMapper.updateFreezeAccountStatus(0, 112233L);
        return true;
    }
}
