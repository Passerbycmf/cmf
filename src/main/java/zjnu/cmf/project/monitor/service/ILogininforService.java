package zjnu.cmf.project.monitor.service;

import zjnu.cmf.project.monitor.bean.Logininfor;
import java.util.List;

/**
 * 系统访问记录 服务层
 * 
 * @author cmf
 * @date 2018-10-11
 */
public interface ILogininforService 
{
	/**
     * 查询系统访问记录信息
     * 
     * @param infoId 系统访问记录ID
     * @return 系统访问记录信息
     */
	public Logininfor selectLogininforById(Integer infoId);
	
	/**
     * 查询系统访问记录列表
     * 
     * @param logininfor 系统访问记录信息
     * @return 系统访问记录集合
     */
	public List<Logininfor> selectLogininforList(Logininfor logininfor);
	
	/**
     * 新增系统访问记录
     * 
     * @param logininfor 系统访问记录信息
     * @return 结果
     */
	public int insertLogininfor(Logininfor logininfor);
	
	/**
     * 修改系统访问记录
     * 
     * @param logininfor 系统访问记录信息
     * @return 结果
     */
	public int updateLogininfor(Logininfor logininfor);
		
	/**
     * 删除系统访问记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteLogininforByIds(String ids);
	
}
