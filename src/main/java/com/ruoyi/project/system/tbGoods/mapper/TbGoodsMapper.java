package com.ruoyi.project.system.tbGoods.mapper;

import com.ruoyi.project.system.tbGoods.domain.TbGoods;
import java.util.List;	

/**
 * 商品 数据层
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
public interface TbGoodsMapper 
{
	/**
     * 查询商品信息
     * 
     * @param goodsId 商品ID
     * @return 商品信息
     */
	public TbGoods selectTbGoodsById(Long goodsId);
	
	/**
     * 查询商品列表
     * 
     * @param tbGoods 商品信息
     * @return 商品集合
     */
	public List<TbGoods> selectTbGoodsList(TbGoods tbGoods);
	
	/**
     * 新增商品
     * 
     * @param tbGoods 商品信息
     * @return 结果
     */
	public int insertTbGoods(TbGoods tbGoods);
	
	/**
     * 修改商品
     * 
     * @param tbGoods 商品信息
     * @return 结果
     */
	public int updateTbGoods(TbGoods tbGoods);
	
	/**
     * 删除商品
     * 
     * @param goodsId 商品ID
     * @return 结果
     */
	public int deleteTbGoodsById(Long goodsId);
	
	/**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbGoodsByIds(String[] goodsIds);
	
}