package com.spring.seata.tx.storage.conf;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.spring.seata.tx.storage.conf.properties.StorageDataSourceProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:11
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Configuration
@MapperScan(
        basePackages = {
                "com.spring.seata.tx.storage.mapper"
        },
        sqlSessionFactoryRef = "storageSqlSessionFactory"
)
public class OrderDataSourceConfiguration {

    @Resource
    private StorageDataSourceProperties storageDatasourceProperties;


    /**
     * 配置数据源
     *
     * @return DataSource
     */
    @Bean(name = "storageDataSource")
    public DataSource createDatasource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(storageDatasourceProperties.getUrl());
        dataSourceBuilder.username(storageDatasourceProperties.getUsername());
        dataSourceBuilder.password(storageDatasourceProperties.getPassword());
        dataSourceBuilder.driverClassName(storageDatasourceProperties.getDriver());

        return dataSourceBuilder.build();
    }


    /**
     * 使用指定的datasource构建SqlSessionFactory
     *
     * @param dataSource datasource ,使用Qualifier指定数据源
     * @return SqlSessionFactory
     */
    @Bean(name = "storageSqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("storageDataSource") DataSource dataSource) throws Exception {
        //SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 如果要使用mybatis-plus的baseMapper的功能,就要设置为MyabtisSqlSessionFactoryBean
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        // 设置数据源和映射的mapper地址
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/storage/**.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 使用SqlSessionFactory构建SqlSessionTemplate
     *
     * @param sqlSessionFactory sql session factory
     * @return SqlSessionTemplate
     */
    @Bean(name = "storageSqlSessionTemplate")
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier("storageSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        log.info("Function[createSqlSessionTemplate] create template now");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    //
    //
    ///**
    // * 构建事务管理器
    // *
    // * @param dataSource dataSource
    // * @return DataSourceTransactionManager
    // */
    //@Bean(name = "storageTxManager")
    //public DataSourceTransactionManager createTransactionManager(@Qualifier("storageDataSource") DataSource dataSource) {
    //    return new DataSourceTransactionManager(dataSource);
    //}

}
