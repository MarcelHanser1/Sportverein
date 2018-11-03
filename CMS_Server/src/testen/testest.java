package testen;

import persistence.DatabaseFacade;

public class testest {
    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        databaseFacade.deleteMember(1);
        System.exit(0);
    }
}
