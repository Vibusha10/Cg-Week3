import java.util.ArrayList;
import java.util.List;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public User getUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
        for (int id : user1.friendIds) {
            if (user2.friendIds.contains(id)) {
                User mutual = getUserById(id);
                if (mutual != null) {
                    System.out.print(mutual.name + " ");
                }
            }
        }
        System.out.println();
    }

    public void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println(user.name + "'s friends:");
        for (int id : user.friendIds) {
            User friend = getUserById(id);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    public void searchUserByNameOrId(String name, int id) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.userId == id || temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }

    public void countFriendsForEachUser() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId);
            System.out.println("Name: " + temp.name);
            System.out.println("Age: " + temp.age);
            System.out.print("Friends: ");
            for (int id : temp.friendIds) System.out.print(id + " ");
            System.out.println("\n");
            temp = temp.next;
        }
    }
}

public class Program7 {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 24);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "David", 27);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 3);
        sm.addFriendConnection(3, 4);

        sm.displayFriends(1);
        sm.displayFriends(3);

        sm.findMutualFriends(1, 2);

        sm.searchUserByNameOrId("Charlie", -1);

        sm.countFriendsForEachUser();

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);

        sm.displayAllUsers();
    }
}
