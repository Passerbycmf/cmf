package zjnu.cmf.project.system.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.cmf.framework.aspectj.lang.annotation.Excel;
import zjnu.cmf.framework.web.BaseEntity;
import java.util.Date;

/**
 * 参数配置表 sys_config
 * 
 * @author cmf
 * @date 2018-10-20
 */
public class Config extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 参数主键 */
	@Excel(name = "参数主键")
	private Integer configId;

	/** 参数名称 */
	@Excel(name = "参数名称")
	private String configName;

	/** 参数键名 */
	@Excel(name = "参数键名")
	private String configKey;

	/** 参数键值 */
	@Excel(name = "参数键值")
	private String configValue;

	/** 系统内置（Y是 N否） */
	@Excel(name = "系统内置")
	private String configType;

	public Integer getConfigId()
	{
		return configId;
	}

	public void setConfigId(Integer configId)
	{
		this.configId = configId;
	}

	public String getConfigName()
	{
		return configName;
	}

	public void setConfigName(String configName)
	{
		this.configName = configName;
	}

	public String getConfigKey()
	{
		return configKey;
	}

	public void setConfigKey(String configKey)
	{
		this.configKey = configKey;
	}

	public String getConfigValue()
	{
		return configValue;
	}

	public void setConfigValue(String configValue)
	{
		this.configValue = configValue;
	}

	public String getConfigType()
	{
		return configType;
	}

	public void setConfigType(String configType)
	{
		this.configType = configType;
	}

}
