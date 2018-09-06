package com.amazon.module.dao;

import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Address;
import com.amazon.module.entity.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * @author 岸久
 * @version 1.0
 * @datetime 2018.8.12 16:46
 * @describe 该dao处理地址表的操作
 * */
public interface AddressDao {

    /**
     * @function 通过地址id查询地址
     * @param aid 地址id
     * @return 地址信息
     * @datetime 2018.9.6 20:05
     * */
    Address queryAddressByAid(@Param("aid") String aid);

    /**
     * @function 存储新的地址
     * @param address 新地址信息
     * @return 操作结果
     * @datetime 2018.8.12 16:50
     * */
    int addNewAddress(Address address);

    /**
     * @function 获取我的所有地址
     * @param user_id 用户id
     * @return 当前用户的所有地址
     * @datetime 2018.8.12 17:57
     * */
    List<Address> queryMyAddress(@Param("userId") String user_id);

    /**
     * @function 将当前用户的所有地址设置为非默认状态
     * @param params 用户id
     * @return 更新的行数
     * @datetime 2018.8.12 19:04
     * */
    int updateAddressStatusToNull(ParamsDto params);

    /**
     * @function 将地址设置成默认地址
     * @param params 地址id 和 用户id
     * @return 更新的行数
     * @datetime 2018.8.12 19:06
     * */
    int updateAddressStatusToDefault(ParamsDto params);

    /**
     * @function 删除指定id的地址
     * @param params 地址id 和 用户id
     * @return 更新的行数
     * @datetime 2018.9.4 18:43
     * */
    int deleteMyAddressByAid(ParamsDto params);
}
