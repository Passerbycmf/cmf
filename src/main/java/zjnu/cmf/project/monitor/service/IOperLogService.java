package zjnu.cmf.project.monitor.service;

import zjnu.cmf.project.monitor.bean.OperLog;
import java.util.List;

/**
 * 操作日志记录 服务层
 * 
 * @author cmf
 * @date 2018-10-09
 */
public interface IOperLogService 
{
	/**
     * 查询操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录信息
     */
	public OperLog selectOperLogById(Integer operId);
	
	/**
     * 查询操作日志记录列表
     * 
     * @param operLog 操作日志记录信息
     * @return 操作日志记录集合
     */
	public List<OperLog> selectOperLogList(OperLog operLog);
	
	/**
     * 新增操作日志记录
     * 
     * @param operLog 操作日志记录信息
     * @return 结果
     */
	public int insertOperLog(OperLog operLog);
	
	/**
     * 修改操作日志记录
     * 
     * @param operLog 操作日志记录信息
     * @return 结果
     */
	public int updateOperLog(OperLog operLog);
		
	/**
     * 删除操作日志记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOperLogByIds(String ids);
	
}
