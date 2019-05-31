package com.ruoyi.project.system.tbGoods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.math.BigDecimal;

/**
 * 商品表 tb_goods
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
public class TbGoods extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long goodsId;
	/** 商品名 */
	private String name;
	/** 介绍 */
	private String intro;
	/** 价格 */
	private BigDecimal price;
	/** 数量 */
	private Integer num;

	public void setGoodsId(Long goodsId) 
	{
		this.goodsId = goodsId;
	}

	public Long getGoodsId() 
	{
		return goodsId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setIntro(String intro) 
	{
		this.intro = intro;
	}

	public String getIntro() 
	{
		return intro;
	}
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	public BigDecimal getPrice() 
	{
		return price;
	}
	public void setNum(Integer num) 
	{
		this.num = num;
	}

	public Integer getNum() 
	{
		return num;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("name", getName())
            .append("intro", getIntro())
            .append("price", getPrice())
            .append("num", getNum())
            .toString();
    }
}
