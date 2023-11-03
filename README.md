# Hackathon
Team 5's 4 hour sprint in order to create a working web app that allows users to swap clothes and toys. They are able to list their own toys and clothes. 


In the hackathon project, my contribution focused on the server-side management of item listings for the clothing swap web application.
I designed the wireframes for the entire website, laying the foundational blueprint for the user interface.
 
The core functionality resides in the ListingPageService class (Service layer), which acts as a singleton to manage ItemListing objects. I utilized the Singleton pattern to ensure a single instance of this service throughout the application, preventing concurrent modification issues and preserving consistency across various client interactions.

The addListing method embodies the application's dynamic nature, allowing users to add new item listings. Each new item is assigned a unique identifier, ensuring that users can reference and interact with listings reliably. 
 
On the client side, the ListingPageController leverages the service to fetch and present listings. By mapping the /listing and /listings endpoints to the showListPage method, it creates a ModelAndView object populated with listing data, which is then rendered to the user.
 
These snippets demonstrate my proficiency in creating dynamic web pages. Each piece of code aligns with best practices in Java and Spring MVC, from initializing the application state to processing user requests and rendering responses. By focusing on modular design and service orientation, my work on the clothing swap app enables easy future enhancements and encapsulates business logic effectively.


