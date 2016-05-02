Controllers:

EventController:
Event by name (with assignments for event) - http://localhost:8080/movie/movies/Dead%20Pool

UserController:
All users - http://localhost:8080/movie/admin-users
User by id (with all booked tickets) - http://localhost:8080/movie/admin-users/1

HomeController(main page)
All events with pagination && all auditoriums - 
http://localhost:8080/movie/home?page=2
http://localhost:8080/movie/home
http://localhost:8080/movie

TicketPdfController:
Booked tickets for user - http://localhost:8080/movie/admin-tickets-pdf?user=0
Booked tickets for event and time - http://localhost:8080/movie/admin-tickets-pdf/Dead%20Pool?time=2016-03-01T18:30

FileUploadController
Upload and create events -  http://localhost:8080/movie/admin-upload-events
Upload and create users -  http://localhost:8080/movie/admin-upload-users

Files examples U can find in the root of repo folder: upload-files (events.json && users.json)

ExceptionController
examples:
NumberFormatException - http://localhost:8080/movie/home?page=pi
NullPointerException - http://localhost:8080/movie/admin-users/1000

HttpErrorController
examples:
404 - http://localhost:8080/movie/users

