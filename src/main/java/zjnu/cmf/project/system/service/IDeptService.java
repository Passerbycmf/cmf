package zjnu.cmf.project.system.service;


import zjnu.cmf.project.system.bean.Dept;

import java.util.List;

/**
 * 部门 服务层
 * 
 * @author cmf
 * @date 2018-08-12
 */
public interface IDeptService 
{
	/**
     * 查询部门信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
	public Dept selectDeptById(Integer deptId);
	
	/**
     * 查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	public List<Dept> selectDeptList(Dept dept);
	
	/**
     * 新增部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	public int insertDept(Dept dept);
	
	/**
     * 修改部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	public int updateDept(Dept dept);
		


	/**
	 * 查询部门人数（判断下一级部门是否存在人员）
	 * @param parentId
	 * @return
	 */
	int selectDeptCount(Integer parentId);

	/**
	 * 删除部门信息
	 * @param deptId
	 * @return
	 */

	int deleteDeptById(Integer deptId);

	/**
	 * 查询部门是否存在用户
	 * @param deptId
	 * @return
	 */
	boolean checkDeptExistUser(Integer deptId);

	/**
	 * 校验部门名称是否唯一
	 * @param dept
	 * @return
	 */
	String checkDeptNameUnique(Dept dept);
}
