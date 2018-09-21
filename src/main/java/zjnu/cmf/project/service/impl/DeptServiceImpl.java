package zjnu.cmf.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjnu.cmf.common.constant.UserConstants;
import zjnu.cmf.common.utils.StringUtils;
import zjnu.cmf.project.bean.Dept;
import zjnu.cmf.project.mapper.DeptMapper;
import zjnu.cmf.project.service.IDeptService;


/**
 * 部门 服务层实现
 * 
 * @author cmf
 * @date 2018-08-12
 */
@Service
public class DeptServiceImpl implements IDeptService
{
	@Autowired
	private DeptMapper deptMapper;

	/**
     * 查询部门信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    @Override
	public Dept selectDeptById(Integer deptId)
	{
	    return deptMapper.selectDeptById(deptId);
	}
	
	/**
     * 查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	@Override
	public List<Dept> selectDeptList(Dept dept)
	{
	    return deptMapper.selectDeptList(dept);
	}
	
    /**
     * 新增部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	@Override
	public int insertDept(Dept dept)
	{
	    //还需要创建者
		return deptMapper.insertDept(dept);
	}
	
	/**
     * 修改部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	@Override
	public int updateDept(Dept dept)
	{
	    //还需要更新修改者
		return deptMapper.updateDept(dept);
	}



	/**
	 * 查询部门人数
	 * @param parentId
	 * @return
	 */
	@Override
	public int selectDeptCount(Integer parentId) {
		Dept dept = new Dept();
		dept.setParentId(parentId);
		return deptMapper.selectDeptCount(dept);
	}

	/**
	 * 删除
	 * @param deptId
	 * @return
	 */
	@Override
	public int deleteDeptById(Integer deptId) {
		return deptMapper.deleteDeptById(deptId);
	}

	/**
	 * 查询部门是否存在用户
	 * @param deptId
	 * @return
	 */
	@Override
	public boolean checkDeptExistUser(Integer deptId) {
		int result = deptMapper.checkDeptExistUser(deptId);
		return result > 0 ? true : false;
	}

	/**
	 * 校验部门名称是否唯一
	 * @param dept
	 * @return
	 */
	@Override
	public String checkDeptNameUnique(Dept dept) {
		Long deptId = StringUtils.isNull(dept.getDeptId()) ? -1L : dept.getDeptId();
		Dept info = deptMapper.checkDeptNameUnique(dept.getDeptName());
		if(StringUtils.isNotNull(info) && info.getDeptId().longValue() != deptId.longValue()){
			return UserConstants.DEPT_NAME_NOT_UNIQUE;
		}
		return UserConstants.DEPT_NAME_UNIQUE;
	}


}
