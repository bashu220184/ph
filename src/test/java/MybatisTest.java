import com.itheima.domain.Order;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


/**
 * @Auther 王飞龙
 * @Date 2020-02-18 10:10
 */
public class MybatisTest {

    private UserMapper userMapper;
    private OrderMapper orderMapper;
    private RoleMapper roleMapper;

    @Before
    public void test() throws IOException {
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml")).openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @Test
    public void test7(){
        List<Role> roleList = roleMapper.findRoleByUid(2);
        for (Role role : roleList) {
            System.out.println(role);
        }
    }

    @Test
    public void test6(){
        List<User> userList = userMapper.findUserAndRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test5(){
        List<User> userList = userMapper.findUserAndOrder();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test4(){
        List<Order> orderList = orderMapper.findAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("红太狼");
        user.setPassword("123");
        userMapper.save(user);
    }


    @Test
    public void testDel(){
        userMapper.delete(5);
    }

    @Test
    public void test3(){
        User user = new User();
        user.setId(2);
        user.setUsername("熊大");
        user.setPassword("123");
        userMapper.update(user);

    }


    @Test
    public void test1(){
        User user = userMapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void test2(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
