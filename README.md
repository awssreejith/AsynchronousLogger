# AsynchronousLogger
This repo contains sample implementation of asynchronous logging using ThreadPoolTaskExecutor. This approach DOES NOT use any inherent ASYNC logger appender for
SLF4J, but uses a threadpool model where a thread is automatically assigned for each log write through @Async
