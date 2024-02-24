package eu.ygames.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This Class Stores all important Settings which can be changed globally all at once.
 * Using the properties file.
 *
 * Current Supported Settings:
 * @params TOKEN
 * @params PREFIX
 * @params LOGCHANNEL
 * @params SETTINGSFILE
 * @params LANGUAGE
 * @params AdminHobbitbear
 * @params RolsHobbitbear
 * @params AdminHeyimt
 * @params RolsHeyimt
 * @params AdminNeor3flux
 * @params RolsNeor3flux
 * @params RoleThruYa
 * @params WELCOMECHANNEL
 * @params RULECHANNEL
 * @params RULECHECKEMOJI
 * @params DEFAULTROLE
 *
 * @since 1.0
 * @author gillthegamer
 */

public class Settings {

    private static String TOKEN;
    private static String SETTINGSFILE = "config.properties";
    private static String PREFIX;
    private static String LANGUAGE;
    private static String LOGCHANNEL;
    private static String AdminHobbitbear;
    private static String[] RoleHobbitbear;
    private static String AdminHeyimt;
    private static String[] RoleHeyimt;
    private static String AdminNeor3flux;
    private static String[] RoleNeor3flux;
    private static String[] RoleThruYa;
    private static String WELCOMECHANNEL;
    private static String RULECHANNEL;
    private static String RULECHECKEMOJI;
    private static String DEFAULTROLE;

    public Settings() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(SETTINGSFILE);
            Properties prop = new Properties();
            prop.load(inputStream);
            setTOKEN(prop.getProperty("TOKEN"));
            setPREFIX(prop.getOrDefault("PREFIX", "-").toString());
            setLANGUAGE(prop.getOrDefault("LANGUAGE", "DE").toString());
            setLOGCHANNEL(prop.getOrDefault("LOGCHANNEL", "1202371648699764786").toString());
            setAdminHobbitbear(prop.getOrDefault("AdminHobbitbear", "not set").toString());
            setRoleHobbitbear(prop.getOrDefault("RoleHobbitbear", "not set").toString().split(";"));
            setAdminHeyimt(prop.getOrDefault("AdminHeyimt", "not set").toString());
            setRoleHeyimt(prop.getOrDefault("RoleHeyimt", "not set").toString().split(";"));
            setAdminNeor3flux(prop.getOrDefault("AdminNeor3flux", "not set").toString());
            setRoleNeor3flux(prop.getOrDefault("RoleNeor3flux", "not set").toString().split(";"));
            setRoleThruYa(prop.getOrDefault("RoleThruYa", "not set").toString().split(";"));
            setWELCOMECHANNEL(prop.getOrDefault("WELCOMECHANNEL","1211028592688107630").toString());
            setRULECHANNEL(prop.getOrDefault("RULECHANNEL","\uD83D\uDCDC-regeln").toString());
            setRULECHECKEMOJI(prop.getOrDefault("RULECHECKEMOJI","U+2705").toString());
            setDEFAULTROLE(prop.getOrDefault("RoleThruYa", "447304919272259585").toString().split(";")[0]);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String getTOKEN() {
        return TOKEN;
    }

    private static void setTOKEN(String TOKEN) {
        Settings.TOKEN = TOKEN;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    private static void setPREFIX(String PREFIX) {
        Settings.PREFIX = PREFIX;
    }

    public static String getLANGUAGE() {
        return LANGUAGE;
    }

    private static void setLANGUAGE(String LANGUAGE) {
        Settings.LANGUAGE = LANGUAGE;
    }

    public static String getAdminHobbitbear() {
        return AdminHobbitbear;
    }

    private static void setAdminHobbitbear(String adminHobbitbear) {
        AdminHobbitbear = adminHobbitbear;
    }

    public static String getLOGCHANNEL() {
        return LOGCHANNEL;
    }

    private static void setLOGCHANNEL(String LOGCHANNEL) {
        Settings.LOGCHANNEL = LOGCHANNEL;
    }

    public static String[] getRoleHobbitbear() {
        return RoleHobbitbear;
    }

    private static void setRoleHobbitbear(String[] roleHobbitbear) {
        RoleHobbitbear = roleHobbitbear;
    }

    public static String getAdminHeyimt() {
        return AdminHeyimt;
    }

    private static void setAdminHeyimt(String adminHeyimt) {
        AdminHeyimt = adminHeyimt;
    }

    public static String[] getRoleHeyimt() {
        return RoleHeyimt;
    }

    private static void setRoleHeyimt(String[] roleHeyimt) {
        RoleHeyimt = roleHeyimt;
    }

    public static String getAdminNeor3flux() {
        return AdminNeor3flux;
    }

    private static void setAdminNeor3flux(String adminNeor3flux) {
        AdminNeor3flux = adminNeor3flux;
    }

    public static String[] getRoleNeor3flux() {
        return RoleNeor3flux;
    }

    private static void setRoleNeor3flux(String[] roleNeor3flux) {
        RoleNeor3flux = roleNeor3flux;
    }

    public static String[] getRoleThruYa() {
        return RoleThruYa;
    }

    private static void setRoleThruYa(String[] roleThruYa) {
        RoleThruYa = roleThruYa;
    }

    public static String getWELCOMECHANNEL() {
        return WELCOMECHANNEL;
    }

    private static void setWELCOMECHANNEL(String WELCOMECHANNEL) {
        Settings.WELCOMECHANNEL = WELCOMECHANNEL;
    }

    public static String getRULECHANNEL() {
        return RULECHANNEL;
    }

    private static void setRULECHANNEL(String RULECHANNEL) {
        Settings.RULECHANNEL = RULECHANNEL;
    }

    public static String getRULECHECKEMOJI() {
        return RULECHECKEMOJI;
    }

    private static void setRULECHECKEMOJI(String RULECHECKEMOJI) {
        Settings.RULECHECKEMOJI = RULECHECKEMOJI;
    }

    public static String getDEFAULTROLE() {
        return DEFAULTROLE;
    }

    private static void setDEFAULTROLE(String DEFAULTROLE) {
        Settings.DEFAULTROLE = DEFAULTROLE;
    }
}
