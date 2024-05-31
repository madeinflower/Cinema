### Technical Specification: "Cinema Management System"

#### Objective:
Develop a cinema management system that includes various entities such as movies, sessions, users, and tickets. The system should demonstrate the use of polymorphism and interfaces.

#### Task Description:
1. **Movies**: Create a class hierarchy for movies with different genres.
2. **Sessions**: Manage the schedule of movie sessions.
3. **Users**: Different types of users (administrators and viewers) with corresponding roles and permissions.
4. **Tickets**: Sell tickets for sessions and display ticket information.

#### Requirements:
1. **Interfaces and Classes:**
   - Create an interface `Film` with methods to get the movie title and genre.
   - Create several classes implementing the `Film` interface for different genres (e.g., `ActionFilm`, `ComedyFilm`, `DramaFilm`).
   - Create an interface `User` with methods to get the user name and role.
   - Create classes implementing the `User` interface for different types of users (e.g., `AdminUser`, `ViewerUser`).
   - Create a `Session` class representing a session, which includes the movie, time, and the number of available tickets.
   - Create a `Ticket` class representing a ticket, which includes information about the user, session, and seat.

2. **Polymorphism:**
   - Use polymorphism to handle different types of movies and users.
   - Demonstrate polymorphic behavior when working with collections of movies and users.

3. **Functionality:**
   - Create, edit, and delete sessions (available only to administrators).
   - View the list of available sessions and purchase tickets (available to all users).
   - View information about purchased tickets.
