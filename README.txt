UUID bliver gemt som en blob i workbench. Kan se lidt mærkeligt ud, tjek det her link for mere info:
https://stackoverflow.com/questions/13634369/mysql-workbench-shows-results-as-blob


Lige nu er connection hardcode



Har haft lidt problemer med den her i application.properties:
spring.jpa.properties.hibernate.dialect
Vær opmærksom på hvis noget crasher kan den muligvis være sønderen.

Database url skal sættes med database og schema, ligesom: localhost:3306/electradrive.

Husk at sæt RabbitMQ og Mysql env variabler. Tjek application.properties.