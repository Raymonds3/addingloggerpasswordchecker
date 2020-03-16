import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoggingPasswordCheckerTest {
        @Test
        public void GlobalVariablesTest(){
            assertEquals(LoggingPasswordChecker.uppercase,"(.*[A-Z].*)");
            assertEquals(LoggingPasswordChecker.lowercase,"(.*[a-z].*)");
            assertEquals(LoggingPasswordChecker.digit,"(.*[0-9].*)");
            assertEquals(LoggingPasswordChecker.specialChar,"(.*[! # @ $ % ^ & * ( ) - _ = + [ ] ; : ' \" , < . > / ?].*)");
            assertEquals(LoggingPasswordChecker.space,"(.*[ ].*)");
        }
        @Test(expected = Exception.class)
        public void passwordIsValidTest() throws Exception {

            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("Raymonds@3"),"Password is Valid");

            String expectedexist = "- password should exist";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid(""), expectedexist);

            String expected = "- password should be longer than than 8 characters";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("ray"), expected);

            String expectedlower = "- password should have at least one lowercase letter";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("RAYMONDS@3"), expectedlower);

            String expectedupper = "- password should have at least one uppercase letter";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("raymonds@3"), expectedupper);

            String expecteddigit = "- password should at least have one digit";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("Raymonds@"), expecteddigit);

            String expectedspecial = "- password should have at least one special character";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("Raymonds3"), expectedspecial);

            String expectedspace = "- password shouldn't have spaces";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsValid("Raymonds@ 3"), expectedspace);
        }

        @Test(expected = Exception.class)
        public void passwordIsOkTest() throws Exception {
            Assert.assertEquals(LoggingPasswordChecker.passwordIsOk("Raymonds@3"),"Password is Valid");

            String expected = "the password is never OK if it doesn't exist and its" +
                    " less than 8 characters are not met.";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsOk(""), expected);

            String expected1 = "the password is never OK if it doesn't exist and its" +
                    " less than 8 characters are not met.";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsOk("ray"), expected1);

            String expectedok = "password is OK";
            Assert.assertEquals(LoggingPasswordChecker.passwordIsOk("Raymonds3"), expectedok);
        }

}
