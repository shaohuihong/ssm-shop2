package com.shh.mapper;

import com.shh.entity.Carts;
import org.apache.ibatis.annotations.Param;

public interface CartsMapper {
    // 根据商品id 和用户id查询商品是否存在
    Carts selectByMidAndPid(@Param("mid") int mid,@Param("pid") int pid) throws Exception;

    // 根据商品商品id 修改商品数量
    int updateById(@Param("cartId") int cartId,@Param("count") int count) throws Exception;

    // 添加商品到购物车
    int insert(@Param("carts") Carts carts) throws Exception;
}