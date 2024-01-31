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
 * @params SETTINGSFILE
 * @params LANGUAGE
 * @params AdminHobbitbear
 * @params RolsHobbitbear
 * @params AdminHeyimt
 * @params RolsHeyimt
 * @params AdminNeor3flux
 * @params RolsNeor3flux
 *
 * @since 1.0
 * @author gillthegamer
 */

public class Settings {

    private static String TOKEN;
    private static String SETTINGSFILE = "config.properties";
    private static String PREFIX;
    private static String LANGUAGE;
    private static String AdminHobbitbear;
    private static String[] RolsHobbitbear;
    private static String AdminHeyimt;
    private static String[] RolsHeyimt;
    private static String AdminNeor3flux;
    private static String[] RolsNeor3flux;

    public Settings() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(SETTINGSFILE);
            Properties prop = new Properties();
            prop.load(inputStream);
            setTOKEN(prop.getProperty("TOKEN"));
            setPREFIX(prop.getOrDefault("PREFIX","-").toString());
            setLANGUAGE(prop.getOrDefault("LANGUAGE","DE").toString());
            setAdminHobbitbear(prop.getOrDefault("AdminHobbitbear", "not set").toString());
            setRolsHobbitbear(prop.getOrDefault("RolsHobbitbear", "not set").toString().split(";"));
            setAdminHeyimt(prop.getOrDefault("AdminHeyimt", "not set").toString());
            setRolsHeyimt(prop.getOrDefault("RolsHeyimt", "not set").toString().split(";"));
            setAdminNeor3flux(prop.getOrDefault("AdminNeor3flux", "not set").toString());
            setRolsNeor3flux(prop.getOrDefault("RolsNeor3flux", "not set").toString().split(";"));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (Exception ex){
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

    public static String[] getRolsHobbitbear() {
        return RolsHobbitbear;
    }

    private static void setRolsHobbitbear(String[] rolsHobbitbear) {
        RolsHobbitbear = rolsHobbitbear;
    }

    public static String getAdminHeyimt() {
        return AdminHeyimt;
    }

    private static void setAdminHeyimt(String adminHeyimt) {
        AdminHeyimt = adminHeyimt;
    }

    public static String[] getRolsHeyimt() {
        return RolsHeyimt;
    }

    private static void setRolsHeyimt(String[] rolsHeyimt) {
        RolsHeyimt = rolsHeyimt;
    }

    public static String getAdminNeor3flux() {
        return AdminNeor3flux;
    }

    private static void setAdminNeor3flux(String adminNeor3flux) {
        AdminNeor3flux = adminNeor3flux;
    }

    public static String[] getRolsNeor3flux() {
        return RolsNeor3flux;
    }

    private static void setRolsNeor3flux(String[] rolsNeor3flux) {
        RolsNeor3flux = rolsNeor3flux;
    }
}
