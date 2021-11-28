package com.example.accountservera.mapper;

import com.example.accountservera.pojo.FreezeAccount;
import org.apache.ibatis.annotations.Param;

/**
 * @author junyangwei
 * @date 2021-11-28
 */
public interface AccountMapper {
    /**
     * 更新美元账户
     * @param dollar 要加/减的美元：如 +10 表示添加10美元，-10 表示扣除10美元
     * @param userId 美元账户 ID
     * @return int
     */
    Integer updateAccountDollar(@Param("dollar") Double dollar,
                                @Param("userId") Integer userId);

    /**
     * 更新人民币账户
     * @param yuan 要加/减的元：如 +10 表示添加10元，-10 表示扣除10元
     * @param userId 人民币账户 ID
     * @return int
     */
    Integer updateAccountYuan(@Param("yuan") Double yuan,
                              @Param("userId") Integer userId);

    /**
     * 添加冻结账户信息
     * @param freezeAccount 冻结账户信息对象
     * @return int
     */
    Integer insertFreezeAccount(FreezeAccount freezeAccount);

    /**
     * 更新冻结账户信息状态
     * @param status 0无效 1生效中 2已结束
     * @return int
     */
    Integer updateFreezeAccountStatus(@Param("status") Integer status,
                                      @Param("transactionId") Long transactionId);
}
