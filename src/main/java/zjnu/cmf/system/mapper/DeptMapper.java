package zjnu.cmf.system.mapper;


import org.apache.ibatis.annotations.Param;
import zjnu.cmf.system.bean.Dept;

import java.util.List;

/**
 * 部门 数据层
 * 
 * @author cmf
 * @date 2018-08-12
 */
public interface DeptMapper 
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
     * 删除部门
     * 
     * @param deptId 部门ID
     * @return 结果
     */
	public int deleteDeptById(Integer deptId);
	
	/**
     * 批量删除部门
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDeptByIds(String[] deptIds);

	/**
	 * 查询部门人数
	 * @param dept
	 * @return
	 */
    int selectDeptCount(Dept dept);

	/**
	 * 查询部门是否存在用户
	 * @param deptId
	 * @return
	 */
	//mybatis中if test里判断传参时，如果传参是像int的基本类型，因为它没有getter方法所以会报错，添加@Param注释
	int checkDeptExistUser(@Param("deptId")Integer deptId);

	/**
	 * 查询部门所有数据
	 * @return
	 */
	List<Dept> selectDeptAll();

	/**
	 * 校验部门名称是否唯一
	 * @param deptName
	 * @return
	 */
	Dept checkDeptNameUnique(String deptName);


}