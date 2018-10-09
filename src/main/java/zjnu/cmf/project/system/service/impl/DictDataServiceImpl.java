package zjnu.cmf.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.utils.Convert;
import zjnu.cmf.project.system.bean.DictData;
import zjnu.cmf.project.system.mapper.DictDataMapper;
import zjnu.cmf.project.system.service.IDictDataService;

/**
 * 字典数据 服务层实现
 * 
 * @author cmf
 * @date 2018-08-14
 */
@Service
public class DictDataServiceImpl implements IDictDataService
{
	@Autowired
	private DictDataMapper dictDataMapper;

	/**
     * 查询字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据信息
     */
    @Override
	public DictData selectDictDataById(Integer dictCode)
	{
	    return dictDataMapper.selectDictDataById(dictCode);
	}
	
	/**
     * 查询字典数据列表
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合
     */
	@Override
	public List<DictData> selectDictDataList(DictData dictData)
	{
	    return dictDataMapper.selectDictDataList(dictData);
	}
	
    /**
     * 新增字典数据
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
	@Override
	public int insertDictData(DictData dictData)
	{
	    return dictDataMapper.insertDictData(dictData);
	}
	
	/**
     * 修改字典数据
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
	@Override
	public int updateDictData(DictData dictData)
	{
	    return dictDataMapper.updateDictData(dictData);
	}

	/**
     * 删除字典数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDictDataByIds(String ids)
	{
		return dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
	}
	
}
