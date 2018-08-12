package zjnu.cmf.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.utils.Convert;
import zjnu.cmf.project.bean.Menu;

import zjnu.cmf.project.mapper.MenuMapper;
import zjnu.cmf.project.service.IMenuService;


/**
 * 菜单权限 服务层实现
 * 
 * @author cmf
 * @date 2018-08-12
 */
@Service
public class MenuServiceImpl implements IMenuService
{
	@Autowired
	private MenuMapper menuMapper;

	/**
     * 查询菜单权限信息
     * 
     * @param menuId 菜单权限ID
     * @return 菜单权限信息
     */
    @Override
	public Menu selectMenuById(Integer menuId)
	{
	    return menuMapper.selectMenuById(menuId);
	}
	
	/**
     * 查询菜单权限列表
     * 
     * @param menu 菜单权限信息
     * @return 菜单权限集合
     */
	@Override
	public List<Menu> selectMenuList(Menu menu)
	{
	    return menuMapper.selectMenuList(menu);
	}
	
    /**
     * 新增菜单权限
     * 
     * @param menu 菜单权限信息
     * @return 结果
     */
	@Override
	public int insertMenu(Menu menu)
	{
	    return menuMapper.insertMenu(menu);
	}
	
	/**
     * 修改菜单权限
     * 
     * @param menu 菜单权限信息
     * @return 结果
     */
	@Override
	public int updateMenu(Menu menu)
	{
	    return menuMapper.updateMenu(menu);
	}

	/**
     * 删除菜单权限对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMenuByIds(String ids)
	{
		return menuMapper.deleteMenuByIds(Convert.toStrArray(ids));
	}
	
}
