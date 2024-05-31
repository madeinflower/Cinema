
package seminar02_20240529.code.cinema;

        import seminar02_20240529.code.cinema.interfaces.Film;
        import seminar02_20240529.code.cinema.interfaces.User;

        import java.time.LocalDateTime;
        import java.util.Arrays;

public class ManageSessions {
    private Session[] sessions = new Session[10];
    private int sessionCount = 0;

    public void createSession(User user, Film film, LocalDateTime time, int ticketCount) {
        if (user.getRole().equals("admin")) {
            if (sessionCount < sessions.length) {
                sessions[sessionCount++] = new Session(film, time, ticketCount);
            } else {
                System.out.println("Session array is full.");
            }
        } else {
            System.out.println("Access denied. Only admins can create sessions.");
        }
    }

    public void editSession(User user, int sessionId, Film film, LocalDateTime time, int ticketCount) {
        if (user.getRole().equals("admin")) {
            if (sessionId >= 0 && sessionId < sessionCount) {
                Session session = sessions[sessionId];
                session.setFilm(film);
                session.setTime(time);
                session.setTickets(ticketCount);
            } else {
                System.out.println("Session not found.");
            }
        } else {
            System.out.println("Access denied. Only admins can edit sessions.");
        }
    }

    public void deleteSession(User user, int sessionId) {
        if (user.getRole().equals("admin")) {
            if (sessionId >= 0 && sessionId < sessionCount) {
                for (int i = sessionId; i < sessionCount - 1; i++) {
                    sessions[i] = sessions[i + 1];
                }
                sessions[--sessionCount] = null;
            } else {
                System.out.println("Session not found.");
            }
        } else {
            System.out.println("Access denied. Only admins can delete sessions.");
        }
    }

    public Session[] viewSessions() {
        return Arrays.copyOf(sessions, sessionCount);
    }

    public Session getSession(int sessionId) {
        if (sessionId >= 0 && sessionId < sessionCount) {
            return sessions[sessionId];
        } else {
            System.out.println("Session not found.");
            return null;
        }
    }
}

