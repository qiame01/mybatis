package springboot10;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * sb整合mybatis：
 * 重点：generator插件、资源拷贝插件、@MapperScan
 *
 * @MapperScan：mybatis用来扫描接口、映射文件所在包
 * 映射文件和接口若都在java目录下，则二者必须在java下的同一个目录。
 * 若映射文件移动到resources目录（接口位置不变），则这里将只扫描到接口，
 * 而映射文件新的位置需要在app文件中配置，以便mybatis扫描
 */
@SpringBootApplication
@MapperScan("springboot10/mapper")
public class Springboot10Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10Application.class, args);
    }

}
