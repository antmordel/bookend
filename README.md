# 🚀 Bookend: Spring Native Starter app

- Example Spring Boot REST application using Spring Native
- Spring Boot, Java 11, Lombok

Provided a comparison between JVM image build and GraalVM image build.

**Using Spring Native** :hourglass_flowing_sand: `0.067 seconds`
<img src="https://github.com/antmordel/bookend-doc/blob/7a20cd9fcbc9556a8500f8606ee0fb9ba3e96cdf/assets/docker-jvm.gif?raw=true"
  width="1200" alt="Execution for Spring Native" />

**Using the JVM** :hourglass_flowing_sand: `2.112 seconds`
<img src="https://github.com/antmordel/bookend-doc/blob/7a20cd9fcbc9556a8500f8606ee0fb9ba3e96cdf/assets/docker-native.gif?raw=true"
  width="1200" alt="Execution for Spring on top of the JVM" />

## Get started

### Create the image locally
```shell
./mvnw clean spring-boot:build-image
```

### Running the just created local image 

```
docker run --rm -p 8080:8080 bookend-native:0.0.1-SNAPSHOT
```
or just
```
docker-compose up
```
