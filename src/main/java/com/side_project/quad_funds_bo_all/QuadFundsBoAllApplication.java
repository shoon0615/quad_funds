package com.side_project.quad_funds_bo_all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

// 없어도 정상 동작
// @MapperScan(basePackages = "com.side_project.quad_funds_bo_all.mapper")
// @MapperScan(basePackageClasses = QuadFundsBoAllApplication.class)		// JPA 와 병행 안됨
@EnableJpaAuditing            // 트랜잭션 커밋 시점에 flush 때 Auditing 기능 실행
@SpringBootApplication
public class QuadFundsBoAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuadFundsBoAllApplication.class, args);
	}

	// chrome 은 모든 매핑을 지원하지만 GET/POST 만 지원하는 브라우저는 method 따로 받아야함(PUT/DELETE..) -> axios 는 상관없음
	// form 기준: <input type="hidden" name="_method" value="put" />
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}

	// 없어도 정상 동작
	/*@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{

		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);

		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
		sessionFactory.setMapperLocations(res);

		return sessionFactory.getObject();
	}*/

}
