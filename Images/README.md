# Image Effects 

Apply effects to uploaded image.\
### Running Instructions
* Server Side
  * Navigate to the root of the project 
  * Run `mvn spring-boot:run` (maven required)
  * or using IDE locate & run `~/images/src/main/java/side/projects/images/EffectsApp.java`
  * Supported ports on server `http://localhost:5502` and `http://localhost:8080` 
  
  
* Client Side
  * Locate `/images/client/index.html` and run with live web page server on hand.
  * Client does not function on VS Code Live Server extension (Live server code injections into HTML breaks Client functionality)


Image effect codes used from [GeeksForGeeks](https://www.geeksforgeeks.org/image-processing-java-set-1-read-write/?ref=lbp)

## Client
![Client](img/client.png)
## Grayscale
![Gray](img/grayscale.jpg)
## Sepia
![Sepia](img/sepia.jpg)
## Negative
![Negative](img/negative.jpg)
## Watermark
![Watermark](img/watermark.jpg)
