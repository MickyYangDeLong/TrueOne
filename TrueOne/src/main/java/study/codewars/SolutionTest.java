package study.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart2() {
        String input = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
        System.out.println("input: "+input);
        System.out.println("input2: "+Solution.toCamelCase(input));
       // assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }



    @Test
    public void testSomeDashLowerStart3() {
        String input = "Square_Yellow_down_Rockstar_Square_Red";
        System.out.println("input: "+input);
        assertEquals("SquareYellowDownRockstarSquareRed", Solution.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart4() {
        String input = "up_Rock";
        System.out.println("input: "+input);
        assertEquals("upRock", Solution.toCamelCase(input));
    }



}
