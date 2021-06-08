package com.sreejith.AsyncLogging;

import com.sreejith.AsyncLogging.impl.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class AsyncLoggingApplication {


	public static void main(String[] args) {
		SpringApplication.run(AsyncLoggingApplication.class, args);
	}

	@Bean
	Executor getThreadPool()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(10);
		executor.setCorePoolSize(10);
		executor.setQueueCapacity(10);
		executor.setKeepAliveSeconds(60);
		executor.setThreadGroupName("MyLoggerThread - ");
		executor.initialize();
		return executor;
	}

}
