package zjnu.cmf.project.service;

import zjnu.cmf.project.bean.DictType;
import java.util.List;

/**
 * 字典类型 服务层
 * 
 * @author cmf
 * @date 2018-08-14
 */
public interface IDictTypeService 
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
     * 删除字典类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDictTypeByIds(String ids) throws Exception;

	/**
	 * 校验字典类型是否唯一
	 * @param dictType
	 * @return
	 */
	String checkDictTypeUnique(DictType dictType);

	/**
	 * 校验字典名称是否唯一
	 * @param dict
	 * @return
	 */
	String checkDictNameUnique(DictType dict);
}
