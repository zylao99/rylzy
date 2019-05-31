package com.ruoyi.project.system.tbGoods.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.tbGoods.domain.TbGoods;
import com.ruoyi.project.system.tbGoods.service.ITbGoodsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 商品信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-29
 */
@Controller
@RequestMapping("/system/tbGoods")
public class TbGoodsController extends BaseController
{
    private String prefix = "system/tbGoods";
	
	@Autowired
	private ITbGoodsService tbGoodsService;
	
	@RequiresPermissions("system:tbGoods:view")
	@GetMapping()
	public String tbGoods()
	{
	    return prefix + "/tbGoods";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("system:tbGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbGoods tbGoods)
	{
		startPage();
        List<TbGoods> list = tbGoodsService.selectTbGoodsList(tbGoods);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出商品列表
	 */
	@RequiresPermissions("system:tbGoods:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbGoods tbGoods)
    {
    	List<TbGoods> list = tbGoodsService.selectTbGoodsList(tbGoods);
        ExcelUtil<TbGoods> util = new ExcelUtil<TbGoods>(TbGoods.class);
        return util.exportExcel(list, "tbGoods");
    }
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("system:tbGoods:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbGoods tbGoods)
	{		
		return toAjax(tbGoodsService.insertTbGoods(tbGoods));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{goodsId}")
	public String edit(@PathVariable("goodsId") Long goodsId, ModelMap mmap)
	{
		TbGoods tbGoods = tbGoodsService.selectTbGoodsById(goodsId);
		mmap.put("tbGoods", tbGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("system:tbGoods:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbGoods tbGoods)
	{		
		return toAjax(tbGoodsService.updateTbGoods(tbGoods));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("system:tbGoods:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbGoodsService.deleteTbGoodsByIds(ids));
	}
	
}
