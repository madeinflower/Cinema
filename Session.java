package seminar02_20240529.code.cinema;

import seminar02_20240529.code.cinema.interfaces.Film;

import java.time.LocalDateTime;

public class Session {

    private Film film;
    private LocalDateTime time;
    private int tickets;

    public Session(Film film, LocalDateTime time, int tickets) {
        this.film = film;
        this.time = time;
        this.tickets = tickets;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
