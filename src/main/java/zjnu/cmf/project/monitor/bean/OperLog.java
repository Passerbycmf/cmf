package zjnu.cmf.project.monitor.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
	private Integer operId;
	/** 模块标题 */
	private String title;
	/** 功能请求 */
	private String action;
	/** 方法名称 */
	private String method;
	/** 来源渠道（manage后台用户 mobile手机端用户 other其它） */
	private String channel;
	/** 操作人员 */
	private String operName;
	/** 部门名称 */
	private String deptName;
	/** 请求URL */
	private String operUrl;
	/** 主机地址 */
	private String operIp;
	/** 操作地点 */
	private String operLocation;
	/** 请求参数 */
	private String operParam;
	/** 操作状态（0正常 1异常） */
	private String status;
	/** 错误消息 */
	private String errorMsg;
	/** 操作时间 */
	private Date operTime;

	public void setOperId(Integer operId) 
	{
		this.operId = operId;
	}

	public Integer getOperId() 
	{
		return operId;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setAction(String action) 
	{
		this.action = action;
	}

	public String getAction() 
	{
		return action;
	}
	public void setMethod(String method) 
	{
		this.method = method;
	}

	public String getMethod() 
	{
		return method;
	}
	public void setChannel(String channel) 
	{
		this.channel = channel;
	}

	public String getChannel() 
	{
		return channel;
	}
	public void setOperName(String operName) 
	{
		this.operName = operName;
	}

	public String getOperName() 
	{
		return operName;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}

	public String getDeptName() 
	{
		return deptName;
	}
	public void setOperUrl(String operUrl) 
	{
		this.operUrl = operUrl;
	}

	public String getOperUrl() 
	{
		return operUrl;
	}
	public void setOperIp(String operIp) 
	{
		this.operIp = operIp;
	}

	public String getOperIp() 
	{
		return operIp;
	}
	public void setOperLocation(String operLocation) 
	{
		this.operLocation = operLocation;
	}

	public String getOperLocation() 
	{
		return operLocation;
	}
	public void setOperParam(String operParam) 
	{
		this.operParam = operParam;
	}

	public String getOperParam() 
	{
		return operParam;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setErrorMsg(String errorMsg) 
	{
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() 
	{
		return errorMsg;
	}
	public void setOperTime(Date operTime) 
	{
		this.operTime = operTime;
	}

	public Date getOperTime() 
	{
		return operTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("operId", getOperId())
            .append("title", getTitle())
            .append("action", getAction())
            .append("method", getMethod())
            .append("channel", getChannel())
            .append("operName", getOperName())
            .append("deptName", getDeptName())
            .append("operUrl", getOperUrl())
            .append("operIp", getOperIp())
            .append("operLocation", getOperLocation())
            .append("operParam", getOperParam())
            .append("status", getStatus())
            .append("errorMsg", getErrorMsg())
            .append("operTime", getOperTime())
            .toString();
    }
}
