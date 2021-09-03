package com.jstar.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.jstar.boot.beans.Car;
import com.jstar.boot.beans.Pet;
import com.jstar.boot.beans.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Indexed;

/**
 * @author Jstar
 * @version 1.0
 * @date 2021/9/3 9:28 上午
 */

/**
 * Config class use @Bean to register module on container and default is Singleton
 * Config class is also a module
 *@Configuration has a property proxyBeanMethods default is true
 * if we use getBean to return a MyConfig instance is not a real MyConfig.class  it's a
 * com.jstar.boot.config.MyConfig$$EnhancerBySpringCGLIB$$2f00f88d@4c9e9fb8   is a proxyObject, w
 *
 *
 *         MyConfig bean = run.getBean(MyConfig.class);
 *         User user = bean.user01();
 *         User user1 = bean.user01();
 *         System.out.println(bean);
 *         System.out.println((user==user1));
 *
 *         return MyConfig$$EnhancerBySpringCGLIB$$2f00f88d@4c9e9fb8   ture;
 *
 *         if we set proxyBeanMethods = false
 *         return MyConfig@77e80a5e  false
 *
 *         Full(proxyBeanMethods = true)
 *         Lite(proxyBeanMethods = false)
 *         solve circular dependency problem
 *
 *         如果我们使用true 当 @bean里面还依赖其他的Bean组件，Spring会帮我们保证依赖的Bean是同一个
 *         使用false 会跳过检查，直接新建对象，不是同一个实例，但是会加快spring的启动速度。
 *         取决于实际的需要情况，一般用默认
 *
 *
 */

/**
 * @Import({User.class, DBHelper.class})
 * auto add  demand class type component  default name is full name of class type
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  // tell Springboot this is a config class == XX.xml
// 兼容xml配置的方式导入bean对象
@ImportResource(locations = "classpath:bean.xml")
// 当容器中缺少这个Bean时才会将下面将下面的类或方法交给spring管理，
//@ConditionalOnBean(name = "Bean")
@ConditionalOnMissingBean(name = "tom")

/**
 * 1开启car配置绑定功能
 * 2把car这个组件自动注册到容器中
 * 一般用于将第三方的实体类交给容器管理时使用，
 * 对于自己实现的实体类使用@Component更加方便
 */
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    @Bean
    // add module to container , module id  = method name
    //  return type = module.class,return value = instance in container
    // we can set instance name in annotation eg @Bean("ZhanSan")
    public User user01() {
        return new User("zhanSan", 13 , Tomcat());
    }

    @Bean("Tom")
    public Pet Tomcat() {
        return new Pet("tomcat");
    }


}
