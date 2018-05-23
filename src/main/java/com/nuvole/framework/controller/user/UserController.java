package com.nuvole.framework.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.nuvole.framework.domain.SysUser;
import com.nuvole.framework.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:36
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;



    /**
     * 分页 PAGE
     */
    @GetMapping("/test")
    public Page<SysUser> test() {
        System.out.println(userService.selectPage(new Page<SysUser>(0, 12)));
        return userService.selectPage(new Page<SysUser>(0, 12));
    }

    /**
     * AR 部分测试
     */
    @GetMapping("/test1")
    public Page<SysUser> test1() {
        SysUser sysUser = new SysUser(1L,"zhangsan", "zhangsan");
        sysUser.setId(1L);
        System.err.println("删除所有：" + sysUser.delete(null));
        sysUser.insert();
        System.err.println("查询插入结果：" + sysUser.selectById().toString());
        System.err.println("更新：" + sysUser.updateById());
        return sysUser.selectPage(new Page<SysUser>(0, 12), null);
    }

    /**
     * 增删改查 CRUD
     */
    @GetMapping("/test2")
    public SysUser test2() {
        System.err.println("删除一条数据：" + userService.deleteById(1L));
//        System.err.println("deleteAll：" + userService.deleteAll());
        System.err.println("插入一条数据：" + userService.insert(new SysUser(4L, "zhangsan", "zhangsan")));
        SysUser sysUser = new SysUser(4L, "zhangsan", "zhangsan");
        boolean result = userService.insert(sysUser);
        // 自动回写的ID
        Long id = sysUser.getId();
        System.err.println("插入一条数据：" + result + ", 插入信息：" + sysUser.toString());
        System.err.println("查询：" + userService.selectById(id).toString());
        System.err.println("更新一条数据：" + userService.updateById(new SysUser(1L, "三毛", "123")));
        for (int i = 0; i < 5; ++i) {
            userService.insert(new SysUser(Long.valueOf(100 + i), "张三" + i, "123"));
        }
        Page<SysUser> userListPage = userService.selectPage(new Page<SysUser>(1, 5), new EntityWrapper<>(new SysUser()));
        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());
        return userService.selectById(1L);
    }

    /**
     * 插入 OR 修改
     */
    @GetMapping("/test3")
    public SysUser test3() {
        SysUser sysUser = new SysUser(4L, "zhangsan", "zhangsan");
        userService.insertOrUpdate(sysUser);
        return userService.selectById(4L);
    }

    @GetMapping("/add")
    public Object addUser() {
        SysUser sysUser = new SysUser(4L, "zhangsan", "zhangsan");
        JSONObject result = new JSONObject();
        result.put("result", userService.insert(sysUser));
        return result;
    }

    @GetMapping("/selectsql")
    public Object getUserBySql() {
        JSONObject result = new JSONObject();
        result.put("records", userService.selectListBySQL());
        return result;
    }

    /**
     * 7、分页 size 一页显示数量  current 当前页码
     * 方式一：http://localhost:8080/user/page?size=1&current=1<br>
     * 方式二：http://localhost:8080/user/pagehelper?size=1&current=1<br>
     */

    // 参数模式分页
    @GetMapping("/page")
    public Object page(Page page) {
        return userService.selectPage(page);
    }

    // ThreadLocal 模式分页
    @GetMapping("/pagehelper")
    public Object pagehelper(Page page) {
        PageHelper.setPagination(page);
        page.setRecords(userService.selectList(null));
        page.setTotal(PageHelper.freeTotal());//获取总数并释放资源 也可以 PageHelper.getTotal()
        return page;
    }


    /**
     * 测试事物
     * http://localhost:8080/user/test_transactional<br>
     * 访问如下并未发现插入数据说明事物可靠！！<br>
     * http://localhost:8080/user/test<br>
     * <br>
     * 启动  Application 加上 @EnableTransactionManagement 注解其实可无默认貌似就开启了<br>
     * 需要事物的方法加上 @Transactional 必须的哦！！
     */
    @Transactional
    @GetMapping("/test_transactional")
    public void testTransactional() {
        userService.insert(new SysUser(4L, "zhangsan", "zhangsan"));
        System.out.println(" 这里手动抛出异常，自动回滚数据");
        throw new RuntimeException();
    }



}
