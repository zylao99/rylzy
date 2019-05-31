package com.ruoyi.project.system.tbGoods.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.tbGoods.mapper.TbGoodsMapper;
import com.ruoyi.project.system.tbGoods.domain.TbGoods;
import com.ruoyi.project.system.tbGoods.service.ITbGoodsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 商品 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
@Service
public class TbGoodsServiceImpl implements ITbGoodsService 
{
	@Autowired
	private TbGoodsMapper tbGoodsMapper;

	/**
     * 查询商品信息
     * 
     * @param goodsId 商品ID
     * @return 商品信息
     */
    @Override
	public TbGoods selectTbGoodsById(Long goodsId)
	{
	    return tbGoodsMapper.selectTbGoodsById(goodsId);
	}
	
	/**
     * 查询商品列表
     * 
     * @param tbGoods 商品信息
     * @return 商品集合
     */
	@Override
	public List<TbGoods> selectTbGoodsList(TbGoods tbGoods)
	{
	    return tbGoodsMapper.selectTbGoodsList(tbGoods);
	}
	
    /**
     * 新增商品
     * 
     * @param tbGoods 商品信息
     * @return 结果
     */
	@Override
	public int insertTbGoods(TbGoods tbGoods)
	{
	    return tbGoodsMapper.insertTbGoods(tbGoods);
	}
	
	/**
     * 修改商品
     * 
     * @param tbGoods 商品信息
     * @return 结果
     */
	@Override
	public int updateTbGoods(TbGoods tbGoods)
	{
	    return tbGoodsMapper.updateTbGoods(tbGoods);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbGoodsByIds(String ids)
	{
		return tbGoodsMapper.deleteTbGoodsByIds(Convert.toStrArray(ids));
	}
	
}
