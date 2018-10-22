package zjnu.cmf.project.system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import zjnu.cmf.framework.config.CmfConfig;
import zjnu.cmf.framework.web.BaseController;
import zjnu.cmf.project.system.bean.Menu;
import zjnu.cmf.project.system.bean.User;
import zjnu.cmf.project.system.service.IMenuService;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author cmf
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private CmfConfig cmfConfig;

    /**
     * 系统首页
     * @param mmap
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUserId(user.getUserId());
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", cmfConfig.getCopyrightYear());
        return "index";
    }

    /**
     * 系统介绍
     * @param mmap
     * @return
     */
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", cmfConfig.getVersion());
        return "main";
    }

}
