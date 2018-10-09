package zjnu.cmf.project.system.mapper;


import org.apache.ibatis.annotations.Param;
import zjnu.cmf.project.system.bean.DictData;

import java.util.List;

/**
 * 字典数据 数据层
 * 
 * @author cmf
 * @date 2018-08-14
 */
public interface DictDataMapper 
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
     * 删除字典数据
     * 
     * @param dictCode 字典数据ID
     * @return 结果
     */
	public int deleteDictDataById(Integer dictCode);
	
	/**
     * 批量删除字典数据
     * 
     * @param dictCodes 需要删除的数据ID
     * @return 结果
     */
	public int deleteDictDataByIds(String[] dictCodes);

	/**
	 * 修改字典数据中的字典类型
	 * @param oldDictType 旧字典类型
	 * @param newDictType 新字典类型
	 */
    void updateDictDataType(@Param("oldDictType") String oldDictType,@Param("newDictType") String newDictType);


	int countDictDataByType(String dictType);
}