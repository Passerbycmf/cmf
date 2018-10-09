package zjnu.cmf.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.constant.UserConstants;
import zjnu.cmf.common.utils.Convert;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.project.system.bean.DictType;
import zjnu.cmf.project.system.mapper.DictDataMapper;
import zjnu.cmf.project.system.mapper.DictTypeMapper;
import zjnu.cmf.project.system.service.IDictTypeService;


/**
 * 字典类型 服务层实现
 * 
 * @author cmf
 * @date 2018-08-14
 */
@Service
public class DictTypeServiceImpl implements IDictTypeService
{
	@Autowired
	private DictTypeMapper dictTypeMapper;

	@Autowired
	private DictDataMapper dictDataMapper;

	/**
     * 查询字典类型信息
     * 
     * @param dictId 字典类型ID
     * @return 字典类型信息
     */
    @Override
	public DictType selectDictTypeById(Integer dictId)
	{
	    return dictTypeMapper.selectDictTypeById(dictId);
	}
	
	/**
     * 查询字典类型列表
     * 
     * @param dictType 字典类型信息
     * @return 字典类型集合
     */
	@Override
	public List<DictType> selectDictTypeList(DictType dictType)
	{
	    return dictTypeMapper.selectDictTypeList(dictType);
	}
	
    /**
     * 新增字典类型
     * 
     * @param dictType 字典类型信息
     * @return 结果
     */
	@Override
	public int insertDictType(DictType dictType)
	{
        //还需要新增创建者
		return dictTypeMapper.insertDictType(dictType);
	}
	
	/**
     * 修改字典类型
     * 
     * @param dictType 字典类型信息
     * @return 结果
     */
	@Override
	public int updateDictType(DictType dictType)
	{
        //还需要更新更新者

		//修改字典数据中的字典类型
		//查出修改前的字典类型
		DictType oldDictType = dictTypeMapper.selectDictTypeById(dictType.getDictId());
		//修改
		dictDataMapper.updateDictDataType(oldDictType.getDictType(),dictType.getDictType());
		return dictTypeMapper.updateDictType(dictType);
	}

	/**
     * 删除字典类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDictTypeByIds(String ids) throws Exception
	{
		//将integer类型转换成int数组
        Integer[] dictIds = Convert.toIntArray(ids);
        //遍历
        for (Integer dictId : dictIds){
        	DictType dictType = selectDictTypeById(dictId);
        	//根据字典类型查
        	if(dictDataMapper.countDictDataByType(dictType.getDictType()) > 0 ){
        		throw new Exception(String.format("该字典已分配，不能删除",dictType.getDictName()));
			}
		}
		return dictTypeMapper.deleteDictTypeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 校验字典类型是否唯一
	 * @param dictType
	 * @return
	 */
	@Override
	public String checkDictTypeUnique(DictType dictType) {
		Long dictId = StringUtils.isNull(dictType.getDictId()) ? -1L : dictType.getDictId();
		DictType type =dictTypeMapper.checkDictTypeUnique(dictType.getDictType());
		if (StringUtils.isNotNull(type) && type.getDictId().longValue() != dictId.longValue()){
			return UserConstants.DICT_TYPE_NOT_UNIQUE;
		}
		return UserConstants.DICT_TYPE_UNIQUE;
	}

	/**
	 * 校验字典名称是否唯一
	 * @param dict
	 * @return
	 */
	@Override
	public String checkDictNameUnique(DictType dict) {
		Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
		DictType dictType = dictTypeMapper.checkDictNameUnique(dict.getDictName());
		if(StringUtils.isNotNull(dictType) && dictType.getDictId().longValue() != dictId.longValue() ){
			return UserConstants.DICT_NAME_NOT_UNIQUE;
		}
		return UserConstants.DICT_NAME_UNIQUE;
	}

	/**
	 *根据所有字典类型
	 * @return
	 */
	@Override
	public List<DictType> selectDictTypeAll()
	{
		return dictTypeMapper.selectDictTypeAll();
	}


}
