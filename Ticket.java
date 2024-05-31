package seminar02_20240529.code.cinema;
import seminar02_20240529.code.cinema.interfaces.User;

public class Ticket {
    private User user;
    private Session session;
    private String seat;

    public Ticket(User user, Session session, String seat) {
        this.user = user;
        this.session = session;
        this.seat = seat;
    }

    public User getUser() {
        return user;
    }

    public Session getSession() {
        return session;
    }

    public String getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Ticket [User=" + user.getName() + ", Role=" + user.getRole() +
                ", Film=" + session.getFilm().getTitle() +
                ", Genre=" + session.getFilm().getGenre() +
                ", Time=" + session.getTime() +
                ", Seat=" + seat + "]";
    }
}
