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

    public Startup() throws SQLException {
        PreparedStatement p = con.prepareStatement("use skola");
        p.execute();
        if (!tableCheck("grades")) {
            p = con.prepareStatement("CREATE TABLE `skola`.`grades` (`UserID` INT NOT NULL,`Georgian` VARCHAR(45) NULL,`History` VARCHAR(45) NULL,`Math` VARCHAR(45) NULL,`Physics` VARCHAR(45) NULL,`Biology` VARCHAR(45) NULL,`Chemistry` VARCHAR(45) NULL,`Geography` VARCHAR(45) NULL,`English` VARCHAR(45) NULL,`Russian` VARCHAR(45) NULL,PRIMARY KEY (`UserID`));");
            p.execute();
            System.out.println("DEBUG: created Table 'GRADES'");
        }
        if (!tableCheck("user")) {
            p = con.prepareStatement("CREATE TABLE `skola`.`user` (`UserID` INT NOT NULL,`Name` VARCHAR(45) NOT NULL,`Lastname` VARCHAR(45) NOT NULL,`Email` VARCHAR(45) NOT NULL,`Class` VARCHAR(45) NOT NULL,`Subject` VARCHAR(45) NOT NULL,`isStudent` BOOLEAN NOT NULL,PRIMARY KEY (`UserID`));");
            p.execute();
            System.out.println("DEBUG: created Table 'USER'");
        }
        if (!tableCheck("class")) {
            p = con.prepareStatement("CREATE TABLE `skola`.`class` (`ClassId` INT NOT NULL AUTO_INCREMENT,`ClassUserId` INT NOT NULL,`ClassTeachId` INT NOT NULL,`ClassGrade` INT NOT NULL,PRIMARY KEY (`ClassId`));");
            p.execute();
            System.out.println("DEBUG: created Table 'CLASS'");
        }

    }


}

