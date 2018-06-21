# spring-micrometer-basics
Demo projects showing how to use Micrometer with Spring and pushing data into Prometheus

1. Download [Prometheus](https://prometheus.io/) and extract to a local folder
2. Copy `prometheus.yml` into Prometheus folder
3. Run prometheous executable
4. Start demo application `mvnw spring-boot:run`
5. Observe accumulation of metrics at endpoints 
   - http://localhost:8080/actuator/metrics
   - http://localhost:8080/actuator/metrics/application.purchases.dollarvalue
6. Launch Prometheus portal at http://localhost:9090, pick one of the metrics from the dropdown and click Execute. Observe accumulation of data over time   
