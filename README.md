# cityconnectdemo
spring boot app for interview

# project goal
cities mentioned in city.txt, every line mentioned a pair of cities which
are connected by road.

# Junit test
ApitestingApplicationTests file establishes negative and positive test cases.

# Run and use the application
As it is a spring boot demo, run the main thread in CityDemoApplication to start the 
application. Any pair of city as per the the txt file shall respond in yes. For example

http://localhost:8081/connected?origin=Boston&destination=Newark   

return yes.

If the city pair is not present it shall return no. Below url return no.

http://localhost:8081/connected?origin=Boston&destination=Trenton

#Swagger interface implemented
http://localhost:8081/swagger-ui/   please use the url to access swagger interface and test the 
application.

