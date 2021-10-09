FROM openjdk:14
COPY . /myapp/
WORKDIR /myapp/
RUN java -cp src/ src/Main.java -d dst/