# Sử dụng image Maven với Eclipse Temurin JDK 21 để build ứng dụng
FROM maven:3.9.9-eclipse-temurin-21 AS build

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy file Maven Wrapper và pom.xml để tải dependencies
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Đảm bảo mvnw có quyền thực thi
RUN chmod +x mvnw

# Tải dependencies (tận dụng Docker layer caching)
RUN ./mvnw dependency:go-offline

# Copy toàn bộ source code
COPY src ./src

# Build ứng dụng, bỏ qua kiểm thử
RUN ./mvnw package -DskipTests

# Tạo image cuối cùng với JDK
FROM openjdk:21-jdk-slim

# Thiết lập thư mục làm việc
WORKDIR /app

# Copy file JAR từ bước build
COPY --from=build /app/target/smart-last-mile-delivery-system-0.0.1-SNAPSHOT.jar app.jar

# Expose port mà ứng dụng Spring Boot chạy
EXPOSE 8080

# Lệnh để chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]