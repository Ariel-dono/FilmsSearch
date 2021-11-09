# FilmsSearch
RESTFul service provisioning search capabilities on top of decentralized datasets

JDK version: 11

#### Instructions:
    - Download a Solr instance 
    - Copy ./Solr/third-party/duckdb_jdbc-0.3.0.jar into ./server/lib in your Solr instance path
    - Copy the folder ./Solr/collection/movies/ into ./server/solr/ as a collection definition in your Solr instance path
    - Run the Solr instance
    - Look for the "movies" collection in the Solr Admin Site
    - Go to the section "Dataimport" and click the button "Execute"
    - Run the jar file in ./Solr/RestFul_API as java -jar ./FilmsSearch-1.0-SNAPSHOT-spring-boot.jar
    - Go to http://localhost:8000/swagger-ui/, explore your new search capabilities

#### Why DuckDB?
Because you can read csv files as an SQL table and load the dataset as an SQL query with ease.

#### Working with Spring Data Solr:
###### Pros:
    - Solr indexed data could be integrated as Spring data documents building queries with ease
###### Cons:
    - Facet ranges has not native support

#### Next steps in order to get a production-ready service:
    - Security set up both at Solr Instance and RESTFul API (Authentication capabilities by Security providers like SSO Platforms, Active Directory, etc and working on top of JWT validation every request)
    - Set up the secrets management strategy
    - Set up the application observability data management strategy (APM, Activity Logs, Audit Logs, etc)
    - Set up the authorization strategy
    - Set up environment profiles

#### About the RESTFul API possible improvements:
    - Add the counter before to expose the data for "Not available" information of rates and duration
    - Move information used in files DurationBin and RateBin to the application.yml
    - Add the counter after to expose the data for "More than 4 hours" over the duration bins definition
    - Detailed configuration of CORS.
    - Add types Film and Series as Enum catalog  

#### Requested indexes: 
- counting grouped by rating ranges
- Search by rate ranges and Genre
- Search by name and sorted by date

#### Complementary indexes:
- counting grouped by duration ranges
- Search by duration ranges and production type
