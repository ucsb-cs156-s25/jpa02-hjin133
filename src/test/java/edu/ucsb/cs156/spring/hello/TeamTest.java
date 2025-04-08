package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void test_Equals_SameObject() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void test_Equals_DifferentClass() {
    	assertEquals(false, team.equals("NotATeam"));
    }

    @Test
    public void test_Equals_SameNameAndMembers() {
        Team t1 = new Team();
        t1.setName("Alpha");
        t1.addMember("A");
        t1.addMember("B");
	Team t2 = new Team();
    	t2.setName("Alpha");
    	t2.addMember("A");
    	t2.addMember("B");
	assertEquals(true, t1.equals(t2));
    }

    @Test
    public void test_Equals_SameNameDifferentMembers() {
        Team t1 = new Team();
    	t1.setName("Alpha");
    	t1.addMember("A");
	Team t2 = new Team();
    	t2.setName("Alpha");
    	t2.addMember("B");
	assertEquals(false, t1.equals(t2));
    }

    @Test
    public void test_Equals_DifferentNameSameMembers() {
        Team t1 = new Team();
   	t1.setName("Alpha");
    	t1.addMember("A");
	Team t2 = new Team();
    	t2.setName("Beta");
    	t2.addMember("A");
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void test_HashCodeConsistency_WithEquals() {
    Team t1 = new Team();
    t1.setName("foo");
    t1.addMember("bar");

    Team t2 = new Team();
    t2.setName("foo");
    t2.addMember("bar");

    assertEquals(t1, t2);
    assertEquals(t1.hashCode(), t2.hashCode());
}
    @Test
    public void hashCode_returns_expected_value() {
    Team t = new Team();
    t.setName("foo");
    t.addMember("bar");

    int result = t.hashCode();
    int expectedResult = 130294;
    assertEquals(expectedResult, result);
}
}
