package test;

public class MainTest {
    static void main(String[] args) {
        System.out.println("Running tests...");

        ParsedMoveTest notationTester = new ParsedMoveTest();

        notationTester.notationProducesParsedMoves();

        System.out.println("All tests passed!");
    }
}
