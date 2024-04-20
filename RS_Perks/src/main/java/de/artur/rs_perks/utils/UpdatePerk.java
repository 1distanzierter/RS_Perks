package de.artur.rs_perks.utils;

import de.artur.rs_perks.RS_Perks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UpdatePerk {

    //Abfrage ob der Spieler das Perk besitzt
    public static int getFallschadenPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("FallschadenPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getErtrinkenPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("ErtrinkenPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getNachtsichtPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("NachtsichtPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getSchmelzenPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("SchmelzenPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getHungerPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("HungerPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getFeuerPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("FeuerresistenzPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getXPPerk(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("XPPerk");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }

    //Spieler beim kaufen eines Perks in der Datenbank eintragen
    public static void setFallschadenPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET FallschadenPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setNachtsichtPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET NachtsichtPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setErtrinkenPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET ErtrinkenPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setHungerPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET HungerPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setSchmelzenPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET SchmelzenPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setFeuerPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET FeuerresistenzPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setXPPerk(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Perks.mysql.update("UPDATE perks SET XPPerk= '1' WHERE UUID= '" + uuid + "';");
        }
    }

    //Status Abfrage beim Aktivieren / Deaktivieren des Perks in der Daten

    public static int getFallschadenPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("FallschadenPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getErtrinkenPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("ErtrinkenPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getNachtsichtPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("NachtsichtPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getHungerPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("HungerPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getFeuerPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("FeuerresistenzPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getSchmelzenPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("SchmelzenPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }
    public static int getXPPerkStatus(UUID uuid) {
        int perk = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");

            if(rs.next())
                perk = rs.getInt("XPPerkStatus");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return perk;
    }

    //Status beim Aktivieren / Deaktivieren des Perk in der Datenbank eintragen

    public static void setFallschadenPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET FallschadenPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET FallschadenPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setErtrinkenPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET ErtrinkenPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET ErtrinkenPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setHungerPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET HungerPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET HungerPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setSchmelzenPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET SchmelzenPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET SchmelzenPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setNachtsichtPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET NachtsichtPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET NachtsichtPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setFeuerPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET FeuerresistenzPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET FeuerresistenzPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setXPPerkStatus(UUID uuid, boolean status) {
        if (playerExists(String.valueOf(uuid))) {
            if(status == true) {
                RS_Perks.mysql.update("UPDATE perks SET XPPerkStatus= '1' WHERE UUID= '" + uuid + "';");
            } else
                RS_Perks.mysql.update("UPDATE perks SET XPPerkStatus= '0' WHERE UUID= '" + uuid + "';");
        }
    }

    //Abfrage ob ein Spieler bereits in der Datenbank eingetragen ist
    public static boolean playerExists(String uuid) {
        try {
            ResultSet rs = RS_Perks.mysql.query("SELECT * FROM perks WHERE UUID= '" + uuid + "'");
            return rs.next();
        } catch (SQLException var2) {
            var2.printStackTrace();
            return false;
        }
    }

    // Neue Spieler eintragen
    public static void createPlayer(String uuid) {
        if (!playerExists(uuid)) {
            RS_Perks.mysql.update("INSERT INTO perks(UUID, FallschadenPerk, FallschadenPerkStatus, NachtsichtPerk, NachtsichtPerkStatus, HungerPerk, HungerPerkStatus, ErtrinkenPerk, ErtrinkenPerkStatus, SchmelzenPerk, SchmelzenPerkStatus, FeuerresistenzPerk, FeuerresistenzPerkStatus, XPPerk, XPPerkStatus) VALUES ('" + uuid + "', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');");
        }

    }

}
