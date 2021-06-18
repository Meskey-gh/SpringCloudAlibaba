
package com.study.user.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * mybatis-plus 配置
 * @author 刘祖鸿
 */
@Configuration
@MapperScan("com.study.user.mapper")
public class MybatisPlusConfiguration {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    /**
     * SQL执行效率插件  性能分析拦截器，用于输出每条 SQL 语句及其执行时间
     *
     * @return PerformanceInterceptor
     */
	@Bean
	@Profile({"dev"})
	public PerformanceInterceptor performanceInterceptor() {
		return new PerformanceInterceptor();
	}

}

