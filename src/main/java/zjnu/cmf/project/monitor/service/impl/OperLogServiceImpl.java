package zjnu.cmf.project.monitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.project.monitor.mapper.OperLogMapper;
import zjnu.cmf.project.monitor.bean.OperLog;
import zjnu.cmf.project.monitor.service.IOperLogService;
import zjnu.cmf.common.utils.Convert;

/**
 * 操作日志记录 服务层实现
 * 
 * @author cmf
 * @date 2018-10-09
 */
@Service
public class OperLogServiceImpl implements IOperLogService 
{
	@Autowired
	private OperLogMapper operLogMapper;

	/**
     * 查询操作日志记录信息
     * 
     * @param operId 操作日志记录ID
     * @return 操作日志记录信息
     */
    @Override
	public OperLog selectOperLogById(Integer operId)
	{
	    return operLogMapper.selectOperLogById(operId);
	}
	
	/**
     * 查询操作日志记录列表
     * 
     * @param operLog 操作日志记录信息
     * @return 操作日志记录集合
     */
	@Override
	public List<OperLog> selectOperLogList(OperLog operLog)
	{
	    return operLogMapper.selectOperLogList(operLog);
	}
	
    /**
     * 新增操作日志记录
     * 
     * @param operLog 操作日志记录信息
     * @return 结果
     */
	@Override
	public int insertOperLog(OperLog operLog)
	{
	    return operLogMapper.insertOperLog(operLog);
	}
	
	/**
     * 修改操作日志记录
     * 
     * @param operLog 操作日志记录信息
     * @return 结果
     */
	@Override
	public int updateOperLog(OperLog operLog)
	{
	    return operLogMapper.updateOperLog(operLog);
	}

	/**
     * 删除操作日志记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOperLogByIds(String ids)
	{
		return operLogMapper.deleteOperLogByIds(Convert.toStrArray(ids));
	}
	
}
