# 如何运行KS3 Java SDK例子


* 配置Java和Maven环境
```
myang@MichaeldeMacBook-Pro-2 ks3_demo % java -version
java version "1.8.0_77"
Java(TM) SE Runtime Environment (build 1.8.0_77-b03)
Java HotSpot(TM) 64-Bit Server VM (build 25.77-b03, mixed mode)
myang@MichaeldeMacBook-Pro-2 ks3_demo % mvn -v
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-18T02:33:14+08:00)
Maven home: /Users/myang/tools/apache-maven-3.5.4
Java version: 1.8.0_77, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_77.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.1", arch: "x86_64", family: "mac"
```
* 修改代码App.java中的AK/SK
```java
        Ks3Client client = new Ks3Client("Your AK", "Your SK", config);
```
* 打包Java Jar文件，形成target/ks3_demo-1.0-SNAPSHOT.jar
```
mvn package assembly:single    
```
* 运行JAR文件
利用maven执行jar文件。
```
export CLASSPATH=target/ks3_demo-1.0-SNAPSHOT.jar
mvn exec:java -Dexec.mainClass=com.ksc.sbt.App
```
利用java执行jar文件，该文件包含所需的依赖。
```
java -jar target/ks3_demo-1.0-SNAPSHOT-jar-with-dependencies.jar
```



