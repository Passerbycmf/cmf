package zjnu.cmf.project.monitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.project.monitor.mapper.LogininforMapper;
import zjnu.cmf.project.monitor.bean.Logininfor;
import zjnu.cmf.project.monitor.service.ILogininforService;
import zjnu.cmf.common.utils.Convert;

/**
 * 系统访问记录 服务层实现
 * 
 * @author cmf
 * @date 2018-10-11
 */
@Service
public class LogininforServiceImpl implements ILogininforService 
{
	@Autowired
	private LogininforMapper logininforMapper;

	/**
     * 查询系统访问记录信息
     * 
     * @param infoId 系统访问记录ID
     * @return 系统访问记录信息
     */
    @Override
	public Logininfor selectLogininforById(Integer infoId)
	{
	    return logininforMapper.selectLogininforById(infoId);
	}
	
	/**
     * 查询系统访问记录列表
     * 
     * @param logininfor 系统访问记录信息
     * @return 系统访问记录集合
     */
	@Override
	public List<Logininfor> selectLogininforList(Logininfor logininfor)
	{
	    return logininforMapper.selectLogininforList(logininfor);
	}
	
    /**
     * 新增系统访问记录
     * 
     * @param logininfor 系统访问记录信息
     * @return 结果
     */
	@Override
	public int insertLogininfor(Logininfor logininfor)
	{
	    return logininforMapper.insertLogininfor(logininfor);
	}
	
	/**
     * 修改系统访问记录
     * 
     * @param logininfor 系统访问记录信息
     * @return 结果
     */
	@Override
	public int updateLogininfor(Logininfor logininfor)
	{
	    return logininforMapper.updateLogininfor(logininfor);
	}

	/**
     * 删除系统访问记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLogininforByIds(String ids)
	{
		return logininforMapper.deleteLogininforByIds(Convert.toStrArray(ids));
	}
	
}
