package seminar02_20240529.code.cinema;

import seminar02_20240529.code.cinema.interfaces.Film;
import seminar02_20240529.code.cinema.interfaces.User;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ManageTickets {
    private Ticket[] tickets = new Ticket[10];
    private int ticketCount = 0;

    public void buyTicket(User user, Session session, String seat) {
        if (session != null) {
            if (session.getTickets() > 0) {
                if (ticketCount < tickets.length) {
                    tickets[ticketCount++] = new Ticket(user, session, seat);
                    session.setTickets(session.getTickets() - 1);
                } else {
                    System.out.println("Ticket array is full.");
                }
            } else {
                System.out.println("No tickets available for this session.");
            }
        } else {
            System.out.println("Invalid session.");
        }
    }

    public Ticket[] viewBoughtTickets(User user) {
        Ticket[] userTickets = new Ticket[ticketCount];
        int count = 0;
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getUser().equals(user)) {
                userTickets[count++] = tickets[i];
            }
        }
        return Arrays.copyOf(userTickets, count);
    }

    public static void main(String[] args) {
        ManageSessions manageSessions = new ManageSessions();
        ManageTickets manageTickets = new ManageTickets();

        User admin = new ViewerUser("Admin", "admin");
        User viewer = new ViewerUser("Viewer", "viewer");

        Film actionFilm = new ActionFilm("Die Hard", "Action");
        LocalDateTime sessionTime = LocalDateTime.of(2024, 6, 1, 18, 0);

        // Admin creates a session
        manageSessions.createSession(admin, actionFilm, sessionTime, 50);

        // Viewer tries to create a session
        manageSessions.createSession(viewer, actionFilm, sessionTime, 50);

        // Admin edits the session
        manageSessions.editSession(admin, 0, actionFilm, sessionTime.plusHours(1), 45);

        // Admin deletes a session
        manageSessions.deleteSession(admin, 0);

        // Viewer buys a ticket
        manageSessions.createSession(admin, actionFilm, sessionTime, 50); // Re-create session
        Session session = manageSessions.getSession(0);
        manageTickets.buyTicket(viewer, session, "A1");

        // Viewer views bought tickets
        Ticket[] viewerTickets = manageTickets.viewBoughtTickets(viewer);
        for (Ticket ticket : viewerTickets) {
            System.out.println(ticket);
        }
    }
}
