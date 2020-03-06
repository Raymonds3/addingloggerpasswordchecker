import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.logging.FileHandler;

public class LoggingPasswordChecker {
    private static final Logger logger = LogManager.getLogger(LoggingPasswordChecker.class.getName());
    FileHandler er;

        public static String uppercase = "(.*[A-Z].*)";
        public static String lowercase = "(.*[a-z].*)";
        public static String digit = "(.*[0-9].*)";
        public static String specialChar = "(.*[! # @ $ % ^ & * ( ) - _ = + [ ] ; : ' \" , < . > / ?].*)";
        public static String space = "(.*[ ].*)";

        public static String passwordIsValid(String password) throws Exception{
            FileHandler er = new FileHandler("errors.log");
            logger.error(er);
            String result = "";
            if (password.isEmpty()) {
                result = "- password should exist";
                logger.error("- password should exist");
                throw new Exception("- password should exist");
            } else {
                if (password.length() < 8) {
                    result = "- password should be longer than than 8 characters";
                    logger.error("- password should be longer than than 8 characters");
                    throw new Exception("- password should be longer than than 8 characters");
                } else {
                    if (!password.matches(lowercase)) {
                        result = "- password should have at least one lowercase letter";
                        logger.error("- password should have at least one lowercase letter");
                        throw new Exception("- password should have at least one lowercase letter");
                    } else {
                        if (!password.matches(uppercase)) {
                            result = "- password should have at least one uppercase letter";
                            logger.error("- password should have at least one uppercase letter");
                            throw new Exception("- password should have at least one uppercase letter");
                        } else {
                            if (!password.matches(digit)) {
                                result = "- password should at least have one digit";
                                logger.error("- password should at least have one digit");
                                throw new Exception("- password should at least have one digit");
                            } else {
                                if (!password.matches(specialChar)) {
                                    result = "- password should have at least one special character";
                                    logger.error("- password should have at least one special character");
                                    throw new Exception("- password should have at least one special character");
                                } else {
                                    if (password.matches(space)) {
                                        result = "- password shouldn't have spaces";
                                        logger.error("- password shouldn't have spaces");
                                        throw new Exception("- password shouldn't have spaces");
                                    } else {
                                        result = "Password is Valid";
                                        System.out.println("Password is Valid");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        }

        public static String passwordIsOk(String password) throws Exception{
            String result1 = "";
            if(password.isEmpty()){
                result1 = "User password is not ok";
                logger.debug("User password is not ok");
                throw new Exception("the password is never OK if it doesn't exist and its" +
                        " less than 8 characters are not met.");
            }
            if(password.length() < 8){
                result1 = "password is not ok";
                logger.debug("User password is not ok");
                throw new Exception("the password is never OK if it doesn't exist and its" +
                        " less than 8 characters are not met.");
            } else {
                if (!password.matches(lowercase) || !password.matches(uppercase) ||
                        !password.matches(digit) || !password.matches(specialChar)){
                    result1 = "password is OK";
                    logger.debug("User password is ok");
                    throw new Exception("password is ok");
                }
                else {
                    result1 = "Password is Valid";
                    System.out.println("Password is Valid");
                }
            }
            return result1;
        }


        public static void main(String[] args) {
            String password1;
            Scanner passwordInput = new Scanner(System.in);
            System.out.println("Please Enter Password?");
            password1 = passwordInput.nextLine();


            try {
                passwordIsValid(password1);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            try {
                passwordIsOk(password1);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
}
