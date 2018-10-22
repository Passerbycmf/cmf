package zjnu.cmf.project.system.service;

import zjnu.cmf.project.system.bean.Config;
import java.util.List;

/**
 * 参数配置 服务层
 * 
 * @author cmf
 * @date 2018-10-20
 */
public interface IConfigService 
{
	/**
     * 查询参数配置信息
     * 
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
	public Config selectConfigById(Integer configId);

	/**
	 * 根据键名查询参数配置信息
	 *
	 * @param configKey 参数键名
	 * @return 参数键值
	 */
	public String selectConfigByKey(String configKey);
	
	/**
     * 查询参数配置列表
     * 
     * @param config 参数配置信息
     * @return 参数配置集合
     */
	public List<Config> selectConfigList(Config config);
	
	/**
     * 新增参数配置
     * 
     * @param config 参数配置信息
     * @return 结果
     */
	public int insertConfig(Config config);
	
	/**
     * 修改参数配置
     * 
     * @param config 参数配置信息
     * @return 结果
     */
	public int updateConfig(Config config);
		
	/**
     * 删除参数配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteConfigByIds(String ids);

	/**
	 * 校验参数键名是否唯一
	 *
	 * @param config 参数信息
	 * @return 结果
	 */
	 String checkConfigKeyUnique(Config config);
}
