package zjnu.cmf.project.mapper;

import org.apache.ibatis.annotations.Param;
import zjnu.cmf.project.bean.DictType;

import java.util.List;

/**
 * 字典类型 数据层
 * 
 * @author cmf
 * @date 2018-08-14
 */
public interface DictTypeMapper 
{
	/**
     * 查询字典类型信息
     * 
     * @param dictId 字典类型ID
     * @return 字典类型信息
     */
	public DictType selectDictTypeById(Integer dictId);
	
	/**
     * 查询字典类型列表
     * 
     * @param dictType 字典类型信息
     * @return 字典类型集合
     */
	public List<DictType> selectDictTypeList(DictType dictType);
	
	/**
     * 新增字典类型
     * 
     * @param dictType 字典类型信息
     * @return 结果
     */
	public int insertDictType(DictType dictType);
	
	/**
     * 修改字典类型
     * 
     * @param dictType 字典类型信息
     * @return 结果
     */
	public int updateDictType(DictType dictType);
	
	/**
     * 删除字典类型
     * 
     * @param dictId 字典类型ID
     * @return 结果
     */
	public int deleteDictTypeById(Integer dictId);
	
	/**
     * 批量删除字典类型
     * 
     * @param dictIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDictTypeByIds(String[] dictIds);

	/**
	 * 校验字典数据类型是否唯一
	 * @param dictType
	 * @return
	 */
    DictType checkDictTypeUnique(String dictType);

	/**
	 * 校验字典名称是否唯一
	 * @param dictName
	 * @return
	 */
	DictType checkDictNameUnique(String dictName);


}