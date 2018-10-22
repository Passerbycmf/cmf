package zjnu.cmf.project.monitor.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import zjnu.cmf.framework.aspectj.lang.annotation.Excel;
import zjnu.cmf.framework.web.BaseEntity;
import java.util.Date;

/**
 * 操作日志记录表 sys_oper_log
 * 
 * @author cmf
 * @date 2018-10-09
 */
public class OperLog extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 日志主键 */
	@Excel(name = "操作序号")
	private Integer operId;

	/** 操作模块 */
	@Excel(name = "操作模块")
	private String title;

	/** 操作类型 */
	@Excel(name = "操作类型")
	private String action;

	/** 请求方法 */
	@Excel(name = "请求方法")
	private String method;

	/** 来源渠道 */
	@Excel(name = "来源渠道")
	private String channel;

	/** 操作人员 */
	@Excel(name = "操作人员")
	private String operName;

	/** 部门名称 */
	@Excel(name = "部门名称")
	private String deptName;

	/** 请求url */
	@Excel(name = "请求地址")
	private String operUrl;

	/** 操作地址 */
	@Excel(name = "操作地址")
	private String operIp;

	/** 操作地点 */
	@Excel(name = "操作地点")
	private String operLocation;

	/** 请求参数 */
	@Excel(name = "请求参数")
	private String operParam;

	/** 状态0正常 1异常 */
	@Excel(name = "状态")
	private String status;

	/** 错误消息 */
	@Excel(name = "错误消息")
	private String errorMsg;

	/** 操作时间 */
	@Excel(name = "操作时间")
	private Date operTime;

	public Integer getOperId()
	{
		return operId;
	}

	public void setOperId(Integer operId)
	{
		this.operId = operId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getChannel()
	{
		return channel;
	}

	public void setChannel(String channel)
	{
		this.channel = channel;
	}

	public String getOperName()
	{
		return operName;
	}

	public void setOperName(String operName)
	{
		this.operName = operName;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	public String getOperUrl()
	{
		return operUrl;
	}

	public void setOperUrl(String operUrl)
	{
		this.operUrl = operUrl;
	}

	public String getOperIp()
	{
		return operIp;
	}

	public void setOperIp(String operIp)
	{
		this.operIp = operIp;
	}

	public String getOperLocation()
	{
		return operLocation;
	}

	public void setOperLocation(String operLocation)
	{
		this.operLocation = operLocation;
	}

	public String getOperParam()
	{
		return operParam;
	}

	public void setOperParam(String operParam)
	{
		this.operParam = operParam;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

	public Date getOperTime()
	{
		return operTime;
	}

	public void setOperTime(Date operTime)
	{
		this.operTime = operTime;
	}

	@Override
	public String toString()
	{
		return "OperLog [operId=" + operId + ", title=" + title + ", action=" + action + ", method=" + method
				+ ", channel=" + channel + ", operName=" + operName + ", deptName=" + deptName + ", operUrl=" + operUrl
				+ ", operIp=" + operIp + ", operLocation=" + operLocation + ", operParam=" + operParam + ", status="
				+ status + ", errorMsg=" + errorMsg + ", operTime=" + operTime + "]";
	}

}
