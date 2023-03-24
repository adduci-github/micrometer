1. 도커를 설치한다. (윈도우는 Docker for Desktop 설치 후 실행, mac은 docker, docker-compose 모두 설치 및 실행)
2. 프로젝트를 Clone
3. gradle build
4. 터미널에서 프로젝트 경로/infra 로 이동
5. docker-compose up --build (백그라운드에서 실행하고 싶으면 -d 옵션 추가)
6. http://localhost:8080/hello/anytext 접속

Zipkin : http://localhost:9411
Prometheus : http://localhost:9090
Grafana : http://localhost:3000
