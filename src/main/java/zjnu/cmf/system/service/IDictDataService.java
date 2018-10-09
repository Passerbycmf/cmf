package zjnu.cmf.system.service;

import zjnu.cmf.system.bean.DictData;
import java.util.List;

/**
 * 字典数据 服务层
 * 
 * @author cmf
 * @date 2018-08-14
 */
public interface IDictDataService 
{
	/**
     * 查询字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据信息
     */
	public DictData selectDictDataById(Integer dictCode);
	
	/**
     * 查询字典数据列表
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合
     */
	public List<DictData> selectDictDataList(DictData dictData);
	
	/**
     * 新增字典数据
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
	public int insertDictData(DictData dictData);
	
	/**
     * 修改字典数据
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
	public int updateDictData(DictData dictData);
		
	/**
     * 删除字典数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDictDataByIds(String ids);
	
}
