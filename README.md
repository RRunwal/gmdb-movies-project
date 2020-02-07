# gmdb-movies-project

One Paragraph of project description goes here

##Requirements

At this point in time, we will only be working on requirement #2
1. As a business user, I need a REST service to register users logging into GMDB movies website which should do the following:
     - register the user successfully after accepting  a valid username and 
      password
2. As a business user, I need a REST service to search through movies on the GMDB movies website so that I can do the following:
     - find all movies
     - find movies using specific keywords 
           - title (returns all movies that contain the title provided by the 
           user)
           - actor (returns all movies that contain the actor)
3. As a business user, I need a REST service to write and save movie reviews for a selected movie on the GMDB movies website so that:
     - review is saved in the database for the logged in user
     - display saved review if one exists for a given movie
     
##Acceptance Criteria

###Acceptance Criteria for Requirement #2:
Given: user has logged into the GMDB movies website
When: the page is loaded, all movies should be displayed to the user
Then: 
1. The movie page by default should show all movies in the database
2. When searching on title only, the page should display any movie that includes the value provided in the title.  
3. If no movies are found for the title entered, an appropriate message should be displayed ("No Content" - status = 204).   
4. When searching on actor only, the page should display all the movies that have the value provided in actors.  
5. If no movies are found for the actor entered, an appropriate message should be displayed ("No Content" - status = 204). 
6. When searching on both title and actor, the page should display all the movies that include the supplied value in actor and title.  
7. If no movies are found for the title and actor entered, an appropriate message should be displayed ("No Content" - status = 204).
8. When searching on movie-id, the page should display just the movie that matches the provided id.  
9. If no movie is found for the movie-id entered, an appropriate message should be displayed ("No Found" - status = 404). 
10. When searching on imdbId, the page should display just the movie that matches the provided imdbId.  
11. If no movie is found for the imdbId entered, an appropriate message should be displayed ("No Found" - status = 404). 
10. When searching for a random list of movies with a specified movie count, the page should display that number of random movies.  
11. When searching for a random list of movies with an unspecified movie count, the page should display 5 random movies.  

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Tests

#### Search Movies
Returns: by title and actors - List of movies containing both title and actors
         by title - List of movies containing title
         by actors - List of movies containing actors
         no parameters - List of all movies in the table

URL
/movies

Method:
GET

URL Params
* Required:
    - None
* Optional:
    - title
    - actors

Data Params
    - None

Success Response:
Code: 200 OK
Content: [{"movieId":67,"metascore":"67","boxOffice":"$389,804,217","website":"https://marvel.com/guardians","imdbRating":"7.7","imdbVotes":"449,175","runtime":"136 min","language":"English","rated":"PG-13","production":"Walt Disney Pictures","released":"05 May 2017","imdbId":"tt3896198","plot":"The Guardians struggle to keep together as a team while dealing with their personal family issues, notably Star-Lord's encounter with his father the ambitious celestial being Ego.","title":"Guardians of the Galaxy Vol. 2","actors":"Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel","response":"True","type":"movie","awards":"Nominated for 1 Oscar. Another 12 wins & 42 nominations.","dVD":"22 Aug 2017","year":"2017","poster":"https://m.media-amazon.com/images/M/MV5BMTg2MzI1MTg3OF5BMl5BanBnXkFtZTgwNTU3NDA2MTI@._V1_SX300.jpg","country":"USA","genre":"Action, Adventure, Comedy, Sci-Fi","writer":"James Gunn, Dan Abnett (based on the Marvel comics by), Andy Lanning (based on the Marvel comics by), Steve Englehart (Star-Lord created by), Steve Gan (Star-Lord created by), Jim Starlin (Gamora and Drax created by), Stan Lee (Groot created by), Larry Lieber (Groot created by), Jack Kirby (Groot created by), Bill Mantlo (Rocket Raccoon created by), Keith Giffen (Rocket Raccoon created by), Steve Gerber (Howard the Duck created by), Val Mayerik (Howard the Duck created by)","dvd":"2017-08-22T00:00:00.000+0000","director":"James Gunn"}]

Success Response:
Code: 204 - NO CONTENT
Content: 

Error Response:
Code: 404 NOT FOUND
Content: 

Sample Calls:  
/movie?title=Star%20Trek&?actors=Chris%20Pine
/movie?title=Star%20Trek
/movie?actors=Chris%20Pine
/movie

## Deployment

Add additional notes about how to deploy this on a live system

## Built With
* Spring - JPA
* Lombok

Add info such as ...
* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Versioning

Add versioning details here

## Authors

* **Vijaya Chganti** - *Initial work* 
* **Kome Chinnusamy** - *Initial work* 
* **Rachana Runwal** - *Initial work* 

## Acknowledgments

* Thank you team !!!!

* Inspiration for Markdown basic syntax: 
    - [MarkdownGuide](https://www.markdownguide.org/basic-syntax/)

* Inspiration for the "Readme" doc: 
    - [PurpleBooth](https://github.com/PurpleBooth) PurpleBooth/README-Template.md
    - [Bulldogjob - write a good Readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

* Galvanize class projects 

## Notes
[Using @ResponseStatus to Set HTTP Status Code](https://www.baeldung.com/spring-response-status)
[Using Spring ResponseEntity to Manipulate the HTTP Response](https://www.baeldung.com/spring-response-entity)
[Mock MVC Json Path Examples](https://github.com/spring-projects/spring-framework/blob/master/spring-test/src/test/java/org/springframework/test/web/servlet/samples/standalone/resultmatchers/JsonPathAssertionTests.java)
[Spring Testing Cheatsheet] (https://github.com/sannidhi/tdd-boot-demo/blob/master/CHEATSHEET.md) 
[Http PUT vs PATCH](https://www.baeldung.com/http-put-patch-difference-spring)
[Hibernate 5 Naming Strategy Configuration](https://www.baeldung.com/hibernate-naming-strategy)
[Spring Response Entity](https://www.baeldung.com/spring-response-entity)
[Exception Handling from Controller](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
