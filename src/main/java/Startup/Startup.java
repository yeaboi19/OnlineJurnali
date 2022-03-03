package Startup;

import SQLConnections.DataConnect;

import java.sql.*;
import java.util.Scanner;

public class Startup {
    Scanner input = new Scanner(System.in);

    DataConnect d = DataConnect.getInstance();
    Connection con = DataConnect.getConnection();

    boolean tableCheck(String tableName) throws SQLException {
        PreparedStatement p = con.prepareStatement("SHOW TABLES LIKE '" + tableName + "';");
        ResultSet res = p.executeQuery();
        return res.next();
    }

    public Startup() {
        try {
            PreparedStatement p = con.prepareStatement("use skola");
            p.execute();
            if (!tableCheck("grades")) {
                p = con.prepareStatement("CREATE TABLE `skola`.`grades` (`PK` INT NOT NULL AUTO_INCREMENT,`UserID` INT NOT NULL,`Georgian` INT NULL,`History` INT NULL,`Math` INT NULL,`Physics` INT NULL,`Biology` INT NULL,`Chemistry` INT NULL,`Geography` INT NULL,`English` INT NULL,`Russian` INT NULL,`Date` VARCHAR(45) NULL,`Class` VARCHAR(45) NULL,PRIMARY KEY (`PK`));");
                p.execute();
                System.out.println("DEBUG: created Table 'GRADES'");
            }
            if (!tableCheck("user")) {
                p = con.prepareStatement("CREATE TABLE `skola`.`user` (`UserID` INT NOT NULL AUTO_INCREMENT,`Name` VARCHAR(45) NOT NULL,`Lastname` VARCHAR(45) NOT NULL,`Email` VARCHAR(45) NOT NULL,`Class` VARCHAR(45) NOT NULL,`Subject` VARCHAR(45) NOT NULL,`isStudent` BOOLEAN NOT NULL,`isMale` BOOLEAN NOT NULL,PRIMARY KEY (`UserID`));");
                p.execute();
                System.out.println("DEBUG: created Table 'USER'");
            }
            if (!tableCheck("class")) {
                p = con.prepareStatement("CREATE TABLE `skola`.`class` (`ClassId` INT NOT NULL AUTO_INCREMENT,`ClassUserId` INT NOT NULL,`ClassTeachId` INT NOT NULL,`ClassGrade` INT NOT NULL,PRIMARY KEY (`ClassId`));");
                p.execute();
                System.out.println("DEBUG: created Table 'CLASS'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

