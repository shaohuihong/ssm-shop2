package com.shh.service.Impl;
import com.shh.entity.Carts;
import com.shh.entity.Product;
import com.shh.mapper.CartsMapper;
import com.shh.service.CartsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 添加商品到购物车
 * 商品存在则更新商品的数量
 * 否则将商品添加到购物车
 */
@Service
public class CartsServiceImpl implements CartsService {
    @Resource
    CartsMapper cartsMapper;
    @Transactional
    public int add(int mid, int quantity, Product product) throws Exception{
        int count=0;
        /**
         * 首先查询购物车中是否存在该条记录
         */
        Carts carts = cartsMapper.selectByMidAndPid(mid, product.getPid());
        // 如果存在的话则修改购物车商品数量
        if (carts!=null) {
            // 购物车商品的数量变为原数量加上购买的数量
            quantity +=carts.getQuantity();
            // count>0 在表示修改成功
            count = cartsMapper.updateById(carts.getCartId(), quantity);
        } else {
            // 如果商品不存在则添加商品
            carts=new Carts();
            carts.setMemberId(mid);
            carts.setQuantity(quantity);
            carts.setPid(product.getPid());
            count = cartsMapper.insert(carts);
        }
        return count;
    }
}
